package ro.siit.java5.homework8;

public class SkiBiathlonCSVParser {

	private static final String SEPARATOR = ",";

	public SkiBiathlonStanding parseSkiBiathlon(String source) {
		String[] tokens = source.split(SEPARATOR);
		
		String[] shootingRange = new String[] { tokens[4], tokens[5], tokens[6]};
		return new SkiBiathlonStanding(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], shootingRange);
	}
}
