package com.HRMS.Pagelayer;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.HRMS.Testbase.Url_screenshot_Quit;
import com.HRMS.Utilities.AssertObject_Dropdown;
import com.HRMS.Utilities.ExcelFileHandler;
import com.HRMS.Utilities.Switch;

import form_library.Candidate_Creation_form;

public class OnBoardingPage {

	private WebDriver driver;
	public Scanner myobj = new Scanner(System.in);
	private ExcelFileHandler fh;
//	soft asset
	private AssertObject_Dropdown ao;

	public OnBoardingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//-------------------------Object Repository-------------------------------------------------

	@FindBy(xpath = "//h3[contains(text(),'Overview')]")
	private WebElement overview_object;

	@FindBy(xpath = "//h3[contains(text(),'Candidate')]")
	private WebElement candidate_object;

	@FindBy(xpath = "//body/div[@id='root']/main[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/span[1]/div[1]/*[1]")
	private WebElement Workflow_dropdown_arrow_btn_click_object;

	@FindBy(xpath = "//h6[contains(text(),'Default Workflow')]")
	private WebElement Workflow_select_dropdown_object;

	@FindBy(xpath = "//span[contains(text(),'Create New')]")
	private WebElement create_new_click_object;

	@FindBy(xpath = "//span[contains(text(),'Add Manually')]")
	private WebElement Add_manually_click_object;

	@FindBy(xpath = "//span[contains(text(),'Submit')]")
	private List<WebElement> submit_btn_object;

	private static final String intitate_button_click = "(//div[contains(@data-rbd-draggable-id,%s)]//ancestor::button)[2]";

	//// ************* common list click on Three dot on
	//// candidate**************//////////////////
	@FindBy(xpath = "//span[contains(text(),'View Candidate')]")
	private WebElement View_candidate_click_object;

	@FindBy(xpath = "//span[contains(text(),'Edit Candidate')]")
	private WebElement Edit_candidate_click_object;

	@FindBy(xpath = "//span[contains(text(),'Withdraw')]")
	private WebElement Withdraw_candidate_click_object;

	@FindBy(xpath = "//span[contains(text(),'Blacklist')]")
	private WebElement Blacklist_candidate_click_object;

	@FindBy(xpath = "//span[contains(text(),'Move to previous step')]")
	private WebElement move_to_previous_candidate_click_object;

	@FindBy(xpath = "//span[contains(text(),'Move to next Step')]")
	private WebElement move_to_next_stage_candidate_click_object;

////*************** start click on Three dot on bucket list**************//////////////////

	private static final String cidwelcome = "(//div[contains(@data-rbd-draggable-id,\"Welcome Mail\") and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

	private static final String cidmanagement = "(//div[contains(@data-rbd-draggable-id,\"Management Approval\")and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

	private static final String cidcandidatejoineeform = "(//div[contains(@data-rbd-draggable-id,\"Candidate Joinee Form\")and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

	private static final String cidverifycandidatedetail = "(//div[contains(@data-rbd-draggable-id,\"Verify Candidate Details\")and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

	private static final String cidaadharverify = "(//div[contains(@data-rbd-draggable-id,\"Aadhaar Verification\")and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

	private static final String cidctcapproval = "((//div[contains(@data-rbd-draggable-id, \"CTC Approval\") and contains(@data-rbd-draggable-id,%s)])//child::button)[1]";

	private static final String cidaddcandidatectc = "(//div[contains(@data-rbd-draggable-id,\"Add Candidate CTC\")and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

	private static final String cidofferletter = "(//div[contains(@data-rbd-draggable-id,\"Send Offer Letter\") and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

	private static final String cidloi = "(//div[contains(@data-rbd-draggable-id,\"LOI\")and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

	private static final String cidconvertemployees = "(//div[contains(@data-rbd-draggable-id,\"Convert to Employee\")and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

	private static final String cidemployeecredential = "(//div[contains(@data-rbd-draggable-id,\"Employee Credentials\")and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

	private static final String cidtransferdocument = "(//div[contains(@data-rbd-draggable-id,\"Transfer Documents\")and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

	private static final String cidappointmentletter = "(//div[contains(@data-rbd-draggable-id,\"Appointment Letter\") and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

