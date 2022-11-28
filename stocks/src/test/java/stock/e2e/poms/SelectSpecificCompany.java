package stock.e2e.poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class SelectSpecificCompany {

    public SelectSpecificCompany(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    
}
