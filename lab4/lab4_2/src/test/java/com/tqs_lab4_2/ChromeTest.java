package com.tqs_lab4_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.seljup.EnabledIfBrowserAvailable;
import io.github.bonigarcia.seljup.SeleniumJupiter;

import static org.assertj.core.api.Assertions.*;

/**
 * Unit test for simple App.
 */
@ExtendWith(SeleniumJupiter.class)
class ChromeTest {
    /**
     * Rigorous Test.
     */
    //@Test
    //void testApp() {
    //    assertEquals(1, 1);
    //}

    private WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @Test
    void test() {
        // Exercise
        String sutUrl = "https://blazedemo.com/";
        driver.get(sutUrl);
        String title = driver.getTitle();

        // Verify
        assertThat(title).isEqualTo("BlazeDemo");
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    void test(ChromeDriver driver) {
        driver.get("https://blazedemo.com/");
        assertThat(driver.getTitle()).contains("BlazeDemo");
    }

    @Test
    public void flightsTest(WebDriver driver) {
      driver.get("https://blazedemo.com/");
      driver.manage().window().setSize(new Dimension(1920, 1080));
      driver.findElement(By.name("fromPort")).click();
      {
        WebElement dropdown = driver.findElement(By.name("fromPort"));
        dropdown.findElement(By.xpath("//option[. = 'New York']")).click();
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
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys("6300-255");
        driver.findElement(By.cssSelector(".control-group:nth-child(2) > .controls")).click();
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).sendKeys("idk");
        driver.findElement(By.cssSelector("form")).click();
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }
}
