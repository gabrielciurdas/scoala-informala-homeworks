package ro.siit.java5.homework6;

public class Seniority {

	private byte[] seniorityList = new byte[40];
	private byte seniority;
	
	public Seniority() {
		fillSeniorityArray();
	}
	
	private void fillSeniorityArray() {
		for(byte i = 1; i < seniorityList.length; i++) {
			seniorityList[i] = i;
		}
	}
	public byte getSeniorityList(byte i) {
		return seniorityList[i];
	}

	/**
	 * @return the senyority
	 */
	public byte getSenyority() {
		return seniority;
	}

	/**
	 * @param senyority the senyority to set
	 */
	public void setSeniority(byte seniority) {
		this.seniority = seniority;
	}
	
	
}
