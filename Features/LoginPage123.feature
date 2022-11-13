Feature: Checking User Login

  Scenario: User Login
    Given Launching Chrome Browser
    When User opens URL "http://www.amazon.in/" and clicking signin button
   And User enters user name "9948704813" and password "123256547"
  Then Page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
  And click logoff and close browser
	
	  Scenario Outline: User Login with multiple sets
	  
    Given Launching Chrome Browser
    When User opens URL "http://www.amazon.in/" and clicking signin button
   And User enters user name "<userid>" and password "<pwd>"
  Then Page title should be "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"
  And click logoff and close browser
  
  Examples:
  |userid|pwd|
  |9948704813|123256547|
  |6305809310|1234|
  