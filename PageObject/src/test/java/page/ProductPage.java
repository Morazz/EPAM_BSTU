package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ProductPage{
    private WebDriver driver;
    private ChromeOptions options;

    @FindBy(xpath = "//*[@id=\"demeterf_1\"]/input[6]")
    private WebElement productsQuantity;

    @FindBy(className = "add_button")
    private WebElement addButton;

    @FindBy(xpath = "//*[@id=\'fc\']/nav/div[2]")
    private WebElement cartLink;

    public ProductPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public CartPage addAndGoToCart(String quantityQuery){
        productsQuantity.click();
        productsQuantity.sendKeys(quantityQuery);
        addButton.click();
        cartLink.click();
        return new CartPage(driver);
    }
}
