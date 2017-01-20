package ro.siit.java5.homework8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		try(BufferedReader br = new BufferedReader(new FileReader("skiBiathlon.csv")); 
				CSVSkiBiathlonReader reader = new CSVSkiBiathlonReader(br);) {
			List<SkiBiathlonStanding> skiBiathlonStandings = reader.readSkiBiathlonStanding();
			System.out.println(skiBiathlonStandings.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
