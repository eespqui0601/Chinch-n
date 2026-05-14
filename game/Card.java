package game;

public class Card {
	
	private Values number;
	private Suit simbol;
	
	public Card(Values number, Suit simbol) { //Constructor de carta.
		this.number = number;
		this.simbol = simbol;
	}

	public Values getValue() {
		return number;
	}

	public Suit getSimbol() {
		return simbol;
	}

	@Override
	public String toString() {
		return number.getSimbol() + simbol.getSimbol();
	}

}