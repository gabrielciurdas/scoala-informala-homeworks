package ro.siit.java5.homework6;

public class ParkingSpace {
	
	private int parkingSpace = 1;
	//private String noParkingSpace = null;
	
	/*public ParkingSpace(int parkingSpace) {
		this.parkingSpace = parkingSpace;
	}*/
	/*
	public ParkingSpace(String noParkingSpace) {
		this.noParkingSpace = noParkingSpace;
	}*/
	
	public void setParkingSpace() {
		parkingSpace = getParkingSpace();
		parkingSpace++;
	}
	public int getParkingSpace() {
		return parkingSpace;
	}
}
