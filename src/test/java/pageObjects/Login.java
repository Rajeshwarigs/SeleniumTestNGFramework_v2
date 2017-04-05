package pageObjects;

/**
 * Created by rgovinakov on 4/4/2017.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class Login {
    private WebDriver driver;

    /* Login Page elements needed for logging in */
    By usernameLocator = By.id("username");
    By passwordLocator = By.id("password");
    By loginButton = By.id("Login");
    By userHomeTabLocator = By.id("home_Tab");

    /* Set up the site under test*/
    public Login(WebDriver driver) {
        this.driver = driver;
    }

    /* Find elements and try Logging in */
    public void with(String username, String password) {
        driver.findElement(usernameLocator).sendKeys(username);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButton).click();

		/* Wait for page to load */
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = (WebElement) wait.until(ExpectedConditions.elementToBeClickable(userHomeTabLocator));
    }

    /* On success, get page title */
    public String loginSuccess() {
        return driver.getTitle();
    }
}
