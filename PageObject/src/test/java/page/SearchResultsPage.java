package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResultsPage{
    private WebDriver driver;
    private ChromeOptions options;

    @FindBy(className = "sisea-result")
    private List<WebElement> searchResult;

    @FindBy(name = "quantity")
    private WebElement itemsQuantity;

    public  SearchResultsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ProductPage selectProduct(){
        searchResult.get(0).click();
        return new ProductPage(driver);
    }
}
