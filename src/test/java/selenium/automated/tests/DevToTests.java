package selenium.automated.tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class DevToTests {

    WebDriver driver; // inicjalizacja driver'a

    @Before
    public void SetUp(){ // pre-requirements - warunki początkowe
        System.setProperty("webdriver.chrome.driver","c://Downloads SDA/SeleniumDrivers//chromedriver.exe"); // ścieżka do ChromeDriver'a
        driver = new ChromeDriver(); // nadpisanie drivera, jako przeglądarkę chrome
    }
    @Test
    public void OpenDevTo(){
        String url = "https://dev.to/"; //zapisujemy w zmiennej url, wartość linku, który ma zostać otworzony w przeglądarce
        driver.get(url); // otworzenie linku w przeglądarce

        String currentUrl = driver.getCurrentUrl();

        assertTrue("The current url isn't dev.to", url.equals(currentUrl));
    }


}
