package stock.e2e.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

        @FindBy(id = "new-filter-button-market-cap")
        public WebElement filterButtonMarketCap;

    // @When("the user selects to view by amount of stocks")
        @FindBy(id = "filter-amount-stocks")
        public WebElement filterAmountStocks;

            public void clickFilterAmountStocks(){
                this.filterAmountStocks.click();
            }

        @FindBy(id = "new-filter-input-amount-stocks")
        public WebElement filterInputAmountStocks;

        @FindBy(id = "new-filter-button-amount-stocks")
        public WebElement filterButtonAmountStocks;

    // @When("the user selects to view by price per stock")
        @FindBy(id = "filter-price-per-stock")
        public WebElement filterPricePerStock;

            public void clickFilterPricePerStock(){
                this.filterPricePerStock.click();
            }

        @FindBy(id = "new-filter-input-price-per-stock")
        public WebElement filterInputPricePerStock;

        @FindBy(id = "new-filter-button-filter-price-per-stock")
        public WebElement filterButtonPricePerStock;

}
