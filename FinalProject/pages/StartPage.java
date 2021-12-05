package FinalProject.pages;

import FinalProject.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StartPage extends TestBase {
    String baseUrl = "https://www.1a.lv/";
    private final By searchBar = By.id("q");
    private final By submitButton = By.className("main-search-submit");
    private final By acceptAllCookiesButton = By.id("CybotCookiebotDialogBodyLevelButtonLevelOptinAllowAll");


    public void openStartPage() {
        startDriver();
        open(baseUrl);

    }

    public void acceptAllCookies() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(acceptAllCookiesButton));
        driver.findElement(acceptAllCookiesButton).click();
    }


    public void itemNameInput() {
        driver.findElement(searchBar).sendKeys("Call of Duty: Vanguard playstation 4");
    }

    public void setSubmitButtonClick() {
        driver.findElement(submitButton).click();
    }
}
