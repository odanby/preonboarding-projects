package stock.e2e.steps;

public class InvestSteps {
    
    // Feature: Users should be able to purchase stocks

    // note-- the given steps is on the filter companies steps

    // Scenario: As a user, I want to purchase stocks from specific companies

        @When("the user selects on a specific company"){
            public void the_user_selects_on_a_specific_company(){

            }
        }

        @When("the user enters the amount of stocks they want to buy"){
            public void the_user_enters_the_amount_of_stocks_they_want_to_buy(){

            }
        }

        @When("the user enters the price per stock they want to pay"){
            public void the_user_enters_the_price_per_stock_they_want_to_pay(){

            }
        }

        @When("the user clicks the button to see estimates"){
            public void the_user_clicks_the_button_to_see_estimates(){

            }
        }

        @When("the user clicks the button to purchase"){
            public void the_user_clicks_the_button_to_purchase(){

            }
        }

        @When("the user confirms they do want to purchase"){
            public void the_user_confirms_they_do_want_to_purchase(){

            }
        }

        @Then("the user will have bought stocks"){
            public void the_user_will_have_bought_stocks(){

            }
        }

    // Scenario: As a system, I want to update a company's information if stocks are purchased

        @When("the user buys a stock and the page refreshes"){
            public void the_user_buys_a_stock_and_the_page_refreshes(){

            }
        }

        @Then("the company should reflect an update market cap and price per stock"){
            public void the_company_should_reflect_an_update_market_cap_and_price_per_stock(){

            }
        }

    // Scenario: As a system, I want to prevent users from purchasing stocks for invalid values

        @When("the user enters an invalid price per stock they want to pay"){
            public void the_user_enters_an_invalid_price_per_stock_they_want_to_pay(){

            }
        }

        @Then("an alert will pop up to tell the user their purchase is invalid"){
            public void an_alert_will_pop_up_to_tell_the_user_their_purchase_is_invalid(){

            }
        }
}
