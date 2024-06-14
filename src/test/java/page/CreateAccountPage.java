package page;

import static util.Constants.HOME_PAGE;

public class CreateAccountPage extends BasePage {

    Locators locators = new Locators();

    public CreateAccountPage() {
        super(driver);
    }

    public void getUrl() {
        navigateTo(HOME_PAGE);
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

    public void selectDay(Object dataExcel) {
        String datoPrueba = String.valueOf(dataExcel);
        System.out.println("The Day is: " + dataExcel);
        selectElementByValue(locators.fechaDia, datoPrueba);
    }

    public void selectMonth(Object dataExcel) {
        String datoPrueba = String.valueOf(dataExcel);
        System.out.println("The Month is: " + dataExcel);
        selectElementByValue(locators.fechaMes, datoPrueba);
    }

    public void selectYear(Object dataExcel) {
        String datoPrueba = String.valueOf(dataExcel);
        System.out.println("The Year is: " + dataExcel);
        selectElementByValue(locators.fechaYear, datoPrueba);
    }

    public void checkSesion() {
        clicElement(locators.checkNewsletter);
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
