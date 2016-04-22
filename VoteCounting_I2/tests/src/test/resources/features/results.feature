Feature: See results
  I want to see the results of the poll
  
  Scenario: See general results
	Given 10 random votes of: PP, PSOE, CIUDADANOS, PODEMOS
	When I start the counting
	Then The votes are shown
	
