package stock.e2e.poms;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import stock.e2e.runner.TestRunner;
import stock.exceptions.NoElementExists;

public class Invest {
    
    public Invest(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // Scenario: As a user, I want to purchase stocks from specific companies

        //     @When("the user selects on a specific company")
            
            // needs to input ticker then click on search button
            @FindBy(id = "specific-company-input")
            public WebElement specificCompanyInput;

            @FindBy(id = "specific-company-button")
            public WebElement specificCompanyButton;

            public void searchCompany(String ticker){
                this.specificCompanyInput.sendKeys(ticker);
                this.specificCompanyButton.click();
            }

        //     @When("the user enters that company id")

            // needs to send keys to input
            @FindBy(id = "enter-company-id")
            public WebElement enterCompanyId;

            public void enterCompanyId(String id){
                this.enterCompanyId.sendKeys(id);
            }

        //     @When("the user enters the amount of stocks they want to buy")

            // needs to send keys to input
            @FindBy(id = "enter-amount-stocks")
            public WebElement enterAmountStocks;

            public void enterAmountStocks(String amount){
                this.enterAmountStocks.sendKeys(amount);
            }

        //     @When("the user enters the price per stock they want to pay")

            // needs to send keys to input
            @FindBy(id = "enter-buying-price")
            public WebElement enterBuyingPrice;

            public void enterBuyingPrice(String price){
                this.enterBuyingPrice.sendKeys(price);
            }

        //     @When("the user clicks the button to see estimates")

            // needs to click button to see estimates
            @FindBy(id = "show-estimates-button")
            public WebElement showEstimatesButton;

            public void showEstimates(){
                this.showEstimatesButton.click();
            }

        //     @When("the user clicks the button to purchase")

            // needs to click button
            @FindBy(id = "purchase-button")
            public WebElement purchaseButton;

            public void purchaseStocks(){
                this.purchaseButton.click();
            }

        //     @Then("the user will have bought stocks")

            // confirm with alert
            // make sure to click alert ok

    // Scenario: As a system, I want to update a company's information if stocks are purchased

        //     @When("the user buys a stock and the page refreshes")

            // go through the process above within one method

            public void entireProcessBuyStock(String ticker, String id, String amount, String price){

                // first, search up company
                this.specificCompanyInput.sendKeys(ticker);
                this.specificCompanyButton.click();

                // wait for info to load
                TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enter-company-id")));

                // next enter id, amount, price and show estimates
                this.enterCompanyId.sendKeys(id);
                this.enterAmountStocks.sendKeys(amount);
                this.enterBuyingPrice.sendKeys(price);
                this.showEstimatesButton.click();

                // wait for info to load
                TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("purchase-button")));

                // purchase stocks and confirm alert
                this.purchaseButton.click();
                TestRunner.wait.until(ExpectedConditions.alertIsPresent());
                Alert alertPurchaseStocks = TestRunner.driver.switchTo().alert();
                alertPurchaseStocks.accept();
            }

        //     @Then("the company should reflect an updated market cap and price per stock")

            // confirm the title of the page is correct

    // Scenario: As a system, I want to prevent users from purchasing stocks for invalid values

        //     @When("the user enters an invalid amount of stocks they want to buy")

            // need to send keys to input

        //     @Then("an alert will pop up to tell the user their purchase is invalid")

            // need to click alert ok

    // Confirm element exists

        public boolean investElementExists(String id){
            try {
                TestRunner.driver.findElement(By.id(id));
            } catch (NoElementExists e ) {
                return false;
            }
            return true;
        }
}
