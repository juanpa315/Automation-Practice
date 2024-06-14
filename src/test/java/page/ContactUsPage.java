package page;

import static org.junit.Assert.assertNotEquals;
import static util.Constants.HOME_PAGE;

public class ContactUsPage extends BasePage {

    Locators locators = new Locators();

    public ContactUsPage() {
        super(driver);

    }

    public void getUrl() {
        navigateTo(HOME_PAGE);
    }

    public boolean signIn(String email, String psw) {
        clicElement(locators.btnSignIn);

        clicElement(locators.emailAddress);
        write(locators.emailAddress, email);

        clicElement(locators.password);
        write(locators.password, psw);

        clicElement(locators.sigInButton);

        return verifyVisibleElement(locators.txtAccount);

    }

    public boolean accessContactUs() {
        clicElement(locators.optionContactUs);
        return verifyVisibleElement(locators.txtContactUs);
    }

    public void selectHeading(String datoPrueba) {
        selectElementByVisibleText(locators.heading, datoPrueba);
    }

    public void validateEmail(String datoPrueba) {
        compareValues(locators.emailC, datoPrueba);
    }

    public void selectOrder(String datoPrueba) {
        selectElementByVisibleText(locators.orderReference, datoPrueba);
    }

    public void writeMessage(String datoPrueba) {
        write(locators.message, datoPrueba);

    }

    public void uploadFile(String path) {
        uploadFile(locators.chooseFile, path);
        String txtActual = getText(locators.txtInputFile);
        System.out.println("El archivo adjunto se llama: " + txtActual);
        String txtUnexpected = "No file selected";
        assertNotEquals(txtUnexpected, txtActual);

    }

    public void Send() {
        clicElement(locators.btnSend);
    }

    public boolean validateAlertSuccessful() {
        return verifyVisibleElement(locators.alertSuccessfuly);
    }

    public String returnHomePage() {
        clicElement(locators.btnHomePage);
        return getCurrentUrl();
    }

    public boolean logOut() {
        clicElement(locators.btnLogOut);
        return verifyVisibleElement(locators.validateLogOut);
    }

    public boolean validateAlertFailed() {
        return verifyVisibleElement(locators.alertFailed);
    }
}
