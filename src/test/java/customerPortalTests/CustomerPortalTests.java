package customerPortalTests;

import base.HigherBaseTest;
import helpers.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.CustomerHomePage;
import page.CustomerLoginPage;

import java.time.Duration;

import static helpers.Strings.validEmail;
import static helpers.Strings.validPassword;
import static helpers.URLs.CUSTOMERPORTALPAGE;
import static helpers.URLs.HIGHERLOGINPAGE;

public class CustomerPortalTests extends HigherBaseTest {

    CustomerLoginPage customerLoginPage;
    CustomerHomePage customerHomePage;


    @BeforeMethod

    public void pageHigherLoginSetUp() {
        customerLoginPage = new CustomerLoginPage();
        customerHomePage=new CustomerHomePage();
        driver.manage().window().maximize();
        driver.navigate().to(HIGHERLOGINPAGE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod

    public void pageHigherLoginCleanup() {
        driver.manage().deleteAllCookies();
    }

    @Test(priority = 20)

    public void userCanSuccessfullyLoginOnCustomerPortal() {
        customerLoginPage.insertEmailOnHigherLoginPage(validEmail);
        customerLoginPage.insertPasswordOnHigherLoginPage(validPassword);
        customerLoginPage.clickOnHigherLoginButton();
        Assert.assertTrue(customerHomePage.overviewButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),CUSTOMERPORTALPAGE);
    }

    @Test(priority = 10)

    public void userCanSuccessfullyLogoutFromCustomerPortal() {
        customerLoginPage.insertEmailOnHigherLoginPage(validEmail);
        customerLoginPage.insertPasswordOnHigherLoginPage(validPassword);
        customerLoginPage.clickOnHigherLoginButton();
        customerHomePage.clickOnOverviewButton();
        customerHomePage.clickOnLogOutButton();
        Assert.assertTrue(customerLoginPage.loginButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),HIGHERLOGINPAGE);


    }
    @Test(dataProvider = "invalidEmailDataForLoginOnCustomerPortal",dataProviderClass = DataProviders.class)
    public void userCanNotSuccessfullyLoginOnCustomerPortalWithInvalidEmail(String invalidEmail){
        customerLoginPage.insertEmailOnHigherLoginPage(invalidEmail);
        customerLoginPage.insertPasswordOnHigherLoginPage(validPassword);
        customerLoginPage.clickOnHigherLoginButton();
        Assert.assertTrue(customerLoginPage.loginButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),HIGHERLOGINPAGE);

    }

    @Test(dataProvider = "invalidPasswordDataForLoginOnCustomerPortal",dataProviderClass = DataProviders.class)
    public void userCanNotSuccessfullyLoginOnCustomerPortalWithInvalidPassword(String invalidPassword){
        customerLoginPage.insertEmailOnHigherLoginPage(validEmail);
        customerLoginPage.insertPasswordOnHigherLoginPage(invalidPassword);
        customerLoginPage.clickOnHigherLoginButton();
        Assert.assertTrue(customerLoginPage.loginButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(),HIGHERLOGINPAGE);

    }


}