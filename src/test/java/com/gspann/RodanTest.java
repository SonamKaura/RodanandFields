package com.gspann;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;



public class RodanTest {
	
	static public WebDriver driver;

	//@Parameters("browser")
	@BeforeClass
	public void startup()  //String browsertype)
	{
	//browsertype="firefox";
	/*if (browsertype.equalsIgnoreCase("firefox"))
	{*/
	driver=new FirefoxDriver();
	/*}
	else{
	System.setProperty("webdriver.chrome.driver",
	"D://IMPTASPECTS//SeleniumLearning//chromedriver_win32//chromedriver.exe");
	driver=new ChromeDriver();
	}*/
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get("https://www.rodanandfields.com/ca/");
	}
	
	@Test
	public void Homepage() throws InterruptedException
	{
		RodanClass rodan=new RodanClass(driver);
		rodan.clickSkinCare();
		System.out.println("done1");
		rodan.mouseOver();
		System.out.println("done2");
		rodan.clickallProduct();
		System.out.println("done3");
		Thread.sleep(5000);
		
		
		rodan.refineCheckbox();
		rodan.redefineCheckbox();
		rodan.PriceDropDown();
		rodan.verifyRefineRedefine();
		rodan.verifyPrice();
		rodan.close();
		
	}
	
}
	

