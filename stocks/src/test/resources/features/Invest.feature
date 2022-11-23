Feature: Users should be able to purchase stocks

    Scenario: As a user, I want to purchase stocks from specific companies

        Given the user is on the main page
        When the user selects on a specific company
        When the user selects to buy stocks
        When the user enters the amount of stocks they want to buy
        When the user enters the price per stock they want to pay
        When the user clicks the button to purchase
        When the user confirms they do want to purchase
        Then the user will have bought stocks

    Scenario: As a system, I want to update a company's information if stocks are purchased

        Given the user is on the main page
        When the user buys a stock
        When the page refreshes
        Then the company should reflect an update market cap and price per stock

    Scenario: As a system, I want to prevent users from purchasing stocks for invalid values

        Given the user is on the main page
        When the user selects on a specific company
        When the user selects to buy stocks
        When the user enters the amount of stocks they want to buy
        When the user enters an invalid price per stock they want to pay
        When the user clicks the button to purchase
        Then an alert will pop up to tell the user their purchase is invalid