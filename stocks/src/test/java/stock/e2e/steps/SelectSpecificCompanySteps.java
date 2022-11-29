package stock.e2e.steps;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import stock.e2e.runner.TestRunner;

public class SelectSpecificCompanySteps {

    // Feature: Users should be able to select a specific company and read more in depth about them

    // Scenario: As a user, I want to view a specific company's information to learn more about them

        @When("the user enters in a company ticker")
            public void the_user_enters_in_a_company_ticker(){
                TestRunner.selectSpecificCompany.enterCompanyTickerInput("PLLO");
            }

        @When("the user clicks the search button")
            public void the_user_clicks_the_search_button(){
                TestRunner.selectSpecificCompany.searchSpecificCompany();
            }

        @Then("the user will be able to view the companys detailed information")
            public void the_user_will_be_able_to_view_the_companys_detailed_information(){
                TestRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("original-id-11")));
                TestRunner.selectSpecificCompany.companyElementExists("original-id-11");
                TestRunner.selectSpecificCompany.companyElementExists("original-company-name-11");
                TestRunner.selectSpecificCompany.companyElementExists("original-ticker-11");
                TestRunner.selectSpecificCompany.companyElementExists("original-description-11");
                TestRunner.selectSpecificCompany.companyElementExists("original-image-url-11");
                TestRunner.selectSpecificCompany.companyElementExists("original-market-cap-11");
                TestRunner.selectSpecificCompany.companyElementExists("original-amount-11");
                TestRunner.selectSpecificCompany.companyElementExists("original-price-per-stock-11");
            }
}
