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

    @FindBy(xpath = "//*[@id=\"fc-cart--fixed-width\"]/header/div/p/span[1]")
    private WebElement itemsAmount;

    public CartPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public double getSubtotalValue(){
        return Double.parseDouble(subtotalValue.getText().substring(1, subtotalValue.getText().length()));
    }

    public int getItemsAmount(){
        return Integer.parseInt(itemsAmount.getText());
    }
}
