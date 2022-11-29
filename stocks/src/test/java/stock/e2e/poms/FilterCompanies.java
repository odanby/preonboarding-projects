package stock.e2e.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stock.e2e.runner.TestRunner;
import stock.exceptions.NoElementExists;

public class FilterCompanies {

    public FilterCompanies(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    
    // @When("the user selects to view by market cap")
        @FindBy(id = "filter-market-cap")
        public WebElement filterMarketCap;

            public void clickFilterMarketCap(){
                this.filterMarketCap.click();
            }

        @FindBy(id = "new-filter-input-market-cap")
        public WebElement filterInputMarketCap;

            public void enterFilterInputMarketCap(String market_cap){
                this.filterInputMarketCap.sendKeys(market_cap);
            }

        @FindBy(id = "new-filter-button-market-cap")
        public WebElement filterButtonMarketCap;
            
            public void goButtonFilterMarketCap(){
                this.filterButtonMarketCap.click();
            }

    // @When("the user selects to view by amount of stocks")
        @FindBy(id = "filter-amount-stocks")
        public WebElement filterAmountStocks;

            public void clickFilterAmountStocks(){
                this.filterAmountStocks.click();
            }

        @FindBy(id = "new-filter-input-amount-stocks")
        public WebElement filterInputAmountStocks;

            public void enterFilterInputAmountStocks(String amount){
                this.filterInputAmountStocks.sendKeys(amount);
            }

        @FindBy(id = "new-filter-button-amount-stocks")
        public WebElement filterButtonAmountStocks;

            public void goButtonFilterAmountStocks(){
                this.filterButtonAmountStocks.click();
            }

    // @When("the user selects to view by price per stock")
        @FindBy(id = "filter-price-per-stock")
        public WebElement filterPricePerStock;

            public void clickFilterPricePerStock(){
                this.filterPricePerStock.click();
            }

        @FindBy(id = "new-filter-input-price-per-stock")
        public WebElement filterInputPricePerStock;

            public void enterFilterInputPricePerStock(String price){
                this.filterInputPricePerStock.sendKeys(price);
            }

        @FindBy(id = "new-filter-button-filter-price-per-stock")
        public WebElement filterButtonPricePerStock;

            public void goButtonFilterPricePerStock(){
                this.filterPricePerStock.click();
            }

    // @When("the user clicks the remove filters button")
        @FindBy(id = "remove-filters")
        public WebElement removeFiltersButton;

            public void removeFiltersButton(){
                this.removeFiltersButton.click();
            }

            
    // Check if the table still exists
        public boolean elementExists(String id){
            try {
                TestRunner.driver.findElement(By.id(id));
            } catch (NoElementExists e) {
                return false;
            }
            return true;
        }    
}
