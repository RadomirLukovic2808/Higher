package page;

import base.HigherBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage extends HigherBaseTest {


    public AdminLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='mat-input-0']")
    public WebElement adminEmail;
    @FindBy(xpath= "//*[@id=\"mat-input-1\"]")
    public WebElement adminPassword;
    @FindBy(css = ".mat-focus-indicator.mat-raised-button.mat-button-base.mat-primary")
    public WebElement adminLoginButton;


    //-----------------------------

    public void insertEmailOnAdminLoginPage(String adminEmailValue) {
        adminEmail.clear();
        adminEmail.sendKeys(adminEmailValue);
    }
    public void insertPasswordOnAdminLoginPage(String adminPasswordValue){
        adminPassword.clear();
        adminPassword.sendKeys(adminPasswordValue);
    }
    public void clickOnAdminLoginButton(){
        adminLoginButton.click();
    }


}
