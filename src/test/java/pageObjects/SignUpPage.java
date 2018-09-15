package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage extends PageNavigator {
    public SignUpPage(WebDriver driver){
        super(driver);
    }
    @Step("fill all fields with valid data")
    public void fillRegisterFields(String email, String password)
    {
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
        driver.findElement(By.id("email")).sendKeys(email);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("confirm-password")).sendKeys(password);

    }
    @Step("click Sign Up button")
    public void clickSignUpButton(){
        driver.findElement(By.xpath("//*[@id=\"registration\"]/button")).click();
    }
    @Step("verify user got sign up confirmation pop-up")
    public WebElement verifySignUpIsSuccessfull(){
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"confirm-signup\"]/div/div/div[1]/div[3]")));
        return driver.findElement(By.xpath("//*[@id=\"confirm-signup\"]/div/div/div[1]/div[3]"));
    }
}
