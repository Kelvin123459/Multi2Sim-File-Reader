package workbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * 
 * @author Kelvin García Muñiz
 *
 */
public class Workbook {
	private HSSFWorkbook workBook;
	private FileOutputStream fos;
	private String inputDirectory;
	public Workbook(String fileName, String inputDirectory, String outputDirectory) {
		this.workBook = new HSSFWorkbook();
		this.inputDirectory = inputDirectory;
		try {
			this.fos = new FileOutputStream(outputDirectory+"\\"+fileName+".xls");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public HSSFSheet setSheet(String sheetLabel){
		return workBook.createSheet(sheetLabel);
	}
	
	public void writeBook() {
		try {
			workBook.write(fos);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public HSSFWorkbook getWorkBook() {
		return workBook;
	}
	
	public String getInputDirectory() {
		return inputDirectory;
	}
}
