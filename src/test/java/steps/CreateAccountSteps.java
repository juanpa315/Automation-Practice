package steps;

import java.io.IOException;
import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.CreateAccountPage;
import util.ExcelUtils;
import static util.RamdomString.generateRandomEmail;

public class CreateAccountSteps {

    CreateAccountPage createAccountPage = new CreateAccountPage();
    ExcelUtils sheetCreateAccount = new ExcelUtils("createAccount");
    private String email = generateRandomEmail(8);

    @Given("^I get into the new experience web site$")
    public void ingreso_al_aplicativo_newExperience() {
        createAccountPage.getUrl();
    }

    @And("^I select SignIn option$")
    public void selecciono_la_opción_SignIn() {
        createAccountPage.btnSignIn();
    }

    @When("^I type my email$")
    public void i_type_my_email() {
        createAccountPage.insertEmail(email);
    }

    @When("^I click on the create account button$")
    public void i_click_on_the_create_account_button() {

        createAccountPage.btnCreateAcount();
        boolean response = createAccountPage.validate_if_email_has_already_registered();
        Assert.assertFalse("The email address has already been registered", response);

    }

    @And("^I enter the data into the systemm$")
    public void I_enter_the_data_into_the_systemm() throws IOException {

        int size = sheetCreateAccount.getRowCount();

        for (int id = 1; id < size; id++) {
            createAccountPage.Gender(sheetCreateAccount.getStringCellData(id, 0));
            createAccountPage.insertFirstName(sheetCreateAccount.getStringCellData(id, 1));
            createAccountPage.insertLastName(sheetCreateAccount.getStringCellData(id, 2));
            createAccountPage.validateEmail(email);
            createAccountPage.insertPassword(sheetCreateAccount.getStringCellData(id, 3));
            createAccountPage.selectDay(sheetCreateAccount.getObjectCellData(id, 4));
            createAccountPage.selectMonth(sheetCreateAccount.getObjectCellData(id, 5));
            createAccountPage.selectYear(sheetCreateAccount.getObjectCellData(id, 6));
            createAccountPage.checkSesion();
            createAccountPage.registerUser();
        }
    }

    @Then("^The system create my user account$")
    public void The_system_create_my_user_account() {
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
