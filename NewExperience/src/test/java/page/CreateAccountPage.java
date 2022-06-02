package page;

public class CreateAccountPage extends BasePage {

    private String btnSignIn = "//a[@class='login']";
    private String email1 = "//input[@id='email_create']";
    private String btnCreateAccount = "//button[@id='SubmitCreate']";
    private String genderM = "//input[@id='id_gender1']";
    private String genderF = "//input[@id='id_gender2']";
    private String firstName = "//input[@id='customer_firstname']";
    private String lastName = "//input[@id='customer_lastname']";
    private String email = "//input[@id='email']";
    private String password = "//input[@id='passwd']";
    private String fechaDia = "//select[@id='days']";
    private String fechaMes = "//select[@id='months']";
    private String fechaYear = "//select[@id='years']";
    private String checkNewsletter = "//div[@id='uniform-newsletter']";
    private String checkOfertas = "//div[@id='uniform-optin']";
    private String firstName2 = "//input[@id='firstname']";
    private String lastName2 = "//input[@id='lastname']";
    private String company = "//input[@id='company']";
    private String address = "//input[@id='address1']";
    private String address2 = "//input[@id='address2']";
    private String city = "//input[@id='city']";
    private String state = "//select[@id='id_state']";
    private String codePostal = "//input[@id='postcode']";
    private String country = "//select[@id='id_country']";
    private String aditionalInformation = "//textarea[@id='other']";
    private String homePhone = "//input[@id='phone']";
    private String mobilePhone = "//input[@id='phone_mobile']";
    private String aliasAddress = "//input[@id='alias']";
    private String btnRegister = "//span[contains(text(),'Register')]";
    private String txtAccount = "//h1[contains(text(),'My account')]";
    private String alert = "//body/div[@id='page']/div[2]/div[1]/div[3]/div[1]/div[1]";
    private String logOut = "//header/div[2]/div[1]/div[1]/nav[1]/div[2]";
    private String txtAuthentication = "//h1[@class='page-heading']";
    private String txtAlertUsedEmail = "//div[@id='create_account_error']";

    public CreateAccountPage() {
        super(driver);
    }

    public void getUrl() {
        navigateTo("http://automationpractice.com/index.php");
    }

    public void logOut() {
        clicElement(logOut);
    }

    public void btnSignIn() {
        clicElement(btnSignIn);
    }

    public void insertEmail(String datoPrueba) {
        clicElement(email1);
        write(email1, datoPrueba);
    }

    public boolean validateAlert() {
        return verifyVisibleElement(alert);
    }

    public void btnCreateAcount() {
        clicElement(btnCreateAccount);
    }

    public void Gender(String datoPrueba) {
        if (datoPrueba.equals("Hombre")) {
            clicElement(genderM);
            System.out.println("The gender is : " + datoPrueba);
        } else if (datoPrueba.equals("Mujer")) {
            clicElement(genderF);
            System.out.println("The gender is : " + datoPrueba);
        } else {
            System.out.println("The gender: " + datoPrueba + " is not found in the website");
        }

    }

    public void insertFirstName(String datoPrueba) {
        write(firstName, datoPrueba);
    }

    public void insertLastName(String datoPrueba) {
        write(lastName, datoPrueba);
    }

    public void validateEmail(String datoPrueba) {
        compareValues(email, datoPrueba);

    }

    public void insertPassword(String datoPrueba) {
        clicElement(password);
        write(password, datoPrueba);
    }

    public void selectDay(String datoPrueba) {
        selectElementByValue(fechaDia, datoPrueba);
    }

    public void selectMonth(String datoPrueba) {
        selectElementByValue(fechaMes, datoPrueba);
    }

    public void selectYear(String datoPrueba) {
        selectElementByValue(fechaYear, datoPrueba);
    }

    public void checkSesion() {
        clicElement(checkNewsletter);
    }

    public void checkOferts() {
        clicElement(checkOfertas);
    }

    public void validateFirstName(String datoPrueba) {
        compareValues(firstName2, datoPrueba);
    }

    public void validateLastName2(String datoPrueba) {
        compareValues(lastName2, datoPrueba);
    }

    public void insertCompany(String datoPrueba) {
        write(company, datoPrueba);
    }

    public void insertAddress(String datoPrueba) {
        write(address, datoPrueba);
    }

    public void insertAddress2(String datoPrueba) {
        write(address2, datoPrueba);
    }

    public void insertCity(String datoPrueba) {
        write(city, datoPrueba);
    }

    public void selectState(String datoPrueba) {
        selectElementByVisibleText(state, datoPrueba);
    }

    public void insertCodePostal(String datoPrueba) {
        write(codePostal, datoPrueba);
    }

    public void selectCountry(String datoPrueba) {
        selectElementByVisibleText(country, datoPrueba);
    }

    public void insertAditionalInformation(String datoPrueba) {
        write(aditionalInformation, datoPrueba);
    }

    public void insertHomePhone(String datoPrueba) {
        write(homePhone, datoPrueba);
    }

    public void insertMobilePhone(String datoPrueba) {
        write(mobilePhone, datoPrueba);
    }

    public void insertAliasAddress(String datoPrueba) {
        write(aliasAddress, datoPrueba);
    }

    public void registerUser() {
        clicElement(btnRegister);
    }

    public boolean registerSuccessful() {

        return verifyVisibleElement(txtAccount);

    }

    public boolean validatelogOut() {
        return verifyVisibleElement(txtAuthentication);
    }

    public boolean validate_if_email_has_already_registered() {
        return verifyVisibleElement(txtAlertUsedEmail);
    }

}
