package FinalProject.pages;

import FinalProject.base.TestBase;
import FinalProject.models.Customer;
import FinalProject.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ItemPage extends TestBase {


    Customer customer = new Customer();
    Product product = new Product();


    private final By itemSelection = By.xpath("(//a[@class='ks-new-product-name'])[1]");
    private final By addItem = By.id("add_to_cart_btn");
    private final By goToBasketButton = By.xpath("//a[@class='main-button']");
    private final By proceedToPayment = By.xpath("//input[@value='Veikt apmaksu']");
    private final By shipmentField = By.xpath("//input[@value='2']");
    private final By pickupPlace = By.xpath("(//div[@class='pickup-point-name'])[1]");
    private final By nameField = By.id("address_first_name");
    private final By surnameField = By.id("address_last_name");
    private final By phoneNumberField = By.id("address_phone_number");
    private final By saveCredentials = By.xpath("(//button[@type='submit'])[1]");
    private final By paymentButton = By.xpath("(//button[@type='submit'])[2]");
    private final By paymentMethod = By.id("payment_unused_22");


    public void setItemSelectionClick() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000)");

        wait.until(ExpectedConditions.elementToBeClickable(itemSelection));
        driver.findElement(itemSelection).click();
    }

    public void setAddItemClick() {
        String Name = driver.findElement(By.cssSelector(".product-righter h1")).getText();
        product.setProductName(Name);
        String Price = driver.findElement(By.xpath("//span[@class='price']")).getText();
        product.setProductPrice(Price);
        driver.findElement(addItem).click();
    }

    public void setGoToBasketButtonClick() {


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(goToBasketButton));
        driver.findElement(goToBasketButton).click();
    }

    public void nameAndPriceValidation() {
        String actualName = driver.findElement(By.xpath("//p[@class='detailed-cart-item__name']")).getText();
        assertThat(actualName).isEqualTo(product.getProductName());

        String actualPrice = driver.findElement(By.xpath("//p[@class='detailed-cart-item__price']")).getText();
        String expectedPrice = product.getProductPrice();
        assertThat(actualPrice).isEqualTo(expectedPrice.substring(0, 7));
    }

    public void setProceedToPaymentClick() {

        driver.findElement(proceedToPayment).click();
    }

    public void setShipmentFieldClick() {

        driver.findElement(shipmentField).click();
    }


    public void setPickupPlaceClick() {

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='plainoverlay']"))));


        wait.until(ExpectedConditions.elementToBeClickable(pickupPlace));
        driver.findElement(pickupPlace).click();
    }


    public void enterCredentials(String name, String surname, String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,2000);");
        wait.until(ExpectedConditions.presenceOfElementLocated(nameField));

        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);

    }

    public void setSaveCredentialsClick() {
        Actions actions = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);


        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1000);");
        actions.moveToElement(driver.findElement(saveCredentials));
        wait.until(ExpectedConditions.elementToBeClickable(saveCredentials));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", driver.findElement(saveCredentials));

    }

    public void setPaymentButtonClick() {
        Actions actions = new Actions(driver);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.elementToBeClickable(paymentButton));

        ((JavascriptExecutor) driver).executeScript("arguments[0].submit();", driver.findElement(By.xpath("(//form[@class='default-form'])[1]")));


    }

    public void setPaymentMethodClick() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(paymentMethod));
        driver.findElement(paymentMethod).click();
    }


    public void nameSurnamePhonePriceValidation() {


        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='name']")));

        String actualNameAndSurname = driver.findElement(By.xpath("//div[@class='name']")).getText();
        assertThat(actualNameAndSurname).isEqualTo(customer.getNameAndSurname());

        String actualPhoneNumber = driver.findElement(By.xpath("//div[@class='address']")).getText();
        assertThat(actualPhoneNumber.substring(0, 8)).isEqualTo(customer.getUserPhoneNumber());

        String actualPrice = driver.findElement(By.xpath("//span[@class='checkout-order-summary-total__price']")).getText();
        String expectedPrice = product.getProductPrice();
        assertThat(actualPrice).isEqualTo(expectedPrice.substring(0, 7));
    }
}