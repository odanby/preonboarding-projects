package stock.e2e.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stock.e2e.runner.TestRunner;
import stock.exceptions.NoElementExists;

public class SelectSpecificCompany {

    public SelectSpecificCompany(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // @When("the user enters in a company ticker")
    @FindBy(id = "specific-company-input")
    public WebElement specificCompanyInput;

        public void enterCompanyTickerInput(String ticker){
            this.specificCompanyInput.sendKeys(ticker);
        }

    // @When("the user clicks the search button")
    @FindBy(id = "specific-company-button")
    public WebElement specificCompanyButton;

        public void searchSpecificCompany(){
            this.specificCompanyButton.click();
        }

    // @Then("the user will be able to view the companys detailed information")
    public boolean companyElementExists(String id){
        try {
            TestRunner.driver.findElement(By.id(id));
        } catch (NoElementExists e) {
            return false;
        }
        return true;
    }    
    
}
