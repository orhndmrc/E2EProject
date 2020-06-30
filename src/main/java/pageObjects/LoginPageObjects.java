package pageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageObjects {
    WebDriver ldriver;
    public LoginPageObjects(WebDriver driver){
        ldriver=driver;
        PageFactory.initElements(ldriver,this);
    }
    By email =By.id("user_email");
//    @FindBy(id = "user_email")
//    WebElement email;

By password = By.xpath("//input[contains(@class,'input-hg') and @name='user[password]']");
//    @FindBy(xpath = "//input[contains(@class,'input-hg') and @name='user[password]']")
//    WebElement password;

    By login = By.xpath("//input[@name='commit']");
//    @FindBy(xpath = "//input[@name='commit']")
//    WebElement login;
//
    public WebElement getEmail(){
        return ldriver.findElement(email);
    }
    public WebElement getPassword(){
        return ldriver.findElement(password);
    }
    public WebElement Login(){
        return ldriver.findElement(login);
    }
}
