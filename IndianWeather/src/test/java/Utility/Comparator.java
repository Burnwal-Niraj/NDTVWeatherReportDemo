package Utility;

public class Comparator {
	
	public boolean compareTempValues(String tempUI, String tempAPI, String variance)
	{
		String temperatureUI = tempUI.substring(0,2);
		System.out.println("UI temp in degree celsius is: " + temperatureUI);
		if(Float.parseFloat(temperatureUI)-Float.parseFloat(tempAPI)<=Integer.parseInt(variance))
		{
			return true;
		}
		
		return false;
	}

}
