package com.HRMS.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestListener;
import org.testng.ITestResult;





public class Listenersetup implements ITestListener{
	
	 WebDriver driver;
	 
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Execution Start");

	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Execution Sucess");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Execution Failure");
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File des = new File ("D:\\screenshot automated\\04_02_2023\\.png");
try {
	FileHandler.copy(src, des);
} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Execution Skipped");

	}

	


}



//right click utility class folder select>>> source >>override/implement method
