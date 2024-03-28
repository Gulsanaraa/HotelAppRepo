package excel;

public class ExcelUtilTest {

public static void main(String[] args) {
	
	//Xls_Reader reader = new Xls_Reader("./src/main/java/com/excel/lib/util/SampleExcel.xlsx");
	
	Xls_Reader reader = new Xls_Reader("target/DailyStatus.xlsx");
	String sheetName = "login";
	
	reader.getCellData(sheetName, 0, 2);
	
	}
}