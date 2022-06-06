package steps;

import java.util.NoSuchElementException;

import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page.ContactUsPage;
import util.ExcelUtils;

public class ContactUsSteps {

    ContactUsPage contactUsPage = new ContactUsPage();

    @Given("^I access the new experience page$")
    public void i_access_the_new_experience_page() {
        contactUsPage.getUrl();
    }

    @And("^I login on the system with email and password$")
    public void i_login_on_the_system_with_email_and_password() {

        ExcelUtils sheetLogin = new ExcelUtils("login");

        String email = sheetLogin.getStringCellData(1, 0);
        String psw = sheetLogin.getStringCellData(1, 1);
        boolean response = contactUsPage.signIn(email, psw);
        Assert.assertTrue("Unable Login", response);

    }

    @And("^I access the contact us page$")
    public void i_access_the_contact_us_page() {
        boolean response = contactUsPage.accessContactUs();
        Assert.assertTrue("Unable to access contact form", response);
    }

    @When("^I complete all the required input$")
    public void i_complete_all_the_required_input() {
        try {
            ExcelUtils excelUtils = new ExcelUtils("contactUs");
            int size = excelUtils.getRowCount();
            for (int id = 1; id < size; id++) {
                System.out.println("el id es: " + id);
                contactUsPage.selectHeading(excelUtils.getStringCellData(id, 1));
                contactUsPage.validateEmail(excelUtils.getStringCellData(id, 2));
                contactUsPage.selectOrder(excelUtils.getStringCellData(id, 3));
                contactUsPage.uploadFile(excelUtils.getStringCellData(id, 4));
                contactUsPage.writeMessage(excelUtils.getStringCellData(id, 5));
            }
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
            System.out.println("Se a generado un error de tipo: " + e.getClass());
        }

    }

    @And("^I click on the send buttom$")
    public void i_click_on_the_send_buttom() {
        contactUsPage.Send();
    }

    @Then("^The system displays a successful request message$")
    public void the_system_displays_a_successful_request_message() {
        boolean response = contactUsPage.validateAlertSuccessful();
        Assert.assertTrue("the request was not sent successfully", response);
    }

    @And("^I can return to the home page and logout on the website$")
    public void i_can_return_to_the_home_page() {

        // get url to the home page.
        ExcelUtils sheetHomePage = new ExcelUtils("homePage");
        String url = sheetHomePage.getStringCellData(0, 0);

        // return successfully to home page.
        String currentUrl = contactUsPage.returnHomePage();
        System.out.println("The current url is: " + currentUrl);
        Assert.assertEquals(url, currentUrl);

        // Log out successful.
        boolean response = contactUsPage.logOut();
        System.out.println("The response is: " + response);
        Assert.assertFalse("The log out was failed", response);
    }

    // Steps when the user sends the request without to completing the required data

    @Then("The system displays a failed message alert.")
    public void the_system_displays_a_failed_message_alert() {

        // Validate alert
        boolean responseAlert = contactUsPage.validateAlertFailed();
        Assert.assertTrue("the alert is not found", responseAlert);

        // Log out successful
        boolean responseLogOut = contactUsPage.logOut();
        System.out.println("The response is: " + responseLogOut);
        Assert.assertFalse("The log out was failed", responseLogOut);

    }
}
