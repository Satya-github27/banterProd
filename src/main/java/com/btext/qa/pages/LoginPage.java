package com.btext.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.btext.qa.base.TestBase;








public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(xpath="//input[@id='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@id='password']")
	WebElement password;
	
	@FindBy(xpath="//button[text()=' Login ']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[@class='logo']")
	WebElement banterLogo;
	
	@FindBy(xpath="//div[@class='search-controls ']//img")
	WebElement numberdriver;
	
	@FindBy(xpath="//a[text()=' Extension']")
	WebElement extension;
	
	@FindBy(xpath="//div[@class='scroll-container mt-1']//a")
	List<WebElement> extensioncount;
	
	@FindBy(xpath="//button[text()='Cancel']")
	WebElement driverpopup_close;
	
	@FindBy(xpath="//div[@class='scroll-container mt-1']//a")
	List<WebElement> numberlistcount;
	
    @FindBy(xpath="//div[@class='search-num my-2 mx-3']//input[@type='text']")
	public 	WebElement popup_Searchbox;
	
	@FindBy(xpath="//div[@class='scroll-container mt-1']")
	public WebElement popup_Searchbox_select_no;
	
	
	@FindBy(xpath="//div[@class='form-group mx-3 my-2']//button[text()='Ok']")
	public WebElement popup_Searchbox_select_no_ClickOk_Button;
	
	@FindBy(xpath="//a[@title='General Settings']")
	public WebElement gen_settings_tab;

	@FindBy(xpath="//a[@title='Number  Settings']")
	public WebElement num_settings_tab;

	@FindBy(xpath="//a[@title='Product Settings']")
	public WebElement prod_settings_tab;
	
	@FindBy(xpath="//span[@class='ml-1']//parent::div")
	public List<WebElement> num_list;
	

	@FindBy(xpath="//input[@type='text']")
	 public WebElement num_searchbox;
	
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	public void numberdriverclick() throws InterruptedException{
		Thread.sleep(2000);
		numberdriver.click();
	}
	
	public void select_driver_popup_number() {
		popup_Searchbox_select_no.click();
	}
	
	
	public void click_popup_ok_button() {
		popup_Searchbox_select_no_ClickOk_Button.click();
	}
	
/*	String str= " (612) 299-2429 ";   
	str = str.replaceAll("[^a-zA-Z0-9]", " ").trim();
	 str=str.replaceAll("\\s", ""); 
	System.out.println(str); */
	
	List<String> num=new ArrayList<String>();
	public List<String> num_list() {
		for(int i=0;i<num_list.size();i++) {
			String str=num_list.get(i).getText().substring(0, 14).replaceAll("[^a-zA-Z0-9]", " ").trim().replaceAll("\\s", "");
			 System.out.println("NUM:"+str);
			 num.add(str);
			
		}
		return num;
	}
	
	
	public void driver_pop_up_num_Serach(String num) throws InterruptedException {
		popup_Searchbox.clear();Thread.sleep(1000);
		popup_Searchbox.sendKeys(num);
	}
	public void driverpopupclose(){
		driverpopup_close.click();
	}
	
	public void extensionclick(){
		extension.click();
	}
	
	public int numberlistcount(){
		return numberlistcount.size();
	}

	public int extensionlistcount(){
		return extensioncount.size();
	}
	
	public boolean validateBanterImage(){
		return banterLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) throws InterruptedException{
		Thread.sleep(10000);
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		    	JavascriptExecutor js = (JavascriptExecutor)driver;
		    	js.executeScript("arguments[0].click();", loginBtn);
		    	
		return new HomePage();
	}
	
}

