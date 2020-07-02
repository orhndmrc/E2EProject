package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePageObjects {
    public WebDriver hdriver;

    public HomePageObjects(WebDriver driver){
    hdriver=driver;
        PageFactory.initElements(hdriver,this);
    }

    @FindBy(xpath="//span[contains(text(),'Login')]")
    WebElement login;

    By title = By.xpath("//div[@class='text-center']/h2");
//    @FindBy(xpath = "//div[@class='text-center']/h2")
//     WebElement title;

    By NavBar = By.cssSelector("ul[class='nav navbar-nav navbar-right']>li>a");

    public void getLogin(){
         login.click();
    }

    public WebElement getTitle(){
     return hdriver.findElement(title);
    }

    public WebElement getNavBar(){
        return hdriver.findElement(NavBar);
    }

}