	private static final String cidbackgroundverification = "(//div[contains(@data-rbd-draggable-id,\"Background Verification\") and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

	private static final String cidrequestasset = "(//div[contains(@data-rbd-draggable-id,\"Request Assets\") and contains(@data-rbd-draggable-id,%s)]//child::button)[1]";

////*************** start click of  bucket list**************//////////////////

	@FindBy(xpath = "//span[contains(text(),'Welcome mail')]")
	private WebElement welcome_candidate_click_object;

	@FindBy(xpath = "//span[contains(text(),'Management approval')]")
	private WebElement management_approval_click_object;

	@FindBy(xpath = "//span[contains(text(),'Candidate joinee form')]")
	private WebElement candidate_joinee_click_object;

	@FindBy(xpath = "//span[contains(text(),'Verify candidate details')]")
	private WebElement Verify_candidate_detail_click_object;

	@FindBy(xpath = "//body/div[@id='openModal']/div[3]/nav[1]/li[7]")
	private WebElement Aadhar_verfication_click_object;

	@FindBy(xpath = "//span[contains(text(),'Ctc approval')]")
	private WebElement ctc_approval__click_object;

	@FindBy(xpath = "//span[contains(text(),'Add candidate ctc')]")
	private WebElement Add_candidate_CTC_click_object;

	@FindBy(xpath = "//span[contains(text(),'Offer letter')]")
	private WebElement Offer_letter_click_object;

	@FindBy(xpath = "//span[contains(text(),'Letter of intent(loi)')]")
	private WebElement LOI_click_object;

	@FindBy(xpath = "//span[contains(text(),'Convert to employee')]")
	private WebElement convert_to_employees_click_object;

	@FindBy(xpath = "//span[contains(text(),'Employee credentials')]")
	private WebElement Employee_credential_click_object;

	@FindBy(xpath = "//span[contains(text(),'Appointment letter')]")
	private WebElement Appointment_letter_click_object;

	@FindBy(xpath = "//span[contains(text(),'Background verification')]")
	private WebElement Background_verfication_click_object;

	@FindBy(xpath = "//span[contains(text(),'Appointment letter')]")
	private WebElement request_asset_click_object;

////*************** start click of  candidate profile **************//////////////////

	@FindBy(xpath = "//span[contains(text(),\"CANDIDATE EMAIL\")]//following::div[2]")
	private WebElement get_candidate_email_object;

	@FindBy(xpath = "//div[contains(text(),'Documents')]")
	private WebElement candidate_profile_Document_object;

	@FindBy(xpath = "//span[contains(text(),\"CANDIDATE NAME\")]//following::div[2]")
	private WebElement get_candidate_name_object;

//	********************verify candidate detail**************************

	@FindBy(xpath = "//span[contains(text(),'Proceed')]")
	private List<WebElement> Procces_btn_verify_candidate_click_object;

	@FindBy(xpath = "//span[contains(text(),'Previous')]")
	private WebElement previous_btn_verify_candidate_click_object;

	@FindBy(xpath = "//h6[contains(text(),'Approve')]")
	private WebElement approve_btn_verify_candidate_click_object;

	@FindBy(xpath = "//h6[contains(text(),'Reclarification')]")
	private WebElement reclarification_btn_verify_candidate_click_object;

//	 *********************offer letter detail *************************

	@FindBy(xpath = "//span[contains(text(),'Next')]")
	private WebElement next_btn_offer_letter_click_object;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private WebElement cancel_btn_offer_letter_click_object;

	@FindBy(xpath = "//span[contains(text(),'Send Offer Letter')]")
	private WebElement send_offer_btn_offer_letter_click_object;

	@FindBy(xpath = "//span[contains(text(),'Update')]")
	private WebElement update_btn_letter_click_object;

	@FindBy(xpath = "//span[contains(text(),'Preview Offer Letter')]")
	private WebElement preview_offer_btn_offer_letter_click_object;

	@FindBy(xpath = "//span[contains(text(),'Previous')]")
	private WebElement previous_btn_offer_letter_click_object;

	@FindBy(xpath = "//span[contains(text(),\"Attach\")]")
	private WebElement attach_document_offer_letter_object;

	@FindBy(xpath = "//p[contains(text(),'Offer Letter')]")
	private WebElement offer_letter_select_object;

