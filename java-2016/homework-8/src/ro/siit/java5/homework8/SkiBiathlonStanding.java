package ro.siit.java5.homework8;

import java.util.Arrays;

/**
 * This class holds information about a Ski Biathlon athlete.
 * 
 * @author Gabriel Ciurdas
 * <p> Date: 27/01/17
 *
 */
public class SkiBiathlonStanding {
	private int athleteNumber = 0;
	private String name = "";
	private String countryCode = "";
	private String timeStanding = "";
	private String[] shootingRange = new String[3];
	
	/**
	 * The Constructor for SkiBiathlonStanding object.
	 * 
	 * @param athleteNumber is the athlete's number.
	 * @param name is the name of the athlete.
	 * @param countryCode is the country code of the athlete.
	 * @param timeStanding is the time result of the athlete.
	 * @param shootingRange represents the shooting results of the athlete.
	 */
	public SkiBiathlonStanding(int athleteNumber, String name, String countryCode,
			String timeStanding, String[] shootingRange) {
		this.athleteNumber = athleteNumber;
		this.name = name;
		this.countryCode = countryCode;
		this.timeStanding = timeStanding;
		this.shootingRange = shootingRange;
	}

	@Override
	public String toString() {
		return "SkiBiathlonStanding [athleteNumber=" + athleteNumber + ", name=" + name + ", countryCode=" + countryCode
				+ ", timeStanding=" + timeStanding + ", shootingRange=" + Arrays.toString(shootingRange) + "]";
	}
	
	public int getAthleteNumber() {
		return athleteNumber;
	}
	
	public String getName() {
		return name;
	}
	
	public String getCountryCode() {
		return countryCode;
	}
	
	public String[] getShootingRange() {
		return shootingRange;
	}
	
	public String getTimeStanding() {
		return timeStanding;
	}
}
