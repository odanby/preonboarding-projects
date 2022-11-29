package stock.e2e.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stock.e2e.runner.TestRunner;

public class FilterCompaniesSteps {
    
    // Feature: Users should be able to filter companies based on particular criteria

    // Scenario: As a user, I want to view companies by market capitalization

        @Given("the user is on the main page")
            public void the_user_is_on_the_main_page(){
                TestRunner.driver.get("File://C:/Users/orian/preonboarding-projects/stocks/src/test/resources/webpages/main-page.html");
            }

        @When("the user selects to view by market cap")
            public void the_user_selects_to_view_by_market_cap(){
                TestRunner.filterCompanies.clickFilterMarketCap();
            }

        @When("the user enters a market cap input")
            public void the_user_enters_a_market_cap_input(){
                TestRunner.filterCompanies.enterFilterInputMarketCap("600");
            }

        @When("the user clicks the go button for market cap")
            public void the_user_clicks_the_go_button_for_market_cap(){
                TestRunner.filterCompanies.goButtonFilterMarketCap();
            }

        @Then("the user will view companies filtered by market cap")
            public void the_user_will_view_companies_filtered_by_market_cap(){
                TestRunner.filterCompanies.elementExists("dynamic-ticker");
            }

    // Scenario: As a user, I want to view companies by amount of stocks

        @When("the user selects to view by amount of stocks")
            public void the_user_selects_to_view_by_amount_of_stocks(){
                TestRunner.filterCompanies.clickFilterAmountStocks();
            }

        @When("the user enters an amount of stocks input")
            public void the_user_enters_an_amount_of_stocks_input(){
                TestRunner.filterCompanies.enterFilterInputAmountStocks("100");
            }

        @When("the user clicks the go button for amount of stocks")
            public void the_user_clicks_the_go_button_for_amount_of_stocks(){
                TestRunner.filterCompanies.goButtonFilterAmountStocks();
            }

        @Then("the user will view companies filtered by amount of stocks")
            public void the_user_will_view_companies_filtered_by_amount_of_stocks(){
                TestRunner.filterCompanies.elementExists("dynamic-ticker");
            }

    // Scenario: As a user, I want to view companies by price per stock

        @When("the user selects to view by price per stock")
            public void the_user_selects_to_view_by_price_per_stock(){
                TestRunner.filterCompanies.clickFilterPricePerStock();
            }

        @When("the user enters a price per stock input")
            public void the_user_enters_a_price_per_stock_input(){
                TestRunner.filterCompanies.enterFilterInputPricePerStock("40");
            }

        @When("the user clicks the go button for price per stock")
            public void the_user_clicks_the_go_button_for_price_per_stock(){
                TestRunner.filterCompanies.goButtonFilterPricePerStock();
            }

        @Then("the user will view companies filtered by price per stock")
            public void the_user_will_view_companies_filtered_by_price_per_stock(){
                TestRunner.filterCompanies.elementExists("dynamic-ticker");
            }

    // Scenario: As a user, I want to remove filters from my view

        @When("the user clicks the remove filters button")
            public void the_user_clicks_the_remove_filters_button(){
                TestRunner.filterCompanies.removeFiltersButton();
            }

        @Then("the user will view companies without filters")
            public void the_user_will_view_companies_without_filters(){
                TestRunner.filterCompanies.elementExists("dynamic-ticker");
            }
}
