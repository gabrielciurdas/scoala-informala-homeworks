package ro.siit.java5.homework8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * A reader for CSV files which contains information about athletes 
 * of a Ski Biathlon competition.
 * @see SkiBiathlonCSVParser
 * @see SkiBiathlonStanding
 * 
 * @author Gabriel Ciurdas
 * <p> Date: 27/01/17
 *
 */
public class CSVSkiBiathlonReader extends BufferedReader {
	
	private SkiBiathlonCSVParser skiBiathlonCSVParser = new SkiBiathlonCSVParser();
	
	/**
	 * The Constructor for a CSVSkiBiathlonReader object.
	 * 
	 * @param in represents the input for the BufferedReader object.
	 */
	public CSVSkiBiathlonReader(Reader in) {
		super(in);
	}
	
	/**
	 * Reads a CSV file line by line in order to create a list of SkiBiathlonStanding objects.
	 * 
	 * @return a list of SkiBiathlonStanding objects.
	 * @throws IOException
	 */
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
