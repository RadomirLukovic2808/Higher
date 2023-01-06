package tests;

import base.HigherBaseTest;
import helpers.DataProviders;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AdminLoginPage;
import page.AdminPortalPage;

import java.time.Duration;

import static helpers.Strings.*;
import static helpers.URLs.ADMINLOGINPAGE;
import static helpers.URLs.ADMINPORTALPAGE;

public class AdminTest extends HigherBaseTest {

    AdminLoginPage adminLoginPage;
    AdminPortalPage adminPortalPage;


    @BeforeMethod
    public void pageAdminLoginSetUp() {
        adminLoginPage = new AdminLoginPage();
        adminPortalPage = new AdminPortalPage();
        driver.manage().window().maximize();
        driver.navigate().to(ADMINLOGINPAGE);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void pageAdminLoginCleanup() {
        driver.manage().deleteAllCookies();

    }


    @Test
    public void userCanSuccessfullyLoginOnAdminPage() {
        adminLoginPage.insertEmailOnAdminLoginPage(validAdminEmail);
        adminLoginPage.insertPasswordOnAdminLoginPage(validAdminPassword);
        adminLoginPage.clickOnAdminLoginButton();
        Assert.assertTrue(adminPortalPage.createCompanyButton.isDisplayed());
        Assert.assertTrue(adminPortalPage.adminPortalButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), ADMINPORTALPAGE);

    }

    @Test(dataProvider  ="invalidEmailDataForLoginOnAdminPortal",dataProviderClass = DataProviders.class)
    public void userCanNotSuccessfullyLoginOnAdminPageWithInvalidEmail(String invalidEmail) {
        adminLoginPage.insertEmailOnAdminLoginPage(invalidEmail);
        adminLoginPage.insertPasswordOnAdminLoginPage(validAdminPassword);
        adminLoginPage.clickOnAdminLoginButton();
        Assert.assertTrue(adminLoginPage.adminLoginButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), ADMINLOGINPAGE);

    }

    @Test(dataProvider  ="invalidPasswordDataForLoginOnAdminPortal",dataProviderClass = DataProviders.class)
    public void userCanNotSuccessfullyLoginOnAdminPageWithInvalidPassword(String invalidPassword) {
        adminLoginPage.insertEmailOnAdminLoginPage(validAdminEmail);
        adminLoginPage.insertPasswordOnAdminLoginPage(invalidPassword);
        adminLoginPage.clickOnAdminLoginButton();
        Assert.assertTrue(adminLoginPage.adminLoginButton.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), ADMINLOGINPAGE);


    }



    }


