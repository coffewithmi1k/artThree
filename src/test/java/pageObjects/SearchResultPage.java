package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultPage extends PageNavigator{

    public SearchResultPage(WebDriver driver){
        super(driver);
    }
    @Step("verify search result")
public WebElement verifySearchResultByLocation(){
        return driver.findElement(By.xpath("//a[@href='/profile/artist/7/view']"));
    }
    }

