package testScripts;

import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.Login;
/**
 * Created by rgovinakov on 4/4/2017.
 */
public class LoginTest implements TestInput{
    /* This test script login page */
    private WebDriver driver;
    private Login login;

    /* Setup Browser that the test going to be running on */
    @BeforeTest
    public void setUp() {
        //System.setProperty("webdriver.gecko.driver", "Selenium Driver Related Files/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get(loginUrl);
        login = new Login (driver);
    }

    /* Test Login*/
    @Test
    public void loginTestSuccess() throws IOException {

    /* Login with correct Username and Password */
        login.with(testUsername, testPassword);
        Assert.assertEquals(login.loginSuccess(), homePageTitle);
        utilities.ScreenshotFile.screenshotFileSave(driver);
    }

    /* Close the Browser after test run */
    @AfterTest
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
