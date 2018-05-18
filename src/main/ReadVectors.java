package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class ReadVectors {
//	private String outputDirectory;
	Workbook workBook;
//	private String outFile = "\\results.xls";
//	private FileOutputStream fos;
//	private HSSFWorkbook workBook = new HSSFWorkbook();
	private HSSFRow row;
	private HSSFCell cell;
	CellType cellType;
	private String[] temp;
	private String delimiter = " = ";
	private String line = null;
	public ReadVectors(Workbook workBook) {
		this.workBook = workBook;
		
	}
	public void createFile() {
		HSSFSheet sheet = workBook.setSheet("VectorProd");
		String inputDirectory = workBook.getInputDirectory();
		try {
//			fos = new FileOutputStream(outputDirectory+outFile);
			int count2=0; //row
			boolean firstRun = true;
			for(int i=256; i<=4096;i+=256){
				for(int j=2; j<=20;j+=2){
					for(int k=4;k<=128;k*=2){
						for(int l=4; l<=256; l*=2){
							try {
								String fileName = "\\x86-cpu-report-vecprod-Cores-"+j+"-Threads-"+k+"-Vector-size-"+l+"-Bandwidth-"+i;
								BufferedReader bufferedReader = new BufferedReader(new FileReader(inputDirectory+fileName));
								int count=1; //file
								int count3=0; //cells
								row = sheet.createRow(count2);
								while ((line = bufferedReader.readLine()) != null) {
									if(count>5) {
										if(count3==0&&count2>0) {
											cell = row.createCell(count3);
											cell.setCellType(cellType.STRING);
											cell.setCellValue(fileName);
										}
										else {
											temp = line.split(delimiter);
											for(int m =0; m < temp.length ; m++){
												String str = temp[m];
												if(m%2==0&&firstRun==true) {
													cell = row.createCell(count3);
													cell.setCellValue(str);
												}
												else if(m%2!=0&&count2>0) {
													cell = row.createCell(count3);
//													System.out.println(str);
													try {
														double doubleStr = Double.parseDouble(str);
														cell.setCellValue(doubleStr);
														cell.setCellType(cellType.NUMERIC);
													} catch (NumberFormatException e) {
														cell.setCellValue(str);
														cell.setCellType(cellType.STRING);
													}
													
												}
											}
										}
										count3++;
									}
									if(count>45) {
										break;
									}
									count++;
								}
								firstRun=false;
								count2++;
								bufferedReader.close();
								System.out.println("File Read: "+fileName);
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
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
}
