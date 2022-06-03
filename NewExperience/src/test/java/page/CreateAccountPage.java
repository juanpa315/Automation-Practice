package page;

public class CreateAccountPage extends BasePage {

    Locators locators = new Locators();

    public CreateAccountPage() {
        super(driver);
    }

    public void getUrl() {
        navigateTo("http://automationpractice.com/index.php");
    }

    public void logOut() {
        clicElement(locators.logOut);
    }

    public void btnSignIn() {
        clicElement(locators.btnSignIn);
    }

    public void insertEmail(String datoPrueba) {
        clicElement(locators.email1);
        write(locators.email1, datoPrueba);
    }

    public boolean validateAlert() {
        return verifyVisibleElement(locators.alertRequiredData);
    }

    public void btnCreateAcount() {
        clicElement(locators.btnCreateAccount);
    }

    public void Gender(String datoPrueba) {
        if (datoPrueba.equals("Hombre")) {
            clicElement2(locators.genderM);
            System.out.println("The gender is : " + datoPrueba);
        } else if (datoPrueba.equals("Mujer")) {
            clicElement2(locators.genderF);
            System.out.println("The gender is : " + datoPrueba);
        } else {
            System.out.println("The gender: " + datoPrueba + " is not found in the website");
        }

    }

    public void insertFirstName(String datoPrueba) {
        write(locators.firstName, datoPrueba);
    }

    public void insertLastName(String datoPrueba) {
        write(locators.lastName, datoPrueba);
    }

    public void validateEmail(String datoPrueba) {
        compareValues(locators.email, datoPrueba);

    }

    public void insertPassword(String datoPrueba) {
        clicElement(locators.newPassword);
        write(locators.newPassword, datoPrueba);
    }

    public void selectDay(String datoPrueba) {
        selectElementByValue(locators.fechaDia, datoPrueba);
    }

    public void selectMonth(String datoPrueba) {
        selectElementByValue(locators.fechaMes, datoPrueba);
    }

    public void selectYear(String datoPrueba) {
        selectElementByValue(locators.fechaYear, datoPrueba);
    }

    public void checkSesion() {
        clicElement(locators.checkNewsletter);
    }

    public void checkOferts() {
        clicElement(locators.checkOfertas);
    }

    public void validateFirstName(String datoPrueba) {
        compareValues(locators.firstName2, datoPrueba);
    }

    public void validateLastName2(String datoPrueba) {
        compareValues(locators.lastName2, datoPrueba);
    }

    public void insertCompany(String datoPrueba) {
        write(locators.company, datoPrueba);
    }

    public void insertAddress(String datoPrueba) {
        write(locators.address, datoPrueba);
    }

    public void insertAddress2(String datoPrueba) {
        write(locators.address2, datoPrueba);
    }

    public void insertCity(String datoPrueba) {
        write(locators.city, datoPrueba);
    }

    public void selectState(String datoPrueba) {
        selectElementByVisibleText(locators.state, datoPrueba);
    }

    public void insertCodePostal(String datoPrueba) {
        write(locators.codePostal, datoPrueba);
    }

    public void selectCountry(String datoPrueba) {
        selectElementByVisibleText(locators.country, datoPrueba);
    }

    public void insertAditionalInformation(String datoPrueba) {
        write(locators.aditionalInformation, datoPrueba);
    }

    public void insertHomePhone(String datoPrueba) {
        write(locators.homePhone, datoPrueba);
    }

    public void insertMobilePhone(String datoPrueba) {
        write(locators.mobilePhone, datoPrueba);
    }

    public void insertAliasAddress(String datoPrueba) {
        write(locators.aliasAddress, datoPrueba);
    }

    public void registerUser() {
        clicElement(locators.btnRegister);
    }

    public boolean registerSuccessful() {

        return verifyVisibleElement(locators.txtAccount);

    }

    public boolean validatelogOut() {
        return verifyVisibleElement(locators.txtAuthentication);
    }

    public boolean validate_if_email_has_already_registered() {
        return verifyVisibleElement(locators.txtAlertUsedEmail);
    }

}
