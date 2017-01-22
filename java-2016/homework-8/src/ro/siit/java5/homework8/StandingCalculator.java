package ro.siit.java5.homework8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;



public class StandingCalculator implements Comparable<SkiBiathlonStanding> {
	
	private List <SkiBiathlonStanding> orderedStandings = new ArrayList<>();
	
	public static final Comparator<SkiBiathlonStanding> STANDING_ASCENDING_ORDER = new Comparator<SkiBiathlonStanding>() {
		
		@Override
		public int compare(SkiBiathlonStanding o1, SkiBiathlonStanding o2) {
			return o1.getTimeStanding().compareTo(o2.getTimeStanding());
		}
	};
	
	public List<SkiBiathlonStanding> getOrderedStandings() {
		return orderedStandings;
	}
	
	public void calculateStanding() {
		generateWinnersList();
	}

	private void generateWinnersList() {
		try(BufferedReader br = new BufferedReader(new FileReader("skiBiathlon.csv")); 
				CSVSkiBiathlonReader reader = new CSVSkiBiathlonReader(br);) {
			identifyWinners(reader);
		} catch (IOException e) {
			e.printStackTrace();
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
