package com.btext.qa.Testcases;


import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.btext.qa.base.TestBase;
import com.btext.qa.pages.HomePage;
import com.btext.qa.pages.LoginPage;




public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homepage;
	
	public LoginPageTest(){
		super();
	}
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginPage = new LoginPage();	
	}
	
	@Test(priority=1)
	public void VerifyLoginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		System.out.println("title:"+title);
		Assert.assertEquals(title, "banter");
	}
	
	@Test(priority=2)
	public void VerifyBanterLogoTest(){
		boolean flag = loginPage.validateBanterImage();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void VerifyloginPageTest() throws InterruptedException{
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	
	
	@BeforeClass
	  public void tearDown()
	  { 
		//  driver.quit(); 
	  }
	 
	
	
	

}
