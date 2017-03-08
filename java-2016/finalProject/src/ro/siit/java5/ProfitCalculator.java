package ro.siit.java5;

public class ProfitCalculator {
	private static final double PROFIT_PER_KM = 0.02;
	
	public double calculateProfit(Package pack) {
		return pack.getDistanceInKm() * PROFIT_PER_KM;
	}

}
