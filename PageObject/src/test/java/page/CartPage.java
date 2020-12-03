package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage{
    private WebDriver driver;
    private ChromeOptions options;

    @FindBy(className = "fc-subtotal__value")
    private WebElement subtotalValue;

    @FindBy(id = "fc-cart")
    private WebElement itemsInfo;

    @FindBy(id = "fc-cart--fixed-width")
    private WebElement itemsWithFreeItem;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public double getSubtotalValue(){
        return Double.parseDouble(subtotalValue.getText().substring(1, subtotalValue.getText().length()));
    }

    public boolean checkFreeGift(){
        return itemsInfo.findElements(By.xpath("//*[@id=\"fc-cart--fixed-width\"]")).size() > 0;
    }
}
