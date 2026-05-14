package game;

public enum Suit {
	
	ORO("🪙"),
	COPAS("🍷"),
	ESPADAS("⚔️"),
	BASTOS("🏑");

	private String simbol;
	
	/* Crea un palo a partir de un simbolo
	 * @param simbol */
	Suit(String simbol) {
		this.simbol = simbol;
	}
	
	/* Devuelve el simbolo
	 * @return simbol */
	public String getSimbol() {
		return simbol;
	}

}