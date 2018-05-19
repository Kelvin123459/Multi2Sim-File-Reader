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
		String inputDir = "C:\\Users\\Kelvin\\Desktop\\CIIC4082-Project2\\test";
		String outputDir = "outputFiles";
		Workbook wb = new Workbook("resultsVectorCPU", inputDir, outputDir );
		Workbook wb2 = new Workbook( "resultsFibCPU", inputDir, outputDir);
		Workbook wb3 = new Workbook( "resultsVectorMEM", inputDir, outputDir);
		Workbook wb4 = new Workbook( "resultsFibMEM", inputDir, outputDir);
		ReadVectors vector;
		ReadFib fib;
		System.out.println("Multi2Sim File Reader");
		if(args.length>0) {
			if(args[0].equals("1")) {
				System.out.println("Reading Vector Product CPU");
				vector = new ReadVectors(wb);
				vector.readCPU();
				System.out.println("Sequence Terminated");
			}
			if(args[0].equals("2")) {
				System.out.println("Reading Fibonacci CPU");
				fib = new ReadFib(wb2);
				fib.readCPU();
				System.out.println("Sequence Terminated");
			}
			if(args[0].equals("3")) {
				System.out.println("Reading Vector Product MEM");
				vector = new ReadVectors(wb3);
				vector.readMEM();
				System.out.println("Sequence Terminated");
			}
			if(args[0].equals("4")) {
				System.out.println("Reading Fibonacci MEM");
				fib = new ReadFib(wb4);
				fib.readMEM();
				System.out.println("Sequence Terminated");
			}
		}
		else if(args.length==0) {
			System.out.println("Reading Files");
			vector = new ReadVectors(wb);
			vector.readCPU();
			fib = new ReadFib(wb2);
			fib.readCPU();
			vector = new ReadVectors(wb3);
			fib = new ReadFib(wb4);
			vector.readMEM();
			fib.readMEM();
			System.out.println("Sequence Terminated");
		}
	}
}
