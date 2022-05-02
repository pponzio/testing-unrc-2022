package tictactoe;

public class Tablero {
	
	Ficha[][] tablero = new Ficha[3][3];
	private int fichas = 0;

	public boolean esVacio() {
		return fichas == 0;
	}

	public void ponerFicha(Ficha x, int i, int j) {
		if (tablero[i][j] != null)
			throw new IllegalArgumentException(
					String.format("Poniendo %s en posicion (%d, %d) "
							+ "que esta ocupada con %s", 
							x, i, j, tablero[i][j]));
		
		tablero[i][j] = x;
		fichas++;
	}

}
