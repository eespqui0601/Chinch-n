package game;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
	
	private int number;
	private ArrayList<String> usedCards = new ArrayList<>();
	private ArrayList<Card> cards;
	private Random random = new Random();
	
	public Deck() {
        cards = new ArrayList<>();
        createDeck();
    }
	
	private void createDeck() { //Crea una baraja.
        for (Suit suit : Suit.values()) {
            for (Values value : Values.values()) {
                cards.add(new Card(value, suit));
            }
        }
    }
	
	public void showDeck() { //Muestra las cartas individualmente.
        for (Card card : cards) {
            System.out.println(card);
        }
    }
	
	public Card drawCard() {
		
		System.out.println("Robando carta... quedan: " + cards.size());
		
		if (cards.isEmpty()) {
			return null;
		}
		
		int position = random.nextInt(cards.size()); //Posición aleatoria de la baraja.
		
		return cards.remove(position); //Devuelve la carta y luego la elimina de la baraja.
	}

}