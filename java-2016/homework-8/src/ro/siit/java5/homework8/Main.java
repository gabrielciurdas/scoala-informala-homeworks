package ro.siit.java5.homework8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.SimpleTimeZone;

public class Main {
	
	public static void main(String[] args) {
		
		StandingCalculator standingCalculator = new StandingCalculator();
		standingCalculator.calculateStanding();
		Collections.sort(standingCalculator.getOrderedStandings(), StandingCalculator.STANDING_ASCENDING_ORDER);
		standingCalculator.displayWinners();
	}
}
