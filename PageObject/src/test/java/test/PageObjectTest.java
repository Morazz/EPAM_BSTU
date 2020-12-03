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

        Assert.assertEquals("160", expectedSubtotalValue);
    }

    @Test
    public void addToCartTest() {
        int expectedItemsAmount = new HomePage(driver)
                .openPage()
                .searchForTerms("wood")
                .selectProduct()
                .addAndGoToCart("0")
                .getItemsAmount();

        Assert.assertEquals("51", expectedItemsAmount);
    }

    @AfterMethod(alwaysRun = true)
    public void browserTearDown() {
        driver.quit();
        driver = null;
    }
}
