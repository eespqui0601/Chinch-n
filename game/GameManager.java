package game;

import java.util.ArrayList;
import java.util.Scanner;

public class GameManager {
	
	Scanner keyboard = new Scanner(System.in);
	
	private int numPlayers;
	private int numBots;
	private String userText;
	private boolean exit = false;
	
	ArrayList<Card> discards = new ArrayList<Card>();
	
	public GameManager(Deck deck) {
		Card firstCard = deck.drawCard();
		discards.add(firstCard);
	}
	
	public boolean startGame(String texto) {
		if(texto.equalsIgnoreCase("Y")) {
			while(!exit) {
				System.out.println("Seleccione el numero de jugadores (2-5)"); //Cambiar a switch case.
				userText = keyboard.nextLine();
				if (userText.equals("2")) {
					numPlayers = 2;
				}
				else if (userText.equals("3")) {
					numPlayers = 3;
				}
				else if (userText.equals("4")) {
					numPlayers = 4;
				}
				else if (userText.equals("5")) {
					numPlayers = 5;
				}
				System.out.println("Seleccione el numero de bots (0-5)"); //Cambiar a switch case.
				userText = keyboard.nextLine();
				if (userText.equals("0")) {
					numBots = 0;
					exit = true;
				}
				else if (userText.equals("1") && numPlayers >= 1) {
					numBots = 1;
					exit = true;
				}
				else if (userText.equals("2") && numPlayers >= 2) {
					numBots = 2;
					exit = true;
				}
				else if (userText.equals("3") && numPlayers >= 3) {
					numBots = 3;
					exit = true;
				}
				else if (userText.equals("4") && numPlayers >= 4) {
					numBots = 4;
					exit = true;
				}
				else if (userText.equals("5") && numPlayers == 5) {
					numBots = 5;
					exit = true;
				}
			}
			return true;
		}
		
		else if(texto.equalsIgnoreCase("N")) {
			System.out.println("Hasta la proxima partida.");
			return false;
		}
		else {
			System.out.println("Ha ocurrido un error inesperado.");
			return false;
		}
	}

	public int getNumPlayers() {
		return numPlayers;
	}

	public int getNumBots() {
		return numBots;
	}
	
	public Card makeDesition(String userText, Deck deck) {
		if (userText.equalsIgnoreCase("b")) {
			return deck.drawCard();
		}
		else if (userText.equalsIgnoreCase("d")) {
			return discards.removeLast();
		}
		else {
			return null;
		}
	}
	
	public void addToDiscards(Card discardCard) {
		System.out.println(discardCard);
		discards.add(discardCard);
	}
	
	public ArrayList<Card> getDiscards() {
		return discards;
	}

}