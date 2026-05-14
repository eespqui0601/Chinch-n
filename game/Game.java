package game;

public class Game {
	
	private int counter = 1;
	
	/* Imprime por la consola el inicio de la partida */
	public void start() {
		System.out.println("----------ChinChón----------");
		System.out.println("Para comenzar pulse Y");
		System.out.println("Para finalizar el juego pulse N");
	}
	
	/* Imprime por la consola de quien es el turno
	 * @param nickname del jugador */
	public void rounds(String nickname) {
		System.out.println("-----------------------------");
		counter++;
		System.out.println("Empieza el Jugador: " + nickname);
	}
	
	/* Imprime por la pantalla el mensaje para decidir de donde robar */
	public void desition() {
		System.out.println("¿Que vas a hacer?");
		System.out.println("Para robar de la baraja introduce B");
		System.out.println("Para robar de la baraja de descartes introduce D");
	}
	
	/* Imprime por la pantalla el mensaje para decidir que carta descartar */
	public void desition2() {
		System.out.println("¿Cual carta quieres descartar?");
		System.out.println("(Introduzca el numero de la carta)");
	}
}