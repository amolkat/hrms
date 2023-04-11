package com.HRMS.Testlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HRMS.Pagelayer.OnBoardingPage;
import com.HRMS.Testbase.Main_Module;
import com.HRMS.Testbase.Sub_module;
import com.HRMS.Testbase.Url_screenshot_Quit;
import com.HRMS.Utilities.ExcelFileHandler;
import com.HRMS.Utilities.IncognitoDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.Network.GetResponseBodyResponse;
import org.openqa.selenium.devtools.v107.network.model.Request;
import org.openqa.selenium.devtools.v107.network.model.RequestId;
import org.openqa.selenium.devtools.v107.network.model.Response;
import org.openqa.selenium.devtools.v107.network.model.Headers;
import org.openqa.selenium.devtools.Command;

import form_library_testlayer.Candidate_Creation_Testcase;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import io.restassured.response.ResponseBody;

public class Onboarding_Test extends Url_screenshot_Quit {

	public OnBoardingPage onboarding;
	public Candidate_Creation_Testcase Candidate_Detail_fill;
	public int i;
	private Url_screenshot_Quit url_screenshot_Quit_object;
	private IncognitoDriver IncognitoDriver_object;

	@Test
	public void Onboarding() throws InterruptedException, IOException {
		try {
			Main_Module Organisation = new Main_Module(driver);
			Organisation.organisation_module();

			Thread.sleep(3000);

			Sub_module submodule_Onboarding = new Sub_module(driver);
			submodule_Onboarding.submodule_onboarding_click();

			Thread.sleep(3000);

			onboarding = new OnBoardingPage(driver);

			onboarding.onboarding_candidate_click();

			Thread.sleep(3000);
			onboarding.candidate_workflow_DD_button_click();
			onboarding.candidate_workflow_click();

			Thread.sleep(3000);

			onboarding.create_new_click();
			onboarding.Add_manually_DD_click();

			// Creating new candidate
			Candidate_Detail_fill = new Candidate_Creation_Testcase(driver);
			Candidate_Detail_fill.Candidate_creation();

			Thread.sleep(3000);

			System.out.println("Response ---");

			DevTools devTools = ((ChromeDriver) driver).getDevTools();
			devTools.createSession();
			devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

			// Event will get fired
			devTools.addListener(Network.responseReceived(), response -> {
				Response res = response.getResponse();
				System.out.println("Res-" + res.getStatusText() + " " + res.getResponseTime());
				System.out.println(res.getUrl());
//				String responseBody = devTools.send(Network.getResponseBody(null)).getBody();
//				System.out.println("Response Body -> " + responseBody);
				if (res.getUrl().equals("https://admin.zimyo.com/apiv2/onbording/add-joinee-save")) {
					System.out.println("Response Inside ---");
					System.out.println(res.getUrl());
					System.out.println(res.getStatus());
				}
			});

			// Clicking Submit button
			onboarding.submit_btn_click();

			ExcelFileHandler excelData = new ExcelFileHandler();
			int sheet = 1;
			int row = 1;
			int cellNum = 3;
			String cid_id = excelData.readData(sheet, row, cellNum);
			System.out.println("Cid Found " + cid_id);

			String sheetNameString = "2 onboarding";
			sheet = 2;
			row = 0;
			int colNum = 1;
			String[] steps = excelData.readColumnData(sheetNameString, sheet, row, colNum);

			// print the array values
			for (String step : steps) {
				System.out.println("Step Number - " + step);
				int num = Integer.parseInt(step);

				this.sendToStep(num, cid_id);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			int a = 0;
			int b = 2;
			System.out.println(b / a);
		}
	}

//		System.out.println("Send Welcome  Mail           : Press 1");
//		System.out.println("Send Management Approval     : Press 2");
//		System.out.println("Send Candidate Joinee Form   : Press 3");
//		System.out.println("Send Verify Candidate Detail : Press 4");
//		System.out.println("Send Aadhaar Verification    : Press 5");
//		System.out.println("Send CTC Approval            : Press 6");
//		System.out.println("Send Add Candidate CTC       : Press 7");
//		System.out.println("Send Offer Letter            : Press 8");
//		System.out.println("Send LOI                     : Press 9");
//		System.out.println("Send Convert to Employee     : Press 10");
//		System.out.println("Send Employee Credentials    : Press 11");
//		System.out.println("Send Transfer Document       : Press 2");
//		System.out.println("Send Appointment Letter      : Press 2");
//		System.out.println("Send Background Verification : Press 2");
//		System.out.println("Send Request Assets          : Press 2");

	public void sendToStep(int step, String cid_id) throws InterruptedException, IOException {

		System.out.println("Step -->" + step);
		System.out.println("CID -->" + cid_id);
		switch (step) {
		case 1: {
//		onboarding.welcome_mail_Three_Dot_send_candidate(cid_id);
//		onboarding.Three_dot_view_candidate_click();
//		onboarding.get_candidate_email_address();
			onboarding.welcome_mail_Three_Dot_send_candidate(cid_id);
			onboarding.welcome_email_Bucket_send_candidate();

		}
			break;
		case 2: {
//		onboarding.management_Bucket_Three_dot_send_candidate(cid_id);
//		onboarding.Three_dot_view_candidate_click();
//		onboarding.get_candidate_email_address();
			onboarding.management_Bucket_Three_dot_send_candidate(cid_id);
			onboarding.management_Bucket_send_candidate();

		}
			break;
		case 3: {
//		onboarding.candidate_joinee_Three_dot_send_candidate(cid_id);
//		onboarding.Three_dot_view_candidate_click();
//		onboarding.get_candidate_email_address();
			onboarding.candidate_joinee_Three_dot_send_candidate(cid_id);
			onboarding.Candidate_joinee_send_candidate();

		}
			break;
		case 4: {
//		onboarding.verify_candidate_Three_dot_click(cid_id);
//		onboarding.Three_dot_view_candidate_click();
//		onboarding.get_candidate_email_address();
			onboarding.verify_candidate_Three_dot_click(cid_id);
			onboarding.Verify_candidate_send_candidate();
			onboarding.verify_candidate_detail();
		}
			break;
		case 5: {
//		onboarding.Adhaar_verification_Three_Dot_click(cid_id);
//        onboarding.Three_dot_view_candidate_click();
//		onboarding.get_candidate_email_address();
			onboarding.Adhaar_verification_Three_Dot_click(cid_id);
			onboarding.Three_dot_move_to_next_step_candidate_click();
		}
			break;
		case 6: {
//		onboarding.Ctc_approval_Three_Dot_send_candidate(cid_id);
//        onboarding.Three_dot_view_candidate_click();
//		onboarding.get_candidate_email_address();
			onboarding.Ctc_approval_Three_Dot_send_candidate(cid_id);
			onboarding.Ctc_Approval_send_candidate();

			IncognitoDriver_object = new IncognitoDriver();
			IncognitoDriver_object.approval_url();
			IncognitoDriver_object.ctc_approval();
		}
			break;
		case 7: {
//		onboarding.Add_candidate_CTC_Three_Dot_click(cid_id);
//        onboarding.Three_dot_view_candidate_click();
//		onboarding.get_candidate_email_address();
			onboarding.Add_candidate_CTC_Three_Dot_click(cid_id);
			Thread.sleep(1000);
			onboarding.Add_candidate_Ctc_click();
			onboarding.joinee_ctc();
		}
			break;
		case 8: {
//		onboarding.Offer_letter_Three_Dot_send_candidate(cid_id);
//        onboarding.Three_dot_view_candidate_click();
//		onboarding.get_candidate_email_address();
			onboarding.Offer_letter_Three_Dot_send_candidate(cid_id);
			onboarding.Offer_letter_send_candidate();
			onboarding.offer_letter_page_action();
		}
			break;
		case 9: {
//		onboarding.LOI_Three_Dot_click_send_canditate(cid_id);
//        onboarding.Three_dot_view_candidate_click();
//		onboarding.get_candidate_email_address();
			onboarding.LOI_Three_Dot_click_send_canditate(cid_id);
			onboarding.Loi_send_candidate();
			onboarding.Loi_page_action();
		}
			break;
		case 10: {
//		onboarding.Convert_To_Employee_Three_Dot_click(cid_id);
//        onboarding.Three_dot_view_candidate_click();
//		onboarding.get_candidate_email_address();
			onboarding.Convert_To_Employee_Three_Dot_click(cid_id);
			onboarding.convert_to_Employees_send_candidate();
		}
			break;
		case 11: {
//		onboarding.Employee_Credential_Three_Dot_click(cid_id);
//        onboarding.Three_dot_view_candidate_click();
//		onboarding.get_candidate_email_address();
			onboarding.Employee_Credential_Three_Dot_click(cid_id);
			onboarding.Employee_credential_send_candidate();
		}
			break;
		default:
			for (i = 1; i <= 2; i++) {
				Thread.sleep(3000);
				onboarding.Intitate_btn_mutiple_time_click(cid_id);
				System.out.println(i);
				Thread.sleep(2000);
			}

		}

	}

}
