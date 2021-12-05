package FinalProject.pages;

import FinalProject.base.TestBase;
import org.openqa.selenium.By;

public class LoginPage extends TestBase {
    private final By noRegEmail = By.xpath("(//input[@type='email'])[2]");
    private final By continueButton = By.xpath("//input[@value='Turpināt']");


    public void enterNoRegEmail(String email) {
        driver.findElement(noRegEmail).sendKeys(email);
    }

    public void setContinueButtonClick() {
        driver.findElement(continueButton).click();
    }

}