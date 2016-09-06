package com.gspann;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.gspann.RodanTest;

public class MyListner implements ITestListener
{

	public void onTestStart(ITestResult result) {
		System.out.println("onTestStart-"+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("Taking screenshot");

		File file=((TakesScreenshot)(RodanTest.driver)).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("D:/sonam/s1.png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("onTestSuccess-"+result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestSuccess-"+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped-"+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage-"+result.getName());
		
	}

	public void onStart(ITestContext context) {
		System.out.println("onTestStart-"+context.getName());
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish-"+context.getName());
		
	}

}
