package UTIL;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelProgram 
{
			static String newSheet=null;
			static String path=null;
			public static Workbook wb;
	
			public static void nxl() throws IOException
			 { 
				  
			        // Creating Workbook instances 
					Workbook wb3 = new HSSFWorkbook(); 
			  
			        // An output stream accepts output bytes and sends them to sink. 
			        OutputStream fileOut = new FileOutputStream("../COM.QA.TCLSELECT/exe/log.xls"); 
			          
			        // Creating Sheets using sheet object 
			         org.apache.poi.ss.usermodel.Sheet sheet1 = wb3.createSheet("Array"); 
			         			          
			  
			System.out.println("Sheets Has been Created successfully"); 
			  
			        wb3.write(fileOut); 
			 }
			
			
		// >>>>>>>>>>>>>>>>>>>>>>>>>>> Create New excel 
			public static void newexl(String path1) throws IOException
			{
				path=path1;
				 wb = new HSSFWorkbook();
				 FileOutputStream	 fileOut = new FileOutputStream(path);
				wb.write(fileOut);
				fileOut.close();
			}
			
			
			// >>>>>>>>>>>>>>>>>>>>>>>>>>> Create New excel with SHeet Name And Column Names 
			
			public static void addsheet(String pat,String Sheet) throws IOException
			{
				System.out.println("In add sheet");
				path=pat;
				newSheet=Sheet;
				 wb = new HSSFWorkbook();
				FileOutputStream fileOut = new FileOutputStream(path);
				CreationHelper createHelper = wb.getCreationHelper();
				org.apache.poi.ss.usermodel.Sheet sheet1 = wb.createSheet(newSheet);
				Row row1 = sheet1.createRow((short) 0);
				row1.createCell(0).setCellValue(createHelper.createRichTextString("TestCase Name"));
				row1.createCell(1).setCellValue(createHelper.createRichTextString("Parameters"));
				row1.createCell(2).setCellValue(createHelper.createRichTextString("Status"));
				row1.createCell(3).setCellValue(createHelper.createRichTextString("Exception"));
				wb.write(fileOut);
				fileOut.close();
				System.out.println( newSheet + " Sheet Added");
				
			}	
			
			

			// >>>>>>>>>>>>>>>>>>>>>>>>>>> Add or update Result of Test case in excel 
			
			public static void updateResult(String sh,String Methodname,String para,String Status,String errormsg) throws EncryptedDocumentException, IOException
			{
				path="../COM.QA.TCLSELECT/exe/loger.xls";
				newSheet=sh;
				
				InputStream inp = new FileInputStream(path); 
			    Workbook wb = WorkbookFactory.create(inp); 
				
				System.out.println(newSheet + "in writer");
				CreationHelper createHelper = wb.getCreationHelper();
				
				int rowcnt=wb.getSheet(newSheet).getLastRowNum();
				System.out.println(rowcnt);
				
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
				   LocalDateTime now = LocalDateTime.now();  
				   System.out.println(dtf.format(now));  
				   String dt=dtf.format(now);
				
				
				Row row1 = wb.getSheet(newSheet).createRow((short) rowcnt+1);
				row1.createCell(0).setCellValue(createHelper.createRichTextString(Methodname));
				row1.createCell(1).setCellValue(createHelper.createRichTextString(para));
				row1.createCell(2).setCellValue(createHelper.createRichTextString(Status));
				row1.createCell(3).setCellValue(createHelper.createRichTextString(errormsg));
				row1.createCell(4).setCellValue(createHelper.createRichTextString(dt));
				FileOutputStream fileOut=new FileOutputStream(path);
				wb.write(fileOut);
				wb.close();
				System.out.println(Methodname + " & "+ Status + " add to "+ newSheet);
			}
			
		// >>>>>>>>>>>>>>>>>>>>>>>>>>> read all excell data of same number of cell
		
		public static ArrayList<Object[]> readData2(String path,String sheetName) throws EncryptedDocumentException, IOException, InvalidFormatException
		{
			//String path="../DigitalWorkspace/Excel/CreateUsernew.xls";
			FileInputStream file=new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(file);
			ArrayList<Object[]> myobj = new ArrayList<Object[]>();
			int rowcnt=wb.getSheet(sheetName).getLastRowNum();
			System.out.println(rowcnt);
			for(int i=1;i<=rowcnt;i++)
			{
				//System.out.println("last row" + rowcnt);
				int cellcnt=wb.getSheet(sheetName).getRow(i).getLastCellNum();
				//System.out.println(cellcnt);
				Object[] obj = new Object[cellcnt];
				
				for(int c=0;c<cellcnt;c++)
				{
					//System.out.println("last cell" +cellcnt);
					String Name=wb.getSheet(sheetName).getRow(i).getCell(c).toString();
					//System.out.println(Name);
					if(Name.equalsIgnoreCase("Null"))
						Name=" ";
					obj[c]=Name;
					//System.out.println(Name);
				}
				myobj.add(obj);
			}
			//System.out.println("sending obj");
			return myobj;
		}

		public static ArrayList<Object[]> readData2range(String path,String sheetName,int start, int o) throws EncryptedDocumentException, IOException, InvalidFormatException
		{
			//String path="../DigitalWorkspace/Excel/CreateUsernew.xls";
			FileInputStream file=new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(file);
			ArrayList<Object[]> myobj = new ArrayList<Object[]>();
			int rowcnt=wb.getSheet(sheetName).getLastRowNum();
			System.out.println(rowcnt);
			if(rowcnt>=o)
			{
			for(int i=start;i<=o;i++)
			{
				//System.out.println("last row" + rowcnt);
				int cellcnt=wb.getSheet(sheetName).getRow(i).getLastCellNum();
				//System.out.println(cellcnt);
				Object[] obj = new Object[cellcnt];
				
				for(int c=0;c<cellcnt;c++)
				{
					//System.out.println("last cell" +cellcnt);
					String Name=wb.getSheet(sheetName).getRow(i).getCell(c).toString();
					//System.out.println(Name);
					if(Name.equalsIgnoreCase("Null"))
						Name=" ";
					obj[c]=Name;
					//System.out.println(Name);
				}
				myobj.add(obj);
			}
			}
			else
			{
				System.out.println("invalid data " + o);
			}
			//System.out.println("sending obj");
			return myobj;
		}
	
		public static ArrayList<String> GetTempnames(String path,String sheetName) throws EncryptedDocumentException, IOException, InvalidFormatException
		{
			//String path="../DigitalWorkspace/Excel/CreateUsernew.xls";
			FileInputStream file=new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(file);
			ArrayList<String> myobj = new ArrayList<String>();
			int rowcnt=wb.getSheet(sheetName).getLastRowNum();
		
			for(int i=1;i<=rowcnt;i++)
			{
				String Tempname=wb.getSheet(sheetName).getRow(i).getCell(0).toString();
				if(myobj.contains(Tempname)){}
				else
				{
					myobj.add(Tempname);
				}
			}
			//System.out.println("sending obj");
			return myobj;
		}
// >>>>>>>>>>>>>>>>>>>>>>>>>>> Read template data
		
		public static ArrayList<Object[]> readTemplateData(String path,String sheetName,String Tname) throws EncryptedDocumentException, IOException, InvalidFormatException
		{
			//String path="../DigitalWorkspace/Excel/CreateUsernew.xls";
			FileInputStream file=new FileInputStream(path);
			Workbook wb = WorkbookFactory.create(file);
			ArrayList<Object[]> myobj = new ArrayList<Object[]>();
			
			int rowcnt=wb.getSheet(sheetName).getLastRowNum();
			System.out.println("last row" + rowcnt);
			for(int i=1;i<=rowcnt;i++)
			{
				//System.out.println("last row" + rowcnt);
				int cellcnt=wb.getSheet(sheetName).getRow(i).getLastCellNum();
				Object[] obj = new Object[cellcnt];
				
				String Tempname=wb.getSheet(sheetName).getRow(i).getCell(0).toString();
				if(Tempname.equalsIgnoreCase(Tname))
				{
				for(int c=0;c<cellcnt;c++)
				{
					//System.out.println("last cell" +cellcnt);
					String Name=wb.getSheet(sheetName).getRow(i).getCell(c).toString();
					//System.out.println(Name);
					if(Name.equalsIgnoreCase("Null"))
						Name=" ";
					obj[c]=Name;
					//System.out.println(Name);
				}
				myobj.add(obj);
				}
			}
			System.out.println("sending " + myobj);
			return myobj;
		}
		
		
		// >>>>>>>>>>>>>>>>>>>>>>>>>>> update result to old excel file  
		
		public static void AddResultAt(String path,String newSheet,int searchcellnum,String UniqField,String Result,int rescellnum) throws EncryptedDocumentException, IOException, InvalidFormatException
		{
			//System.out.println("Add res excel");
		//String path="../DigitalWorkspace/Excel/CreateUsernew.xls";
		FileInputStream file=new FileInputStream(path);
		Workbook wb = WorkbookFactory.create(file);
		int rowcnt=wb.getSheet(newSheet).getLastRowNum();
		//System.out.println(rowcnt);
		for(int i=1;i<=rowcnt;i++)
		{
			String searchField=wb.getSheet(newSheet).getRow(i).getCell(searchcellnum).toString();
			//System.out.println(searchField);
			if(searchField.equalsIgnoreCase(UniqField))
			{
				//System.out.println(UniqField + " in if");
				//short Lastcell = wb.getSheet(newSheet).getRow(i).getLastCellNum();
				short lc = wb.getSheet(newSheet).getRow(i).getLastCellNum();
			//System.out.println(	lc);
			//System.out.println(	wb.getSheet(newSheet).getRow(i).getCell(13).toString());
			
			//System.out.println(	wb.getSheet(newSheet).getRow(i).getCell(14).toString());
			CreationHelper createHelper = wb.getCreationHelper();
			wb.getSheet(newSheet).getRow(i).createCell(rescellnum).setCellValue(createHelper.createRichTextString(Result));
			
				break;
			}
					
		}
		FileOutputStream fileOut=new FileOutputStream(path);
		wb.write(fileOut);
		wb.close();
		//System.out.println("saved excel");
		}
		
		// >>>>>>>>>>>>>>>>>>>>>>>>>>> Create New excel Excel to save string array 
		
		public static void Altimg(String Sheet,ArrayList<String> ar) throws IOException
		{
			
			newSheet=Sheet;
			FileOutputStream fileOut = new FileOutputStream(path);
			CreationHelper createHelper = wb.getCreationHelper();
			org.apache.poi.ss.usermodel.Sheet sheet1 = wb.createSheet(newSheet);		
			int k=0;
			for (String st : ar) {
				System.out.println("printing " + st);
				sheet1.createRow((short) k).createCell(0).setCellValue(createHelper.createRichTextString(st));
			k++;
			}
			wb.write(fileOut);
			fileOut.close();
			System.out.println("done from me in altimg of " + newSheet);
		}
		
		/*public static void Intersect(String Sheet)
		{
			String targetLetter;
			String displayLetter;
			newSheet=Sheet;
			FileOutputStream fileOut = new FileOutputStream(path);
			CreationHelper createHelper = wb.getCreationHelper();
			org.apache.poi.ss.usermodel.Sheet sheet1 = wb.createSheet(newSheet);
			for (Row row : Sheet) 
		    {
		        for (Cell cell : row)
		            {
		               
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) 
		                    if (cell.getRichStringCellValue().getString().trim().equals(targetLetter))
		                        row1= row.getRowNum();  
		                
						if (cell.getCellType() == Cell.CELL_TYPE_STRING) 
		                    if (cell.getRichStringCellValue().getString().trim().equals(displayLetter)) 
		                        col1= cell.getColumnIndex();  
		                c= sheet.getRow(row1).getCell(col1); // c is of type Cell
		            }
		    }
		}*/
		
	}

