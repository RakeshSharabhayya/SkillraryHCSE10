package genaricLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	private Workbook workbook;
	/**
	 * This method is used to initialize excel file
	 * @param excelPath
	 */
	public void excelInit(String excelPath) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(excelPath);
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook= WorkbookFactory.create(fis);
		}catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}
	}
    public String getDataFromExcel(String sheetname, int rowNum, int cellNum) {
	DataFormatter df=new DataFormatter();
	String data=df.formatCellValue(workbook.getSheet(sheetname).getRow(rowNum).getCell(cellNum));
			return data;
			/**
			 * This method is used to fetch multiple data from excel
			 * @author admin
			 * @return
			 */
		    }
		    public Map<String, String> getDataFromExcel(String sheetName) {
		    	DataFormatter df=new DataFormatter();
		    	Map<String, String> map=new HashMap<>();
		    	Sheet sheet=workbook.getSheet(sheetName);
		    	
		    	for(int i=0; i<=sheet.getLastRowNum(); i++) {
		    		String key=df.formatCellValue(sheet.getRow(i).getCell(0));
		    		String value=df.formatCellValue(sheet.getRow(i).getCell(1));
		    		map.put(key, value);
		    	}
		    	return map;
		    	}
		    public void writeToExcel(String sheetName, int rowNum, int cellNum, String excelPath, Date data) {
		    	Cell cell=workbook.getSheet(sheetName).getRow(rowNum).createCell(cellNum);
		    	cell.setCellValue(data);
		        FileOutputStream fos=null;
		        try {
		        	fos= new FileOutputStream(excelPath);
		        } catch(FileNotFoundException e) {
		        	e.printStackTrace();
		        }
		        try {
		        	workbook.write(fos);
		        } catch(IOException e) {
		        	e.printStackTrace();
		        }
		    }
		    /**
		     * This method is used to close the excel
		     * 
		     */
		    public void Closeexcel()
		    {
		    	try {
					workbook.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }

 		
		}
