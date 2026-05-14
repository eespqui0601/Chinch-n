package game;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerManager {
	
	private Scanner keyboard = new Scanner(System.in);
	private ArrayList<Human> humans;
	private ArrayList<Bot> bots;
	String nickname;
	
	public PlayerManager(GameManager manager) {
		humans = new ArrayList<Human>(manager.getNumPlayers() - manager.getNumBots());
		bots = new ArrayList<Bot>(manager.getNumBots());
	}
	
	public void createPalyers(GameManager manager) {
		for (int i = 0; i < manager.getNumPlayers() - manager.getNumBots(); i++) { //Crea humanos.
			System.out.println("Introduzca su nombre jugador" + (i + 1) + ": ");
			nickname = keyboard.nextLine();
			humans.add(new Human(nickname, PlayerState.PLAYING));
		}
		
		for (int i = 0; i < manager.getNumBots(); i++) { //Crea bots.
			bots.add(new Bot("bot" + i, PlayerState.PLAYING));
		}
	}

	public ArrayList<Human> getHumans() {
		return humans;
	}

	public ArrayList<Bot> getBots() {
		return bots;
	}

}