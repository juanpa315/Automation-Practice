package steps;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.LoginPage;
import util.ExcelUtils;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();
    ExcelUtils excelUtils = new ExcelUtils("login");

    @Given("^I access the new experience website$")
    public void ingreso_al_aplicativo_newExperience() {
        loginPage.getUrl();
    }

    @And("^I click SignIn option$")
    public void selecciono_la_opción_SignIn() {
        loginPage.btnSignIn();
    }

    @When("^I enter my email$")
    public void i_enter_my_email() {
        String email = excelUtils.getStringCellData(1, 0);
        loginPage.insertEmail(email);
    }

    @And("^I enter my Password$")
    public void i_enter_my_Password() {
        String pass = excelUtils.getStringCellData(1, 1);
        loginPage.insertPass(pass);
    }

    @And("^I click on the SignIn button$")
    public void i_click_on_the_SignIn_buttom() {
        loginPage.signIn();
    }

    @Then("^The website load my user account$")
    public void the_website_load_my_user_account() {
        boolean response = loginPage.validateSignIn();
        Assert.assertTrue("SignIn Failed", response);
    }

    @And("^I can log out$")
    public void i_can_log_out() {
        boolean response = loginPage.logOut();
        Assert.assertTrue("Failed logout", response);
        System.out.println("se encontró el texto? " + response);
    }

    // Steps when the user data is invalid

    @When("^I enter a invalid email$")
    public void when_i_enter_a_invalid_email() {
        String emailInv = excelUtils.getStringCellData(2, 0);
        loginPage.insertEmail(emailInv);
    }

    @And("^I enter a password$")
    public void i_Insert_pwd() {
        String pass = excelUtils.getStringCellData(2, 1);
        loginPage.insertPass(pass);
    }

    @And("^I click on the signin button$")
    public void i_click_on_the_signin_buttom() {
        loginPage.signIn();
    }

    @Then("^The system does not allow to login successfully$")
    public void the_website_does_not_allow_to_login_successfully() {
        boolean response = loginPage.loginFailed();
        Assert.assertTrue("alert not found", response);
        System.out.println("el resultado del booleano es: " + response);
    }

}
