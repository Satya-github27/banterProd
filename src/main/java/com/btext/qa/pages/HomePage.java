package com.btext.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.btext.qa.base.TestBase;







public class HomePage extends TestBase {

	
	//Page Factory - OR:
		@FindBy(xpath="//div[@class='header']//img[@title='bantertext']")
		WebElement bantertext_logo;
	
	
	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean IsBantertextlogo_Displayed() {
		return bantertext_logo.isDisplayed();
	}
	
	
	

}
