package FinalProject.testRunner;

import FinalProject.base.TestBase;
import FinalProject.models.Customer;
import FinalProject.pages.ItemPage;
import FinalProject.pages.LoginPage;
import FinalProject.pages.StartPage;
import org.junit.Test;

public class TestRunnerOneAlv extends TestBase {

    StartPage startPage = new StartPage();
    ItemPage itemPage = new ItemPage();
    LoginPage loginPage = new LoginPage();
    Customer customer = new Customer();

    @Test
    public void itemBuyingTest() {
        startPage.openStartPage();
        startPage.acceptAllCookies();
        startPage.itemNameInput();
        startPage.setSubmitButtonClick();
        itemPage.setItemSelectionClick();
        itemPage.setAddItemClick();
        itemPage.setGoToBasketButtonClick();
        itemPage.nameAndPriceValidation();
        itemPage.setProceedToPaymentClick();
        loginPage.enterNoRegEmail(customer.getUserEmail1());
        loginPage.setContinueButtonClick();
        itemPage.setShipmentFieldClick();
        itemPage.setPickupPlaceClick();
        itemPage.enterCredentials(customer.getUserName(), customer.getUserSurname(), customer.getUserPhoneNumber());
        itemPage.setSaveCredentialsClick();
        itemPage.setPaymentButtonClick();
        itemPage.setPaymentMethodClick();
        itemPage.nameSurnamePhonePriceValidation();


    }
}