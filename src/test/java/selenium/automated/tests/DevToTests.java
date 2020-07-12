package selenium.automated.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DevToTests {

    WebDriver driver; // inicjalizacja driver'a
    String url = "https://dev.to/";

    public void HighlightElement(WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
    }


    @Before
    public void SetUp(){ // pre-requirements - warunki początkowe
        System.setProperty("webdriver.chrome.driver","c://Downloads SDA/SeleniumDrivers//chromedriver.exe"); // ścieżka do ChromeDriver'a
        driver = new ChromeDriver(); // nadpisanie drivera, jako przeglądarkę chrome
        driver.get(url);
        driver.manage().window().maximize();

    }
    @Test
    public void OpenDevTo(){
        String currentUrl = driver.getCurrentUrl();
        assertTrue("The current url isn't dev.to", url.equals(currentUrl));

    }
    @Test
    public void GoToWeek(){
        WebElement week = driver.findElement(By.cssSelector("#on-page-nav-controls > div > nav > a:nth-child(2)"));
        HighlightElement(week);
        week.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.urlToBe("https://dev.to/top/week"));
        //wait.until(ExpectedConditions.attributeContains(week, "class", "item--current"));
        WebElement firstPostOnWeek = driver.findElement(By.className("crayons-story__body"));

        HighlightElement(firstPostOnWeek);
        WebElement firstPostTitle = driver.findElement(By.cssSelector(".crayons-story__title > a"));
        HighlightElement(firstPostTitle);
        String linkToFirstPost = firstPostTitle.getAttribute("href");
        firstPostOnWeek.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("crayons-article__header__meta")));
        String currentUrl = driver.getCurrentUrl();

        assertEquals("url isnt't the same as link(href) value", linkToFirstPost, currentUrl);
    }


}
