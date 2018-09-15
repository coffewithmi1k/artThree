package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.concurrent.TimeUnit;

public class SmokeTest {

     /*
    1. Check WebsiteisOn+
    2. Check Log in+
    3. Check Sign Up confirmation pop-up+
    4. Check that search by Name from the main page works+
    5. Check that search by Event from the main page works +
    6. Check that search by Location works from the main page.+
    7. Check Search by Categories;+
    8. Check search by Event type
    9. Check main logo redirects to the Home Page.+

     */

    WebDriver driver;
    int random = (int) (Math.random() * 100000 + 1);

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test(description = "Check WebsiteisOn", priority = 0)
    public void checkHomePageOpened() {
        PageNavigator pn = new PageNavigator(driver);
        pn.openHomePage();
        assertThat(driver.getTitle(), equalTo("Artist Next Door"));
    }

    @Test(description = "Check main logo redirects to the Home Page.")
    public void checkMainLogo() {
        PageNavigator pn = new PageNavigator(driver);
        HomePage onHomePage = pn.openHomePage();
        onHomePage.clickOnMainLogo();
        assertThat(driver.getTitle(), equalTo("Artist Next Door"));

    }

    @Test(description = "Check Log in", priority = 1)
    public void checkUserCanLogin() throws InterruptedException {
        PageNavigator pn = new PageNavigator(driver);
        HomePage onHomePage = pn.openHomePage();
        LogInPage onLogInPage = onHomePage.openLogInPage();
        Thread.sleep(3000);
        onLogInPage.fillLogInFields("coffe1@mailinator.com", "qwe1156q");
        onLogInPage.clickLogInButton();
        assertThat(onLogInPage.verifyUserLogged().getText(), equalTo("coffe1@mailinator.com"));

    }

    @Test(description = "Check Sign Up confirmation pop-up", priority = 2)
    public void checkUserCanSignUP() throws InterruptedException {
        PageNavigator pn = new PageNavigator(driver);
        HomePage onHomePage = pn.openHomePage();
        SignUpPage onSignUpPage = onHomePage.openSignUpPage();
        Thread.sleep(3000);
        onSignUpPage.fillRegisterFields("coffe" + random + "@mailinator.com", "qwe1156q");
        onSignUpPage.clickSignUpButton();
        Thread.sleep(3000);
        assertThat(onSignUpPage.verifySignUpIsSuccessfull().getText(), equalTo("Welcome to Artist"));

    }

    @Test(description = "Check that search by Name from the main page works")
    public void checkMainSearchByName() throws InterruptedException {
        PageNavigator pn = new PageNavigator(driver);
        HomePage onHomePage = pn.openHomePage();
        onHomePage.fillSearchByNameField("China girl");
        SearchResultPage onSearchResultPage = onHomePage.clickSearch();
        Thread.sleep(5000);
        assertThat(onSearchResultPage.verifySearchResultByLocation().getText(), equalTo("Book Now"));
    }

    @Test(description = "Check that search by Event from the main page works")
    public void checkMainSearchByEvent() throws InterruptedException {
        PageNavigator pn = new PageNavigator(driver);
        HomePage onHomePage = pn.openHomePage();
        onHomePage.fillSearchByNameField("Wedding");
        SearchResultPage onSearchResultPage = onHomePage.clickSearch();
        Thread.sleep(5000);
        assertThat(onSearchResultPage.verifySearchResultByLocation().getText(), equalTo("Book Now"));

    }

    @Test(description = "Check that search by Location works from the main page.")
    public void checkMainSearchByLocation() throws InterruptedException {
        PageNavigator pn = new PageNavigator(driver);
        HomePage onHomePage = pn.openHomePage();
        onHomePage.fillSearchByLocationField("Hamar");
        SearchResultPage onSearchResultPage = onHomePage.clickSearch();
        Thread.sleep(3000);
        assertThat(onSearchResultPage.verifySearchResultByLocation().getText(), equalTo("Book Now"));
    }

    @Test(description = "Check Search by Categories")
    public void checkSearchByCategories() throws InterruptedException {
        PageNavigator pn = new PageNavigator(driver);
        HomePage onHomePage = pn.openHomePage();
        SearchResultPage onSearchResultPage= onHomePage.clickOnCategoryTheatre();
        assertThat(onSearchResultPage.verifySearchResultByLocation().getText(), equalTo("Book Now"));

    }

    @Test(description = "Check search by Event type")
public void checkSearchByEvents(){
        PageNavigator pn = new PageNavigator(driver);
        HomePage onHomePage = pn.openHomePage();
        SearchResultPage onSearchResultPage= onHomePage.clickEventWedding();
        assertThat(onSearchResultPage.verifySearchResultByLocation().getText(), equalTo("Book Now"));

    }
}
