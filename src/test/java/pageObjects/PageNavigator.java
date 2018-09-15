package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class PageNavigator {

    WebDriver driver;

    public PageNavigator(WebDriver driver){
        this.driver = driver;
    }

    @Step("Navigate to Home Page")
    public HomePage openHomePage(){
        driver.get("https://stage.your-nextdoor.com/");
        return new HomePage(driver);
    }
}
