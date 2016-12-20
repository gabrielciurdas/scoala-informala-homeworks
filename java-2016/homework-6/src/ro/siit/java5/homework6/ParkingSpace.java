package ro.siit.java5.homework6;

public class ParkingSpace {
	
	private int parkingSpace = 0;
	
	public void setParkingSpace() {
		parkingSpace = getParkingSpace();
		parkingSpace++;
	}
	public int getParkingSpace() {
		return parkingSpace;
	}
}
