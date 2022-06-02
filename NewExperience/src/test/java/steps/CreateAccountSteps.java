package steps;

import java.util.List;

import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import page.CreateAccountPage;

public class CreateAccountSteps {

    CreateAccountPage createAccountPage = new CreateAccountPage();

    @Given("^I get into the new experience web site$")
    public void ingreso_al_aplicativo_newExperience() {
        createAccountPage.getUrl();
    }

    @And("^I select SignIn option$")
    public void selecciono_la_opción_SignIn() {
        createAccountPage.btnSignIn();
    }

    @When("^Digito mi correo eléctronico \"([^\"]*)\"$")
    public void digito_mi_correo_eléctronico(String email) {
        createAccountPage.insertEmail(email);
        boolean response = createAccountPage.validate_if_email_has_already_registered();
        Assert.assertFalse("The email address has already been registered", response);
    }

    @And("^hago clic en el botón Create an acount$")
    public void hago_clic_en_el_botón_Create_an_acount() {
        createAccountPage.btnCreateAcount();
    }

    @And("^Completo la información solicitada por el sistema$")
    public void completo_la_información_solicitada_por_el_sistema(DataTable dtDatosForm) {
        List<List<String>> data = dtDatosForm.asLists();

        for (int id = 1; id < data.size(); id++) {
            createAccountPage.Gender(data.get(id).get(0).trim());
            createAccountPage.insertFirstName(data.get(id).get(1).trim());
            createAccountPage.insertLastName(data.get(id).get(2).trim());
            createAccountPage.validateEmail(data.get(id).get(3).trim());
            createAccountPage.insertPassword(data.get(id).get(4).trim());
            createAccountPage.selectDay(data.get(id).get(5).trim());
            createAccountPage.selectMonth(data.get(id).get(6).trim());
            createAccountPage.selectYear(data.get(id).get(7).trim());
            createAccountPage.checkSesion();
            createAccountPage.checkOferts();
            createAccountPage.validateFirstName(data.get(id).get(8).trim());
            createAccountPage.validateLastName2(data.get(id).get(9).trim());
            createAccountPage.insertCompany(data.get(id).get(10).trim());
            createAccountPage.insertAddress(data.get(id).get(11).trim());
            createAccountPage.insertAddress2(data.get(id).get(12).trim());
            createAccountPage.insertCity(data.get(id).get(13).trim());
            createAccountPage.selectState(data.get(id).get(14).trim());
            createAccountPage.insertCodePostal(data.get(id).get(15).trim());
            createAccountPage.selectCountry(data.get(id).get(16).trim());
            createAccountPage.insertAditionalInformation(data.get(id).get(17).trim());
            createAccountPage.insertHomePhone(data.get(id).get(18).trim());
            createAccountPage.insertMobilePhone(data.get(id).get(19).trim());
            createAccountPage.insertAliasAddress(data.get(id).get(20).trim());
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

    @When("^I type my email \"([^\"]*)\"$")
    public void i_type_my_email(String email) {
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
