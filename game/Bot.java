package game;

import java.util.ArrayList;
import java.util.Comparator;

public class Bot extends Player{
	
	private String botText;
	private int botNumber;
	
	/* Crea un nuevo Bot con un nickname y un estado.
	 * @param nickname2 nombre del Bot 
	 * @param state es el estado y sirve para determinar si esta jugando o ha sido eliminado */
	public Bot(String nickname2, PlayerState state) {
		super(nickname2, state);
	}
	
	/* Devuelve el texto introducido por el bot 
	 * @returns botText introducido por el bot */
	public String getBotText() {
		return botText;
	}
	
	/* Devuelve el numero introducido por el bot
	 * @returns botNumber introducido por el bot */
	public int getBotNumber() {
		return botNumber;
	}
	
	/* Permite al bot decidir si quiere robar del la baraja o del mazo de descartes
	 * @param discard es la ultima carta del mazo de descartes */
	public void botDesition(Card discard) {
		boolean markDiscard = false; //Lo utilizaremos para marcar que hemos encontrado una combinacion y que vamos a robar del mazo de descartes. 
		
		for (Card card : hand) {
			
			if (card.getValue().getNumber() == discard.getValue().getNumber()) {
				markDiscard = true;
			}
			
			else if (card.getSimbol().equals(discard.getSimbol())) {
				if (card.getValue().getNumber() == discard.getValue().getNumber() - 1 || card.getValue().getNumber() == discard.getValue().getNumber() + 1) {
					markDiscard = true;
				}
			}
			
		}
		
		if (markDiscard) {
			botText = "d";
		}
		else {
			botText = "b";
		}
	}
	
	/* Permite al bot decidir que carta quiere descartar segun las combinaciones y el valor de laas cartas */
	public void botDesition2() {
		
		int discardNumber = 0;
		
		ArrayList<Integer> combinedCards = new ArrayList<Integer>();
		ArrayList<Integer> notCombinedCards = new ArrayList<Integer>();
			
		ArrayList<Integer> checkedNumbers = new ArrayList<Integer>();
		for (int i = 0; i < hand.size(); i++) {
			int count = 1;
			
			if (!checkedNumbers.contains(hand.get(i).getValue().getNumber())) { //Si el numero no ha salido antes.
				checkedNumbers.add(hand.get(i).getValue().getNumber());
				
				for (int j = i + 1; j < hand.size(); j++) { //Recorre otra vez la mano.
					if (hand.get(i).getValue().getNumber() == hand.get(j).getValue().getNumber()) { //Comprueba si hay alguna carta con el numero i.
						count++; //Añade el numero de cartas que encuentra con ese numero al contador. 
					}
				}
				
				if (count >= 3) { //Si hay tres o mas. 
					if (!combinedCards.contains(i)) {
						combinedCards.add(i);
					}
				}
				
			}
		}
		
		ArrayList<Card> currentStair = new ArrayList<Card>();
		ArrayList<Card> sortedHand = new ArrayList<Card>();
		
		for (Card card : hand) {
			sortedHand.add(card);
		}
		
		sortedHand.sort(Comparator.comparing(Card :: getSimbol).thenComparing(Card :: getValue));
			
		for (int i = 0; i < hand.size(); i++) {
			if (currentStair.isEmpty()) { //Añade la primera carta de la escalera que vamos a comprobar a la lista de escaleras. 
				currentStair.add(sortedHand.get(i));
			}
			else {
				if (sortedHand.get(i).getSimbol().equals(sortedHand.get(i - 1).getSimbol())) { //Comprueba que la carta actual y la anterior sean del mismo palo
					if (sortedHand.get(i).getValue().getNumber() == (sortedHand.get(i - 1).getValue().getNumber() + 1)) { //Comprueba que la carta anterior sea parte de la escalera. 
						currentStair.add(sortedHand.get(i)); //La añade a la lista de escaleras.
					}
					else {
						if (currentStair.size() >= 3) { //Guarda la escalera actual en una lista
							if (!combinedCards.contains(i)) {
								combinedCards.add(i);
							}
						}
						
						currentStair.clear();
						currentStair.add(sortedHand.get(i));
					}
				}
				else {
					if (currentStair.size() >= 3) { //Igual que antes. 
						if (!combinedCards.contains(i)) {
							combinedCards.add(i);
						}
					}
					
					currentStair.clear();
					currentStair.add(sortedHand.get(i));
				}
			}
		}
		
		for (int i = 0; i < sortedHand.size(); i++) {
			if (!combinedCards.contains(i)) {
				for (int j = 0; j < hand.size(); j++) {
					if (hand.get(j).equals(sortedHand.get(i))) {
						notCombinedCards.add(j);
					}
				}
			}
		}
		
		int lastCard = 0;
		
		for (int i = 0; i < notCombinedCards.size(); i++) {
			if (hand.get(notCombinedCards.get(i)).getValue().getNumber() > lastCard) {
				lastCard = hand.get(notCombinedCards.get(i)).getValue().getNumber();
				discardNumber = notCombinedCards.get(i);
			}
		}
		
		botNumber = discardNumber; 
	} 

}