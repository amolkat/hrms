package com.HRMS.Utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;



public class Switch {

	private WebDriver driver;
	
	public Switch(WebDriver driver) {
		this.driver = driver;
	}
	
	public void switchwindow() {
	
 	   String parent_id=driver.getWindowHandle();
 	   System.out.println(parent_id);
 	   
 	   Set<String> all_id=driver.getWindowHandles();
 	   
 	   Iterator<String> xyz =all_id.iterator();
 	   String p_id=xyz.next();
 	   String c_id=xyz.next();
 	   driver.switchTo().window(c_id);
 	   System.out.println("parent_id" +" " +p_id);
 	   System.out.println("child_id" +" "  +c_id);
	}

	}
	

