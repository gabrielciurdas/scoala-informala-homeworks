package ro.siit.java5.homework8;

import java.util.Collections;

/**
 * The Main class.
 * 
 * @author Gabriel Ciurdas
 * <p> Date: 27/01/17
 *
 */
public class Main {
	
	/**
	 * The main method.
	 * 
	 * @param args represents the command line arguments.
	 */
	public static void main(String[] args) {
		
		StandingCalculator standingCalculator = new StandingCalculator();
		standingCalculator.calculateStanding();
		Collections.sort(standingCalculator.getOrderedStandings(), StandingCalculator.STANDING_ASCENDING_ORDER);
		standingCalculator.displayWinners();
	}
}
