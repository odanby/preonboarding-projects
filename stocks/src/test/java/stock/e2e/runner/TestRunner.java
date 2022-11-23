package stock.e2e.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "test/resources/features", glue = "steps")

public class TestRunner {
    
    public static WebDriver driver;
    public static WebDriverWait wait;

    // view companies
        // place my poms in here

    // select specific company
        // place my poms in here

    // filter
        // place my poms in here

    // invest
        // place my poms in here

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 5);

        // add the poms in here later
        // ex: filterCompanies = new FilterCompanies(driver);
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}
