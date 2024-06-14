package page;
import static util.Constants.HOME_PAGE;

public class LoginPage extends BasePage {

    Locators locators = new Locators();

    public LoginPage() {
        super(driver);

    }

    public void getUrl() {
        navigateTo(HOME_PAGE);
    }

    public void btnSignIn() {
        clicElement(locators.btnSignIn);
    }

    public void insertEmail(String datoPrueba) {
        clicElement(locators.emailAddress);
        write(locators.emailAddress, datoPrueba);
    }

    public void insertPass(String datoPrueba) {
        clicElement(locators.password);
        write(locators.password, datoPrueba);
    }

    public void signIn() {
        clicElement(locators.sigInButton);
    }

    public boolean validateSignIn() {
        return verifyVisibleElement(locators.txtAccount);
    }

    public boolean logOut() {
        clicElement(locators.logOut);
        return verifyVisibleElement(locators.txtAuthentication);
    }

    public boolean loginFailed() {
        return verifyVisibleElement(locators.alert);
    }

}
