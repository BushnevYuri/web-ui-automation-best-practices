@cucumber
Feature: Find flights

  As a regular traveler
  I want to be to be able to search flights between Boston and New York

  Scenario: Find flights from Boston to New York
    Given that Yuri open the home page
    Then he should see the home page with 'BlazeDemo' title and 'Welcome to the Simple Travel Agency!' heading
    When he search flights from Boston to New York
    Then he should find some flights