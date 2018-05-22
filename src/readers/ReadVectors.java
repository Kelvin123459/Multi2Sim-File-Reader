package readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.CellType;

import workbook.Workbook;

/**
 * 
 * @author Kelvin García Muñiz
 *
 */
public class ReadVectors {
	Workbook workBook;
	private HSSFRow row;
	private HSSFCell cell;
	private String[] temp;
	private String line = null;
	private final String delimiter = " = ";
	private final int[] lineRangeCPU = {132, 139, 4, 50};
	private final int[] lineRangeMem = {24, 46, 136, 155};
	private int[] lineRange;
	private final String[] fileSpecs = {"File Name", "Bandwidth", "Cores", "Threads", "Size"};
	public ReadVectors(Workbook workBook) {
		this.workBook = workBook;
	}
	public void readCPU() {
		reader("cpu");
	}
	public void readMEM() {
		reader("mem");
	}
	private void reader(String reportType) {
		HSSFSheet sheet = workBook.setSheet("VectorProd");
		String inputDirectory = workBook.getInputDirectory();
		if(reportType=="mem") {
			lineRange = lineRangeMem;
		}
		else if(reportType == "cpu") {
			lineRange = lineRangeCPU;
		}
		try {
			int count2=1; //row
			setLabels(reportType, sheet);
			for(int i=256; i<=4096;i+=256){
				for(int j=2; j<=20;j+=2){
					for(int k=4;k<=128;k*=2){
						for(int l=4; l<=256; l*=2){
							try {
								String fileName = "\\x86-"+reportType+"-report-vecprod-Cores-"+j+"-Threads-"+k+"-Vector-size-"+l+"-Bandwidth-"+i;
								BufferedReader bufferedReader = new BufferedReader(new FileReader(inputDirectory+fileName));
								int count=1; //file
								int count3=0; //cells
								row = sheet.createRow(count2);
								int[] currentSpecs = {i,j,k,l};
								for(int z=0;z<5;z++){
									if(count3<5) {
										setSpecs(currentSpecs,count,count3,fileName);
										count3++;
									}
								}
								while ((line = bufferedReader.readLine()) != null) {
									if(count>=lineRange[0]&&count<=lineRange[1]) {
										setCells(count3);
										count3++;
									}
									else if(reportType=="mem"&&count>=lineRange[2]&&count<=lineRange[3]){
										setCells(count3);
										count3++;
									}
									count++;
								}
								count2++;
								bufferedReader.close();
								System.out.println("File Read: "+fileName);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
//								e.printStackTrace();
							}
						}
					}
				}
			}
			workBook.writeBook();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("\n ---------------------------------------------"
				+ "\n VECTOR PRODUCT TERMINATED \n ---------------------------------------------");
	}

	private void setLabels(String reportType, HSSFSheet sheet) {
		String fileName = "\\x86-"+reportType+"-report-vecprod-Cores-2-Threads-4-Vector-size-4-Bandwidth-256";
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(workBook.getInputDirectory()+fileName));
			int count = 0;
			int count2 = 0;
			row = sheet.createRow(0);
			for(count=0;count<5;count++){
				cell = row.createCell(count);
				cell.setCellValue(fileSpecs[count]);
			}
			count++;
			while ((line = bufferedReader.readLine()) != null) {
				if(count2>lineRange[0]&&count2<lineRange[1]) {
					temp = line.split(delimiter);
					for(int m =0; m < temp.length ; m++){
						String str = temp[m];
						System.out.println(str);
						if(m%2==0) {
							cell = row.createCell(count);
							cell.setCellValue(str);
						}
					}
					count++;
				}
				else if(reportType=="mem"&&count>=lineRange[2]&&count<=lineRange[3]){
					temp = line.split(delimiter);
					for(int m =0; m < temp.length ; m++){
						String str = temp[m];
						if(m%2==0) {
							cell = row.createCell(count);
							cell.setCellValue(str);
						}
					}
					count++;
				}
				count2++;
			}
			bufferedReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private void setSpecs(int[] currentSpecs, int count, int count3, String fileName){
		switch(count3){
		case 1: count3=0;{
			cell = row.createCell(count3);
			cell.setCellValue(fileName);
		}
		case 2: count3=1;{
			cell = row.createCell(count3);
			cell.setCellValue(currentSpecs[0]);
		}
		case 3: count3=2;{
			cell = row.createCell(count3);
			cell.setCellValue(currentSpecs[1]);
		}
		case 4: count3=3;{
			cell = row.createCell(count3);
			cell.setCellValue(currentSpecs[2]);
		}
		case 5: count3=4;{
			cell = row.createCell(count3);
			cell.setCellValue(currentSpecs[3]);
		}
		}
	}
	private void setCells(int count3){
		temp = line.split(delimiter);
		for(int m =0; m < temp.length ; m++){
			String str = temp[m];
			if(m%2!=0) {
				cell = row.createCell(count3-1);
				try {
					double doubleStr = Double.parseDouble(str);
					cell.setCellValue(doubleStr);
					cell.setCellType(CellType.NUMERIC);
				} catch (NumberFormatException e) {
					cell.setCellValue(str);
					cell.setCellType(CellType.STRING);
				}

			}
		}
	}
}
