package page;

import base.HigherBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerLoginPage extends HigherBaseTest {

    public CustomerLoginPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//body/app-root[1]/app-login[1]/main[1]/div[1]/form[1]/div[1]/input[1]")
    public WebElement email;
    @FindBy(xpath = "//body/app-root[1]/app-login[1]/main[1]/div[1]/form[1]/div[2]/input[1]")
    public WebElement password;
    @FindBy(css = ".btn.btn-contrast")
    public WebElement loginButton;


    //------------------------
    public void insertEmailOnHigherLoginPage(String emailValue) {
        email.clear();
        email.sendKeys(emailValue);

    }

    public void insertPasswordOnHigherLoginPage(String passwordValue) {
        password.clear();
        password.sendKeys(passwordValue);
    }

    public void clickOnHigherLoginButton() {
        loginButton.click();
    }


}


