package main;

import java.io.IOException;
public class Main {

	public static void main(String args[]) throws IOException {
		Workbook work = new Workbook( "results", 
				"C:\\Users\\Kelvin\\Desktop\\CIIC4082-Project2\\test", 
				"C:\\Users\\Kelvin\\Desktop\\CIIC4082-Project2");
		ReadVectors vector = new ReadVectors(work);
		ReadFib fib = new ReadFib(work);
		vector.createFile();
		fib.createFile();
	}
}
