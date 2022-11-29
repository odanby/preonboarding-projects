package stock.e2e.poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import stock.e2e.runner.TestRunner;
import stock.exceptions.NoElementExists;

public class ViewCompanies {
    
    public ViewCompanies(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    // method to confirm each element
    public boolean viewCompanyElementExists(String id){
        try {
            TestRunner.driver.findElement(By.id(id));
        } catch (NoElementExists e) {
            return false;
        }
        return true;
    }
}
