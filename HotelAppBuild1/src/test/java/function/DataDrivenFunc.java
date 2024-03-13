	//This function is used to read data from specified cell of Excel sheet once you give Excelsheet name and path
package function;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.read.biff.BiffException;

public class DataDrivenFunc {
	

	@SuppressWarnings ("deprecation")
	public String HA_GF_readXL (int row, String column, String strFilePath) {

	Cell c= null;
	int reqCol=0;
	WorkbookSettings ws = null;
	Workbook workbook = null;
	Sheet sheet = null;
	FileInputStream fs = null;

		try {
			fs = new FileInputStream(new File(strFilePath) ) ;
			ws = new WorkbookSettings ();
			ws.setLocale (new Locale("en", "EN") ) ;
	
			// opening the work book and sheet for reading data
			workbook = Workbook.getWorkbook (fs, ws) ;
			sheet = workbook.getSheet (0) ;
	
			// Sanitise given data
			String col = column.trim();
	
			//loop for going through the given row
			for(int j=0; j<sheet.getColumns(); j++) {
			Cell cell = sheet.getCell(j,0);
			if((cell.getContents() .trim() ) .equalsIgnoreCase (col) ) {
	
			reqCol= cell.getColumn();
			//System.out.println("column No:"+reqCol) ;
			c = sheet.getCell(reqCol, row) ;
			fs.close ();
			return c.getContents ();
			}
			}
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BiffException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IndexOutOfBoundsException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return c.getContents ();
		}

	
	public int HA_GF_XLRowCount (String strFilePath, String columnName) {

		Cell c= null;
		int reqRow=0;
		WorkbookSettings ws = null;
		Workbook workbook = null;
		Sheet sheet = null;
		FileInputStream fs = null;

			try {
				fs = new FileInputStream(new File(strFilePath) ) ;
				ws = new WorkbookSettings ();
				ws.setLocale (new Locale("en", "EN") ) ;
		
				// opening the work book and sheet for reading data
				workbook = Workbook.getWorkbook (fs, ws) ;
				sheet = workbook.getSheet (0) ;
		
				reqRow =sheet.getRows()-1;
				
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (BiffException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IndexOutOfBoundsException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return reqRow;
			}

}
