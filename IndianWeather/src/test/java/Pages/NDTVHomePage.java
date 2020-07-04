package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ResuableMethods.CommonMethods;

public class NDTVHomePage extends CommonMethods {

	

	@FindBy(xpath = "//a[@id='h_sub_menu']")
	WebElement moreOptions;

	@FindBy(xpath = "//a[text()='WEATHER']")
	WebElement weather;

	public void openNDTVUrl(String url) {
		
		driver.get(url);
	}

	public void clickMoreOption() {
		NDTVHomePage ndtvHomePage = PageFactory.initElements(driver, NDTVHomePage.class);
		clicking(ndtvHomePage.moreOptions);

	}

	public void GoToWeather() {
		NDTVHomePage ndtvHomePage = PageFactory.initElements(driver, NDTVHomePage.class);
        clicking(ndtvHomePage.weather);
	}
}
