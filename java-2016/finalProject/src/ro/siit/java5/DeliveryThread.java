package ro.siit.java5;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class DeliveryThread extends Thread {
	private double merchandiseValue = 0;
	private double profit = 0;
	private int distanceToTarget = 0;
	private List<Package> packs;

	public DeliveryThread(List<Package> packs, int distanceToTarget) {
		this.distanceToTarget = distanceToTarget;
		this.packs = packs;
	}

	public void run() {
		System.out.println(packs.get(0).getTargetLocation().name() + " package delivery started");
		try {
			TimeUnit.SECONDS.sleep(distanceToTarget);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		calculateMerchandiseValue(packs);
		calculateTotalProfit(packs);
		System.out.println(toString());
	}

	private void calculateTotalProfit(List<Package> packs) {
		ProfitCalculator pc = new ProfitCalculator();
		for (Package p : packs) {
			profit += pc.calculateProfit(p);
		}
	}

	private void calculateMerchandiseValue(List<Package> packs) {
		for (Package p : packs) {
			merchandiseValue += p.getMerchandiseValue();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return packs.get(0).getTargetLocation().name() + " DeliveryThread [merchandiseValue=" + merchandiseValue
				+ ", profit=" + profit + "]" + " completed";
	}

	public int getDistanceToTarget() {
		return distanceToTarget;
	}

	public List<Package> getPacks() {
		return packs;
	}
}
