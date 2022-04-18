Feature: Booking a flight

  Scenario: Booking a trip to New York from Boston
    When I navigate to 'https://blazedemo.com/'
    And I choose a ticket from 'Boston' to 'New York'
    And I click Find Flights
    Then I see 'Flights from Boston to New York'

  Scenario: Choosing a flight
    When I navigate to 'https://blazedemo.com/reserve.php'
    And I choose a flight
    Then I see the message that the flight was reserved 


  Scenario: Purchase a flight
    When I navigate to 'https://blazedemo.com/purchase.php'
    And I fill my personal informations like my name 'Pedro', my address 'Guarda', my city 'Guarda', my state 'idk' and my zipCode '6300-255' 
    And I fill my card informations like brand 'Visa', CVC 123456789, expiration year 2022 and name on card 'PedroMonteirovski'
    And I click Purchase a flight
    Then I see the confirmation message