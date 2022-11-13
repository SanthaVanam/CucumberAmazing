package com.StepsDefinition;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.PageObjects.CountriesListCucumber;
import com.PageObjects.GoodsTypeCucumber;
import com.PageObjects.LoginPageObject;
import com.PageObjects.SearchCaseCucumber;
import com.PageObjects.SlideLinkCucumber;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class StepsDefinitionClass extends BaseClassCucumber {
	WebDriver driver;
	LoginPageObject lp;
	GoodsTypeCucumber gt;
	CountriesListCucumber cl;
	SearchCaseCucumber sc;
	SlideLinkCucumber slide;
	
	
	@Given("Launching Chrome Browser")
	public void launching_chrome_browser() {
	   
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	lp = new LoginPageObject(driver);
	gt = new GoodsTypeCucumber(driver);
	cl = new CountriesListCucumber(driver);
	sc = new SearchCaseCucumber(driver);
	slide = new SlideLinkCucumber(driver);

	}
	
	@Then("Printing all links and validating whether it is existing or not")
	public void printing_all_links_and_validating_whether_it_is_existing_or_not() throws Exception {
	
		List<String> links = slide.getSlideImagesLink1();
		int validlinks = 0;
		
		for(String li:links) 
		{
			URL url = new URL(li);
			HttpURLConnection httpc =(HttpURLConnection) url.openConnection();
			httpc.connect();
			if(httpc.getResponseCode()>400)
			{
				System.out.println("The URL  "+url+"  is invalid");
			}
			else
			{
				System.out.println();
				
				System.out.println("The URL  "+url+"  is valid");
				System.out.println("************");
				validlinks++;
			}
		}
						
		System.out.println("The valid Links count is:"+" "+validlinks);
	}

	
	@When("Clicking all button and printing headings")
	public void clicking_all_button_and_printing_headings() throws InterruptedException {
		Thread.sleep(5000);
		gt.clickTypeGoods();
		gt.getHeadings();
	  
	}

	@Then("Printing Sub Headings")
	public void printing_sub_headings() throws Exception {
		Thread.sleep(5000);
	    
	  gt.handlingSubList();
	}


	@When("User opens URL {string} and clicking signin button")
	public void user_opens_url_and_clicking_signin_button(String url) {
		driver.get(url);
		lp.clickSigninLink();
				 
	}
	
	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		driver.get(url);
						 
	}
	
	@Then("Printing All Countries which are having Amazon branches")
	public void printing_all_countries_which_are_having_amazon_branches() throws Exception {
		cl.getFooterCountries();
		cl.clickDelivertobutton();
		cl.clickCountriesDD();
		cl.getListDD();
	  
	}

	@Then("close browser")
	public void close_browser() {
		driver.quit();
	  
	}
	

@Then("clear text in textbox and add text as {string}")
public void clear_text_in_textbox_and_add_text_as(String sname) {
	
	sc.clearItems();
	sc.searchItems(sname);
	driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
  
	
	
}

	@When("User enters user name {string} and password {string}")
	public void user_enters_user_name_and_password(String username, String pwd) {
		
		lp.enterUserName(username);
		lp.clickContinue();
		lp.enterPassword(pwd);
		lp.clickSigninbutton();
		
		
	
	}

	@SuppressWarnings("deprecation")
	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {
		
		try {

//			By ele =By.xpath("//span[@id='nav-link-accountList-nav-line-1']");
//			waitTimeNow(20,ele);
			String hello = driver.findElement(By.xpath("//span[text()='Hello, Santha']")).getText();
			System.out.println(hello);

			if(hello.equals("Hello, Santha"))
			{
				String actualtitle = driver.getTitle();
				System.out.println(actualtitle);

				title.equals(actualtitle); 
				
				System.out.println("Welcome to HomePage");
//				By ele1 = By.xpath("//span[text()='Sign Out']");
//				waitTimeNow(10,ele1);
				
				
			}
		}
		catch(Exception e)
		{
			System.out.println("Incorrect Credentials");
			Assert.assertTrue(false);
			

		}
		
	
	}
	
	@Then("click logoff and close browser")
	public void click_logoff() throws Exception {
	 
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.id("nav-link-accountList-nav-line-1")))
		.moveToElement(driver.findElement(By.xpath("//span[text()='Sign Out']"))).click().perform();	
	   Thread.sleep(5000);
	 //  driver.quit();
	}




}
