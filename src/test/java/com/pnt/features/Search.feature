Feature: Search functionality

  Scenario: user being able to search for java books
    Given user opens the browser and navigate to amazon.com
    When user can see search bar
    Then user types Java Books in the searchh bar
    And user clicks on search button
    And user can see search result of Java Books
    And user closes the browser

  Scenario Outline: user being able to search for java books
    Given user opens the browser and navigate to amazon.com
    When user can see search bar
    Then user types <bookName> in the search bar
    And user clicks on search button
    And user can see search result of Java Books
    And user closes the browser

    Examples:
    |bookName|
    |Java Books|
    |Selenium Books|



