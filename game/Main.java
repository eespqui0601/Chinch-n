package game;

import java.util.Scanner;

public class Main {
	public void main() {
		
		Scanner keyboard = new Scanner(System.in);
		
		String userText;
		String botText;
		int userNumber;
		int botNumber;
		int roundNumber = 1;
		
		int numPlayers;
		int numBots;
		int puntuacion;
		boolean finish = false;
		boolean win = false;
		
		Game game = new Game();
		Deck deck = new Deck();
		GameManager manager = new GameManager(deck);
		Card drawncard;
		
		//Inicia el juego.
		game.start();
		userText = keyboard.nextLine();
		manager.startGame(userText);
		
		//Crear jugadores.
		PlayerManager pmanager = new PlayerManager(manager);
		pmanager.createPalyers(manager);
		System.out.println("Numero de humanos que van a jugar: " + pmanager.getHumans().size());
		System.out.println("Numero de bots que van a jugar: " + pmanager.getBots().size());
		
		//Primeras cartas.
		for (int i = 0; i < pmanager.getHumans().size(); i++) {
		    pmanager.getHumans().get(i).getFirstCards(deck);
		    pmanager.getBots().get(i).getFirstCards(deck);
		}
		
		//Rondas de los jugadores humanos primero.
		while(!finish) {
			while(!win) {
				for (int i = 0; i < pmanager.getHumans().size(); i++) {
					game.rounds(pmanager.getHumans().get(i).getNickname());
					game.desition();
					System.out.println(pmanager.getHumans().get(i).getHand());
					System.out.println(manager.getDiscards());
					userText = keyboard.nextLine();
					drawncard = manager.makeDesition(userText, deck);
					System.out.println("--------------------");
					System.out.println(drawncard);
					pmanager.getHumans().get(i).receiveCard(drawncard);
					System.out.println(pmanager.getHumans().get(i).getHand());
					game.desition2();
					userNumber = keyboard.nextInt();
					manager.addToDiscards(pmanager.getHumans().get(i).discardCard(userNumber));
					keyboard.nextLine();
					pmanager.getHumans().get(i).calculatePoints(roundNumber);
				}
				for (int i = 0; i < pmanager.getBots().size(); i++) {
					game.rounds(pmanager.getBots().get(i).getNickname());
					game.desition();
					System.out.println(pmanager.getBots().get(i).getHand());
					System.out.println(manager.getDiscards());
					pmanager.getBots().get(i).botDesition(manager.getDiscards().getLast());
					botText = pmanager.getBots().get(i).getBotText();
					drawncard = manager.makeDesition(botText, deck);
					System.out.println("--------------------");
					System.out.println(drawncard);
					pmanager.getBots().get(i).receiveCard(drawncard);
					System.out.println(pmanager.getBots().get(i).getHand());
					game.desition2();
					pmanager.getBots().get(i).botDesition2();
					botNumber = pmanager.getBots().get(i).getBotNumber();
					manager.addToDiscards(pmanager.getBots().get(i).discardCard(botNumber));
					pmanager.getBots().get(i).calculatePoints(roundNumber);
				}
				
				for (int i = 0; i < pmanager.getHumans().size(); i++) {
					if (pmanager.getHumans().get(i).getCombinations() >= 2) {
						System.out.println(pmanager.getHumans().get(i).getNickname() + " closes");
						manager.discards.clear();
						for (int j = 0; j < pmanager.getHumans().size(); j++) {
							pmanager.getHumans().get(j).hand.clear();
						}
						for (int j = 0; j < pmanager.getBots().size(); j++) {
							pmanager.getBots().get(j).hand.clear();
						}
						win = true;
					}
				}
				for (int i = 0; i < pmanager.getBots().size(); i++) {
					if (pmanager.getBots().get(i).getCombinations() >= 2) {
						System.out.println(pmanager.getBots().get(i).getNickname() + " closes");
						manager.discards.clear();
						for (int j = 0; j < pmanager.getHumans().size(); j++) {
							pmanager.getHumans().get(j).hand.clear();
							
						}
						for (int j = 0; j < pmanager.getBots().size(); j++) {
							pmanager.getBots().get(j).hand.clear();
						}
						win = true;
					}
				}
				
				if (!win) {
					roundNumber++;
				}
				
				for (int i = 0; i < pmanager.getHumans().size(); i++) {
					if (pmanager.getHumans().get(i).getPoints() >= 100) {
						finish = true;
					}
					else {
						win = false;
					}
				}
				for (int i = 0; i < pmanager.getBots().size(); i++) {
					if ( pmanager.getBots().get(i).getPoints() >= 100) {
						finish = true;
					}
					else {
						win = false;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		new Main().main();
	}
}