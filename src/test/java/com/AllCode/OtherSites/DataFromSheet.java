package com.AllCode.OtherSites;



	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;

	import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.testng.annotations.Parameters;
	import org.testng.annotations.Test;

	public class DataFromSheet extends SearchClearClose {
		
		String browser;
		   String SerachKeyword;
		     String SearchUrl;
		    int Stime;
		     int count;
		    int min;
		    int max;
		    String RefUrl;
		    int RowsPerBatch=4;
		   // static String ChromePath = "src//test//resources//chromedriver.exe";
		    List<String> urls = new ArrayList<String>();
		    @Parameters({"SheetName"})
		    @Test
		public  void ExcelSheetData(String SheetName) throws EncryptedDocumentException, IOException {
			try {
			FileInputStream fis=new FileInputStream("src\\test\\resources\\ClientData2.xlsx");
			Workbook book=WorkbookFactory.create(fis);
			Sheet sh=book.getSheet(SheetName);
			Row row;
			for(int i=1;i<=sh.getLastRowNum();i++) {
				urls.clear();
			System.out.println(i);
				System.out.println(sh.getLastRowNum());
				 row = sh.getRow(i);
			 int CellCount=row.getPhysicalNumberOfCells();
					 System.out.println(CellCount);
			SerachKeyword=row.getCell(1).getStringCellValue();
			browser = row.getCell(0).getStringCellValue();
			 System.out.println(browser);
		     SearchUrl=row.getCell(2).getStringCellValue();
		     min=(int) row.getCell(CellCount-2).getNumericCellValue();
		     max=(int) row.getCell(CellCount-1).getNumericCellValue();
		      Stime=Range(max,min);
		      System.out.println("Stime is:"+Stime);
		     System.out.println(SerachKeyword);
		     String fixurl="https://www.google.com/search?q=" + SerachKeyword;
		     browserSelectiontoOpenUrl(  browser,fixurl);
		    // browserValue(browser);
		   sleep(3);
		     System.out.println("Browser opened is:"+browser);
		 System.out.println("Searching Keyword is done:"+SerachKeyword);
		     System.out.println("Seraching Url is done:"+SearchUrl);
		      for(int j=3;j<=CellCount-3;j++) {
		    	 Cell cell = row.getCell(j);
		    	    if (cell != null && cell.getCellType() == CellType.STRING) {
		    	        String url = cell.getStringCellValue();
		    	       urls.add(url);
		             System.out.println(url);
		      }}
		     
		   PassValueToSearchBox(SerachKeyword, SearchUrl, browser, Stime,urls);
		  ClosingBrowserPages();
	   ClearCookiesAndCache();
	   
		
		 System.out.println("Completed row num is:"+i);
			
		    
			}}
			
		catch(Exception e) {
			System.out.println("getDataFromExcelSheet fot failed");
		e.printStackTrace();}}
		    
		   

			private static  int Range(int max,int min) {
				int num=(int) ((Math.random()*(max-min))+min);
				
				
				return num;
			}

	}







