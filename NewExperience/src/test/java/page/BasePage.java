package page;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected static WebDriver driver;
    private static WebDriverWait wait;

    static {

        System.setProperty("webdriver.gecko.driver", "src/test/resources/driver/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        driver = new FirefoxDriver(firefoxOptions);
        wait = new WebDriverWait(driver, 20);

    }

    // constructor
    public BasePage(WebDriver driver) {
        BasePage.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    // Funcion para navegar
    public static void navigateTo(String url) {
        driver.get(url);
    }

    // get page url current
    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        return currentUrl;
    }

    private WebElement Find(String locator) {

        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));

    }

    /*
     * private WebElement findById(String locator) {
     * return
     * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator)));
     * }
     */

    public void clicElement(String locator) {
        Find(locator).click();
    }

    public void clicElement2(String locator) {
        driver.findElement(By.xpath(locator)).click();

    }

    // Metodo para ingresar información en un campo de texto
    public void write(String campoBusqueda, String criterioBusqueda) {
        // limpiar texto antes de escribir en el campo
        Find(campoBusqueda).clear();
        // Ingresar texto en el campo de busqueda
        Find(campoBusqueda).sendKeys(criterioBusqueda);
    }

    // compare a text string with a text of a label
    public void compareValues(String locator, String datoPrueba) {
        String elementValue = Find(locator).getAttribute("value");
        assertEquals(datoPrueba, elementValue);
    }

    // Obtener un artibuto de un label
    public String getValue(String locator) {
        String elementValue = Find(locator).getAttribute("value");
        return elementValue;
    }

    public String getText(String locator) {
        String txtWebElement = Find(locator).getText();
        return txtWebElement;
    }

    // Select webelement by value

    public void selectElementByValue(String locator, String datoPrueba) {

        System.out.println("El valor del locator es: " + locator);
        Select dropdown = new Select(driver.findElement(By.xpath(locator)));
        dropdown.selectByValue(datoPrueba);

    }

    // Select webelement by visible text
    public void selectElementByVisibleText(String locator, String datoPrueba) {
        Select s = new Select(driver.findElement(By.xpath(locator)));
        s.selectByVisibleText(datoPrueba);

    }

    /*
     * public void selectElementIntByVisibleText(String locator, int datoPrueba) {
     * Select s = new Select(driver.findElement(By.xpath(locator)));
     * s.selectByValue(datoPrueba);
     * s.selectByIndex(datoPrueba);
     * 
     * }
     */

    public boolean verifyVisibleElement(String locator) {
        boolean element;
        try {

            Find(locator);
            element = true;

        } catch (NoSuchElementException e) {

            System.out.println(e.getMessage());
            System.out.println("Se a generado un error de tipo: " + e.getClass());
            element = false;

        } catch (TimeoutException exp) {

            System.out.println(exp.getMessage());
            System.out.println("Se a generado un error de tipo: " + exp.getClass());
            element = false;
        }
        return element;

        /*
         * Boolean txtAccount2 = driver.findElement(By.xpath(locator)).isDisplayed();
         * System.out.println("El elemento es visible: " + txtAccount);
         * return txtAccount2;
         */

    }

    // upload file on the webpage
    public void uploadFile(String locator, String filePath) {
        driver.findElement(By.xpath(locator)).sendKeys(filePath);
    }

    // Cerrar e navegador
    public static void closeTheWindow() {
        driver.quit();
    }

}
