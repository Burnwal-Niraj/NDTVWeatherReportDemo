package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Pojo.WeatherDataUI;
import ResuableMethods.CommonMethods;

public class WeatherMapPage extends CommonMethods {
	
	WeatherDataUI weatherDataUI;

	@FindBy(xpath = "//input[@id='searchBox']")
	WebElement searchBox;

	String checkbox = "//label[@for='%s']/input";

	String city = "//div[text()='%s']";

	String cityTempInCelsius = "//div[text()='%s']/..//div[@class='temperatureContainer']//span[@class='tempRedText']";

	String cityTempInFahreinhite = "//div[text()='%s']/..//div[@class='temperatureContainer']//span[@class='tempWhiteText']";

	String WeatherCondtion = "(//span[contains(text(),'%s')]/../..//span[@class='heading']/b)[1]";

	String WindVelocity = "(//span[contains(text(),'%s')]/../..//span[@class='heading']/b)[2]";

	String Humidity = "(//span[contains(text(),'%s')]/../..//span[@class='heading']/b)[3]";

	@FindBy(xpath = "//div[@id='logo']")
	WebElement weatherHeader;

	public void verifyWeatherLayoutPage() {
		WeatherMapPage weatherMapPage = PageFactory.initElements(driver, WeatherMapPage.class);
		waiting(weatherMapPage.weatherHeader);
		if (weatherMapPage.weatherHeader.isDisplayed()) {
			System.out.println("User has naviagted to weather layout page");
		}

		else {
			System.out.println("User has not naviagted to weather layout page");
		}
	}

	public void provideCity(String cityname) {
		WeatherMapPage weatherMapPage = PageFactory.initElements(driver, WeatherMapPage.class);
		passingText(weatherMapPage.searchBox, cityname);
		
	}

	public void verifyCityOnMapWithTemp(String cityname) {
		
		checkbox = String.format(checkbox, cityname);
		if (driver.findElement(By.xpath(checkbox)).isSelected() == false) {
			clicking(driver.findElement(By.xpath(checkbox)));
			
		} else {
			System.out.println("The checkbox is already checked");
		}
			city = String.format(city, cityname);
			cityTempInCelsius = String.format(cityTempInCelsius, cityname);
			cityTempInFahreinhite = String.format(cityTempInFahreinhite, cityname);
			waiting(driver.findElement(By.xpath(city)));
			if (driver.findElement(By.xpath(city)).isDisplayed() == true
					&& driver.findElement(By.xpath(cityTempInCelsius)).isDisplayed() == true
					&& driver.findElement(By.xpath(cityTempInFahreinhite)).isDisplayed() == true) {
				System.out.println("City is available on the map  with temperature details");
			} else {
				System.out.println("There is some missing information");
			}
		}
	
    public WeatherDataUI verifyWeatherDetailsOfCity(String cityname) {
    	city = String.format(city, cityname);
    	clicking(getElement(city));
		WeatherCondtion = String.format(WeatherCondtion, cityname);
		WindVelocity = String.format(WindVelocity, cityname);
		Humidity = String.format(Humidity, cityname);
		cityTempInCelsius = String.format(cityTempInCelsius, cityname);
		cityTempInFahreinhite = String.format(cityTempInFahreinhite, cityname);
        weatherDataUI = new WeatherDataUI();
    	weatherDataUI.setCity(cityname);
    	weatherDataUI.setCondition(getElement(WeatherCondtion).getText());
    	weatherDataUI.setWind(getElement(WindVelocity).getText());
    	weatherDataUI.setHumidity(getElement(Humidity).getText());
    	weatherDataUI.setTempinDegrees(getElement(cityTempInCelsius).getText());
    	weatherDataUI.setTempinFahrenheit(getElement(cityTempInFahreinhite).getText());
		return weatherDataUI;
	}
    
    

}
