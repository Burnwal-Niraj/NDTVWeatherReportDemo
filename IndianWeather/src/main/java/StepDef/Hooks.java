package StepDef;



import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;



public class Hooks {
	
	public static WebDriver driver;
	
	@Before
	public void setUp()
	{
		System.out.println("Inside before");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + ".//ChromeDriver//chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	

}
