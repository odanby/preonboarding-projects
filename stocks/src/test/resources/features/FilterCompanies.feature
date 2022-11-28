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
        When the user enters a price per stock input
        When the user selects to see companies below or above price per stock input
        Then the user will view companies filtered by price per stock