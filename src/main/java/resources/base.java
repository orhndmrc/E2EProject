package resources;

import driverManager.DriverManager1;
import driverManager.DriverMngProp;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class base  {
      public static WebDriver driver;


    public static void initializeDriver() throws IOException {
        String url;
        Properties prop  =new Properties();
        FileInputStream fis = new FileInputStream("C:\\Users\\demir\\E2EProject\\src\\main\\java\\resources\\browser1.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        System.out.println(browserName);
        switch(browserName){
            case "chrome":
                System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\E2EProject\\chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                url = "http://qaclickacademy.com";
                driver.get(url);
                break;
            case "firefox":
                System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\E2EProject\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                url = "http://qaclickacademy.com";
                driver.get(url);
                break;
            case "edge":
                System.setProperty("webdriver.chrome.driver","C:\\Users\\demir\\E2EProject\\msedgedriver.exe");
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                url = "http://qaclickacademy.com";
                driver.get(url);
                break;

        }
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    public void getScreenShotPath(String testCaseName) {
        TakesScreenshot screenShot =(TakesScreenshot) driver;
       File source =  screenShot.getScreenshotAs(OutputType.FILE);
       String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".jpg";
        try {
            FileUtils.copyFile(source,new File(destinationFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
