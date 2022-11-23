## Goal
Our goal is to build an application that keeps track of the stock market. We should be able to view all stocks available in the market and perform operations using that information.

We will be creating a functional user interface that works with a dynamic database, and run automated tests of every level to ensure our application meets all of our sprint requirements.

## Technologies
- HTML
    - The backbone of our webpages
- CSS
    - Styles our webpages
- Javascript
    - Helps add dynamic features to our UI
    - Methods to work with API
- Java
    - Hibernate
        - Uses object-relational mapping to connect Java code with our SQL database
    - Cucumber-Junit
        - Testing framework that integrates with Cucumber
    - Cucumber
        - Testing framework to turn acceptance criteria into executable steps
    - Selenium
        - Browser automation tool
- SQL
    - DBeaver/PostgreSQL
- Mockito
    - Can create mock objects so we can run service tests without affecting our database
- Javalin
    - Supports HTTP requests
- Postman
    - Can set up API

## Sprint Backlog
These are all the user stories we need to complete to create a minimum viable product (MVP):

- View Companies
    - As a user, I can see a list of all companies in the system, their stock ticker symbols, amount of stocks, and price per stock.
- Select and View Single Companies
    - As a user, I can select a specific company's ticker symbol and pull up the company name, ticker symbol, market capitalization, price per stock, and amount of stocks.
        - NOTE: market capitalization is the total amount of money invested in that company's stock (market cap = price per stock * quantity of stocks)
- Filter Companies Based on Criteria
    - As a user, I can see a list of all companies whose stock market cap, price per stock, or amount of stocks is above or below a specified number.
- Purchase Stocks
    - As a user, I can purchase a number of stocks for a given price.
        - Users should only be able to purchase the max amount of existing stocks.
        - Users should not be able to purchase a stock for zero dollars or negative dollars.
    - As a system, I should update a company's stock market capitalization and price per stock if stocks are purchased.
        - If a stock is purchased, the system should calculate the difference between the CURRENT price per stock and the buy price. The stock market cap and price will increase or decrease as appropriate.
            - EXAMPLE: If we had a company with 50 stocks and a market cap of $5000, that would mean the price per stock is $100. ($5000 market cap / 50 stocks = $100 price per stock)
                - If someone buys 15 stocks for $150 ($50 more than the $100 baseline), this just introduced excess money of $750 ($50 excess x 15 stocks) to the company's market cap. The market cap should update to $5750, and the amount of stocks is STILL 50. That means the new price per stock will be ($5750 market cap / 50 stocks) $115 per stock.
                - Now, if someone buys 25 stocks for $75 ($40 less than the $115 per stock cost), the market cap of the company will decrease by ($40 deficit x 25 stocks) $1000. Now the market cap should update to $4375, and the amount of stocks is STILL 50. The new price per stock will be ($4000 market cap / 50 stocks) $80 per stock.


## Testing Requirements
These are the main tests I want to perform.

- Unit Tests
    - "Repository Layer"
        - All methods must have a positive test
            - This is where we will take a single piece of the application's code logic and test it in isolation
            - The goal of this is to check the logic of the code we have written
    - "Service Layer"
        - All methods must have a negative test per business rule
            - We can use Mockito to stub the methods for these tests
            - This is where we will confirm that we have handled any business logic that has specifically been requested

- Integration Tests
    - API
        - All routes must have a positive and negative test

- End to End Tests
    - All acceptance criteria must be tested via Cucumber and Selenium

## Steps
These are the general steps I should follow.

- Create a test plan and acceptance requirements (DONE)
- Create UI framework with HTML (DONE)
- Create SQL database (DONE)
- Set up Hibernate with Java (DONE)
- Create all Java methods (DONE)
- All repo tests (DONE)
- All service tests (DONE)
- Create controllers (DONE)
    - Get all tickers (DONE)
    - Filter by market cap (DONE)
    - Filter by amount stocks (DONE)
    - Filter by price per stock (DONE)
    - Get specific company (DONE)
    - Update company (DONE)
- Connect to Postman (DONE)
- Integration testing (DONE)
- Connect UI to Java (DONE)
- CSS time! (DONE)
- Make all of our user stories run
- Perform all of our tests manually
- Perform all of our tests automatically

## Future Improvement
- Reconfigure the back-end so the update only updates certain fields
- Make the filters filter by range (ex: market cap >= 100)
- Make everything animate more smoothly
- Be able to click on a ticker on the chart to see more in depth about them
- Make ticker that you're hovering over highlight