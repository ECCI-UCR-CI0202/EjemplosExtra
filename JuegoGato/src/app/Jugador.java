package app;
import java.util.Random;

/**
 * Esta clase representa un jugador del juego Gato
 * 
 * @author Rubén Jiménez Goñi
 */
public class Jugador {

	/**
	 * Tablero donde va a jugar el jugador
	 */
	private Tablero tablero;

	/**
	 * Ficha del jugador
	 */
	private char ficha;

	/**
	 * Objeto Random para escoger donde poner la ficha
	 */
	private Random r;

	/**
	 * Constructor del Jugador.
	 * 
	 * @param tablero
	 *            Tablero donde va a jugar el jugador
	 * @param ficha
	 *            Ficha que va a utilizar el jugador
	 */
	public Jugador(Tablero tablero, char ficha) {
		// Se asignan los parámetros que vienen de afuera
		this.tablero = tablero;
		this.ficha = ficha;
		// Se crea el objeto Random
		r = new Random();
	}

	/**
	 * Método que le permite al jugador poner una ficha en el tablero.
	 * 
	 * En esta implementación, el jugador juega con una estrategia aleatoria.
	 */
	public void decidir() {

		// Se escoge una posición (i, j) aleatoria
		int i = r.nextInt(3);
		int j = r.nextInt(3);

		// Si la posición obtenida no está vacía,
		while (tablero.get(i, j) != Tablero.VACIO) {
			// Entonces se genera una nueva posición (i, j) aleatoria
			i = r.nextInt(3);
			j = r.nextInt(3);
		}

		// Una vez que termina el while, podemos saber con certeza,
		// que la posición (i, j) se encuentra vacía
		// y se puede poner una ficha en esa posición
		tablero.ponerFicha(i, j, ficha);
	}

	/**
	 * Devuelve la ficha que el jugador utiliza para jugar
	 * 
	 * @return Ficha del jugador
	 */
	public char getFicha() {
		return ficha;
	}

}
