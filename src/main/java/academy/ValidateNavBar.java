package academy;

import driverManager.DriverMngProp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.annotations.Test;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import resources.base;

import java.io.IOException;

public class ValidateNavBar extends base {
    public WebDriver driver;
    HomePageObjects homePageObjects;
    LoginPageObjects loginPageObjects;
    @Test
    public void navigatingToLoginPage() throws IOException {
        driver=initializeDriver();
        homePageObjects = new HomePageObjects(driver);
        Assert.assertTrue(homePageObjects.getNavBar().isDisplayed(),"failure");

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
