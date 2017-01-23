package ro.siit.java5.homework8;

import java.util.regex.Pattern;

public class SkiBiathlonCSVParser {

	private static final String SEPARATOR = ",";

	public SkiBiathlonStanding parseSkiBiathlon(String source) {
		String[] tokens = source.split(SEPARATOR);
		String alphabeticalCharacters = tokens[1] + tokens[2] + tokens[4] + tokens[5] + tokens[6];
		
		String[] shootingRange = new String[] { tokens[4], tokens[5], tokens[6]};
		
		if(!Pattern.matches("[a-zA-Z ]+", alphabeticalCharacters)) {
			throw new IllegalArgumentException("Name, Country Code, and Shooting Range results"
					+ " cannot be composed of non alphabetical characters!");
		}else if(!Pattern.matches("[0-9:]+", tokens[3])) {
			throw new IllegalArgumentException("Invalid format for time result!\n"
					+ "Should be this format: XX:XX:XX, where X is a number.");
		}else if(!Pattern.matches("[0-9]+", String.valueOf(tokens[0]))) {
				throw new IllegalArgumentException("Athlete number can only be composed of mnumbers!");
		}else {
			return new SkiBiathlonStanding(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], shootingRange);
		}
	}
}
