package com.HRMS.Testbase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Main_Module {
	
	private WebDriver driver;      //  this driver1 access throught class by uses non static method  & driver1 value is null so uses construtor to intiliase data member/variable
	
	 public Main_Module(WebDriver driver){     
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		  }

//       Object repro
	 
	 @FindBy(xpath="//span[contains(text(),'apps')]")
	private  WebElement  apps;
	 
	 
	 
	 
//	private By apps=By.xpath("//span[contains(text(),'apps')]");
	
	private By dashboard = By.xpath("//span[contains(text(),'dashboard')]");
	
	private By organisation=By.xpath("//p[contains(text(),'Organisation')]");
	
	private By calendar = By.xpath("//p[contains(text(),'Calendar')]");
	
	
	
	
//	     Action repro
	
	
	   public void apps_module() {
//		   driver.findElement(apps).click();
		   apps.click();
	   }
	   
	   public void dashboard_module() {
		   driver.findElement(dashboard).click();
	   }
	   
       public void organisation_module() {
	   driver.findElement(organisation).click();
       }
       
       public void calendar_module() {
    	   driver.findElement(calendar).click();
       }
   

	 


}
