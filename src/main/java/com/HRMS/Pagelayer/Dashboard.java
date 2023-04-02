package com.HRMS.Pagelayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	private WebDriver driver;
	
	public Dashboard(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//	Object Repository
	
	@FindBy(xpath="//span[contains(text(),'Apply New')]")
	 private WebElement  Apply_new_Btn_click;
	
	
//	Action repository
	
	public void Apply_new_Btn_Click() {
		Apply_new_Btn_click.click();
	}
	
}
