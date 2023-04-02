package com.HRMS.Utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class AssertObject_Dropdown {
	
	private WebDriver driver;
	
	public AssertObject_Dropdown(WebDriver driver) {
		this.driver=driver;
	}
	 
	
//	soft assert
public void assertobject(String actual ,String expected) {
	SoftAssert sa = new SoftAssert();
	System.out.println(actual);
	sa.assertEquals(actual, expected);
	sa.assertAll();
	
}


public void getlistdropdown(String desiredOption ) {

//	 locate the list of options using a suitable selector, such as By.xpath
	WebElement optionsList = driver.findElement(By.xpath("(//UL[contains(@class,\" MuiList-padding list-popover \")])//parent::div"));

	// get a list of all the options in the dropdown
	List<WebElement> options = optionsList.findElements(By.tagName("li"));

	// create a loop that iterates over the options in the list
	for (WebElement option : options) {
	    // get the visible text of the option
	    String optionText = option.getText();
	    
	    // check if the option text matches the desired option from the array
	    if (optionText.equals(desiredOption)) {
	 
	        // click on the option to select it
	        option.click();
	        
	        // do something with the selected option
	        System.out.println("Selected option: " + optionText);
	        
	        // break out of the loop since we've found the desired option
	        break;
	    }
	
	}
}

}
