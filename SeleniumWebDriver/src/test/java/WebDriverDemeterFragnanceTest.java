import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebDriverDemeterFragnanceTest {
    private  WebDriver driver;
    private ChromeOptions options;

    @BeforeMethod (alwaysRun = true)
    public  void driverMounting() {
        options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void addToCartTest() {
        driver.get("https://demeterfragrance.com/");

        WebElement search = driver.findElement(By.xpath("/html/body/div[1]/header/div[4]/div[1]"));
        search.click();
        search = driver.findElement(By.id("search"));
        search.click();
        search.sendKeys("wood");
        search.submit();

        List<WebElement> searchResult = driver.findElements(By.className("sisea-result"));
        searchResult.get(0).click();
        List<WebElement> itemOptions = driver.findElements(By.className("list_container"));
        WebElement itemOption = itemOptions.get(0).findElement(By.name("quantity"));
        itemOption.click();
        itemOption.sendKeys("50");
        itemOptions.get(0).findElement(By.className("add_button")).click();

        Assert.assertEquals("$160.00", driver.findElement(By.className("fc-subtotal__value")).getText());
    }

    @AfterMethod(alwaysRun = true)
    public void driverDemounting() {
        driver.quit();
    }
}
