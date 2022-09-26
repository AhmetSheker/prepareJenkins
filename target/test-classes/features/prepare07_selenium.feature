Feature: IMDB home page arrow test
  Scenario:User clicks arrows
    Given user is on imdb home page
    And verifies imdb logo
    When user clicks right arrow button once
    Then user clicks left arrow button twice
    And user clicks the trailer