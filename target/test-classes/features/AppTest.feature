@app_regression
Feature: Validate android app
  I want to validate an android app functionality
	
	Background:
		Given I launch the app successfully
	
	@login
	Scenario: 01_Validate successfull login functionality
		When I enter correct user credentials on login page
		Then I verify the "Samples List" page present
		When I perform scrolling operation for "Wheel Picker" element
		Then It has 10 list of elements
		
  @login
  Scenario Outline: 02_Validate unsuccessfull login functionality
   When I enter "<username>" and "<password>" on login page
   Then I verify "<message>" alert message displayed

   Examples: 
     | username | password 		| message  														|
     | admin 		|   ab123 		| Invalid  Credentials 								|
     |  				|    					|	Please enter Username or password 	|
	
	@native_view
	Scenario: 03_Validate native view page
	 When I click on the Login button
   And I click on "Native View" element
   Then I verify the "Native View Demo" page present
   And It has 3 list of elements
    
  @long_press 
  Scenario: 04_Validate long press functionality
	 When I click on the Login button
   And I click on "Long Press" element
   Then I verify the "Long Press Demo" page present
   And I long press on "Long Press Me" element
   Then I verify "Long Pressed" alert title displayed
   And I verify "you pressed me hard" alert message displayed
   And I click on Alert OK button
    
   @drag_and_drop
   Scenario: 05_Validate drag and drop functionality
	 	When I click on the Login button
    And I click on "Drag & Drop" element
    Then I verify the "Drag & Drop" page present
    And I perform drag and drop operation
    Then I verify "Circle dropped" message appeared
    
   @doubletap
   Scenario: 06_Validate double tap functionality
	 	When I click on the Login button
    And I click on "Double Tap" element
    Then I verify the "Double Tap Demo" page present
    And I perform double tap operation
    Then I verify "Double Tap" alert title displayed
    And I verify "Double tap successful" alert message displayed
    And I click on Alert OK button
    
   @swiping
   Scenario: 07_Validate vertical swiping functionality
	 	When I click on the Login button
    And I click on "Vertical swiping" element
    Then I verify the "Vertical swiping" page present 
    And I verify " C" element displayed on the screen
    And I verify " Karma" element not displayed on the screen
    And I perform scrolling operation for " Karma" element
    Then I verify " Karma" element displayed on the screen
    
   @wheel_picker
   Scenario: 08_Validate wheel picker functionality
	 	When I click on the Login button
	 	And I perform scrolling operation for "Wheel Picker" element
    And I click on "Wheel Picker" element
    Then I verify the "Wheel Picker Demo" page present
    And I click on spinner
    And I select "green" value in wheel picker
    Then I verify " Current Color: green " element displayed on the screen
    
    	
   Scenario: 09_Validate back button functionality
	 	When I click on the Login button
	 	Then I verify the "Samples List" page present
    And I click on "Native View" element
    Then I verify the "Native View Demo" page present
    And I click on "Back" element
    Then I verify the "Samples List" page present
    
    
    