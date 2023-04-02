package com.HRMS.Testbase;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.HRMS.Utilities.Switch;



public class Sub_module {
        private WebDriver driver;
        private  Switch sw;
        

        
      public  Sub_module(WebDriver driver){
        	this.driver=driver;
        	PageFactory.initElements(driver, this);
        }
        
      
//----------------Object Repository
      
      //***************ess***************      
        
      @FindBy(xpath="//p[contains(text(),\"Employee Self Service\")]")
      private WebElement ESS_btn_object_click;
      
      //***************onboarding***************      
      
        @FindBy(xpath="//h3[contains(text(),'Onboarding')]")
    	private	 WebElement Onboarding_object;
 
      //********************calendar**************************
        @FindBy(xpath="//h3[contains(text(),'Shift')]")
        private WebElement shift_object;
     
        
        
        
        
//------------------Action Repository
        
       //***************ess***************      
       
       public void submodule_ess_click() throws InterruptedException {
    	   ESS_btn_object_click.click();
    	   Thread.sleep(6000);

    	   sw=new Switch(driver);
    	   sw.switchwindow();
    	   
    	  
       } 
  
      //***************onboarding***************      

       public void submodule_onboarding_click()  {    	   
    	   Onboarding_object.click();  
       }
       //********************calendar**************************

       public void submodule_shift_click() {
    	   shift_object.click();
       }

       
       
       
       
}
