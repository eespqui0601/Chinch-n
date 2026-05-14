package game;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private int number;
	private ArrayList<String> usedCards = new ArrayList<>();
	private ArrayList<Card> cards;
	private Random random = new Random();
	
	/* Crea una baraja */
	public Deck() {
        cards = new ArrayList<>();
        createDeck();
    }
	
	/* Crea la baraja para pasarla luego al constructor */
	private void createDeck() { //Crea una baraja.
        for (Suit suit : Suit.values()) {
            for (Values value : Values.values()) {
                cards.add(new Card(value, suit));
            }
        }
    }
	
	/* Muestra la baraja */
	public void showDeck() { //Muestra las cartas individualmente.
        for (Card card : cards) {
            System.out.println(card);
        }
    }
	
	/* Permite robar cartas de la baraja
	 * @return devuelve la carta para luego eliminarla de la baraja */
	public Card drawCard() {
		
		System.out.println("Robando carta... quedan: " + cards.size());
		
		if (cards.isEmpty()) {
			return null;
		}
		
		int position = random.nextInt(cards.size()); //Posición aleatoria de la baraja.
		
		return cards.remove(position); //Devuelve la carta y luego la elimina de la baraja.
	}

}