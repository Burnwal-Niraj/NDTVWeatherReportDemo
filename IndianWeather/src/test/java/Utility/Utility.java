package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility {
	
	public static WebDriver driver;
	
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ".//ChromeDriver//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public void closeBrowser()
	{
		driver.quit();
	}

}