	@FindBy(xpath = "(//div[contains(@class,\"flex-between-center wh-100 css-1a8w37c\")])[2]")
	private WebElement offer_letter_dropdownElement_object;

//	****************************LOI******************************
	@FindBy(xpath = "//span[contains(text(),'Send Letter of Intent')]")
	private WebElement send_loi_btn_object;

	@FindBy(xpath = "//span[contains(text(),'Cancel')]")
	private WebElement cancel_btn_click_object;

	@FindBy(xpath = "//p[contains(text(),'Application acknowledgment')]")
	private WebElement Application_Acknowledge_click_object;

	@FindBy(xpath = "(//div[contains(@class,\"flex-between-center wh-100 css-1a8w37c\")])[2]")
	private WebElement loi_letter_dropdownElement_object;

//*****************************joinee ctc***************************

	@FindBy(xpath = "//input[contains(@name,\"CTC\")]")
	private WebElement candidate_ctc;

	@FindBy(xpath = "//input[contains(@name,\"sal_structure\")]")
	private List<WebElement> joinee_ctc_salary_structure_object;

	@FindBy(xpath = "//input[contains(@name,\"incentive_plans\")]")
	private List<WebElement> joinee_ctc_incentive_object;

	@FindBy(xpath = "//input[contains(@name,\"ot_plans\")]")
	private WebElement joinee_ctc_overtime_plan;

	@FindBy(xpath = "//input[contains(@name,\"flexi_plans\")]")
	private WebElement joinee_ctc_flexible_plan;

	@FindBy(xpath = "//input[contains(@name,\"bonus_plans\")]")
	private WebElement joinee_ctc_bonus_plan;

	@FindBy(xpath = "//input[contains(@name,\"applible_date_list\")]")
	private WebElement joinee_ctc_date;

	@FindBy(xpath = "//input[contains(@name,\"esic_months\")]")
	private WebElement joinee_ctc_esc;

	@FindBy(xpath = "//span[contains(text(),'Compute')]")
	private WebElement compute_btn_click;

	@FindBy(xpath = "//span[contains(text(),\"Save\")]")
	private WebElement save_btn_click;

//-----------------------------  sucess message-----------------

	@FindBy(xpath = "//div[contains(text(),\"Welcome mail sent successfully\")][1]")
	private WebElement Welcome_mail_sent_successfully;

	@FindBy(xpath = "//div[contains(text(),\"Management approval request has been sent successfully.\")]")
	private WebElement Management_approval_request_has_been_sent_successfully;

	@FindBy(xpath = "//div[contains(text(),\"Joinee form sent successfully.\")]")
	private WebElement Joinee_form_sent_successfully;

	@FindBy(xpath = "//div[contains(text(),\"Candidate status updated successfully.\")]")
	private WebElement Candidate_status_updated_successfully;

	@FindBy(xpath = "//div[contains(text(),\"Offer letter released\")]")
	private WebElement Offer_letter_sucess_mess_object;

	@FindBy(xpath = "//div[contains(text(),\"Acknowledge letter released\")]")
	private WebElement Acknowledge_letter_sucess_mess_object;

	@FindBy(xpath = "//div[contains(text(),\"Login credentials sent successfully\")]")
	private WebElement Login_credentials_sent_successfully;

	@FindBy(xpath = "//div[contains(text(),\"CTC approval request sent successfully\")]")
	private WebElement ctc_approval_sucess_message_objectElement;

//---------------------------------------------------------------------
//-----------------------------	Action Repository----------------------------------------

//	public void onboarding_overview_click() throws IOException, InterruptedException  {
//		Url_screenshot_Quit screenshot = new Url_screenshot_Quit();
////		screenshot.screenshot("top");
//
////		JavascriptExecutor js = (JavascriptExecutor) driver;
//		
//	}

	public void candidate_workflow_DD_button_click() {
		Workflow_dropdown_arrow_btn_click_object.click();
	}

	public void onboarding_candidate_click() {
		candidate_object.click();
	}

	public void candidate_workflow_click() {
		Workflow_select_dropdown_object.click();
	}

	public void create_new_click() {
		create_new_click_object.click();
	}

