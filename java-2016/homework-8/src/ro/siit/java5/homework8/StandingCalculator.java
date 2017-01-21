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
	
	private List<SkiBiathlonStanding> orderedStandings = new ArrayList<>();
	
	public static final Comparator<SkiBiathlonStanding> STANDING_ASCENDING_ORDER = new Comparator<SkiBiathlonStanding>() {
		
		@Override
		public int compare(SkiBiathlonStanding o1, SkiBiathlonStanding o2) {
			return o1.getTimeStanding().compareTo(o2.getTimeStanding());
		}
	};
	
	public List<SkiBiathlonStanding> getOrderedStandings() {
		return orderedStandings;
	}
	
	public void displayStandings() {
		System.out.println("Winners: \n");
		for (int i = 0; i < 3; i++) {
			System.out.println(i + 1 + ". " + orderedStandings.get(i).toString());
		}
		if(orderedStandings.size() > 3) {
			System.out.println("-----------------------------------------------------------------"
					+ "--------------------------------------------------------------------------");
			for(int j = 3; j < orderedStandings.size() - 1 ; j++) {
				System.out.println(j + 1 + ". " + orderedStandings.get(j).toString());
			}
		}
	}
	
	public void calculateStanding() {
		try(BufferedReader br = new BufferedReader(new FileReader("skiBiathlon.csv")); 
				CSVSkiBiathlonReader reader = new CSVSkiBiathlonReader(br);) {
			List<SkiBiathlonStanding> skiBiathlonStandings = reader.readSkiBiathlonStanding();
			
			int penalty = 0;
			String timeResult = "";
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			int PENALTY = 10;
			int minute = 0;
			int second = 0;
			
			for (SkiBiathlonStanding standing : skiBiathlonStandings) {
				for (String s : standing.getShootingRange()) {
					timeResult = standing.getTimeStanding();
					minute = Integer.parseInt(timeResult.substring(0, 2));
					second = Integer.parseInt(timeResult.substring(3, 5));
					for (Character c : s.toCharArray()) {
						if(c == 'o') {
							penalty += PENALTY;
						}
					}
				}
				cal.set(Calendar.MINUTE, minute);
				cal.set(Calendar.SECOND, second + penalty);
				String finalTimeStanding = String.valueOf(cal.get(Calendar.MINUTE)) + ":" + String.valueOf(cal.get(Calendar.SECOND)) + ":00";
				orderedStandings.add(new SkiBiathlonStanding(standing.getAthleteNumber(), standing.getName(),
						standing.getCountryCode(), finalTimeStanding, standing.getShootingRange()));
				minute = 0;
				second = 0;
				penalty = 0;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int compareTo(SkiBiathlonStanding o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
