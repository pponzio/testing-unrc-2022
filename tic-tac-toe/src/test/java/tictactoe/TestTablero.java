package tictactoe;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestTablero {

	@Test
	void crearTableroInicial() {
		Tablero t = new Tablero();
		assertTrue(t.esVacio());
	}
	
	@Test
	void crearTableroNoVacio() {
		Tablero t = new Tablero();
		t.ponerFicha(Ficha.X, 1, 1);
		assertFalse(t.esVacio());
	}
	
	@Test
	void ponerFichaSobreFicha() {
		Tablero t = new Tablero();
		t.ponerFicha(Ficha.X, 1, 1);
		assertThrows(IllegalArgumentException.class, 
				()->t.ponerFicha(Ficha.O, 1, 1));
	}
	
	
}
