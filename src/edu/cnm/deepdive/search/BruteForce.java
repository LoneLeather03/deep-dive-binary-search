/**
 * 
 */
package edu.cnm.deepdive.search;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author David S. Martinez
 *
 */
public class BruteForce {

	/**
	 * @param args
	 */
	private static String haystackName;
	private static String needlesName;
	private static String outputName;
	
	public static void main(String[] args) {
		
		haystackName = args[0];
		needlesName = args[1];
		outputName = args[2];
		long startTime = System.currentTimeMillis();
		ArrayList<Integer> haystack = readFile(haystackName);
		ArrayList<Integer> needles = readFile(needlesName);
			System.out.printf("Read data: %,d ms%n",
		startTime =	System.currentTimeMillis()- startTime);
		List<Integer> found = getNeedlesFound(haystack, needles);
			System.out.printf("Read data: %,d ms%n",
				System.currentTimeMillis()- startTime);
		writeNeedlesFound(outputName, found);
	}
	
	private static ArrayList<Integer> readFile(String filename) {
		try (
			FileInputStream stream = new FileInputStream(haystackName);
			InputStreamReader input = new InputStreamReader(stream);
			BufferedReader reader = new BufferedReader(input);
		) {
			String line;
			ArrayList<Integer> results = new ArrayList<>();
			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (line.length() > 0) {
					
				}
			}
			return results;
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	private static List<Integer> getNeedlesFound(
			List<Integer> haystack, List<Integer> needles) {
		ArrayList<Integer> results = new ArrayList<>();
		for (int needle : needles) {
			for(int haystalk : haystack) {
				if (needle == haystalk) {
					results.add(needle);
					break;
				}
			}
		}
		return results;
	}
	
	private static void writeNeedlesFound(
			String filename, List<Integer> found) {
		try(
			FileOutputStream stream = new FileOutputStream(filename);
			OutputStreamWriter writer = new OutputStreamWriter(stream);
			PrintWriter printer = new PrintWriter(writer);	
				) {
			for (int needle : found) {
				printer.println(needle);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
}
