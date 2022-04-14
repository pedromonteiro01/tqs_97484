/*
 * (C) Copyright 2020 Boni Garcia (https://bonigarcia.github.io/)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package io.github.bonigarcia;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import io.github.bonigarcia.wdm.WebDriverManager;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FlightSteps {

    private WebDriver driver;

    @When("I navigate to {string}")
    public void iNavigateTo(String url) {
        driver = WebDriverManager.chromedriver().create();
        driver.get(url);
    }

    @And("I choose a ticket from {string} to {string}")
    public void flight(String departure, String destination) {
        driver.findElement(By.name("fromPort")).sendKeys(departure);
        driver.findElement(By.name("toPort")).sendKeys(destination);
    } 

    @And("I click Find Flights")
    public void iPressEnter() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @Then("I see {string}")
    public void iShouldSeeFlights(String results) {
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), containsString(results));
    }

    @And("I choose a flight")
    public void iPressFlight() {
        driver.findElement(By.cssSelector("tr:nth-child(2) .btn")).click();
    
    }

    @Then("I see the message that the flight was reserved")
    public void iShouldSeeTheReservation() {
        assertThat(driver.findElement(By.cssSelector("h2")).getText(), containsString("has been reserved"));
    }

    @And("I fill my personal informations like my name {string}, my address {string}, my city {string}, my state {string} and my zipCode {string}")
    public void fillPersonalInfo(String name, String address, String city, String state, String zipcode) {
        //name
        driver.findElement(By.id("inputName")).click();
        driver.findElement(By.id("inputName")).sendKeys(name);

        //address
        driver.findElement(By.id("address")).click();
        driver.findElement(By.id("address")).sendKeys(address);

        //city
        driver.findElement(By.id("city")).click();
        driver.findElement(By.id("city")).sendKeys(city);

        //state
        driver.findElement(By.id("state")).click();
        driver.findElement(By.id("state")).sendKeys(state);

        //zipCode
        driver.findElement(By.id("zipCode")).click();
        driver.findElement(By.id("zipCode")).sendKeys(zipcode);
    } 


    @And("I fill my card informations like brand {string}, CVC {int}, expiration year {int} and name on card {string}")
    public void fillPCardInfo(String type, Integer cardNumber, Integer cardYear, String cardOwner) {
            driver.findElement(By.xpath("//div[5]/div")).click();
        {
        WebElement dropdown = driver.findElement(By.id("cardType"));
        dropdown.findElement(By.xpath("//option[. = '"+ type+ "']")).click();    }
        {
        WebElement element = driver.findElement(By.id("cardType"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).clickAndHold().perform();
        }
        {
        WebElement element = driver.findElement(By.id("cardType"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
        }
        {
        WebElement element = driver.findElement(By.id("cardType"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).release().perform();
        }

        driver.findElement(By.id("creditCardNumber")).click();
        driver.findElement(By.id("creditCardNumber")).sendKeys(cardNumber.toString());
        driver.findElement(By.id("creditCardYear")).click();
        driver.findElement(By.id("creditCardYear")).sendKeys(cardYear.toString());
        driver.findElement(By.id("nameOnCard")).click();
        driver.findElement(By.id("nameOnCard")).sendKeys(cardOwner);
    } 

    @And("I click Purchase a flight")
    public void iPurchaseFlight() {
        driver.findElement(By.cssSelector(".btn-primary")).click();
    }

    @Then("I see the confirmation message")
    public void confirmed() {
        assertThat(driver.findElement(By.cssSelector("h1")).getText(), containsString("Thank you for your purchase today!"));
    }
   
    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
