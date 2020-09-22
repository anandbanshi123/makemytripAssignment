	Feature: test


	Scenario: makemytrip.com : Create user functionality
	Given User Open the browser
	And User enter the URL of makemytrip.com in browser
	When User selects the fligt destination from to
	|Delhi|Patna|
	And Enter date for depature after 30 days
	And Select the passanger and class
	And User click on search
	Then Verify that the flight list is as per on required date.
	
	When user select the one stop flight
	Then verify that the list should be one stop flight.
	And Print the count one stop flight and lowestprice.
	