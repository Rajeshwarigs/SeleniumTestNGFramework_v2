package utilities;

/**
 * Created by rgovinakov on 4/4/2017.
 */
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
public class ScreenshotFile {
    public static void screenshotFileSave(WebDriver driver) throws IOException {

        String screenshotFileName = System.currentTimeMillis() + "screenshot.png";
        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(screenshotFileName));

    }
}