	public void Add_manually_DD_click() {
		Add_manually_click_object.click();
		String Submit = submit_btn_object.get(0).getText();
		System.out.println("Candidate Joinee form Display");
		Assert.assertEquals(Submit, "Submit");
	}

	public void submit_btn_click() throws InterruptedException {
		if (submit_btn_object.size() > 0) {
			submit_btn_object.get(0).click();
			String Create_New = create_new_click_object.getText();
			System.out.println("Candidate create Sucessfully");
			Assert.assertEquals(Create_New, "Create New");
			submit_btn_click();
		}
	}


	public void Intitate_btn_mutiple_time_click(String cid_id) {
		String fullpath = String.format(intitate_button_click, cid_id);
		driver.findElement(By.xpath(fullpath)).click();

	}

////****************** common list click on Three dot on candidate**************//////////////////

	public void Three_dot_view_candidate_click() {
		View_candidate_click_object.click();
	}

	public void Three_dot_edit_candidate_click() {
		Edit_candidate_click_object.click();
	}

	public void Three_dot_withdraw_candidate_click() {
		Withdraw_candidate_click_object.click();
	}

	public void Three_dot_Blacklist_candidate_click() {
		Blacklist_candidate_click_object.click();
	}

	public void Three_dot_move_to_next_step_candidate_click() {
		move_to_next_stage_candidate_click_object.click();
	}

	public void Three_dot_move_to_prevoius_step_click() {
		move_to_previous_candidate_click_object.click();
	}

////*************** start click on Three dot on bucket list**************//////////////////

