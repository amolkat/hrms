package com.HRMS.Testbase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.HRMS.Pagelayer.Loginpage;
import com.HRMS.Utilities.ExcelFileHandler;
import com.HRMS.Utilities.Switch;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Url_screenshot_Quit {

	public WebDriver driver;
	public WebDriver incognitoDriver;
	public Switch switchobject;

	@BeforeMethod
	public void action_url() throws InterruptedException, IOException {

		ExcelFileHandler fh = new ExcelFileHandler();

		// Getting Browser
		String browserName = fh.readData(0, 0, 1);

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.http.factory", "jdk-http-client");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else {
			System.out.println("Please provide correct browser name");
			return;
		}

		// Going to the URL
		driver.get(fh.readData(0, 1, 1));

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

		Loginpage login_obj = new Loginpage(driver);

		// Entering Login Details
		login_obj.username_txtbox(fh.readData(0, 2, 1));
		login_obj.password_txtbox(fh.readData(0, 3, 1));
		login_obj.Login_btn_click();
		login_obj.Sucessfully_mess_get_text();

	}

	public String screenshot(String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\automation screenshot\\" + filename + ".png");
		FileUtils.copyFile(src, des);
		return filename;

	}

	@AfterMethod
	public void quit() throws InterruptedException {
		Thread.sleep(9000);
		driver.close();
		driver.quit();
	}

}