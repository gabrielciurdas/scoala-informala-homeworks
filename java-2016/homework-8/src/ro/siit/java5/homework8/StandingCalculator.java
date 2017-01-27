package ro.siit.java5.homework8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * A calculator for for the Winners of a Ski Biathlon competition.
 * @see SkiBiathlonStanding
 * @see SkiBiathlonCSVParser
 * @see CSVSkiBiathlonReader
 * 
 * @author Gabriel Ciurdas
 * <p> Date: 27/01/17
 *
 */
public class StandingCalculator implements Comparable<SkiBiathlonStanding> {
	
	private List <SkiBiathlonStanding> orderedStandings = new ArrayList<>();
	
	/**
	 * A comparator for SkiBiathlonStanding objects based on their time results.
	 */
	public static final Comparator<SkiBiathlonStanding> STANDING_ASCENDING_ORDER = new Comparator<SkiBiathlonStanding>() {
		
		@Override
		public int compare(SkiBiathlonStanding o1, SkiBiathlonStanding o2) {
			return o1.getTimeStanding().compareTo(o2.getTimeStanding());
		}
	};
	
	public void addStanding(SkiBiathlonStanding standing) {
		orderedStandings.add(standing);
	}
	public List<SkiBiathlonStanding> getOrderedStandings() {
		return orderedStandings;
	}
	
	/**
	 * Calculates the Ski Biathlon Winners based on a certain competition.
	 * Takes a CSV file as an input from which a list of SkiBiathlonStanding object
	 * is created. The time result of each athlete is adjusted based on their 
	 * shooting range results.
	 */
	public void calculateStanding() {
		generateWinnersList();
	}
	public void calculateStandingTest(List<String> list) {
		generateWinnersListTest(list);
	}

	private void generateWinnersList() {
		try(BufferedReader br = new BufferedReader(new FileReader("skiBiathlon.csv")); 
				CSVSkiBiathlonReader reader = new CSVSkiBiathlonReader(br);) {
			identifyWinners(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void generateWinnersListTest(List<String> list) {
		SkiBiathlonReader r = new SkiBiathlonReader();
		identifyWinnersTest(r, list);
	}

	
	private void identifyWinnersTest(SkiBiathlonReader reader, List<String> list) {
		List<SkiBiathlonStanding> skiBiathlonStandings = reader.readSkiBiathlonStandingTest(list);
		String timeResult = "";
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int PENALTY = 10;
		
		for (SkiBiathlonStanding standing : skiBiathlonStandings) {
			Integer penalty = 0;
			int minute = 0;
			int second = 0;
			for (String s : standing.getShootingRange()) {
				timeResult = standing.getTimeStanding();
				minute = Integer.parseInt(timeResult.substring(0, 2));
				second = Integer.parseInt(timeResult.substring(3, 5));
				penalty = calculatePenalty(PENALTY, penalty, s);
			}
			cal.set(Calendar.MINUTE, minute);
			cal.set(Calendar.SECOND, second + penalty);
			updateStanding(cal, standing, penalty);
			
			minute = 0;
			second = 0;
			penalty = 0;
		}
	}
	
	private void identifyWinners(CSVSkiBiathlonReader reader) throws IOException {
		List<SkiBiathlonStanding> skiBiathlonStandings = reader.readSkiBiathlonStanding();
		
		String timeResult = "";
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int PENALTY = 10;
		
		for (SkiBiathlonStanding standing : skiBiathlonStandings) {
			Integer penalty = 0;
			int minute = 0;
			int second = 0;
			for (String s : standing.getShootingRange()) {
				timeResult = standing.getTimeStanding();
				minute = Integer.parseInt(timeResult.substring(0, 2));
				second = Integer.parseInt(timeResult.substring(3, 5));
				penalty = calculatePenalty(PENALTY, penalty, s);
			}
			cal.set(Calendar.MINUTE, minute);
			cal.set(Calendar.SECOND, second + penalty);
			updateStanding(cal, standing, penalty);
			
			minute = 0;
			second = 0;
			penalty = 0;
		}
	}

	private Integer calculatePenalty(int PENALTY, Integer penalty, String s) {
		for (Character c : s.toCharArray()) {
			if(c == 'o') {
				penalty += PENALTY;
			}
		}
		return penalty;
	}

	private void updateStanding(Calendar cal, SkiBiathlonStanding standing, Integer penalty) {
		String finalTimeStanding = String.valueOf(cal.get(Calendar.MINUTE)) + ":" + String.valueOf(cal.get(Calendar.SECOND))
				 + " (" + standing.getTimeStanding().substring(0, 5) + " + " + String.valueOf(penalty) +")";
		
		orderedStandings.add(new SkiBiathlonStanding(standing.getAthleteNumber(), standing.getName(),
				standing.getCountryCode(), finalTimeStanding, standing.getShootingRange()));
	}
	/**
	 * Displays the list of Winners from a Ski Biathlon competition.
	 */
	public void displayWinners() {
		System.out.println("Winner - " + orderedStandings.get(0).getName() + " " + orderedStandings.get(0).getTimeStanding());
		System.out.println("Runner-up - " + orderedStandings.get(1).getName() + " " + orderedStandings.get(1).getTimeStanding());
		System.out.println("Third place - " + orderedStandings.get(2).getName() + " " + orderedStandings.get(2).getTimeStanding());
	}
	
	@Override
	public int compareTo(SkiBiathlonStanding o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
