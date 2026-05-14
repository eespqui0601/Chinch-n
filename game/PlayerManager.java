package game;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerManager {
	
	private Scanner keyboard = new Scanner(System.in);
	private ArrayList<Human> humans;
	private ArrayList<Bot> bots;
	String nickname;
	
	/* Crea un player manager que permite controlar al jugador con un game manager */
	public PlayerManager(GameManager manager) {
		humans = new ArrayList<Human>(manager.getNumPlayers() - manager.getNumBots());
		bots = new ArrayList<Bot>(manager.getNumBots());
	}
	
	/* Crea a los jugadores
	 * @param manager es el controlador de la partida
	 * @return humans son el grupo de jugadores */
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
	
	/* Devuelve los jugadores humanos
	 * @return humans son los jugadores humanos */
	public ArrayList<Human> getHumans() {
		return humans;
	}
	
	/* Devuelve los jugadores que son bots
	 * @return bots son los jugadores que son bots */
	public ArrayList<Bot> getBots() {
		return bots;
	}

}