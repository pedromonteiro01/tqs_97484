Feature: Booking a flight

  Scenario: Booking a trip to New York from Boston
    When I navigate to "https://blazedemo.com/"
    And I choose my departure city "Boston" and destination "New York"
    And I click Find Flights
    Then I should see flights of "Flights from Boston to New York"

  Scenario: Choosing a flight
    When I navigate to "https://blazedemo.com/reserve.php"
    And I choose a flight
    Then I should see the message that the flight was reserved 


  Scenario: Purchase a flight
    When I navigate to "https://blazedemo.com/purchase.php"
    And I fill my personal informations like "Mariana Rosa", my "Alameda 29 de junho", my "Ribeira Grande", my "Azores" and my "9600" 
    And I fill my card informations like what type is my card "Visa", it's number 123456, it's year 2024 and who it is "Mariana Rosa" from
    And I click Purchase a flight
    Then I should see the confirmation message