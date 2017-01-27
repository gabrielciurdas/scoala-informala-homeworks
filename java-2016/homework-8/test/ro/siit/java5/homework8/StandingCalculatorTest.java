package ro.siit.java5.homework8;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.junit.Assert;


public class StandingCalculatorTest {

	@Test
	public void calculatesStandingsFromAListOfAthletes() {
		StandingCalculator standingCalculator = new StandingCalculator();
		
		List<String> athleteList = Arrays.asList("3,Ben Berry,UK,29:45:00,xxxxo,oxxxx,oxoxx",
				"15,Ion Ionescu,RO,30:03:00,xxxxx,xxxxx,xxxxo",
				"1,Jimmy Smiles,UK,29:15:00,xxoox,xooxo,xxxxo",
				"7,Dan Danila,RO,29:25:00,oxoxo,xxoox,oooxx"
				);
		
		standingCalculator.calculateStandingTest(athleteList);
		Collections.sort(standingCalculator.getOrderedStandings(), StandingCalculator.STANDING_ASCENDING_ORDER);
		String actual1 = "Winner - " + standingCalculator.getOrderedStandings().get(0).getName() + 
				" " + standingCalculator.getOrderedStandings().get(0).getTimeStanding();
		String actual2 = "Runner-up - " + standingCalculator.getOrderedStandings().get(1).getName() + " " 
				+ standingCalculator.getOrderedStandings().get(1).getTimeStanding();
		String actual3 = "Third place - " + standingCalculator.getOrderedStandings().get(2).getName() + " " 
				+ standingCalculator.getOrderedStandings().get(2).getTimeStanding();
		
		String expected1 = "Winner - Ion Ionescu 30:13 (30:03 + 10)";
		String expected2 = "Runner-up - Jimmy Smiles 30:15 (29:15 + 60)";
		String expected3 = "Third place - Ben Berry 30:25 (29:45 + 40)";
		
		Assert.assertEquals(expected1, actual1);
		Assert.assertEquals(expected2, actual2);
		Assert.assertEquals(expected3, actual3);
	}

}
