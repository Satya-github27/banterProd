package com.btext.qa.base;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.btext.qa.util.TestUtil;
import com.btext.qa.util.WebEventListener;



public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	static ChromeOptions options;
	
	public TestBase(){
		
		try {
			prop = new Properties();
			//System.out.println("file::"+System.getProperty("user.dir")+ "\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\btext\\qa\\config\\config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void initialization(){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
		//	System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", ".\\driverjar\\chromedriver.exe");
			 options=new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "E:\\ChromeDriver\\geckodriver.exe");	
			driver = new FirefoxDriver();
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("banter1url"));
		
	}
	
	public static void initialization(String url){
		String browserName = prop.getProperty("browser");
		
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "E:\\ChromeDriver\\chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("FF")){
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\satyanarayanac\\Downloads\\BanterScreens\\geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		
		e_driver = new EventFiringWebDriver(driver);
		// Now create object of EventListerHandler to register it with EventFiringWebDriver
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(url);
		
	}	
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)driver);

        //Call getScreenshotAs method to create image file

        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }
	
	public static void WaitUntil(WebDriver driver,WebElement element,int timeout) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOf(element));
		
	}
	
	
	public static void sendKeys(WebDriver driver,WebElement element,int timeout,String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.invisibilityOf(element));
		element.sendKeys(value);
		
		
	}
	
	public static void clickOn(WebDriver driver,WebElement element,int timeout,String value) {
		new WebDriverWait(driver, timeout).until(ExpectedConditions.elementToBeClickable(element));
		element.click();
		
		
	}
	

}


