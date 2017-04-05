package testScripts;

import java.io.IOException;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import pageObjects.Login;
import pageObjects.Account;
/**
 * Created by rgovinakov on 4/5/2017.
 */
public class AddProductTest implements TestInput{

        private WebDriver driver;
        private Login login;
        private Account account;
        private String recordType = "SML Company";
        private String companyName = "Test SML Company??";
        private String primaryIndustry = "Auto";
        private String primaryFocus = "Auto Auction";
        private String mediaPartner = "G/O Digital, Phoenix AZ";
        private WebElement companyRecCreated;
        private Boolean isDeleted = false;

        /* Setup Browser that the test going to be running on */
        @BeforeTest
        public void setUp() {
            driver = new FirefoxDriver();
            login = new Login (driver);
            account = new Account (driver);

        }

        /* Test Login*/
        @Test
        public void CBLTest() throws IOException, InterruptedException {

		/* Login with right Username & Password */
            driver.get(loginUrl);
            login.with(testUsername, testPassword);
            driver.get(companiesUrl);
		/* Create Company */
            companyRecCreated =
                    account.createCompany(recordType, companyName, primaryIndustry, primaryFocus, mediaPartner);
            Assert.assertEquals(companyRecCreated.isDisplayed(), true);

		/*company.editAndSaveCompany(companyRecCreated, "companyName");
		Assert.assertEquals(companyRecCreated.isDisplayed(), true);*/

		/* Delete the Company Record created */
            isDeleted = account.deleteCompany(companyRecCreated);
            Assert.assertTrue(isDeleted);

        }

        /* Close the Browser after test run */
        @AfterTest
        public void tearDown() {
            if (driver != null)
                driver.quit();
        }


}
