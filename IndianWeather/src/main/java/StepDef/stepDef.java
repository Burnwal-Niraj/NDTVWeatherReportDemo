package StepDef;

import org.testng.Assert;

import APICall.test_get;
import Pages.NDTVHomePage;
import Pages.WeatherMapPage;
import Pojo.WeatherDataUI;
import Utility.Comparator;
import Utility.Utility;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.restassured.specification.RequestSpecification;

public class stepDef extends Utility {

	NDTVHomePage ndtvHomePage = new NDTVHomePage();
	WeatherMapPage weatherMapPage = new WeatherMapPage();
	test_get test = new test_get();
	Comparator comparator = new Comparator();
	WeatherDataUI weatherDataUI;
	RequestSpecification request;
	String tempInKelvin;

	@Given("^User is on NDTV home page on hitting \"([^\"]*)\"$")
	public void openNDTVUrlStep(String url) {

		ndtvHomePage.openNDTVUrl(url);
	}

	@When("^User clicks on more options$")
	public void clickMoreOptionStep() {
		ndtvHomePage.clickMoreOption();
	}

	@When("^User selects weather option$")
	public void GoToWeatherStep() {
		ndtvHomePage.GoToWeather();
	}

	@When("^user navigates to weather layout page$")
	public void verifyWeatherLayoutPageStep() {
		weatherMapPage.verifyWeatherLayoutPage();
	}

	@When("^user provides \"([^\"]*)\" in pin your city search field$")
	public void provideCityStep(String cityname) {
		weatherMapPage.provideCity(cityname);
	}

	@When("^user checks if the \"([^\"]*)\" city is present on the map with temperature information$")
	public void verifyCityOnMapWithTempStep(String cityname) {
		weatherMapPage.verifyCityOnMapWithTemp(cityname);
	}

	@When("^user checks the weather details of the \"([^\"]*)\" city$")
	public void verifyWeatherDetailsOfCityStep(String cityname) {
		weatherDataUI = weatherMapPage.verifyWeatherDetailsOfCity(cityname);
	}

	@When("^user checks weather response for \"([^\"]*)\" by city name using the api key \"([^\"]*)\" in base uri \"([^\"]*)\"$")
	public void checkResponseStep(String cityname, String key, String uri) {
		tempInKelvin = test.getTest(cityname, key, uri, request).toString();

	}

	@When("^user compares the temperature from UI and API with \"([^\"]*)\"$")
	public void checkResponseStep(String variance) {

		Assert.assertTrue(comparator.compareTempValues(weatherDataUI.getTempinDegrees(),
				String.valueOf(Float.parseFloat(tempInKelvin) - 273.15), variance));
	}

}
