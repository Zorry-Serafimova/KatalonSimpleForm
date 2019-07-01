Feature: Form Automation Katalon
  As a student I can navigate to test form, fill it and submit it

  Background:
    Given User fills out form

  Scenario Outline: Form Submit
    Given User navigates to Katalon page
    When User enters "<firstname>" and "<lastname>"
    And User selects Gender
    And User enters "<dateofbirth>"
    And User enters "<address>" in address field
    And User enters "<email>" in email field and "<password>" in password field
    And  User enters "Forte Knowledge" in company field and "Cucumber Tests" in comment field
    And User selects role and job expectation
    And  User selects ways of development
    And User clicks submit button
    Then Form is submitted and success Message is shown
    And all fields clear

    Examples:
      | firstname | lastname   | dateofbirth | address         | email                 | password     |
      | Zorry     | Serafimova | 07/02/1982  | 123 Madison Rd  | zserafimova@gmail.com | 123Password  |
      | Nick      | Drummond   | 08/25/1975  | 435 Central Ave | ndrummond@yahoo.com   | 564Password! |
      | Vincent   | Jenkins    | 10/31/1999  | 3234 Main Blvd  | vjenkins@comcast.net  | 8#pass4!     |
