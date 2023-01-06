package helpers;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider(name = "invalidPasswordDataForLoginOnAdminPortal")
    public Object[][] invalidPasswordDataForLoginOnAdminPortal() {
        return new Object[][]{
                {" "},
                {"first123."},
                {"First123"},
                {"FIRST123."}
        };

    }

    @DataProvider(name = "invalidEmailDataForLoginOnAdminPortal")
    public Object[][] invalidEmailDataForLoginOnAdminPortal() {
        return new Object[][]{
                {"Radomir.lukovic@soprex.com"},
                {"RADOMIR.LUKOVIC@SOPREX.COM"},
                {"adomir.lukovic@soprex"},
                {" "}
        };
    }

    @DataProvider(name = "invalidEmailDataForLoginOnCustomerPortal")
    public Object[][] invalidEmailDataForLoginOnCustomerPortal() {
        return new Object[][]{
                {"Radomir.lukovic@soprex.com"},
                {"RADOMIR.LUKOVIC@SOPREX.COM"},
                {"adomir.lukovic@soprex"},
                {" "}


        };
    }

    @DataProvider(name = "invalidPasswordDataForLoginOnCustomerPortal")
    public Object[][] invalidPasswordDataForLoginOnCustomerPortal() {
        return new Object[][]{
                {" "},
                {"first123."},
                {"First123"},
                {"FIRST123."}
        };

    }
}