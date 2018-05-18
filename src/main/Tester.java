package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Tester {
	public static void main(String[] args) throws IOException {
		String outputDirectory = "C:\\Users\\Kelvin\\Desktop\\CIIC4082-Project2\\test";
		String line = null;
		String line2 = null;
		int count =0;
		for(int i=256; i<=4096;i+=256){
			for(int j=2; j<=20;j+=2){
				for(int k=4;k<=128;k*=2){
					for(int l=4; l<=256; l*=2){
						BufferedReader bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Kelvin\\Desktop\\CIIC4082-Project2\\x86-cpu-report-vecprod-Cores-4-Threads-32-Vector-size-128-Bandwidth-256"));
						BufferedReader bufferedReader2 = new BufferedReader(new FileReader("C:\\Users\\Kelvin\\Desktop\\CIIC4082-Project2\\x86-cpu-report-fibonacci-Cores-2-Threads-4-Vector-size-4-Bandwidth-256"));
						String fileName = "\\x86-cpu-report-vecprod-Cores-"+j+"-Threads-"+k+"-Vector-size-"+l+"-Bandwidth-"+i;
						String fileName2 = "\\x86-cpu-report-fibonacci-Cores-"+j+"-Threads-"+k+"-Vector-size-"+l+"-Bandwidth-"+i;
						PrintWriter out = new PrintWriter(new File(outputDirectory, fileName)); 
						PrintWriter out2 = new PrintWriter(new File(outputDirectory, fileName2)); 
						while ((line = bufferedReader.readLine()) != null) {
							out.println(line);
						}
						System.out.println(count=count+1);
						while ((line2 = bufferedReader2.readLine()) != null) {
							out2.println(line2);
						}
						out.close();
						out2.close();
						bufferedReader.close();
						bufferedReader2.close();
						System.out.println(count=count+1);
					}
				}
			}
		}
	}
}
