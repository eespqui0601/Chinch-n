package game;

import java.util.ArrayList;
import java.util.Comparator;

public class Player {
	
	private PlayerState state;
	protected String nickname;
	private int points;
	private int roundPoints;
	private int combinations;
	protected ArrayList<Card> hand = new ArrayList<Card>();
	
	/* Crea un jugador con su nombre y estado
	 * @param nickname es el nombre del jugador
	 * @param state es el estado del jugador */
	public Player(String nickname, PlayerState state) {
		this.nickname = nickname;
		this.state = state;
	}

	/* Devuelve el nombre del jugador
	 * @return nickname */
	public String getNickname() {
		return nickname;
	}
	
	//---------------Cartas---------------//
	
	/* Permite que el jugador reciva una carta
	 * @param card es la carta que va a recibir */
	public void receiveCard(Card card) {
		if (card != null) {
			hand.add(card);
		}
	}
	
	/* Reparte las primeras 7 cartas
	 * @param deck es la baraja */
	public void getFirstCards(Deck deck) {
		for (int i = 0; i < 7; i++) {
			receiveCard(deck.drawCard());
		}
	}
	
	/* Permite descartar una carta de la mano del jugador
	 * @param userNumber es el numero introducido por el usuario
	 * @return la carta que va a descartar y la elimina de la mano del jugador */
	public Card discardCard(int userNumber) {
		if(userNumber - 1 == 0) {
			return hand.remove(0);
		}
		else if(userNumber - 1 == 1) {
			return hand.remove(1);
		}
		else if(userNumber - 1 == 2) {
			return hand.remove(2);
		}
		else if(userNumber - 1 == 3) {
			return hand.remove(3);
		}
		else if(userNumber - 1 == 4) {
			return hand.remove(4);
		}
		else if(userNumber - 1 == 5) {
			return hand.remove(5);
		}
		else if(userNumber - 1 == 6) {
			return hand.remove(6);
		}
		else if(userNumber - 1 == 7) {
			return hand.remove(7);
		}
		else {
			System.out.println("ERROR: Se descartara la primera carta");
			return hand.remove(0);
		}
	}
	
	/* Devuelve la mano del jugador
	 * @return hand es la mano del jugador */
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	//---------------Puntuación---------------//
	
	/* Devuelve los puntos totales del jugador
	 * @return points son los puntos totales */
	public int getPoints() {
		return points;
	}
	
	/* Devuelve el numero de combinaciones que tiene el jugador
	 * @return combinations es el numero de combinaciones */
	public int getCombinations() {
		return combinations;
	}
	
	/* Permite reestablecer el numero de combinaciones que tiene el jugador
	 * @param combinations es el numero de combinaciones */
	public void setCombinations(int combinations) {
		this.combinations = combinations;
	}

