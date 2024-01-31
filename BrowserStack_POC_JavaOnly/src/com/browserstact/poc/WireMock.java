package com.browserstact.poc;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.stubbing.ServeEvent;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

import java.util.List;



public class WireMock {
	
	
	
	public WireMockServer wireMockServer;
	
	String host = "localhost";
	int port = 8080;
	String proxyBaseUrl = "https://en.wikipedia.org";
	
	public void wireMockSetup() 
	{
//		wireMockServer = new WireMockServer(options().port(port));
		wireMockServer = new WireMockServer(options().dynamicHttpsPort());
		wireMockServer.start();
		System.out.println("WireMock server has started");
		
		
		stubFor(any(anyUrl()).willReturn(aResponse().proxiedFrom(proxyBaseUrl)));
		
		
		

	}
	
	public void allServeEvents()
	{
		
		List<ServeEvent> allServeEvents = wireMockServer.getAllServeEvents();
		System.out.println(allServeEvents);
		
	}
	
	
	public void stopServer() 
	{
		wireMockServer.stop();
		System.out.println("WireMock server has stopped");
	}

}
