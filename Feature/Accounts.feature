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
	And I quit 
	
	Examples: 
		| username                | password |
		| test.user@gmail.com.test | Pa55word |
		
@test 
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
	And I should see the following values for "acc9" field 
		| --None-- |
		| Hot |
		| Warm |
		| Cold |
		
	And I should see the following values for "acc6" field 
		| --None-- |
		| Prospect |
		| Customer - Direct |
		| Customer - Channel |
		| Channel Partner / Reseller |
		| Installation Partner |
		| Technology Partner |
		| Other |
		
	When I click the "save" button 
	Then I see the record got created 
	And I quit 
	
	Examples: 
		| username                | password |
		| test.user@gmail.com.test | Pa55word |
