package academy;

import driverManager.DriverMngProp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import resources.base;

import java.io.IOException;

public class ValidateTitle extends base {
    public WebDriver driver;
    HomePageObjects homePageObjects;
    LoginPageObjects loginPageObjects;
    @Test
    public void navigatingToLoginPage() throws IOException {
        driver=initializeDriver();
        homePageObjects = new HomePageObjects(driver);
        Assert.assertEquals(homePageObjects.getTitle().getText(),"FEATURED COURSES","failure");

    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }


}
