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
				"C:\\Users\\Kelvin\\Desktop\\CIIC4082-Project2");
		Workbook wb2 = new Workbook( "resultsFibCPU", 
				"C:\\Users\\Kelvin\\Desktop\\CIIC4082-Project2\\test", 
				"C:\\Users\\Kelvin\\Desktop\\CIIC4082-Project2");
		ReadVectors vector = new ReadVectors(wb);
		ReadFib fib = new ReadFib(wb2);
		vector.readCPU();
		fib.readCPU();
		System.out.println("Sequence Terminated");
	}
}
