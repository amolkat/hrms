package com.HRMS.Testlayer;

import org.testng.annotations.Test;

import com.HRMS.Pagelayer.Asset;
import com.HRMS.Testbase.Main_Module;
import com.HRMS.Testbase.Sub_module;
import com.HRMS.Testbase.Url_screenshot_Quit;

public class Asset_Test extends Url_screenshot_Quit {
	
	private  Main_Module Main_Module_object;
	private Sub_module Sub_module_object;
	private Asset Asset_object;

	@Test
	public void asset()  {
		Main_Module_object = new  Main_Module(driver);
		Main_Module_object.organisation_module();
		
		Sub_module_object = new Sub_module(driver);
		Sub_module_object.submodule_asset_click();
		
//		category add
		Asset_object = new Asset(driver);
		Asset_object.asset_category_type_click();
		Asset_object.add_category_click();
		Asset_object.submit_btn_click();
		
	}
}
