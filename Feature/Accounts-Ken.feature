Feature: Create an Account object
  As an authenticated user, I should be able to create an account record

  Scenario Outline: Create and Verify Account record
  Given I open "chrome" browser
  And I go to the "qa" environment
  And I enter valid username "<username>"
  And I enter valid password "<password>"
  When I click the "Login" button
  And I verify the logo
  Then I should see the "Accounts" tab
  Then I should see the "Accounts" home page
  When I click the "new" button
  And I enter "BAT-1" value for "acc2" field
  When I click the "save" button
  Then I see the record got created
  Then I close the browser
  
  Examples:
  | username                | password |
  | batch03@codegator.us.qa | Pa55word |
  
  Scenario Outline: Create and Verify Account record
  Given I open "chrome" browser
  And I go to the "qa" environment
  And I enter valid username "<username>"
  And I enter valid password "<password>"
  When I click the "Login" button
  And I verify the logo
  Then I should see the "Accounts" tab
  Then I should see the "Accounts" home page
  When I click the "new" button
  When I click the "save" button
  Then I should see the error "Error: You must enter a value"
  And I enter "BAT-1" value for "acc2" field
  When I click the "save" button
  Then I see the record got created
  Then I close the browser
  
  Examples:
  | username                | password |
  | batch03@codegator.us.qa | Pa55word |
  Scenario Outline: Verify Account Source Field is created
    Given I open "chrome" browser
    And I go to the "qa" environment
    And I enter valid username "<username>"
    And I enter valid password "<password>"
    When I click the "Login" button
    Then I should see the "Accounts" tab
    When I click the "new" button
    Then I should see the "AccountSource" field
    Then I close the browser

    Examples: 
      | username                | password |
      | batch03@codegator.us.qa | Pa55word |

  Scenario Outline: Verify Account Source Field is not required
    Given I open "chrome" browser
    And I go to the "qa" environment
    And I enter valid username "<username>"
    And I enter valid password "<password>"
    When I click the "Login" button
    Then I should see the "Accounts" tab
    When I click the "new" button
    Then I should see the "AccountSource" field
    And I enter "BAT-1" value for "acc2" field
    When I click the "save" button
    Then I see the record got created
    Then I close the browser

    Examples: 
      | username                | password |
      | batch03@codegator.us.qa | Pa55word |

  Scenario Outline: Verify Account Source Field Values
    Given I open "chrome" browser
    And I go to the "qa" environment
    And I enter valid username "<username>"
    And I enter valid password "<password>"
    When I click the "Login" button
    Then I should see the "Accounts" tab
    When I click the "new" button
    Then I see all required values in the "AccountSource" field
    Then I close the browser

    Examples: 
      | username                | password |
      | batch03@codegator.us.qa | Pa55word |

  Scenario Outline: Verify Account Source Field Values are selectable and Saveable
    Given I open "chrome" browser
    And I go to the "qa" environment
    And I enter valid username "<username>"
    And I enter valid password "<password>"
    When I click the "Login" button
    Then I should see the "Accounts" tab
    When I click the "new" button
    And I enter "BAT-1" value for "acc2" field
    Then I select "<Picklist Values>" in the "AccountSource" field
    When I click the "save" button
    Then I close the browser

    Examples: 
      | username                | password | Picklist Values  |
      | batch03@codegator.us.qa | Pa55word | --None--					|
      | batch03@codegator.us.qa | Pa55word | Web              |
      | batch03@codegator.us.qa | Pa55word | Phone Inquiry    |
      | batch03@codegator.us.qa | Pa55word | Partner Referral |
      | batch03@codegator.us.qa | Pa55word | Purchased List   |
      | batch03@codegator.us.qa | Pa55word | Other            |
