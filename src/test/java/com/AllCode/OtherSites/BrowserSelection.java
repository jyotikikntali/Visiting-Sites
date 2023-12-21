package com.AllCode.OtherSites;


	

	import java.awt.Desktop;
	import java.io.IOException;
	import java.net.URI;

	public class BrowserSelection {
		public  void browserSelectiontoOpenUrl( String browser,String link) {
			try {
				  String[] command = {"cmd", "/c", "start", browser, link};

		          // Execute the command
		          Process process = new ProcessBuilder(command).start();

		          // Optionally, you can wait for the process to finish
		          int exitCode = process.waitFor();
		          System.out.println(browser+" browser opened with exit code: " + exitCode);
			} catch (IOException | InterruptedException e) {
		        e.printStackTrace();
		        openDefaultBrowser("https://www.google.com/");
		    }
		}
		/*public static void browserValue(String browser) {
			
			       // getDataFromExcelSheet("Sheet1");
				 try {
			            if (browser.equalsIgnoreCase("chrome")) {
			                openBrowserWithPowerShell("src\\test\\resources\\Chrome.ps1");
			                Thread.sleep(2000);
			            } else if (browser.equalsIgnoreCase("edge")) {
			                openBrowserWithPowerShell("src\\test\\resources\\Edge.ps1");
			                Thread.sleep(2000);
			            } else if (browser.equalsIgnoreCase("firefox")) {
			                openBrowserWithPowerShell("src\\test\\resources\\Firefox.ps1");
			                Thread.sleep(2000);
			            } else {
			                openDefaultBrowser("https://www.google.com/");
			                Thread.sleep(2000);
			            }
			        } catch (Exception e) {
			            // Opening the specified browser failed, open the default browser
			            openDefaultBrowser("https://www.google.com/");
			        }
			    }

			    private static void openBrowserWithPowerShell(String scriptPath) throws Exception {
			        String command = "powershell.exe -ExecutionPolicy Bypass -File \"" + scriptPath + "\"";
			        Process process = Runtime.getRuntime().exec(command);
			        process.waitFor();
			    }
*/
			    private static void openDefaultBrowser(String url) {
			        try {
			            URI uri = new URI(url);
			            Desktop.getDesktop().browse(uri);
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    }}
			      

	

