import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DevToTest1 {

    WebDriver driver;

    @Before
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver","c://Downloads SDA/SeleniumDrivers//chromedriver.exe");
        driver = new ChromeDriver();
        String url = "https://dev.to/";
        driver.get(url);
        driver.manage().window().maximize();
    }

    @Test
    public void goToWeek(){
        WebElement weekField = driver.findElement(By.linkText("Week"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", weekField);
        weekField.click();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void endAndClean(){
        driver.close();
    }



}
