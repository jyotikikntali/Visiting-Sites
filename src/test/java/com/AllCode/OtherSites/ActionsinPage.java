package com.AllCode.OtherSites;


	

	import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
	import java.awt.event.KeyEvent;
	import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
	import java.util.List;

	import javax.net.ssl.SSLHandshakeException;

	import org.jsoup.Jsoup;
	import org.jsoup.nodes.Document;
	import org.jsoup.nodes.Element;

	public class ActionsinPage extends BrowserSelection {
		int count;
		//int count=1;
		public   void ScrollForRandomTime(int Stime) throws AWTException {
			Robot r1=new Robot();
			long startTime = System.currentTimeMillis();
		    long endTime =  (startTime + (Stime * 1000));
			 

			    while (System.currentTimeMillis() < endTime) {
			        r1.keyPress(KeyEvent.VK_DOWN);
			        r1.keyRelease(KeyEvent.VK_DOWN);
			        sleep(1);
			        r1.keyPress(KeyEvent.VK_DOWN);
			        r1.keyRelease(KeyEvent.VK_DOWN);
			       
			        }
			  
		}
		public void sleep(int timeInSeconds) {
			try {
				Thread.sleep(timeInSeconds * 1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		 public  void FalseClickInBase(String SearchUrl,  List<String> urls, String browser, int Stime) throws Exception {
				//System.out.println("Entered into False Click Method");
			 count=1;
			 sleep(2);
		    		
		    		ScrollForRandomTime(Stime);
		    		System.out.println("Page is scrolling");
				
					System.out.println("Checking blocks");
				 
				 try {
					 Robot robot = new Robot();
						Document PageData=Jsoup.connect(SearchUrl).get();
						Element Reqdata=PageData.getElementsByAttributeValue("class", "chapternav-label05").first();
						System.out.println(Reqdata);
						 System.out.println("Entered into try block of base page");
					 System.out.println("Entered into try block of base page");
				if(Reqdata!=null) {
	      robot.keyPress(KeyEvent.VK_ENTER);
				      robot.keyRelease(KeyEvent.VK_ENTER);
				      
				     }
				else {
					System.out.println("Clicking Action can't happen as no element found");
				}}
				  catch(Exception e ){
					  System.out.println("Entered into catch block of base");
					 
					 }
				 for(String url:urls) {
					  FalseClickInRef(url,browser, Stime);
				  }
				  
		    	}
		    	
		    	
		 public  void FalseClickInRef(String url,String browser, int Stime) throws AWTException, IOException, InterruptedException, URISyntaxException {
			sleep(2);
				
				
				System.out.println("Page is scrolling");
				
				 if(url!=null) {
			browserSelectiontoOpenUrl(browser,url);}
			ScrollForRandomTime(Stime);
				
			
				try{
					Robot robot = new Robot();
			count++;
			System.out.println("Count is:"+count);
				Document PageData=Jsoup.connect(url).get();
 Element Reqdata=PageData.getElementsByAttributeValue("class", "chapternav-label05").first();

				System.out.println(Reqdata);
				if(Reqdata!=null) {
					
				      robot.keyPress(KeyEvent.VK_ENTER);
				      robot.keyRelease(KeyEvent.VK_ENTER);
				      System.out.println("Entered try block of ref page");
				  }}
				catch(Exception e) {
					System.out.println("Entered into catch block of ref");
					//e.printStackTrace();
					
				}}
			
	}
	


