package ro.siit.java5.homework8;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used for creating an array list of SkiBiathlonStanding objects.
 * @see SkiBiathlonStanding
 * 
 * @author Gabriel Ciurdas
 * <p> Date: 27/01/17
 *
 */
public class SkiBiathlonReader {
	private SkiBiathlonCSVParser skiBiathlonCSVParser = new SkiBiathlonCSVParser();

	/**
	 * Takes a list of strings as an input in order to create an array of SkiBiathlonStanding object.
	 * 
	 * @param list is the input of an array list of strings .
	 * @return the array list of SkiBiathlonStanding object.
	 */
	public List<SkiBiathlonStanding> readSkiBiathlonStandingTest(List<String> list) {
		ArrayList<SkiBiathlonStanding> skiBiathlonStandings = new ArrayList<>();
		for (String s : list) {
			SkiBiathlonStanding skiBAStanding = skiBiathlonCSVParser.parseSkiBiathlon(s);
			skiBiathlonStandings.add(skiBAStanding);
		}
		
		return skiBiathlonStandings;
	}
}
