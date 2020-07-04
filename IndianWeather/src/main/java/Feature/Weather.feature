Feature: Weather report Feature
  
  @SmokeSuite
  Scenario Outline: Checking weather report for specific city
    Given User is on NDTV home page on hitting "<Url>"
    When User clicks on more options
    And User selects weather option
    And user navigates to weather layout page
    When user provides "<cityName>" in pin your city search field
    And user checks if the "<cityName>" city is present on the map with temperature information
    And user checks the weather details of the "<cityName>" city 
    And user checks weather response for "<cityName>" by city name using the api key "<Key>" in base uri "<Uri>"
    And user compares the temperature from UI and API with "<variance>"


    Examples: 
      |Url|cityName|Key|Uri|variance|
      |https://www.ndtv.com/|Kolkata|7fe67bf08c80ded756e598d6f8fedaea|http://api.openweathermap.org/data/2.5/weather?|5|