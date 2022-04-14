Feature: Book search
  To allow a customer to find his favourite books quickly, the library must offer multiple ways to search for a book.
  
  Scenario: Search books by publication year
    Given a book with the title 'One good book', written by 'Anonymous', published in 2013-03-14
      And another book with the title 'One good book 2', written by 'Anonymous', published in 2018-03-23
      And another book with the title 'Some other book', written by 'Tim Tomson', published in 2014-03-23
      And another book with the title 'How to cook a dino', written by 'Fred Flintstone', published in 2012-01-01
    When the customer searches for books published between 2013-01-01 and 2014-12-31
    Then 2 books should have been found
      And Book 1 should have the title 'Some other book'
      And Book 2 should have the title 'One good book'

  Scenario: Search books by author
    Given a book with the title 'Title 1', written by 'Pedro', published in 2020-05-14
      And another book with the title 'Title 2', written by 'Pedro', published in 2021-10-21
      And another book with the title 'Title 3', written by 'José', published in 2018-02-02
    When the customer searches for books written by 'Pedro'
    Then 2 books written by 'Pedro' should have been found
      And Book 1 should have the title 'Title 1' and published in 2020-05-14
      And Book 2 should have the title 'Title 2' and published in 2021-10-21