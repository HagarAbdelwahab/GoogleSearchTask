package pages;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import util.constants.Constants;
import util.datareaders.PropertiesReader;
import java.io.File;
import java.io.IOException;

public class Helper {

    public static void takeScreenShot(String page, WebDriver driver) {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile = new File(System.getProperty("user.dir") + "\\screenshots\\" + page);
        try {
            FileUtils.copyFile(SrcFile, DestFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFileMainResources(String fileName, String propertyName) {
        PropertiesReader.readProperties(Constants.MAIN_RESOURCES_DATA + fileName);
        return PropertiesReader.getPropertyValue(propertyName);
    }

    public static String readFileTestResources(String fileName, String propertyName) {
        PropertiesReader.readProperties(Constants.TEST_RESOURCES_PROPERTIES + fileName);
        return PropertiesReader.getPropertyValue(propertyName);
    }

}
