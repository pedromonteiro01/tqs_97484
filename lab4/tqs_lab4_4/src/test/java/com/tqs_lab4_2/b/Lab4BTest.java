package test.java.com.tqs_lab4_2.b;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//import io.github.bonigarcia.seljup.EnabledIfBrowserAvailable;
import io.github.bonigarcia.seljup.SeleniumJupiter;

import static org.assertj.core.api.Assertions.*;

import org.openqa.selenium.remote.RemoteWebDriver;
import static io.github.bonigarcia.seljup.BrowserType.CHROME;
import io.github.bonigarcia.seljup.DockerBrowser;

/**
 * Unit test for simple App.
 */
@ExtendWith(SeleniumJupiter.class)
class Lab4BTest {

    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void chromeConnectionTest(){
        String sutUrl = "https://blazedemo.com/";
        driver.get(sutUrl);
        assertThat(driver.getTitle()).contains("BlazeDemo");
    }

    @Test
    public void chromeTest(@DockerBrowser(type = CHROME) RemoteWebDriver driver) {
        String sutUrl = "https://blazedemo.com/";
        driver.get(sutUrl);

        driver.findElement(By.name("fromPort")).click();
        {
        WebElement dropdown = driver.findElement(By.name("fromPort"));
        dropdown.findElement(By.xpath("//option[. = 'Boston']")).click();
        }
        driver.findElement(By.name("toPort")).click();
        {
        WebElement dropdown = driver.findElement(By.name("toPort"));
        dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
        }
        driver.findElement(By.cssSelector(".btn-primary")).click();
        driver.findElement(By.cssSelector("tr:nth-child(3) .btn")).click();
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys("Pedro");
        driver.findElement(By.cssSelector(".control-group:nth-child(2) > .controls")).click();
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys("Guarda");
        driver.findElement(By.cssSelector(".control-group:nth-child(2) > .controls")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys("Guarda");
        driver.findElement(By.cssSelector(".control-group:nth-child(2) > .controls")).click();
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).sendKeys("idk");
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("6300-255");
        driver.findElement(By.cssSelector("form")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}
