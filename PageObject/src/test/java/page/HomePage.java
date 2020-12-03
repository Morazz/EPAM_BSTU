package page;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    public static final String HOMEPAGE_URL = "https://demeterfragrance.com/";
    private  WebDriver driver;
    private ChromeOptions options;

    @FindBy(xpath = "/html/body/div[1]/header/div[4]/div[1]")
    private WebElement searchScope;

    @FindBy(id = "search")
    private WebElement searchInput;

    public  HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage(){
        driver.get(HOMEPAGE_URL);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(searchScope));
        return  this;
    }

    public SearchResultsPage searchForTerms(String searchQuery){
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(searchScope));
        searchScope.click();
        searchInput.click();
        searchInput.sendKeys(searchQuery);
        searchInput.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }
}
