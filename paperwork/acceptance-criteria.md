Feature: Users of our stock market application should be able to view all companies and their information

    Scenario: As a user, I want to view all companies' information so I can monitor the stock market

        Given the user is on the main page
        When the user can see stock ticker symbols
        When the user can see amounts of stocks
        When the user can prices per stock
        When the user can see market capitalizations
        Then the user is able to successfully view companies' information

Feature: Users should be able to select a specific company and read more in depth about them

    Scenario: As a user, I want to view a specific company's information to learn more about them

        Given the user is on the main page
        When the user select a company's ticker symbol
        Then the user will be able to view the company's detailed information

Feature: Users should be able to filter companies based on particular criteria

    Scenario: As a user, I want to view companies by market capitalization

        Given the user is on the main page
        When the user selects to view by market cap
        When the user enters a market cap input
        When the user selects to see companies below or above market cap input
        Then the user will view companies filtered by market cap

    Scenario: As a user, I want to view companies by amount of stocks

        Given the user is on the main page
        When the user selects to view by amount of stocks
        When the user enters an amount of stocks input
        When the user selects to see companies below or above amount of stocks input
        Then the user will view companies filtered by amount of stocks

    Scenario: As a user, I want to view companies by price per stock

        Given the user is on the main page
        When the user selects to view by price per stock
        When the user eneters a price per stock input
        When the user selects to see companies below or above price per stock input
        Then the user will view companies filtered by price per stock

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
