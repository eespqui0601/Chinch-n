package game;

public enum Values {
	
	UNO("1", 1),
	DOS("2", 2), 
	TRES("3", 3), 
	CUATRO("4", 4), 
	CINCO("5", 5), 
	SEIS("6", 6), 
	SIETE("7", 7), 
	SOTA("10", 10), 
	CABALLO("11", 11), 
	REY("12", 12);
	
	private int number;
	private String simbol;
	
	Values(String simbol, int number) {
		this.simbol = simbol;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public String getSimbol() {
		return simbol;
	}

}