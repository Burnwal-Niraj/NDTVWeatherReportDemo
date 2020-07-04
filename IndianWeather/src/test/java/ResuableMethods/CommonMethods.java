package ResuableMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Utility;

public class CommonMethods extends Utility{
	
	
	public void clicking(WebElement e)
	{
		e.click();
	}
	
	public void passingText(WebElement e, String text)
	{
		e.sendKeys(text);
	}
	
	public void waiting(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public void waiting1(WebElement e)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}
	
	public void window_handles()
	{
		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		for (String child : windows)
		{
			if (!parent.equalsIgnoreCase(child))
				driver.switchTo().window(child);
		}
	}
	
	public void screenCapture()
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File file=ts.getScreenshotAs(OutputType.FILE);
		try {
			FileInputStream fileInputStream= new FileInputStream(file);
			FileUtils.copyFile(file, new File(".//Screenshot//Result.jpg"));
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	public WebElement getElement(String s)
	{
		 return driver.findElement(By.xpath(s));
	}
	

}
