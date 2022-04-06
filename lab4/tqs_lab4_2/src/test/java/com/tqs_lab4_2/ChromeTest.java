package com.tqs_lab4_2;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
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
}
