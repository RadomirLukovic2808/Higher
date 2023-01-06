package page;

import base.HigherBaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPortalPage extends HigherBaseTest {


    public AdminPortalPage() {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[contains(text(),'Create a Company')]")
    public WebElement createCompanyButton;
    @FindBy(css = ".mat-toolbar.mat-elevation-z6.mat-primary.mat-toolbar-single-row")
    public WebElement adminPortalButton;
    @FindBy(xpath = "//body/app-root[1]/app-layout[1]/mat-sidenav-container[1]/mat-sidenav[1]/div[1]/mat-nav-list[1]/a[6]/div[1]")
    public  WebElement logoutAdminButton;


    //---------------------------------


}
