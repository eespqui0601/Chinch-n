package game;

public class Card {
	
	private Values number;
	private Suit simbol;
	
	/* Crea una carta con un valor y un palo
	 * @param number es el numero de la carta
	 * @param simbol es el palo de la carta */
	public Card(Values number, Suit simbol) { //Constructor de carta.
		this.number = number;
		this.simbol = simbol;
	}

	/* Devuelve number que es el valor de la carta
	 * @returns number */
	public Values getValue() {
		return number;
	}

	/* Devuelve simbol que es el palo de la carta
	 * @returns simbol */
	public Suit getSimbol() {
		return simbol;
	}
	
	/* Devuelve el objeto en String
	 * @returns cadena de texto */
	@Override
	public String toString() {
		return number.getSimbol() + simbol.getSimbol();
	}

}