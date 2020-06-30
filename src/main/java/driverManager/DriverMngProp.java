package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverMngProp {
    public WebDriver driver;


    public WebDriver initializer() throws IOException {
        Properties prop =new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\demir\\E2EProject\\src\\main\\java\\DriverManager\\browser.properties");
        prop.load(fis);
       String browserName = prop.getProperty("browser");
        System.out.println(browserName);
       switch(browserName){
           case "chrome":
               System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\E2EProject\\chromedriver.exe");
               driver = new ChromeDriver();
               driver.manage().window().maximize();

               break;
           case "firefox":
               System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\E2EProject\\geckodriver.exe");
                driver = new FirefoxDriver();
               driver.manage().window().maximize();

               break;
           case "edge":
               System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\E2EProject\\msedgedriver.exe");
               driver = new FirefoxDriver();
               driver.manage().window().maximize();

               break;

       }
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       return driver;
    }
}
