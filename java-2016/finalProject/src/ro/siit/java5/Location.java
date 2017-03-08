package ro.siit.java5;

public enum Location {
	BAIA_MARE(150),
	BUCURESTI(449),
	BISTRITA(108),
	BRASOV(273),
	CONSTANTA(684),
	DEVA(167),
	IASI(391),
	ORADEA(157),
	SUCEAVA(308),
	TIMISOARA(316);
	
	private int distanceFromCluj = 0;
	
	private Location(int distanceFromCluj) {
		this.distanceFromCluj = distanceFromCluj;
	}
	
	public int getDistanceToTarget() {
		return distanceFromCluj;
	}
}
