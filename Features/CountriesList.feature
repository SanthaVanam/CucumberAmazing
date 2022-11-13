Feature: Displaying Countries list & Search testing
Background:  
		Given Launching Chrome Browser
    When User opens URL "http://www.amazon.in/"
    
	Scenario: Countries List
	
 		Then Printing All Countries which are having Amazon branches
    And close browser
    
    Scenario Outline: Search Testing
    
    Then clear text in textbox and add text as "<item name>"
     And close browser
    
    Examples:
    |item name|
    |Prestige|
    |Rakhi|
    |Guitar|
    |phone|
    |celing fan|
    
    

   
   
   
    
    