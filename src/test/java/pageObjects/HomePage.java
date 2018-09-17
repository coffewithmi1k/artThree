package pageObjects;

import io.qameta.allure.Epic;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
@Epic("Smoke tests")

public class HomePage extends PageNavigator {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Open log in pop-up")
    public LogInPage openLogInPage() {
        driver.findElement(By.xpath("//*[@id=\"navbarTopContent\"]/ul/li[6]/a")).click();
        return new LogInPage(driver);
    }

    @Step("Open sign Up pop-up")
    public SignUpPage openSignUpPage() {
        driver.findElement(By.xpath("//*[@id=\"navbarTopContent\"]/ul/li[1]/a")).click();
        return new SignUpPage(driver);

    }

    @Step("Insert data in Search By Name field")
    public void fillSearchByNameField(String searchName) {
        driver.findElement(By.id("artist-search form-control w-100 h-100 border-0")).sendKeys(searchName);
    }
    @Step("Insert data in Location Field")
    public void fillSearchByLocationField(String location){
        driver.findElement(By.id("search-location")).sendKeys(location);
    }

    @Step("Click search button")
    public SearchResultPage clickSearch(){
        driver.findElement(By.xpath("/html/body/section[1]/div/div[2]/form/div/div[3]/div/div[2]/button")).click();
        return new SearchResultPage(driver);
    }
    @Step("Click on main Logo")
    public void clickOnMainLogo(){
        driver.findElement(By.xpath("//a[@class='navbar-brand logo']")).click();
    }
    @Step("Click on Theatre category")
public SearchResultPage clickOnCategoryTheatre(){
        driver.findElement(By.xpath("//a[@href='/search/result?category=3']")).click();
        return new SearchResultPage(driver);
    }

    @Step("Click on Theatre category")
    public SearchResultPage clickEventWedding(){
        driver.findElement(By.xpath("//a[@href='/search/result?theme=2' and @class='book-now']")).click();
        return new SearchResultPage(driver);
    }



}