	/* Cuenta los puntos de las combinaciones de grupos 
	 * Deben de ser de tres o más cartas para contar como combinación
	 * @return minusThreePoints es el numero de puntos total de todos los grupos */
	public int markGroupsOfThree() { 
		int minusThreePoints = 0;
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
					minusThreePoints += count * hand.get(i).getValue().getNumber(); //Multiplica el numero por el numero de veces que lo ha encontrado antes. 
					combinations++;
				}
				
			}
		}
		return minusThreePoints;
	}
	
	/* Cuenta los puntos de todas las combinaciones de escaleras
	 * Deben de estar formadas por tres o mas cartas para contar como combinación
	 * @return minusStairPoints son los puntos totales de las combinaciones de escaleras encontradas */
	public int markGroupsOfStairs() { 
		int minusStairPoints = 0; 
		ArrayList<Card> currentStair = new ArrayList<Card>();
		ArrayList<Card> sortedHand = new ArrayList<Card>();
		
		for (Card card : hand) {
			sortedHand.add(card);
		}
		
		sortedHand.sort(Comparator.comparing(Card :: getSimbol).thenComparing(Card :: getValue));
		
		for (int i = 0; i < hand.size(); i++) {
			if (currentStair.isEmpty()) { //Añade la primera carta de la escalera que vamos a comprobar a la lista de escaleras. 
				currentStair.add(hand.get(i));
			}
			else {
				if (hand.get(i).getSimbol().equals(hand.get(i - 1).getSimbol())) { //Comprueba que la carta actual y la anterior sean del mismo palo
					if (hand.get(i).getValue().getNumber() == (hand.get(i - 1).getValue().getNumber() + 1)) { //Comprueba que la carta anterior sea parte de la escalera. 
						currentStair.add(hand.get(i)); //La ñade a la lista de escaleras.
					}
					else {
						if (currentStair.size() >= 3) { //Cuenta los puntos dentro de cada escalera para luego pasar a la siguiente. 
							for (Card card : currentStair) {
								minusStairPoints += card.getValue().getNumber();
								combinations++;
							}
						}
						
						currentStair.clear();
						currentStair.add(hand.get(i));
					}
				}
				else {
					if (currentStair.size() >= 3) { //Igual que antes. 
						for (Card card : currentStair) {
							minusStairPoints += card.getValue().getNumber();
							combinations++;
						}
					}
					
					currentStair.clear();
					currentStair.add(hand.get(i));
				}
			}
		}
		if (currentStair.size() >= 3) { //Sirve para contar la ultima escalera que no se cierra.
			for (Card card : currentStair) {
				minusStairPoints += card.getValue().getNumber(); //Añade el valor de las cartas.
			}
		}
		
		return minusStairPoints;
	}
	
	/* Comprueba si el jugador tiene o no Chinchón
	 * @return boolean */
	public boolean hasChinChón() { 
		ArrayList<Card> currentStair = new ArrayList<>();
		ArrayList<Card> largestStair = new ArrayList<>();
		ArrayList<Card> sortedHand = new ArrayList<Card>();
		
		for (Card card : hand) {
			sortedHand.add(card);
		}
		
		sortedHand.sort(Comparator.comparing(Card :: getSimbol).thenComparing(Card :: getValue));
		
		for (int i = 0; i < hand.size(); i++) {
			if (currentStair.isEmpty()) { //Añade la primera carta de la escalera que vamos a comprobar a la lista de escaleras. 
				currentStair.add(hand.get(i));
			}
			else {
				if (hand.get(i).getSimbol().equals(hand.get(i - 1).getSimbol())) { //Comprueba que la carta actual y la anterior sean del mismo palo
					if (hand.get(i).getValue().getNumber() == (hand.get(i - 1).getValue().getNumber() + 1)) { //Comprueba que la carta anterior sea parte de la escalera. 
						currentStair.add(hand.get(i)); //La ñade a la lista de escaleras.
					}
					else {
						if (currentStair.size() >= 3) { //Comprueba que sea escalera valida.
							if (currentStair.size() > largestStair.size()) { //Si encuentra una escalera mayor que la anterior.
								largestStair.clear(); //Vacia la lista anterior.
								for (Card card : currentStair) { //Recorre la escalera acutal.
									largestStair.add(card); //La guarda carta por carta en la lista de la escalera más grande. 
								}
							}
						}
						
						currentStair.clear();
						currentStair.add(hand.get(i));
					}
				}
				else {
					if (currentStair.size() >= 3) { //Igual que antes. 
						if (currentStair.size() > largestStair.size()) {
							largestStair.clear(); 
							for (Card card : currentStair) { 
								largestStair.add(card); 
							}
						}
					}
					
					currentStair.clear();
					currentStair.add(hand.get(i));
				}
			}
		}
		if (currentStair.size() >= 3) { //Sirve para tener en cuenta la ultima escalera que no se cierra.
			if (currentStair.size() > largestStair.size()) {
				largestStair.clear(); 
				for (Card card : currentStair) { 
					largestStair.add(card); 
				}
			}
		}
		
		if (largestStair.size() == 7) { //Si la escalera mas grande que se ha encontrado es de 7 entonces es un Chinchón.
			return true; //Devuelve que si hay Chinchón. 
		}
		else {
			return false; //Devulve que no hay Chinchón.
		}
	}
	
	/* Calcula el total de puntos de la ronda
	 * @param roundNumber es el numero de la ronda actual */
	public void calculatePoints(int roundNumber) {
		roundPoints = 0;
		combinations = 0;
		int lastRoundNumber = 1;
		if (roundNumber == lastRoundNumber) {
			points = 0;
		}
		
		boolean chinchón = hasChinChón();
		int minusThreePoints;
		int minusStairPoints;
		
		if (chinchón) {
			roundPoints += -10;
			combinations = 2;
		}
		else {
			for (Card card : hand) {
				roundPoints += card.getValue().getNumber(); //Suma a los puntos el valor de las cartas en la mano.
			}
			
			minusThreePoints = markGroupsOfThree(); //Calcula la puntuación de las combinaciones de grupos.
			minusStairPoints = markGroupsOfStairs(); //Calcula la puntuación de las combinaciones de escaleras.
			roundPoints = roundPoints - minusThreePoints; //Le resta las combinaciones de grupos al total de puntos.
			roundPoints = roundPoints - minusStairPoints; //Le resta las combinaciones de escaleraas al total de puntos. 
		}
		
		lastRoundNumber = roundNumber;
		System.out.println(roundPoints); //Muestra por consola los puntos totales de cada jugador. 
		points += roundPoints;
	}

}