package com.PageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CountriesListCucumber {
	WebDriver ldriver;

	public CountriesListCucumber(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);

	}

	@FindBy(xpath="//div[@class='navFooterLine navFooterLinkLine navFooterPadItemLine']/ul/li/a") List<WebElement> footercountries;
	@FindBy (xpath="//div[@id='glow-ingress-block']/span[1]") WebElement delivertobutton;
	@FindBy (xpath="//span[text()='Ship outside the US']") WebElement countriesDD;
	@FindBy (xpath="//ul[@role='listbox']/li/a") List<WebElement> listDD;

	public void getListDD()
	{
		System.out.println();
		System.out.println("************");
		System.out.println("Total Countries:"+listDD.size());
		System.out.println("************");
		System.out.println();
		for(WebElement list:listDD) 
		{			

			System.out.println(list.getText());
		}
		for(WebElement list:listDD)
		{
			if(list.getText().equalsIgnoreCase("Yemen"))
			{
				list.click();
			}
			
		}
		

	}


public void clickCountriesDD() throws InterruptedException {
	Thread.sleep(5000);
	countriesDD.click();
}


public void clickDelivertobutton() throws InterruptedException {
	Thread.sleep(5000);
	delivertobutton.click();
}


public void getFooterCountries() throws Exception
{

	Thread.sleep(5000);
	for(WebElement footercountry:footercountries)
	{

		String footerc =footercountry.getText();
		if(footerc.equalsIgnoreCase("United States"))
		{
			footercountry.click();
		}

	}
}


}
