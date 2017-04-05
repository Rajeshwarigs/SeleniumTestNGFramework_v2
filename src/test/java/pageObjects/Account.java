package pageObjects;

/**
 * Created by rgovinakov on 4/4/2017.
 */
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class Account {

    private WebDriver driver;
    private WebElement elementPresent;
    //String companyTabHomeTitle = "Companies: Home ~ Salesforce - Unlimited Edition";
    //String allTabsPageTitle = "All Tabs ~ Salesforce - Unlimited Edition";

    By companyNewButton = By.name("new");//xpath("//td[@class='pbButton']/input");//??
    By companyRecordTypeLocator = By.id("p3"); // Select Company  Record Type
    By companySaveButton = By.name ("save");
    By companyEditButton = By.name ("edit");
    By companyDeleteButton = By.name ("delete");
    By companySaveandNewButton = By.name("save_new");
    By companyCancelButton = By.name("cancel");
    By companyNameLocator = By.name("acc2");
    By companyPrimaryIndustry = By.name("00NF000000CerIm");
    By companyPrimaryFocusOptions = By.id("00NF000000CerIl_unselected");
    By companyPrimaryFocusSelectionOption = By.className("picklistArrowRight");
    By companyMediaPartner = By.id("CF00NF0000008MKnM");


    WebElement afterActionElement;

    public Account(WebDriver driver) {
        this.driver = driver;
    }

    /* Find elements and try adding Company */
    public WebElement createCompany(String recordType, String companyName, String primaryIndustry, String primaryFocus, String mediaPartner) throws IOException, InterruptedException{

		/* Wait for page to load */
        WebDriverWait wait = new WebDriverWait(driver, 10);
        elementPresent = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(companyNewButton)));

		/* Click on New Button */
        driver.findElement(companyNewButton).click();
        Thread.sleep(10000);
        driver.findElement(companyNameLocator).sendKeys(companyName);
        driver.findElement(companyPrimaryIndustry).sendKeys(primaryIndustry);
        driver.findElement(companyPrimaryFocusOptions).sendKeys(primaryFocus);
        driver.findElement(companyPrimaryFocusSelectionOption).click();
        driver.findElement(companyMediaPartner).clear();
        driver.findElement(companyMediaPartner).sendKeys(mediaPartner);
        driver.findElement(companySaveButton).click();
        utilities.ScreenshotFile.screenshotFileSave(driver);
        elementPresent = wait.until(ExpectedConditions.presenceOfElementLocated(companyNameLocator));
        //driver.findElement(companyDeleteButton).click();
        //driver.switchTo().alert().accept();

		/* Get screenshot*/
        //Utilities.ScreenshotSave.screenshotFileSave(driver);
        return driver.findElement(companyNameLocator);
    }

	/* Click on Edit Button on Company view page
	public void editAndSaveCompany(WebElement companyRec, String companyName) {

		driver.findElement(companyEditButton).click();
		driver.findElement(companyNameLocator).sendKeys(companyName);

	}*/

	/* Click on Cancel Button on New/Select Record Type/Edit Button pages
	public void cancelCompany() {
		 driver.findElement(companyCancelButton).click();
	}	*/

    /* Delete Company Record */
    public Boolean deleteCompany(WebElement companyRec) {
		/* Wait for page to load */
        WebDriverWait wait = new WebDriverWait(driver, 10);
        elementPresent = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(companyDeleteButton)));

        Boolean isCompanyDeleted = false;
        driver.findElement(companyDeleteButton).click();
        driver.switchTo().alert().accept();

		 /* Find Company Tab after deleting a Company */
        if(driver.findElement(companyNameLocator).equals(false))
            isCompanyDeleted = true;

        return isCompanyDeleted;
    }
}
