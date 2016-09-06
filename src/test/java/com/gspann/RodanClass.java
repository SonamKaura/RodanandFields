package com.gspann;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class RodanClass {

WebDriver driver;

RodanClass(WebDriver d)
{
this .driver=d;
}

private By shopskinCareLoc=By.xpath("//span[@class='icon-search']/preceding::a[@id='our-products']");
private By allProductsLoc=By.xpath("//span[@class='icon-search']/preceding::a[@title='All Products']");
private By refineByDropLoc=By.xpath("//div[@id='main-content']/div[2]/div[2]/div[1]");
By redefineLoc=By.xpath("//div[@class='dropdown-wrapper']//li[1]//div[@class='pull-right']/div");
By reverseLoc=By.xpath("//ul[@class='refine-products select-dropdown open']/li[2]//div[@class='repaired-checkbox']");
private By priceDropDownLoc=By.xpath("//div[@id='main-content']/div[2]/div[2]/div[2]");
private By priceSelectLoc=By.xpath("//div[@id='main-content']/div[2]/div[2]/div[2]/ul//li[2]/form/div/div[1]/div[2]/div");
private By RefineRedefineverifyLoc=By.xpath("//div[@id='main-content']/div[2]/div[3]/div/ul[2]");
private By PriceLoc=By.xpath("//section[@class='row main-content productCatPage']/div[1]/div/div[5]/div[1]/p/span");


public void clickSkinCare() throws InterruptedException
{
	WebElement shopSkinCare=driver.findElement(shopskinCareLoc);
	shopSkinCare.click();
	Thread.sleep(4000);
}

public void mouseOver()
{
	Actions action = new Actions(driver);
	WebElement allProducts=driver.findElement(allProductsLoc);
	action.moveToElement(allProducts).build().perform();
	}


public void clickallProduct() throws InterruptedException
{
	WebElement allProducts=driver.findElement(allProductsLoc);
	allProducts.click();
	Thread.sleep(4000);
}

public void refineByDropdown() throws InterruptedException
{
	WebElement refineCheck=driver.findElement(refineByDropLoc);
	refineCheck.click();
	Thread.sleep(4000);
	
}


public void redefineCheckbox() throws InterruptedException
{
	WebElement redefineCheck=driver.findElement(redefineLoc);
	redefineCheck.click();
	Thread.sleep(4000);
	
}


public void reverseCheckbox() throws InterruptedException
{
	WebElement redefineCheck=driver.findElement(reverseLoc);
	redefineCheck.click();
	Thread.sleep(4000);
	
}

public void PriceDropDown() throws InterruptedException
{
	WebElement PriceDrop=driver.findElement(priceDropDownLoc);
	PriceDrop.click();
	Thread.sleep(4000);
}

public void selectPrice() throws InterruptedException
{
	WebElement priceselect=driver.findElement(priceSelectLoc);
	priceselect.click();
	Thread.sleep(4000);
}

public boolean verifyRefineRedefine(){
	
	WebElement checkbox=driver.findElement(RefineRedefineverifyLoc);
	boolean checkpresent=checkbox.isDisplayed();
	return checkpresent;

}

public boolean verifyPrice()
{
	WebElement checkprice=driver.findElement(PriceLoc);
	boolean pricepresent=checkprice.isDisplayed();
	return pricepresent;
}

public void close()
{
	driver.close();
}
}

