package page;

import base.HigherBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerHomePage extends HigherBaseTest {


    public CustomerHomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(text(),'Overview')]")
    public WebElement overviewButton;
    @FindBy(xpath = "//span[contains(text(),'Logout')]")
    public WebElement logoutButton;

    //----------------------------

    public void clickOnOverviewButton() {
        overviewButton.click();
    }
    public void clickOnLogOutButton(){
        logoutButton.click();
    }
}
