Feature: Users should be able to select a specific company and read more in depth about them

    Scenario: As a user, I want to view a specific company's information to learn more about them

        Given the user is on the main page
        When the user select a company's ticker symbol
        Then the user will be able to view the company's detailed information