package tictactoe;

import io.cucumber.java.ast.Cuando;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InitStepDefinitions {
	
	TaTeTi juego;
	
	@Dado("que la aplicación ha sido iniciada")
	public void que_la_aplicacion_ha_sido_iniciada() {
	    // Write code here that turns the phrase above into concrete actions
		juego = new TaTeTi();
	}

	@Cuando("se crea un nuevo juego")
	public void se_crea_un_nuevo_juego() {
	    // Write code here that turns the phrase above into concrete actions
		juego.iniciarJuego();
	}

	@Entonces("el tablero no tiene fichas")
	public void el_tablero_no_tiene_fichas() {
		assertTrue(juego.tableroVacio());
	}
	
	@Dado("hay un juego en curso")
	public void hay_un_juego_en_curso() {
		juego.iniciarJuego();
	}

	@Dado("es el turno del jugador {int}")
	public void es_el_turno_del_jugador(Integer player) {

	}

	@Dado("el jugador {int} juega con las {string}")
	public void el_jugador_juega_con_las_x(Integer player, String ficha) {

	}

	@Dado("no hay ficha en la posición \\({int},{int}\\)")
	public void no_hay_ficha_en_la_posición(int x, int y) {

	}

	@Cuando("el jugador {int} pone una ficha en la celda \\({int},{int}\\)")
	public void el_jugador_pone_una_ficha_en_la_celda(int x, int y) {
		//juego.colocarFichaEn(Ficha.X, x, y);
		juego.jugarEn(x, y);
	}

	@Entonces("el tablero tiene una {string} en la celda \\({int},{int}\\)")
	public void el_tablero_tiene_una_x_en_la_celda(String ficha, int x, int y) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	
	
	
	
}
