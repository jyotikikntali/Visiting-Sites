package com.AllCode.OtherSites;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SearchClearClose  extends ActionsinPage{
	
	public  void OpenNewLink(String SearchUrl,String link,String browser,int Stime, List<String> urls) throws IOException, URISyntaxException, InterruptedException, AWTException {
		try {
		Robot r1=new Robot();
		browserSelectiontoOpenUrl(browser,link);
		System.out.println("in openlink");
		System.out.println(browser);
		/*Desktop.isDesktopSupported();

	      Desktop.getDesktop().browse(new URI(link));}*/
	        Thread.sleep(5000);
	        	Thread.sleep(1000);
	        	//ScrollForRandomTime(Stime);
	        	 FalseClickInBase(SearchUrl, urls, browser, Stime);
	        	  
	}
		catch(Exception e) {e.printStackTrace();
			System.out.println("OpenNewLink method couldn't get executed");
		}
		
	}
	public  void PassValueToSearchBox( String SerachKeyword,String SearchUrl,String browser,int Stime, List<String> urls) throws AWTException, InterruptedException, IOException {
		try {
				        System.out.println("Parsing the page");
Document searchPageDoc = Jsoup.connect("https://www.google.com/search?q=" + SerachKeyword).get();
		 Elements searchResults = searchPageDoc.select("div.g");
				       

				        for (Element result : searchResults) {
				            Element titleElement = result.selectFirst("h3");
				            Element linkElement = result.selectFirst("a");

				            if (titleElement != null && linkElement != null) {
				                String title = titleElement.text();
				                String link = linkElement.attr("href");
				                sleep(1);
				               // System.out.println(link);
				               // System.out.println(SearchUrl);
				               if (link.equalsIgnoreCase(SearchUrl)) {
				            	   System.out.println(link);
					                System.out.println(SearchUrl);
				                    OpenNewLink(SearchUrl,link,browser, Stime,urls);
				                   // FalseClickInBase(SearchUrl,null, browser,Stime);
				                    		                    break;
				                } else {
				                    System.out.println("Couldnt find matched link");
				                }
				            }

				        }}     catch(Exception e) {
				        	e.printStackTrace();
				        	System.out.println("error in executeTest method");
				        


			}
			}
			 public void  ClearCookiesAndCache() throws AWTException, InterruptedException {
				 //int count;
			 
			    	try {
					System.out.println("it will clear the cookies and cache of the browser");
					sleep(1);
					Robot r1=new Robot();
			    	r1.keyPress(KeyEvent.VK_CONTROL);
			    	r1.keyPress(KeyEvent.VK_SHIFT);
			    	r1.keyPress(KeyEvent.VK_DELETE);
			    	r1.keyRelease(KeyEvent.VK_CONTROL);
			    	r1.keyRelease(KeyEvent.VK_SHIFT);
			    	r1.keyRelease(KeyEvent.VK_DELETE);
			    	sleep(2);
			    	r1.keyPress(KeyEvent.VK_ENTER);
			    	r1.keyRelease(KeyEvent.VK_ENTER);
			    	sleep(1);
			    	count=1;
			    	while(count>=0) {
			    		System.out.println(count);
			    	r1.keyPress(KeyEvent.VK_CONTROL);
					r1.keyPress(KeyEvent.VK_W);
				    r1.keyRelease(KeyEvent.VK_CONTROL);
				    r1.keyRelease(KeyEvent.VK_W);
				  sleep(1);
				    count--;}
			    	System.out.println("cleared Cookies and cache");}
			    	catch(Exception e) {
			    		e.printStackTrace();
			    		System.out.println("ClearCookiesAndCache Method got failed");
			    	}
			    		
			    	}
			 
			 public void ClosingBrowserPages() throws AWTException {
				 System.out.println("Count in ClosingBrowserPages is:"+count);
					try {
					System.out.println("All opened tabs will be closed now");
					//Robot r2=new Robot();
					Robot r=new Robot();
					System.out.println(count);
					while(count>0) {
					System.out.println(count);
					r.keyPress(KeyEvent.VK_CONTROL);
					r.keyPress(KeyEvent.VK_W);
				    r.keyRelease(KeyEvent.VK_CONTROL);
				    r.keyRelease(KeyEvent.VK_W);
				   sleep(1);
				    count--;
				    sleep(1);
				    
				    
					System.out.println("Closing ");
					
					// TODO Auto-generated method stub
					}
					
					}
					catch(Exception e) {
						System.out.println("ClosingBrowserPages method got failed");
						e.printStackTrace();
						
						
					}
				}
			 public void NetworkReset() throws IOException, InterruptedException {
				 String ScriptPath="src\\test\\resources\\NetworkReset.ps1";
				 String command = "powershell.exe -ExecutionPolicy Bypass -File \"" + ScriptPath + "\"";
			        Process process = Runtime.getRuntime().exec(command);
			        process.waitFor();
			        System.out.println("Network Reset is done");
			 }
			    	
			


}
