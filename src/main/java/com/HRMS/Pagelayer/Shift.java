package com.HRMS.Pagelayer;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMS.Testbase.Main_Module;

public class Shift {

	private WebDriver driver;

	
	public Shift(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

//	øbject Respository
	
	@FindBy(xpath="//span[contains(text(),'Create New')]")
	private WebElement create_new_btn_click_object;
	
	@FindBy(xpath="//span[contains(text(),'Flexible Daily Shift')]")
	private WebElement flexible_shift_click_from_DD_object;

	@FindBy(xpath="//span[contains(text(),'Fixed Daily Shift')]")
	private WebElement fixed_shift_click_from_DD_object;

	@FindBy(xpath="//input[@id='Shift Name']")
	private WebElement shift_name_object;
	
	@FindBy(xpath="//label[contains(text(),\"Time zone\")]")
	private WebElement time_zone_sendkeys_object;
	
//	
//	@FindBy(xpath="//span[contains(text(),'Fixed Daily Shift')]")
//	private WebElement fixed_shift_click_from_DD_object;
//	
//	@FindBy(xpath="//span[contains(text(),'Fixed Daily Shift')]")
//	private WebElement fixed_shift_click_from_DD_object;
//	
//	@FindBy(xpath="//span[contains(text(),'Fixed Daily Shift')]")
//	private WebElement fixed_shift_click_from_DD_object;
//	
//	@FindBy(xpath="//span[contains(text(),'Fixed Daily Shift')]")
//	private WebElement fixed_shift_click_from_DD_object;
//	
//	@FindBy(xpath="//span[contains(text(),'Fixed Daily Shift')]")
//	private WebElement fixed_shift_click_from_DD_object;
//	
//	@FindBy(xpath="//span[contains(text(),'Fixed Daily Shift')]")
//	private WebElement fixed_shift_click_from_DD_object;
//	
////	Action Respository
//	
//	public void shift_create_btn_click(){
//		create_new_btn_click_object.click();
//	}
//	
//	public void flexible_shift_click_from_DD(){
//		flexible_shift_click_from_DD_object.click();
//	}
//	
//	public void fixed_shift_click_from_DD(){
//		flexible_shift_click_from_DD_object.click();
//	}
//	
//	
	
	
	
}
