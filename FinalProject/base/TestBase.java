package FinalProject.base;

import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {

    public static ChromeDriver driver;

    public void startDriver() {
        String driverPath = "C:\\Lecture6Automstion\\src\\test\\resources\\";
        System.setProperty("webdriver.chrome.driver", driverPath + "chromedriver.exe");
        driver = new ChromeDriver();

    }

    public void open(String url) {
        driver.get(url);
        driver.manage().window().maximize();

    }


}




