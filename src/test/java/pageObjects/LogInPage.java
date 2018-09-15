package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LogInPage extends PageNavigator{
    public LogInPage(WebDriver driver){
        super(driver);
    }


    @Step("Fill log in fields with valid data")
    public void fillLogInFields(String email, String password){
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("username")));
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.id("username")).sendKeys(email);
        driver.findElement(By.id("reg-password")).sendKeys(password);
    }

    @Step("Click Log in button")
    public void clickLogInButton(){
        driver.findElement(By.xpath("//*[@id=\"login\"]/button")).click();
    }

    @Step("Verify user is logged In")
    public WebElement verifyUserLogged(){
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("navbarDropdown2")));


        return driver.findElement(By.id("navbarDropdown2"));
    }
}
