import org.junit.Assert;
import org.junit.Test;

import ro.siit.java5.homework8.SkiBiathlonCSVParser;
import ro.siit.java5.homework8.SkiBiathlonStanding;

public class SkiBiathlonCSVParserTest {

	@Test
	public void whenCorrectStringIsUsedAsInput_SkiBiathlonStandingIsParsed() {
		SkiBiathlonCSVParser parser = new SkiBiathlonCSVParser();
		
		String input = "3,Ben Benassi,CA,29:25:00,oxoxo,xxoox,oooxx";
		SkiBiathlonStanding actual = parser.parseSkiBiathlon(input);
		
		String[] expectedShootingRange = new String[] {"oxoxo", "xxoox", "oooxx"};
		SkiBiathlonStanding expected = new SkiBiathlonStanding(3, "Ben Benassi", "CA", "29:25:00", expectedShootingRange);
		
		Assert.assertEquals(expected.toString(), actual.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenIncorrectStringIsUsedAsInput_SkiBiathlonStandingIsNotParsed() {
		SkiBiathlonCSVParser parser = new SkiBiathlonCSVParser();
		
		String input = "23,Michell Poir2,FR,29:25:00,oxoxo3,xxoox4,oooxx5";
		SkiBiathlonStanding actual = parser.parseSkiBiathlon(input);
		
		String[] expectedShootingRange = new String[] {"oxoxo3", "xxoox4", "oooxx5"};
		SkiBiathlonStanding expected = new SkiBiathlonStanding(23, "Michell Poir2", "FR", "29:25:00", expectedShootingRange);
		
		Assert.assertEquals(expected.toString(), actual.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenIncorectInputIsUsedForTimeResult_SkiBiathlonStandingIsNotParsed() {
		SkiBiathlonCSVParser parser = new SkiBiathlonCSVParser();
		
		String input = "7,Dan Danila,RO,29a25b00,oxoxo,xxoox,oooxx";
		SkiBiathlonStanding actual = parser.parseSkiBiathlon(input);
		
		String[] expectedShootingRange = new String[] {"oxoxo", "xxoox", "oooxx"};
		SkiBiathlonStanding expected = new SkiBiathlonStanding(7, "Dan Danila", "RO", "29a25b00", expectedShootingRange);
		
		Assert.assertEquals(expected.toString(), actual.toString());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void whenAthleteNumberIsNotComposedOfNumbers_SkiBiathlonStandingIsNotParsed() {
		SkiBiathlonCSVParser parser = new SkiBiathlonCSVParser();
		
		String input = "5th,Dan Danila,RO,29:25:00,oxoxo,xxoox,oooxx";
		SkiBiathlonStanding actual = parser.parseSkiBiathlon(input);
		
		String[] expectedShootingRange = new String[] {"oxoxo", "xxoox", "oooxx"};
		SkiBiathlonStanding expected = new SkiBiathlonStanding(Integer.valueOf(input.substring(0, 3)),
				"Dan Danila", "RO", "29:25:00", expectedShootingRange);
		
		Assert.assertEquals(expected.toString(), actual.toString());
	}
}
