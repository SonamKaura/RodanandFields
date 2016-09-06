package com.gspann;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(com.gspann.MyListner.class)
public class RodanTest {
	static public WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	//@BeforeTest
	public void startup(String browsertype)
	{
	browsertype="firefox";
	if (browsertype.equalsIgnoreCase("firefox"))
	{
	driver=new FirefoxDriver();
	}
	else
	{
	System.setProperty("webdriver.chrome.driver",
	"D://IMPTASPECTS//SeleniumLearning//chromedriver_win32//chromedriver.exe");
	driver=new ChromeDriver();
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get("https://www.rodanandfields.com/ca/");
	}
	
	@Test(priority=1)
	public void Homepage() throws InterruptedException
	{
		RodanClass rodan=new RodanClass(driver);
		rodan.clickSkinCare();
		System.out.println("done1");
		rodan.mouseOver();
		System.out.println("done2");
		rodan.clickallProduct();
		System.out.println("done3");
		Thread.sleep(7000);
		
		rodan.refineByDropdown(); 
		System.out.println("Refine By dropdown is clicked");
		rodan.redefineCheckbox();
		System.out.println("redefine checkbox clicked");
		Thread.sleep(3000);
		rodan.refineByDropdown();
		System.out.println("refineByDropdown is clicked");
		rodan.reverseCheckbox();
		Thread.sleep(3000);
		rodan.PriceDropDown();
		System.out.println("price dropdown is clicked");
		rodan.selectPrice();
		System.out.println("price is selected ");
		Thread.sleep(3000);
		rodan.verifyRefineRedefine();
		System.out.println("done 4");
		rodan.verifyPrice();
		System.out.println("done 5");
		rodan.close();
		
		
	}
	
	
	@Test(priority=2)
	public void consultant() throws InterruptedException
	{
		//driver=new FirefoxDriver();
		driver.get("https://www.rodanandfields.com/ca/");
		driver.manage().window().maximize();
		RodanConsultant consult=new RodanConsultant(driver);
		consult.clickBecomeConsultant();
		System.out.println("done6");
		Thread.sleep(4000);
		consult.mouseOver();
		Thread.sleep(4000);
		System.out.println("done7");
		consult.clickEnrollNow();
		Thread.sleep(4000);
		System.out.println("done8");
		consult.clickPolicies();
		Thread.sleep(4000);
		System.out.println("done9");
		consult.switchWindow();
		Thread.sleep(4000);
		System.out.println("Window switch done");
		String url=consult.verifyUrl();
		Assert.assertTrue(url.contains("https://www.rodanandfields.com/_ui/responsive/common/pdf/Archives/Policies_Procedures_CANADA.pdf"), "url mismatch");
		consult.close();
		consult.switchParentWin();
		System.out.println("Window is switched to parent");
		consult.enterName();
		Thread.sleep(4000);
		System.out.println("done10");
		consult.search();
		Thread.sleep(4000);
		System.out.println("done11");
		consult.productMouseOver();
		Thread.sleep(4000);
		System.out.println("done12");
		String productName=consult.getProductName();
		consult.productClick();
		Thread.sleep(4000);
		System.out.println("done13");
		String actualProduct=consult.brandVerify();
		Assert.assertEquals(actualProduct, productName);
		System.out.println("done14");
		consult.close();
	}
	
}
	

