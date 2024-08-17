Feature: Google Searching
  As a web user, I want to search Google so that I can find relevant information quickly.

  @GoogleSearch
  Scenario: Successful search for a keyword
    Given a web browser is on the Google home page
    When the user enters "selenium" into the search bar
    And the user clicks the "Google Search" button
    Then title should contains the searched term
