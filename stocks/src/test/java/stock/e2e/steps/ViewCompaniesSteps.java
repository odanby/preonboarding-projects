package stock.e2e.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stock.e2e.runner.TestRunner;

public class ViewCompaniesSteps {
    
    // Feature: Users of our stock market application should be able to view all companies and their information

    // Scenario: As a user, I want to view all companies' information so I can monitor the stock market

        @When("the user can see stock tickers")
            public void the_user_can_see_stock_tickers(){
                TestRunner.viewCompanies.viewCompanyElementExists("display-original-ticker-2");
            }

        @When("the user can see amounts of stocks")
            public void the_user_can_see_amounts_of_stocks(){
                TestRunner.viewCompanies.viewCompanyElementExists("display-original-amount-2");
            }

        @When("the user can see prices per stock")
            public void the_user_can_see_prices_per_stock(){
                TestRunner.viewCompanies.viewCompanyElementExists("display-original-price-per-stock-2");
            }

        @When("the user can see market capitalizations")
            public void the_user_can_see_market_capitalizations(){
                TestRunner.viewCompanies.viewCompanyElementExists("display-original-market-cap-2");
            }

        
        @Then("the user is able to successfully view companies information")
            public void the_user_is_able_to_successfully_view_companies_information(){
                TestRunner.viewCompanies.viewCompanyElementExists("dynamic-ticker");
            }
}
