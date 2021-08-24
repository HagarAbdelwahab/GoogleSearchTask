import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.*;
import org.testng.xml.dom.Tag;
import pages.Helper;
import pages.HomePage;
import pages.SearchResultsPage;


public class TestScenario extends BaseTest {
    HomePage home;
    SearchResultsPage searchResultsPage;

    /*
     *Using the same base test web driver for the pages
     */
    @BeforeClass
    public void createAnInstanceOfEachPage() {
        home = new HomePage(driver);
        searchResultsPage = new SearchResultsPage(driver);
    }

    /*
     *This method is to launch the google home page before each test method
     */
    @BeforeMethod
    public void openHomePageOfGoogle() {
        home.openHomePage();
    }

    @Test(priority = 1)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test search for a specific word in google home page")
    @Tag(name = "TC_01")
    public void testSearchInTheHomePage() {
        searchResultsPage.lookForaSpecificWord("Egypt");
        Helper.takeScreenShot("test 1", driver);

    }

    @Test(priority = 2)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test search for a different word in the results page")
    @Tag(name = "TC_02")
    public void testChangeSearchKeywordInResultsPage() {
        searchResultsPage.changeTheSearchKeywordInResultsPage("Egypt", "Athens");
        Helper.takeScreenShot("test 2", driver);
    }

    @Test(priority = 3)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test search for a word that produces no results")
    @Tag(name = "TC_03")
    public void testSearchForAWordThatDoesNotProduceResults() {
        searchResultsPage.searchForANonExistentWord("jfioiojaofjajfajofjaofoajfa");
        Helper.takeScreenShot("test 3", driver);
    }

    @Test(priority = 4)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test search suggestions in the home page")
    @Tag(name = "TC_04")
    public void testSearchSuggestions() {
        home.SearchSuggestionEnabled("egypt");
        Helper.takeScreenShot("test 4", driver);
    }

    @Test(priority = 5)
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test search suggestions in the home page")
    @Tag(name = "TC_05")
    public void testIfSearchFieldInHomePageKeepsHistory() {
        searchResultsPage.returnBackToTheHomePage("Egypt");
        Helper.takeScreenShot("test 5", driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }


}
