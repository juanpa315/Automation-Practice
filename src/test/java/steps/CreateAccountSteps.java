package steps;

import java.io.IOException;
import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.CreateAccountPage;
import util.ExcelUtils;

public class CreateAccountSteps {

    CreateAccountPage createAccountPage = new CreateAccountPage();
    ExcelUtils sheetCreateAccount = new ExcelUtils("createAccount");

    @Given("^I get into the new experience web site$")
    public void ingreso_al_aplicativo_newExperience() {
        createAccountPage.getUrl();
    }

    @And("^I select SignIn option$")
    public void selecciono_la_opción_SignIn() {
        createAccountPage.btnSignIn();
    }

    @When("^Digito mi correo eléctronico$")
    public void digito_mi_correo_eléctronico() {
        String email = sheetCreateAccount.getStringCellData(1, 3);
        createAccountPage.insertEmail(email);
    }

    @And("^hago clic en el botón Create an acount$")
    public void hago_clic_en_el_botón_Create_an_acount() {
        createAccountPage.btnCreateAcount();
        boolean response = createAccountPage.validate_if_email_has_already_registered();
        Assert.assertFalse("The email address has already been registered", response);
    }

    @And("^Completo la información solicitada por el sistema$")
    public void completo_la_información_solicitada_por_el_sistema() throws IOException {

        int size = sheetCreateAccount.getRowCount();

        for (int id = 1; id < size; id++) {
            createAccountPage.Gender(sheetCreateAccount.getStringCellData(id, 0));
            createAccountPage.insertFirstName(sheetCreateAccount.getStringCellData(id, 1));
            createAccountPage.insertLastName(sheetCreateAccount.getStringCellData(id, 2));
            createAccountPage.validateEmail(sheetCreateAccount.getStringCellData(id, 3));
            createAccountPage.insertPassword(sheetCreateAccount.getStringCellData(id, 4));
            createAccountPage.selectDay(sheetCreateAccount.getObjectCellData(id, 5));
            createAccountPage.selectMonth(sheetCreateAccount.getObjectCellData(id, 6));
            createAccountPage.selectYear(sheetCreateAccount.getObjectCellData(id, 7));
            createAccountPage.checkSesion();
            createAccountPage.registerUser();
        }
    }

    @Then("^El sistema crea mi cuenta de usuario$")
    public void el_sistema_crea_mi_cuenta_de_usuario() {
        boolean response = createAccountPage.registerSuccessful();
        Assert.assertTrue("Information register Failed", response);

    }

    @And("^I close my session on the website$")
    public void I_close_my_session_on_the_website() {
        createAccountPage.logOut();
        boolean response = createAccountPage.validatelogOut();
        Assert.assertTrue("Failed logout", response);
        System.out.println("se encontró el texto? " + response);
    }

    // Steps for the alternate test case

    @When("^I type my email$")
    public void i_type_my_email() {
        String email = sheetCreateAccount.getStringCellData(1, 21);
        createAccountPage.insertEmail(email);
    }

    @When("^I click on the create account button$")
    public void i_click_on_the_create_account_button() {

        createAccountPage.btnCreateAcount();
        boolean response = createAccountPage.validate_if_email_has_already_registered();
        Assert.assertFalse("The email address has already been registered", response);

    }

    @When("^I click on the register button$")
    public void i_click_on_the_register_button() {
        createAccountPage.registerUser();
    }

    @Then("^The system does not allow to create the user account$")
    public void the_system_does_not_allow_to_create_the_user_account() {
        boolean response = createAccountPage.validateAlert();
        Assert.assertTrue("The expected alert was not found", response);
    }

}
