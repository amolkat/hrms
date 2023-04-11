package com.HRMS.Pagelayer;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bsh.This;

public class Asset {
	public WebDriver driver;
	
	public Asset(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
//***************	object repository************
	
	@FindBy(xpath = "//h3[contains(text(),\"Dashboard\")]")
	private WebElement asset_dashboard_object;
	
	@FindBy(xpath = "//h3[contains(text(),\"Asset Category & Type\")]")
	private WebElement asset_Category_Type_object;
	
	@FindBy(xpath = "//h3[contains(text(),\"Asset List\")]")
	private WebElement asset_list_object;
	
//	 asset category
	
	@FindBy(xpath = "//span[contains(text(),\"Add Category\")]")
	private WebElement add_category_object;
	
	@FindBy(xpath = "//span[contains(text(),\"Category Name\")]")
    private WebElement category_name_sendkeys_object;
	
//	asset type
	@FindBy(xpath = "//span[contains(text(),\" Add Asset Type\")]")
	private WebElement add_assert_type_object;
	
	@FindBy(xpath = "//span[contains(text(),\"Submit\")]")
	private List<WebElement> submit_btn_click;
	
//*********	Action repository**********************
	
	
	public void asset_dashboard_click() {
		asset_dashboard_object.click();
	}
    
	public void asset_category_type_click(){
		asset_Category_Type_object.click();
	}
	
	public void asset_list() {
		asset_list_object.click();
	}

//	 asset category
	
	public void add_category_click() {
		add_category_object.click();
	}
	
	public void asset_category_category_Name_sendkeys() {
		category_name_sendkeys_object.sendKeys(null);
	}
	
//	asset type
	public void add_asset_type() {
		asset_Category_Type_object.click();
	}
	
	
	public void submit_btn_click() {
		if(submit_btn_click.size()>0){
			submit_btn_click.get(0).click();
		}
	}
	

}
