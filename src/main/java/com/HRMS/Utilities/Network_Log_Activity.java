package com.HRMS.Utilities;

import java.util.Optional;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v107.network.Network;
import org.openqa.selenium.devtools.v107.network.model.Request;

import com.github.dockerjava.api.model.Driver;

import net.bytebuddy.build.Plugin.Engine.Source.Empty;

public class Network_Log_Activity {

	private WebDriver driver;

	public Network_Log_Activity(WebDriver driver) {
		this.driver = driver;
	}

	public void extract_response() {
		
		
		// Get Dev Tools
		DevTools devTools = ((ChromeDriver) driver).getDevTools();

		// Create Session
		devTools.clearListeners();

       //  Enables network tracking, network events will now be delivered to the client.
     	devTools.send(Network.enable(
     			Optional.empty(),
     			Optional.empty(),
     			Optional.empty())
     			);
     	
     	devTools.addListener(Network.requestWillBeSent(),
     			request -> {
     				System.out.println("request URL : " + request.getRequest().getUrl());
     				System.out.println("request Method :" + request.getRequest().getMethod());
     			});
     	
		// Event will get fired
		devTools.addListener(Network.responseReceived(), response -> {
			response.getResponse().getStatus()	
			
		}

	}
}