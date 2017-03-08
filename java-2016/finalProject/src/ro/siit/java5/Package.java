package ro.siit.java5;

import java.util.Calendar;
import java.util.Comparator;

public class Package implements Comparator<Package> {
	private Location targetLocation;
	private Integer distanceInKm = 0;
	private double merchandiseValue = 0;
	private String deliveryDate = "";

	public Package(Location targetLocation, double merchandiseValue, String deliveryDate) {
		super();
		this.targetLocation = targetLocation;
		distanceInKm = targetLocation.getDistanceToTarget();
		this.merchandiseValue = merchandiseValue;
		this.deliveryDate = deliveryDate;
	}

	@Override
	public String toString() {
		return "Package [targetLocation=" + targetLocation + ", distanceInKm=" + distanceInKm + ", merchandiseValue="
				+ merchandiseValue + ", deliveryDate=" + deliveryDate + "]";
	}

	/**
	 * @return the targetLocation
	 */
	public Location getTargetLocation() {
		return targetLocation;
	}

	/**
	 * @return the distanceInKm
	 */
	public int getDistanceInKm() {
		return distanceInKm;
	}

	/**
	 * @return the merchandiseValue
	 */
	public double getMerchandiseValue() {
		return merchandiseValue;
	}

	/**
	 * @return the deliveryDate
	 */
	public String getDeliveryDate() {
		return deliveryDate;
	}

	@Override
	public int compare(Package p1, Package p2) {
		int value1 = p1.targetLocation.compareTo(p2.targetLocation);
		if (value1 == 0) {
			int value2 = p1.distanceInKm.compareTo(p2.distanceInKm);
			return value2;
		}
		return value1;
	}
}
