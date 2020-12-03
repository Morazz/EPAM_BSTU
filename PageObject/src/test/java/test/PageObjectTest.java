package test;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageObjectTest {
    private WebDriver driver;
    private ChromeOptions options;

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        System.setProperty("webdriver.chrome.driver", "D:\\webdriver\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

   @Test
    public void addToCartAndGetSubtotalValueTest() {
        double expectedSubtotalValue = new HomePage(driver)
                .openPage()
                .searchForTerms("wood")
                .selectProduct()
                .addAndGoToCart("50")
                .getSubtotalValue();

        Assert.assertEquals(160.0, expectedSubtotalValue, 0.001);
    }

    @Test
    public void addToCartAndHasNoFreeItemTest() {
        boolean expectedFreeItem = new HomePage(driver)
                .openPage()
                .searchForTerms("wood")
                .selectProduct()
                .addAndGoToCart("5")
                .checkFreeGift();

        Assert.assertFalse(expectedFreeItem);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
