package com.AllCode.OtherSites;


	import org.jsoup.Jsoup;
	import org.jsoup.nodes.Document;
	import org.jsoup.select.Elements;

	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
	import java.net.URL;
	import java.io.UnsupportedEncodingException;
	import java.net.URLEncoder;

	public class Searchword {

	    public static void main(String[] args) throws IOException, InterruptedException {
	    	String scriptpath="src\\test\\resources\\Chrome.ps1";	    	;
	    	 String command = "powershell.exe -ExecutionPolicy Bypass -File \"" + scriptpath + "\"";
		        Process process = Runtime.getRuntime().exec(command);
		        process.waitFor();
	        String searchKeyword = "Digital marketing agency";
	        searchOnGoogle(searchKeyword);
	    }

	    private static void searchOnGoogle(String searchKeyword) {
	        try {
	            // Encode the search keyword for use in a URL
	            String encodedSearchKeyword = URLEncoder.encode(searchKeyword, "UTF-8");

	            // Construct the URL for Google Search
	            String url = "https://www.google.com/search?q=" + encodedSearchKeyword;

	            // Create an HTTP connection
	            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
	            connection.setRequestMethod("GET");

	            // Read the HTML response
	            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	                StringBuilder response = new StringBuilder();
	                String line;
	                while ((line = reader.readLine()) != null) {
	                    response.append(line);
	                }

	                // Parse the HTML content using Jsoup
	                parseHtml(response.toString());
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void parseHtml(String html) {
	        // Use Jsoup to parse the HTML
	        Document document = Jsoup.parse(html);

	        // Extract and print search results (just the titles for simplicity)
	        Elements searchResults = document.select("h3");
	        for (int i = 0; i < searchResults.size(); i++) {
	            System.out.println((i + 1) + ". " + searchResults.get(i).text());
	        }
	    }
	}


