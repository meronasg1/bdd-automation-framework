Feature: Login functionality

  Scenario: user being able to login successfully
    Given user opens the browser and navigate to facebook.com
    When user fills username field
    Then user fills password field
    And user clicks on sign in button
    And user is logged in successfully

  Scenario: user being able to search for java books
    Given user opens the browser and navigate to amazon.com
    When user can see search bar
    Then user types Java Books in the search bar
    And user clicks on search button
    And user can see search result of Java Books
    And user closes the browser
