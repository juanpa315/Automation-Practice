package page;

public class LoginPage extends BasePage {

    private String btnSignIn = "//a[@class='login']";
    private String emailAddress = "//input[@id='email']";
    private String password = "//input[@id='passwd']";
    private String sigInButton = "//button[@id='SubmitLogin']";
    private String alert = "//p[contains(text(),'There is 1 error')]";
    private String txtAccount = "//h1[contains(text(),'My account')]";
    private String txtAuthentication = "//h1[@class='page-heading']";
    private String logOut = "//header/div[2]/div[1]/div[1]/nav[1]/div[2]";

    public LoginPage() {
        super(driver);

    }

    public void getUrl() {
        navigateTo("http://automationpractice.com/index.php");
    }

    public void btnSignIn() {
        clicElement(btnSignIn);
    }

    public void insertEmail(String datoPrueba) {
        clicElement(emailAddress);
        write(emailAddress, datoPrueba);
    }

    public void insertPass(String datoPrueba) {
        clicElement(password);
        write(password, datoPrueba);
    }

    public void signIn() {
        clicElement(sigInButton);
    }

    public boolean validateSignIn() {
        return verifyVisibleElement(txtAccount);
    }

    public boolean logOut() {
        clicElement(logOut);
        return verifyVisibleElement(txtAuthentication);
    }

    public boolean loginFailed() {
        return verifyVisibleElement(alert);
    }

}
