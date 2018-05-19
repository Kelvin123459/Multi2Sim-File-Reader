package main;

import java.io.IOException;

import readers.ReadFib;
import readers.ReadVectors;
import workbook.Workbook;

/**
 * 
 * @author Kelvin García Muñiz
 *
 */
public class Main {

	public static void main(String args[]) throws IOException {
		Workbook wb = new Workbook( "resultsVectorCPU", 
				"C:\\Users\\Kelvin\\Desktop\\CIIC4082-Project2\\test", 
				"outputFiles");
		Workbook wb2 = new Workbook( "resultsFibCPU", 
				"C:\\Users\\Kelvin\\Desktop\\CIIC4082-Project2\\test", 
				"outputFiles");
		Workbook wb3 = new Workbook( "resultsVectorMEM", 
				"C:\\Users\\Kelvin\\Desktop\\CIIC4082-Project2\\test", 
				"outputFiles");
		Workbook wb4 = new Workbook( "resultsFibMEM", 
				"C:\\Users\\Kelvin\\Desktop\\CIIC4082-Project2\\test", 
				"outputFiles");
		ReadVectors vector = new ReadVectors(wb);
		ReadFib fib = new ReadFib(wb2);
		vector.readCPU();
		fib.readCPU();
		vector = new ReadVectors(wb3);
		fib = new ReadFib(wb4);
		vector.readMEM();
		fib.readMEM();
		System.out.println("Sequence Terminated");
	}
}
