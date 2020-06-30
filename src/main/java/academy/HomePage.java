package academy;

import driverManager.DriverManager1;
import driverManager.DriverMngProp;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.HomePageObjects;
import pageObjects.LoginPageObjects;
import resources.base;

import java.io.IOException;

public class HomePage extends base {
    public WebDriver driver;
    HomePageObjects homePageObjects;
    LoginPageObjects loginPageObjects;


    @Test( dataProvider = "getData")
    public void navigatingToLoginPage(String Username, String Passwrd) throws IOException {
        driver=initializeDriver();
        homePageObjects = new HomePageObjects(driver);
        Assert.assertEquals(homePageObjects.getTitle().getText(),"FEATURED COURSES","failure");
        homePageObjects.getLogin();
        loginPageObjects= new LoginPageObjects(driver);
        loginPageObjects.getEmail().sendKeys(Username);
        loginPageObjects.getPassword().sendKeys(Passwrd);
        loginPageObjects.Login().click();
        driver.close();
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @DataProvider
    public Object[][] getData(){
        Object[][] data ={{"demirci_orhan@outlook.com","xt4y58"},{"xy@outlook.com","7483urfn"},{"rtu@yahoo.com","84ufml."}};
        return data;
    }
}
