package com.gspann;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RodanConsultant {
WebDriver driver;

String parent=driver.getWindowHandle();

RodanConsultant(WebDriver d)
{
this .driver=d;
}
	
private By becomeConsultantLoc=By.xpath("//span[@class='icon-search']/preceding::a[@title='BECOME A CONSULTANT']");
private By enrollNowLoc=By.xpath("//span[@class='icon-search']/preceding::a[@title='Enroll Now']");
private By policesProceduresLoc=By.xpath("//div[@class='col-xs-12 click-help']/div/div/div[1]//a[1]");
private By enterConsulNameLoc=By.xpath("//input[@class='required text-input']");
private By searchLoc=By.xpath("//button[@id='search-sponsor-button']");
private By productMouseOverLoc=By.xpath("//div[@class='the-search-results']/div[1]/form/div");
private By selectProdLoc=By.xpath("//div[@class='the-search-results']/div[1]/form/div/div/input");
private By textLoc=By.xpath("//div[@class='the-search-results']/div[1]/form/div/div/div[1]//ul/li[1]");
private By brandLoc=By.xpath("//div[@class='selected-consultant']/a");









public void clickBecomeConsultant()
{
	WebElement consultant=driver.findElement(becomeConsultantLoc);
	consultant.click();
}


public void mouseOver()
{
	Actions action = new Actions(driver);
	WebElement enrollNow=driver.findElement(enrollNowLoc);
	action.moveToElement(enrollNow).build().perform();
	}


public void clickEnrollNow() throws InterruptedException
{
	WebElement enrollNow=driver.findElement(enrollNowLoc);
	enrollNow.click();
	Thread.sleep(4000);
}

public void clickPolicies()
{
	WebElement policies=driver.findElement(policesProceduresLoc);
	policies.click();
	
}

public void switchWindow()
{
	Set<String> allwin=driver.getWindowHandles();
	for(String currentWin:allwin)
	{
		if(!currentWin.equals(parent))
		{
			driver.switchTo().window(currentWin);
			break;
		}
	}
	
}

public String verifyUrl()
{
	String currentUrl=driver.getCurrentUrl();
	System.out.println("Current url is "+currentUrl);
	return currentUrl;
}

public void close()
{
	driver.close();

}

public void switchParentWin()
{
	driver.switchTo().window(parent);
	
}

public void enterName()
{
	WebElement name=driver.findElement(enterConsulNameLoc);
	name.sendKeys("Test");
}

public void search()
{
	WebElement search=driver.findElement(searchLoc);
	search.click();
}

public void productMouseOver()
{
	Actions action = new Actions(driver);
	WebElement product=driver.findElement(productMouseOverLoc);
	action.moveToElement(product).build().perform();
}


public String getProductName()
{
	WebElement productName=driver.findElement(textLoc);
	String nameProduct=productName.getText();
	return nameProduct;
	
}
public void productClick()
{
	WebElement selectProduct=driver.findElement(selectProdLoc);
	selectProduct.click();
}

public String brandVerify()
{
	WebElement brand=driver.findElement(brandLoc);
	String brandName=brand.getText();
	return brandName;
	
}



}

