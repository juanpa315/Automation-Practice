package page;

public class Locators {

    // Locators from login
    public String btnSignIn = "//a[@class='login']";
    public String emailAddress = "//input[@id='email']";
    public String password = "//input[@id='passwd']";
    public String sigInButton = "//button[@id='SubmitLogin']";
    public String alert = "//p[contains(text(),'There is 1 error')]";
    public String txtAccount = "//h1[contains(text(),'My account')]";
    public String txtAuthentication = "//h1[@class='page-heading']";
    public String btnLogOut = "//header/div[2]/div[1]/div[1]/nav[1]/div[2]";
    public String optionContactUs = "//div[@id='contact-link']";
    public String logOut = "//header/div[2]/div[1]/div[1]/nav[1]/div[2]";

    // Locators from create Account
    public String email1 = "//input[@id='email_create']";
    public String btnCreateAccount = "//button[@id='SubmitCreate']";
    public String genderM = "//input[@id='id_gender1']";
    public String genderF = "//input[@id=\'id_gender2\']";
    public String firstName = "//input[@id='customer_firstname']";
    public String lastName = "//input[@id='customer_lastname']";
    public String email = "//input[@id='email']";
    public String newPassword = "//input[@id='passwd']";
    public String fechaDia = "//select[@id='days']";
    public String fechaMes = "//select[@id='months']";
    public String fechaYear = "//select[@id='years']";
    public String checkNewsletter = "//div[@id='uniform-newsletter']";
    public String btnRegister = "//span[contains(text(),'Register')]";
    public String txtAlertUsedEmail = "//div[@id='create_account_error']";
    public String alertRequiredData = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]";

    // locators from contact us page
    public String txtContactUs = "//h1[contains(text(),' - Contact us')]";
    public String heading = "//select[@id='id_contact']";
    public String emailC = "//input[@id='email']";
    public String orderReference = "//select[@name='id_order']";
    public String chooseFile = "//input[@id='fileUpload']";
    public String txtInputFile = "//span[@class='filename']";
    public String message = "//textarea[@id='message']";
    public String btnSend = "//button[@id='submitMessage']";
    public String alertSuccessfuly = "//p[contains(text(),'Your message')]";
    public String alertFailed = "//div[@class='alert alert-danger']";
    public String btnHomePage = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/ul[1]/li[1]/a[1]";
    public String validateLogOut = "//div[@class='header_user_info']/a/span";

}
