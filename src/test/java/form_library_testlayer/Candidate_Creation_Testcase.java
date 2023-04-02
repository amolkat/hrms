package form_library_testlayer;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.HRMS.Utilities.ExcelFileHandler;

import form_library.Candidate_Creation_form;

public class Candidate_Creation_Testcase {
	
	private WebDriver driver;
	private Candidate_Creation_form form ;
	
	public Candidate_Creation_Testcase(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public void Candidate_creation()  throws InterruptedException, IOException {
		form = new Candidate_Creation_form(driver);
		ExcelFileHandler efh= new ExcelFileHandler();
		
		 
		
		form.candidate_name_sendkeys(efh.readData(1, 1, 1));
		form.candidate_email_sendkey(efh.readData(1, 2, 1));
		form.reporting_sendkeys_enter(efh.readData(1, 3, 1));
		form.candidate_department_sendkeys(efh.readData(1, 4, 1));
		form.candidate_location_sendkeys(efh.readData(1, 5, 1));
		form.entity_sendkeys_click(efh.readData(1, 6, 1));
		form.joining_sendkeys_click(efh.readData(1, 7, 1));
		form.ctc_sendkeys_click(efh.readData(1, 8, 1));
		form.designation_sendkeys_click(efh.readData(1, 9, 1));
		form.workflow_sendkeys_click(efh.readData(1, 10, 1));
		form.salary_structure_click(efh.readData(1, 11, 1));
		form.age_sendkeys(efh.readData(1, 12, 1));
		
	}
	
}
