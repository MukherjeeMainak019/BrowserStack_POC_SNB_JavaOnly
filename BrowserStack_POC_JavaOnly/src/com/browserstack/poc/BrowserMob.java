package com.browserstack.poc;
import io.netty.handler.codec.http.HttpRequest;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.filters.RequestFilter;
import net.lightbody.bmp.filters.ResponseFilter;
import net.lightbody.bmp.util.HttpMessageContents;
import net.lightbody.bmp.util.HttpMessageInfo;
import io.netty.handler.codec.http.HttpResponse;

public class BrowserMob {

	static BrowserMobProxyServer proxyServer;
	static String accessToken;
	static HttpResponse httpResponse;
	static HttpMessageContents httpMessageContents;
	static HttpMessageInfo httpMessageInfo;

	public static void StartProxy()
	{
		proxyServer = new BrowserMobProxyServer();

		proxyServer.start(8888);

		proxyServer.addRequestFilter(new RequestFilter()
		{
			@Override
			public HttpResponse filterRequest(HttpRequest httpRequest, HttpMessageContents httpMessageContents, HttpMessageInfo httpMessageInfo) {
				//System.out.println("URL:" + httpMessageInfo.getOriginalUrl());
				//System.out.println("REQUEST CONTENT:" + httpMessageContents.getTextContents());
				return null;
			}
		});

		proxyServer.addResponseFilter(new ResponseFilter()
		{
			public void filterResponse(HttpResponse httpResponse, HttpMessageContents httpMessageContents, HttpMessageInfo httpMessageInfo) {
				//System.out.println("RESPONSE STATUAS:" + httpResponse.getStatus());
				//System.out.println("RESPONSE CONTENT:" + httpMessageContents.getTextContents());

				// this gives us all the URLs and endpoints after each operation
//				System.out.println("getOriginalURL " + httpMessageInfo.getOriginalUrl()); 

				if(httpMessageInfo.getOriginalUrl().endsWith("api/token"))
				{
					System.out.println(".....Inside 1st IF.....");
					System.out.println("RESPONSE CONTENT:" + httpMessageContents.getTextContents());
					String[] responseContent = httpMessageContents.getTextContents().split("_token\":\"");
					String token[] = responseContent[1].split("\",\"token");
					accessToken = token[0];
					System.out.println(".....Access Token is " + accessToken);
				}
			}
		});

//		proxyServer.addResponseFilter(new ResponseFilter()
//		{
//			public void filterResponse(HttpResponse httpResponse, HttpMessageContents httpMessageContents, HttpMessageInfo httpMessageInfo) {
//
//				if(httpMessageInfo.getOriginalUrl().endsWith("/runs/latest/meta.json"))
//				{
//					System.out.println(".....Inside 2nd IF");
//					System.out.println("RESPONSE CONTENT:" + httpMessageContents.getTextContents());
//				}
//			}
//		});
//
	}




	public static void StopProxy()
	{
		proxyServer.stop();
	}
}
