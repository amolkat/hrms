package com.HRMS.Pagelayer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

 

public class Loginpage  {
	
	private  WebDriver driver;
	public Loginpage(WebDriver driver)
	{
		this.driver = driver;
	}
 

//	Object Repository
	private  By username_textbox_object=By.xpath("//input[@name=\"username\"]");
	private  By password_textbox_object=By.xpath("//input[@name=\"password\"]");
	private  By login_btn_object=By.xpath("//span[text()=\"Login\"]");
	private  By Sucessfully_message_object=By.xpath("//div[contains(text(),\"Login Successfully.\")]");



	
//	 Action Repository
	public  void username_txtbox(String enter_username) {
	
		driver.findElement(username_textbox_object).sendKeys(enter_username);
			
	}
	
    public void password_txtbox(String enter_password) {
	
		driver.findElement(password_textbox_object).sendKeys(enter_password);
	}
	
	public  void Login_btn_click(){
		driver.findElement(login_btn_object).click();

	}
	
	public void Sucessfully_mess_get_text() {
		 String Sucess_mess_gettext=driver.findElement(Sucessfully_message_object).getText();
		 String sucess_mess=Sucess_mess_gettext.replaceAll("\\s", " ");
	     Assert.assertEquals(sucess_mess,"Success Login Successfully.");   
//hard asset - It will stop execute statement even statement fail	     
	}


	
}
