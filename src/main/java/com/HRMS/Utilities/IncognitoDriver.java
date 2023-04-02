package com.HRMS.Utilities;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.HRMS.Pagelayer.Loginpage;
import com.HRMS.Pagelayer.Request_module;

public class IncognitoDriver {

	private WebDriver incognitoDriver;
	private Request_module Request_module_object;
	
	public void approval_url() throws InterruptedException, IOException {
		   
	    ExcelFileHandler fh = new ExcelFileHandler();
	    ChromeOptions options = new ChromeOptions();
	    options.addArguments("--incognito");
    	incognitoDriver = new ChromeDriver(options);
	  
	    
    	//Going to the uRL
    	incognitoDriver.get(fh.readData(0, 1, 1));
    	 
		incognitoDriver.manage().window().maximize();
		incognitoDriver.manage().deleteAllCookies();
//		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		incognitoDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		


		Loginpage login_obj = new Loginpage(incognitoDriver);
//		Entering Login Details
		login_obj.username_txtbox(fh.readData(0, 5, 1));
		login_obj.password_txtbox(fh.readData(0, 6, 1));
		login_obj.Login_btn_click();	
		login_obj.Sucessfully_mess_get_text();	
		
		
	 
}
	
	public void ctc_approval() throws InterruptedException, IOException {
		Request_module_object = new Request_module(incognitoDriver);
		Request_module_object.ctc_approval();
}
	
}
