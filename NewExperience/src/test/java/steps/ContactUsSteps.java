package steps;

import java.util.List;

import org.junit.Assert;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import page.ContactUsPage;

public class ContactUsSteps {

    ContactUsPage contactUsPage = new ContactUsPage();

    @Given("^I access the new experience page$")
    public void i_access_the_new_experience_page() {
        contactUsPage.getUrl();
    }

    @And("^I login on the system with email \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void i_login_on_the_system_with_email_and_password(String email, String psw) {
        boolean response = contactUsPage.signIn(email, psw);
        Assert.assertTrue("Unable Login", response);

    }

    @And("^I access the contact us page$")
    public void i_access_the_contact_us_page() {
        boolean response = contactUsPage.accessContactUs();
        Assert.assertTrue("Unable to access contact form", response);
    }

    @When("^I complete all the required input$")
    public void i_complete_all_the_required_input(DataTable dtDatosForm) {
        List<List<String>> data = dtDatosForm.asLists();
        for (int id = 1; id < data.size(); id++) {
            contactUsPage.selectHeading(data.get(id).get(0).trim());
            contactUsPage.validateEmail(data.get(id).get(1).trim());
            contactUsPage.selectOrder(data.get(id).get(2).trim());
            contactUsPage.uploadFile(data.get(id).get(3).trim());
            contactUsPage.writeMessage(data.get(id).get(4).trim());
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

    @And("^I can return to the home page \"([^\"]*)\" and logout on the website$")
    public void i_can_return_to_the_home_page(String url) {

        // return successfully to home page
        String currentUrl = contactUsPage.returnHomePage();
        System.out.println("The current url is: " + currentUrl);
        Assert.assertEquals(url, currentUrl);

        // Log out successful
        boolean response = contactUsPage.logOut();
        System.out.println("The response is: " + response);
        Assert.assertTrue("The log out was failed", response);
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
        Assert.assertTrue("The log out was failed", responseLogOut);

    }
}
