
Feature: Conduit CRUD Functions

	
#	Background: Login into app
#	Given User is on login page
#	When User provide "username" and "password"
#	Then User should be on Home page
	
	Scenario: Login into app
	Given User is on login page
	When User provide "username" and "password"
	Then User should be on Home page
	
	
  Scenario: Create new Article
    Given User should be on New Article Page
    When User enters Article details
   # | title | Desc | content |tag|
    Then Article must be created


Scenario: View Article
    Given User should be on global feed page
    When User select an article "Article title"
    Then Article must be displayed1
 
 Scenario: Update an Article
 		Given Article detail page must be displayed1
 		When User update article detail
 		Then Article detail must be displayed
 		
 	Scenario: Delete an Article
 		Given Article detail page must be displayed2
 		When User delete aricle
 		Then User must be in your feed tab
 

 