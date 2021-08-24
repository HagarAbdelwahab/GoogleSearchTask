package pages;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import java.util.List;
import static pages.Helper.readFileTestResources;
import static util.datareaders.ElementReader.readElement;

public class HomePage {
    WebDriver driver;
    private static final SoftAssert softAssertions = new SoftAssert();

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openHomePage() {
        driver.get(readFileTestResources("URL.properties", "url"));
    }

    /**
     * this is to check the suggestions used for easing the search for the used by listing the most matching keywords
     *
     * @param searchKeyWord the user used for search
     */


    public void SearchSuggestionEnabled(String searchKeyWord) {
        driver.findElement(By.xpath(readElement("searchKey"))).sendKeys(searchKeyWord);
        softAssertions.assertEquals(driver.findElement(By.xpath(readElement("searchKey"))).getAttribute("value"), searchKeyWord);
        List<WebElement> links = driver.findElements(By.xpath(readElement("listOfSuggestions")));
        System.out.println((links.size()));
        for (int i = 1; i <= links.size(); i++) {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            String test = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath((readElement("suggestionElement")) + searchKeyWord + "')])[" + i + "]"))).getText();
            softAssertions.assertTrue(StringUtils.containsIgnoreCase(test, searchKeyWord));
            softAssertions.assertAll();
        }
    }
}
