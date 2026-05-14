package game;

public class Game {
	
	private int counter = 1;
	
	public void start() {
		System.out.println("----------ChinChón----------");
		System.out.println("Para comenzar pulse Y");
		System.out.println("Para finalizar el juego pulse N");
	}
	
	public void rounds(String nickname) {
		System.out.println("-----------------------------");
		counter++;
		System.out.println("Empieza el Jugador: " + nickname);
	}
	
	public void desition() {
		System.out.println("¿Que vas a hacer?");
		System.out.println("Para robar de la baraja introduce B");
		System.out.println("Para robar de la baraja de descartes introduce D");
	}
	
	public void desition2() {
		System.out.println("¿Cual carta quieres descartar?");
		System.out.println("(Introduzca el numero de la carta)");
	}
}