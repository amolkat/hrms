package form_library;

import java.time.Duration;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class Candidate_Creation_form {
	
	private WebDriver driver;
	
	public Candidate_Creation_form(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	
//	Object Repository
	
	@FindBy(xpath="//input[@id='CANDIDATE NAME']")
	private WebElement full_name_sendkey_object;
	
	@FindBy(xpath="//input[@id='CANDIDATE EMAIL']")
	private WebElement candidate_email_sendkey_object;
	
	@FindBy(xpath="//input[@id='multiple-limit-tags']")
	private WebElement reporting_manager_sendkey_object;
	
	@FindBy(xpath="//input[contains(@name,\"CANDIDATE_DEPARTMENT\")]")
	private WebElement candidate_dep_sendkeys_enter_object;
	
	@FindBy(xpath="//input[contains(@name,\"CANDIDATE_LOCATION\")]")
	private WebElement  candidate_location_sendkeys_enter_object; 
	
	@FindBy(xpath="//input[contains(@name,\"CANDIDATE_ENTITY\")]")
	private WebElement entity_sendkeys_enter_object;
	
	@FindBy(xpath="//input[contains(@name,\"JOINING_DATE\")]")
	private WebElement joining_date_sendkeys_enter_object;
	
	@FindBy(xpath="//input[contains(@name,\"CANDIDATE_CTC\")]")
	private WebElement ctc_sendkeys_enter_object;
	
	@FindBy(xpath="//input[contains(@name,\"CANDIDATE_DESIGNATION\")]")
	private WebElement designation_sendkeys_enter_object;
	
	@FindBy(xpath="//input[contains(@name,\"WORKFLOW_ID\")]")
	private WebElement workflow_sendkeys_enter_object;

	@FindBy(xpath="//input[contains(@name,\"SALARY\")]")
	private WebElement salary_structure_sendkeys_object;
	
	@FindBy(xpath="//input[@id='AGE']")
	private List<WebElement> age_sendkeys_object;
	
	@FindBy(xpath="(//div[contains(text(),\"Candidate has been added successfully\")]//preceding-sibling::div)[2]")
	private WebElement Candidate_create_sucess_mess_object;
	
	
//	Action Repository
	
	public void candidate_name_sendkeys(String fullname) throws InterruptedException {
		full_name_sendkey_object.click();
		full_name_sendkey_object.sendKeys(fullname + Keys.ARROW_DOWN + Keys.ENTER);
	}
	
	public void candidate_email_sendkey(String Email) throws InterruptedException {
		candidate_email_sendkey_object.sendKeys(Email + Keys.ARROW_DOWN + Keys.ENTER);
	}
	
	public void reporting_sendkeys_enter(String rm) throws InterruptedException {
	reporting_manager_sendkey_object.sendKeys(rm +Keys.ARROW_DOWN +Keys.ENTER);
	}
	
	public void candidate_department_sendkeys(String department) throws InterruptedException {
		candidate_dep_sendkeys_enter_object.sendKeys(department + Keys.ARROW_DOWN + Keys.ENTER);
	Thread.sleep(1000);
	}

	public void candidate_location_sendkeys(String location) {
		candidate_location_sendkeys_enter_object.sendKeys(location + Keys.ARROW_DOWN + Keys.ENTER);
	}
	
	public void entity_sendkeys_click(String entity) throws InterruptedException {
			entity_sendkeys_enter_object.sendKeys(entity + Keys.ARROW_DOWN + Keys.ENTER);
	Thread.sleep(1000);
	}
	
	public void joining_sendkeys_click(String joining_date) {
		joining_date_sendkeys_enter_object.sendKeys(joining_date +  Keys.ENTER);
	}
	
	public void ctc_sendkeys_click(String ctc) {
		ctc_sendkeys_enter_object.sendKeys(ctc + Keys.ARROW_DOWN + Keys.ENTER);
	}
	
	public void designation_sendkeys_click(String designation) {
		designation_sendkeys_enter_object.sendKeys(designation + Keys.ARROW_DOWN + Keys.ENTER);
	}
	
	public void workflow_sendkeys_click(String workflow) {
		workflow_sendkeys_enter_object.sendKeys(workflow + Keys.ARROW_DOWN + Keys.ENTER);
	}
	
	public void salary_structure_click(String sa_st){
		salary_structure_sendkeys_object.sendKeys(sa_st + Keys.ARROW_DOWN +Keys.ENTER);
	}

	public void  age_sendkeys(String age) {
		boolean isElementExists = age_sendkeys_object.size()>0;

		if(isElementExists = true ) {
			System.out.println("age element   exists");
		  age_sendkeys_object.get(0).sendKeys(age);
		}
		else {
			System.out.println("age element   not exists");

		}

	}
	


	


	
	
}
