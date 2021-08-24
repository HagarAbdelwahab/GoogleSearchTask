import com.opencsv.CSVReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import util.constants.Constants;
import java.io.FileReader;
import java.io.IOException;

public class BaseTest {
    WebDriver driver;
    CSVReader reader;

    /*
     * This step is to initiate the driver instance for different browser types, just you need to specify the browser name for
     * your test in the BrowserConfig.csv file attached with the relative location for the driver executable file.
     */
    @BeforeClass
    public void setupDriver() throws IOException{
        String CSV_file = Constants.TEST_DATA_PATH + "BrowserConfig.csv";
        reader = new CSVReader(new FileReader(CSV_file));
        String[] cell;

        while ((cell = reader.readNext()) != null)
        {
            String driverrname = cell[0];
            String driverloaction = cell[1];

            if(driverrname.equalsIgnoreCase("Chrome"))
            {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\"+driverloaction);
                driver = new ChromeDriver();
            }

            else
            {
                System.out.println("driver you specified is not available");
            }
            driver.manage().window().maximize();

        }
    }

}
