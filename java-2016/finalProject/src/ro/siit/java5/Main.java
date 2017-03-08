package ro.siit.java5;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		
		List<Package> packsToBaiaMare = new ArrayList<>();
		packsToBaiaMare.add(new Package(Location.BAIA_MARE, 130.55, "13/3/2017"));
		packsToBaiaMare.add(new Package(Location.BAIA_MARE, 202.99, "13/3/2017"));
		packsToBaiaMare.add(new Package(Location.BAIA_MARE, 87.99, "13/3/2017"));
		packsToBaiaMare.add(new Package(Location.BAIA_MARE, 335.99, "13/3/2017"));
		
		List<Package> packsToBucuresti = new ArrayList<>();
		packsToBucuresti.add(new Package(Location.BUCURESTI, 330.50," 13/3/2017"));
		packsToBucuresti.add(new Package(Location.BUCURESTI, 55.50," 13/3/2017"));
		packsToBucuresti.add(new Package(Location.BUCURESTI, 127," 13/3/2017"));
		packsToBucuresti.add(new Package(Location.BUCURESTI, 456.50," 13/3/2017"));
		
		List<Package> packsToBistrita = new ArrayList<>();
		packsToBistrita.add(new Package(Location.BISTRITA, 225.50," 14/3/2017"));
		packsToBistrita.add(new Package(Location.BISTRITA, 77.60," 14/3/2017"));
		packsToBistrita.add(new Package(Location.BISTRITA, 327," 14/3/2017"));
		packsToBistrita.add(new Package(Location.BISTRITA, 390.50," 14/3/2017"));
		
		List<DeliveryThread> deliveryThreads = new ArrayList<>();
		deliveryThreads.add(new DeliveryThread(packsToBaiaMare, Location.BAIA_MARE.getDistanceToTarget()));
		deliveryThreads.add(new DeliveryThread(packsToBucuresti, Location.BUCURESTI.getDistanceToTarget()));
		deliveryThreads.add(new DeliveryThread(packsToBistrita, Location.BISTRITA.getDistanceToTarget()));
		
		for(DeliveryThread d: deliveryThreads) {
			d.start();
			try {
				TimeUnit.SECONDS.sleep(d.getDistanceToTarget());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(d.getDistanceToTarget() + d.toString());
		}

	}
}
