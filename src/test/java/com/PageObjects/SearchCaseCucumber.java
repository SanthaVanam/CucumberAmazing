package com.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCaseCucumber {
WebDriver ldriver;
	
	public SearchCaseCucumber(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver,this);
	}
	

	@FindBy(id="twotabsearchtextbox") WebElement searchbox;
	
	public void searchItems(String searchitem)
	{
		searchbox.sendKeys(searchitem);
	}
	
	public void clearItems() {
		searchbox.clear();
	}


}
