package ro.siit.java5.homework8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;


public class CSVSkiBiathlonReader extends BufferedReader {
	
	private SkiBiathlonCSVParser skiBiathlonCSVParser = new SkiBiathlonCSVParser();
	
	public CSVSkiBiathlonReader(Reader in) {
		super(in);
	}
	
	public List<SkiBiathlonStanding> readSkiBiathlonStanding() throws IOException{
		String line = readLine();
		ArrayList<SkiBiathlonStanding> skiBiathlonStandings = new ArrayList<>();
		while(line!=null){
			SkiBiathlonStanding skiBAStanding = skiBiathlonCSVParser.parseSkiBiathlon(line);
			skiBiathlonStandings.add(skiBAStanding);
			line = readLine();
		}
		return skiBiathlonStandings;
	}
}
