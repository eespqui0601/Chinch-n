package game.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import game.Card;
import game.Deck;
import game.Game;
import game.GameManager;
import game.PlayerManager;

class test {

	@Test
	void testRobo() { // Es de caja blanca ya que para hacer esta prueba hay que saber sobre el código interno, ademas utiliza un bucle.
		Game game = new Game();
		Deck deck = new Deck();
		GameManager manager = new GameManager(deck);
		PlayerManager pmanager = new PlayerManager(manager);
		pmanager.createPalyers(manager);
		
		for (int i = 0; i < pmanager.getHumans().size(); i++) {
			pmanager.getHumans().get(0).getFirstCards(deck);
			System.out.println(pmanager.getHumans().get(i).getHand());
			int longitud = pmanager.getHumans().get(i).getHand().size();
			assertEquals(7, longitud);
		}
	}
	
	@Test
	void testRobarCarta() { // Es de caja negra por que comprueba si se roban cartas adecuadamente o no sin necesidad de saber del código.
		Deck deck = new Deck();
		
		Card card = deck.drawCard();
		assertNotNull(card);
	}
}