	public void welcome_mail_Three_Dot_send_candidate(String cid_id) {
		String fullXpath = String.format(cidwelcome, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void management_Bucket_Three_dot_send_candidate(String cid_id) {
		String fullXpath = String.format(cidmanagement, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void candidate_joinee_Three_dot_send_candidate(String cid_id) {
		String fullXpath = String.format(cidcandidatejoineeform, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void verify_candidate_Three_dot_click(String cid_id) {
		String fullXpath = String.format(cidverifycandidatedetail, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void Adhaar_verification_Three_Dot_click(String cid_id) {
		String fullXpath = String.format(cidaadharverify, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void Add_candidate_CTC_Three_Dot_click(String cid_id) {
		String fullXpath = String.format(cidaddcandidatectc, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void Ctc_approval_Three_Dot_send_candidate(String cid_id) {
		String fullXpath = String.format(cidctcapproval, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void Offer_letter_Three_Dot_send_candidate(String cid_id) {
		String fullXpath = String.format(cidofferletter, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void LOI_Three_Dot_click_send_canditate(String cid_id) {
		String fullXpath = String.format(cidloi, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void Convert_To_Employee_Three_Dot_click(String cid_id) {
		String fullXpath = String.format(cidconvertemployees, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void Employee_Credential_Three_Dot_click(String cid_id) {
		String fullXpath = String.format(cidemployeecredential, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void Transfer_Document_Three_Dot_click(String cid_id) {
		String fullXpath = String.format(cidtransferdocument, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void Appointment_letter_Three_Dot_click(String cid_id) {
		String fullXpath = String.format(cidappointmentletter, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void Background_verification_Three_Dot_click(String cid_id) {
		String fullXpath = String.format(cidbackgroundverification, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

	public void Request_Asset_Three_Dot_click(String cid_id) {
		String fullXpath = String.format(cidrequestasset, cid_id);
		driver.findElement(By.xpath(fullXpath)).click();
	}

////*************** start click of  bucket list**************//////////////////

	public void welcome_email_Bucket_send_candidate() throws InterruptedException {
		welcome_candidate_click_object.click();
//		soft assert used
		String result = Welcome_mail_sent_successfully.getText();
		String actual = StringUtils.normalizeSpace(result);
		ao = new AssertObject_Dropdown(driver);
		ao.assertobject(actual, "Success Welcome mail sent successfully");
	}

	public void management_Bucket_send_candidate() throws InterruptedException {
		management_approval_click_object.click();
//		soft assert used
		String result = Management_approval_request_has_been_sent_successfully.getText();
		String actual = StringUtils.normalizeSpace(result);
		ao = new AssertObject_Dropdown(driver);
		ao.assertobject(actual, "Success Management approval request has been sent successfully.");
	}

	public void Candidate_joinee_send_candidate() throws InterruptedException {
		candidate_joinee_click_object.click();
//		soft assert used
		String result = Joinee_form_sent_successfully.getText();
		String actual = StringUtils.normalizeSpace(result);
		ao = new AssertObject_Dropdown(driver);
		ao.assertobject(actual, "Success Joinee form sent successfully.");

	}

	public void Verify_candidate_send_candidate() {
		Verify_candidate_detail_click_object.click();
	}

	public void Adhaar_verification_send_candidate() {
		Aadhar_verfication_click_object.click();
	}

	public void Ctc_Approval_send_candidate() {
		ctc_approval__click_object.click();
//		soft assert used
		String result = ctc_approval_sucess_message_objectElement.getText();
		String actual = StringUtils.normalizeSpace(result);
		ao = new AssertObject_Dropdown(driver);
		ao.assertobject(actual, "Success CTC approval request sent successfully");
	}

	public void Add_candidate_Ctc_click() {
		Add_candidate_CTC_click_object.click();
	}

	public void Offer_letter_send_candidate() {
		Offer_letter_click_object.click();
	}

	public void Loi_send_candidate() {
		LOI_click_object.click();
	}

	public void convert_to_Employees_send_candidate() {
		convert_to_employees_click_object.click();
	}

	public void Employee_credential_send_candidate() {
		Employee_credential_click_object.click();
//		soft assert used
		String result = Login_credentials_sent_successfully.getText();
		String actual = StringUtils.normalizeSpace(result);
		ao = new AssertObject_Dropdown(driver);
		ao.assertobject(actual, "Success Login credentials sent successfully");

	}

////*************** start click of  candidate profile **************//////////////////

	public void candidate_profile_document() throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
				candidate_profile_Document_object);
		Thread.sleep(3000);
		Actions action = new Actions(driver);
		action.moveToElement(candidate_profile_Document_object).click().perform();
		Thread.sleep(3000);
		driver.navigate().back();
//		driver.navigate().refresh();
	}

	public void get_candidate_email_address() throws InterruptedException {
		Thread.sleep(3000);
		System.out.println("Candidate Name  ----->  " + get_candidate_name_object.getText());
		Thread.sleep(3000);
		System.out.println("On This Email Address User Get Email----->  " + get_candidate_email_object.getText());
		OnBoardingPage profile = new OnBoardingPage(driver);
		profile.candidate_profile_document();
	}

//	*************************verify candidate detail*********************************

	public void verify_candidate_detail() throws InterruptedException, IOException {
		if (Procces_btn_verify_candidate_click_object.size() > 0) {
			Thread.sleep(3000);
			Procces_btn_verify_candidate_click_object.get(0).click();
			verify_candidate_detail();
		}

		else if (approve_btn_verify_candidate_click_object.isDisplayed()) {

			fh = new ExcelFileHandler();
// approve verify candidate detail
			int process_btn_click = fh.readDataint(2, 8, 4);
			verify_candidate_detail_btn_detail(process_btn_click);
//        		soft assert used
			String result = Candidate_status_updated_successfully.getText();
			String actual = StringUtils.normalizeSpace(result);
			ao = new AssertObject_Dropdown(driver);
			ao.assertobject(actual, "Success Candidate status updated successfully.");
		}

		else {
			int process_btn_click = fh.readDataint(2, 8, 4);
			verify_candidate_detail_btn_detail(process_btn_click);
		}

	}

	public void verify_candidate_detail_btn_detail(int process_btn_click) throws InterruptedException {
		switch (process_btn_click) {
		case 1:
			approve_btn_verify_candidate_click_object.click();
			break;

		case 2:
			reclarification_btn_verify_candidate_click_object.click();
			break;
		default:
		}
	}

//  **********************************offer letter**********************

	public void offer_letter_page_action() throws InterruptedException, IOException {

		int offer_letter_stage = 1;
		ExcelFileHandler efh = new ExcelFileHandler();

		String loi_letter_dropdownElement_object = efh.readData(2, 0, 4);
		offer_letter_dropdownElement_object.click();
		ao = new AssertObject_Dropdown(driver);

//    	EXCEL FILE READ DROPDOWN data "offer letter name select"
		String offer_letter_DD = efh.readData(2, 1, 4);
		ao.getlistdropdown(offer_letter_DD);

		if (loi_letter_dropdownElement_object.equalsIgnoreCase("send")) {
			Thread.sleep(3000);
			offer_letter_action_switch(efh.readDataint(2, 2, 4));
//		soft asset used 
			String result = Offer_letter_sucess_mess_object.getText();
			String actual = StringUtils.normalizeSpace(result);
			ao = new AssertObject_Dropdown(driver);
			ao.assertobject(actual, "Success Offer letter released");
		}

		else {
			Thread.sleep(3000);
			offer_letter_action_switch(efh.readDataint(2, 3, 4));
		}
	}

	public void offer_letter_action_switch(int offer_letter_stage) throws InterruptedException, IOException {
		try {
			switch (offer_letter_stage) {

			case 1: {
				next_btn_offer_letter_click_object.click();
			}
				break;
			case 2: {
				cancel_btn_offer_letter_click_object.click();
			}
				break;
			case 3: {
				send_offer_btn_offer_letter_click_object.click();
			}
				break;
			case 5: {
				update_btn_letter_click_object.click();
			}
				break;
			case 4: {
				preview_offer_btn_offer_letter_click_object.click();
			}
				break;
			case 7: {
				attach_document_offer_letter_object.click();
			}
				break;
			case 8: {
				offer_letter_select_object.click();
			}
				break;
			default:

			}

		} catch (NoSuchElementException e) {
			offer_letter_page_action();
		}

	}

//******************************LOI****************

	public void Loi_page_action() throws IOException, InterruptedException {
		int Loi_action = 0;
		ExcelFileHandler efh = new ExcelFileHandler();

		String LOI_letter_action = efh.readData(2, 0, 7);
		loi_letter_dropdownElement_object.click();
		ao = new AssertObject_Dropdown(driver);

//    	EXCEL FILE READ DROPDOWN data "loi letter name select"
		String loi_letter_DD = efh.readData(2, 1, 7);
		ao.getlistdropdown(loi_letter_DD);

		if (LOI_letter_action.equalsIgnoreCase("send")) {
			Thread.sleep(3000);
			Loi_page_action_switch(efh.readDataint(2, 2, 7));
//    		soft assert used
			String result = Acknowledge_letter_sucess_mess_object.getText();
			String actual = StringUtils.normalizeSpace(result);
			ao = new AssertObject_Dropdown(driver);
			ao.assertobject(actual, "Success Acknowledge letter released");
		} else {
			Thread.sleep(3000);
			Loi_page_action_switch(efh.readDataint(2, 3, 7));
		}
	}

	public void Loi_page_action_switch(int Loi_action) {
		switch (Loi_action) {
		case 1: {
			send_loi_btn_object.click();
		}
			break;
		case 2: {
			cancel_btn_click_object.click();
		}
			break;
		default:
		}
	}

//   	joinee ctc

	public void joinee_ctc() throws InterruptedException, IOException {
		fh = new ExcelFileHandler();
		candidate_ctc.sendKeys(fh.readData(1, 1, 3));

		boolean ctc = joinee_ctc_salary_structure_object.size() > 0;
		if (ctc = true) {
			System.out.println("g");
			joinee_ctc_salary_structure_object.get(0).sendKeys(fh.readData(1, 2, 3));
		}

		boolean incentive = joinee_ctc_incentive_object.size() > 0;
		if (incentive = true) {
			System.out.println("hh");
			joinee_ctc_incentive_object.get(0).sendKeys(fh.readData(1, 3, 3));
			joinee_ctc_overtime_plan.sendKeys(fh.readData(1, 4, 3));
			joinee_ctc_flexible_plan.sendKeys(fh.readData(1, 5, 3));
			joinee_ctc_bonus_plan.sendKeys(fh.readData(1, 6, 3));
			joinee_ctc_esc.sendKeys(fh.readData(1, 7, 3));
		}
		joinee_ctc_date.sendKeys(fh.readData(1, 8, 3));

		Thread.sleep(1000);
		compute_btn_click.click();
		Thread.sleep(1000);
		int i = 1;
		for (i = 1; i <= 2; i++) {
			Thread.sleep(1000);
			save_btn_click.click();
			System.out.println(i);
		}
	}

}
