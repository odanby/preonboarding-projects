package stock.e2e.runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import stock.e2e.poms.FilterCompanies;
import stock.e2e.poms.SelectSpecificCompany;
import stock.e2e.poms.ViewCompanies;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", glue = "stock/e2e/steps")

public class TestRunner {
    
    public static WebDriver driver;
    public static WebDriverWait wait;

    // view companies
        public static ViewCompanies viewCompanies;

    // select specific company
        public static SelectSpecificCompany selectSpecificCompany;

    // filter
        public static FilterCompanies filterCompanies;

    // invest
        // place my poms in here

    @BeforeClass
    public static void setup(){
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 5);

        // add the poms in here later
        
            filterCompanies = new FilterCompanies(driver);
            viewCompanies = new ViewCompanies(driver);
            selectSpecificCompany = new SelectSpecificCompany(driver);
    }

    @AfterClass
    public static void teardown(){
        driver.quit();
    }

}
