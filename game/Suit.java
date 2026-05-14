package game;

public enum Suit {
	
	ORO("🪙"),
	COPAS("🍷"),
	ESPADAS("⚔️"),
	BASTOS("🏑");

	private String simbol;
	
	Suit(String simbol) {
		this.simbol = simbol;
	}

	public String getSimbol() {
		return simbol;
	}

}