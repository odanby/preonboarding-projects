Feature: Users should be able to select a specific company and read more in depth about them

    Scenario: As a user, I want to view a specific company's information to learn more about them

        Given the user is on the main page
        When the user enters in a company ticker
        When the user clicks the search button
        Then the user will be able to view the companys detailed information