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
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

//import io.github.bonigarcia.seljup.EnabledIfBrowserAvailable;
import io.github.bonigarcia.seljup.SeleniumJupiter;

import static org.assertj.core.api.Assertions.*;

import java.beans.Transient;

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

    @FindBy(name="fromPort")
    private WebElement fromPort;

    @FindBy(xpath = "//option[. = 'Boston']")
    private WebElement fromPortOption;

    @FindBy(name="toPort")
    private WebElement toPort;

    @FindBy(xpath = "//option[. = 'New York']")
    private WebElement toPortOption;

    @FindBy(css=".btn-primary")
    private WebElement btn1;

    @FindBy(css="tr:nth-child(3) .btn")
    private WebElement btn2;

    @FindBy(id="inputName")
    private WebElement inputName;

    @FindBy(css=".control-group:nth-child(2) > .controls")
    private WebElement btn3;

    @FindBy(id="address")
    private WebElement address;

    @FindBy(css=".control-group:nth-child(2) > .controls")
    private WebElement btn4;

    @FindBy(id="city")
    private WebElement city;

    @FindBy(css=".control-group:nth-child(2) > .controls")
    private WebElement btn5;

    @FindBy(id="state")
    private WebElement state;

    @FindBy(css="form")
    private WebElement btn6;

    @FindBy(id="zipCode")
    private WebElement zipCode;

    @FindBy(css=".control-group:nth-child(2) > .controls")
    private WebElement btn7;

    @FindBy(css=".btn-primary")
    private WebElement btn8;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }

    @Test
    public void chromeTest(WebDriver driver) {
        String sutUrl = "https://blazedemo.com/";
        driver.get(sutUrl);
        PageFactory.initElements(driver, this);

        fromPortOption.click();
        toPortOption.click();
        btn1.click();
        btn2.click();
        inputName.click();
        inputName.sendKeys("Pedro");
        btn3.click();
        address.click();
        address.sendKeys("Guarda");
        btn4.click();
        city.click();
        city.sendKeys("Guarda");
        btn5.click();
        zipCode.click();
        state.click();
        state.sendKeys("idk");
        btn6.click();
        zipCode.sendKeys("6300-255");
        btn7.click();
        btn8.click();
    }
}
