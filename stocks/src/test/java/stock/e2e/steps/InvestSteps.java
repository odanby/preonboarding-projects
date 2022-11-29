package stock.e2e.steps;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stock.e2e.runner.TestRunner;

public class InvestSteps {
    
    // Feature: Users should be able to purchase stocks

    // note-- the given steps is on the filter companies steps

    // Scenario: As a user, I want to purchase stocks from specific companies

        @When("the user selects on a specific company")
            public void the_user_selects_on_a_specific_company(){
                TestRunner.invest.searchCompany("PLLO");
            }

        @When("the user enters that company id")
            public void the_user_enters_that_company_id(){
                // need to add a wait until you can see the company id
                TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enter-company-id")));
                TestRunner.invest.enterCompanyId("11");
            }

        @When("the user enters the amount of stocks they want to buy")
            public void the_user_enters_the_amount_of_stocks_they_want_to_buy(){
                TestRunner.invest.enterAmountStocks("20");
            }

        @When("the user enters the price per stock they want to pay")
            public void the_user_enters_the_price_per_stock_they_want_to_pay(){
                TestRunner.invest.enterBuyingPrice("100");
            }

        @When("the user clicks the button to see estimates")
            public void the_user_clicks_the_button_to_see_estimates(){
                TestRunner.invest.showEstimates();
            }

        @When("the user clicks the button to purchase")
            public void the_user_clicks_the_button_to_purchase(){
                // needs to wait until button is visible
                TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("purchase-button")));
                // confirm that the total purchase cost is there
                TestRunner.invest.investElementExists("buy-total");
                // confirm that the new market cap est is there
                TestRunner.invest.investElementExists("new-market-capitalization-estimate");
                // confirm that the new price per stock is there
                TestRunner.invest.investElementExists("new-price-per-stock-estimate");
                TestRunner.invest.purchaseStocks();
            }

        @Then("the user will have bought stocks")
            public void the_user_will_have_bought_stocks(){
                TestRunner.wait.until(ExpectedConditions.alertIsPresent());
                Alert alertPurchaseStocks = TestRunner.driver.switchTo().alert();
                alertPurchaseStocks.accept();
            }

    // Scenario: As a system, I want to update a company's information if stocks are purchased

        @When("the user buys a stock and the page refreshes")
            public void the_user_buys_a_stock_and_the_page_refreshes(){
                TestRunner.invest.entireProcessBuyStock("PLLO", "11", "30", "370");
            }

        @Then("the company should reflect an updated market cap and price per stock")
            public void the_company_should_reflect_an_updated_market_cap_and_price_per_stock(){
                TestRunner.wait.until(ExpectedConditions.titleIs("Stock Market"));
                String title = TestRunner.driver.getTitle();
                Assert.assertEquals("Stock Market", title);
            }

    // Scenario: As a system, I want to prevent users from purchasing stocks for invalid values

        @When("the user enters an invalid amount of stocks they want to buy")
            public void the_user_enters_an_invalid_amount_of_stocks_they_want_to_buy(){
                TestRunner.invest.enterAmountStocks("200");
            }

        @Then("an alert will pop up to tell the user their purchase is invalid")
            public void an_alert_will_pop_up_to_tell_the_user_their_purchase_is_invalid(){
                TestRunner.wait.until(ExpectedConditions.alertIsPresent());
                Alert alertInvalidAmount = TestRunner.driver.switchTo().alert();
                alertInvalidAmount.accept();
            }
}
