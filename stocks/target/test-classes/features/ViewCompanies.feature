Feature: Users of our stock market application should be able to view all companies and their information

    Scenario: As a user, I want to view all companies' information so I can monitor the stock market

        Given the user is on the main page
        When the user can see stock tickers
        When the user can see amounts of stocks
        When the user can see prices per stock
        When the user can see market capitalizations
        Then the user is able to successfully view companies information