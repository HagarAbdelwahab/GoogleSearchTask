package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import static util.datareaders.ElementReader.readElement;

public class SearchResultsPage {
    WebDriver driver;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    private static final SoftAssert softAssertions = new SoftAssert();

    /**
     * this is a search for a word and check that results page search field has the same keyword
     *
     * @param searchKeyWord the user used for search
     */
    public void lookForaSpecificWord(String searchKeyWord) {
        driver.findElement(By.xpath(readElement("searchKey"))).sendKeys(searchKeyWord);
        //assert that the inout from the keyboard is displayed
        softAssertions.assertEquals(driver.findElement(By.xpath(readElement("searchKey"))).getAttribute("value"), searchKeyWord);
        driver.findElement(By.xpath(readElement("searchKey"))).sendKeys(Keys.ENTER);
        //assert that the the search key word is in the search results input field
        softAssertions.assertEquals(driver.findElement(By.xpath(readElement("searchKey"))).getAttribute("value"), searchKeyWord);
        softAssertions.assertAll();
    }


    /**
     * this method to search for a word in the home page then changing the keyword in the results page
     *
     * @param searchKeyWord1 user first search keyword in the home page
     * @param searchKeyWord2 user second search keyword in the results page
     */
    public void changeTheSearchKeywordInResultsPage(String searchKeyWord1, String searchKeyWord2) {
        driver.findElement(By.xpath(readElement("searchKey"))).sendKeys(searchKeyWord1 + Keys.ENTER);
        softAssertions.assertEquals(driver.findElement(By.xpath(readElement("searchKey"))).getAttribute("value"), searchKeyWord1);
        driver.findElement(By.xpath(readElement("searchKey"))).clear();
        driver.findElement(By.xpath(readElement("searchKey"))).sendKeys(searchKeyWord2 + Keys.ENTER);
        softAssertions.assertEquals(driver.findElement(By.xpath(readElement("searchKey"))).getAttribute("value"), searchKeyWord2);
        softAssertions.assertAll();
    }

    /**
     * this method to check the suggestions when the user looks for a word that produces no results
     *
     * @param searchKeyword user first search keyword in the home page
     */
    public void searchForANonExistentWord(String searchKeyword) {
        driver.findElement(By.xpath(readElement("searchKey"))).sendKeys(searchKeyword + Keys.ENTER);
        softAssertions.assertEquals(driver.findElement(By.xpath(readElement("searchKey"))).getAttribute("value"), searchKeyword);
        softAssertions.assertEquals(driver.findElement(By.xpath(readElement("suggestionsMessage"))).getText(), "Suggestions:");
        softAssertions.assertAll();
    }

    /**
     * this method to check if the search field in the home page keeps history of the search key word when returning back to it from results page
     *
     * @param searchKeyword user first search keyword in the home page
     */
    public void returnBackToTheHomePage(String searchKeyword) {
        driver.findElement(By.xpath(readElement("searchKey"))).sendKeys(searchKeyword);
        softAssertions.assertEquals(driver.findElement(By.xpath(readElement("searchKey"))).getAttribute("value"), searchKeyword);
        driver.findElement(By.xpath(readElement("searchKey"))).sendKeys(Keys.ENTER);
        driver.navigate().back();
        softAssertions.assertEquals(driver.findElement(By.xpath(readElement("searchKey"))).getAttribute("value"), "");
        softAssertions.assertAll();
    }


}
