package app;
/**
 * 
 * Esta es la clase Tablero que contiene todos los elementos básicos para
 * simular un juego de Gato entre 2 jugadores.
 * 
 * @author Rubén Jiménez Goñi
 */
public class Tablero {

	/**
	 * Constante que contiene los valores de las fichas de los jugadores
	 * 
	 * Como se declara final, su valor no puede ser modificado en tiempo de
	 * ejecución. Sin embargo, puede ser modificado antes de ejecutar el
	 * programa. De ser hecho esto, se podrá observar el cambio cuando se
	 * ejecute el programa
	 *
	 * Las constantes, declaradas como static final, deben tener el nombre
	 * completamente en mayúsculas
	 */
	public static final char FICHAS[] = { 'X', 'O' };

	/**
	 * Constante que contiene el valor de los espacios vacíos en el tablero
	 */
	public static final char VACIO = '-';

	/**
	 * Vector de jugadores del juego
	 */
	private Jugador jugadores[];

	/**
	 * Matriz en la cual juegan los jugadores
	 */
	private char tablero[][];

	/**
	 * Constructor de la clase Tablero. Crea el vector con 2 jugadores y un
	 * tablero de 3x3.
	 */
	public Tablero() {

		// Se inicializa el atributo jugadores
		this.jugadores = new Jugador[2];

		// NOTA!
		// Como es un vector de objetos y el vector se inicializa
		// con el valor por defecto del tipo de dato, entonces
		// se crea un vector de 2, pero en cada posición contiene
		// un null.

		// Se inicializa cada posición del vector
		for (int i = 0; i < jugadores.length; i++) {
			// Se llama al constructor de Jugador que recibe un Tablero
			// y la ficha con la cual el jugador juega.
			this.jugadores[i] = new Jugador(this, FICHAS[i]);
		}

		// Se crea el tablero de fichas
		tablero = new char[3][3];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				// Se inicializan todas las posiciones del tablero
				// con la ficha que equivale a VACIO.
				tablero[i][j] = VACIO;
			}
		}
	}

	/**
	 * Devuelve el contenido de una posición del tablero.
	 * 
	 * @param i
	 *            Fila en la cual se encuentra la ficha
	 * @param j
	 *            Columna en la cual se encuentra la ficha
	 * @return La ficha que se encuentra en tablero[i][j]
	 */
	public char get(int i, int j) {
		return tablero[i][j];
	}

	/**
	 * Permite poner una ficha en una posición del tablero.
	 * 
	 * @param i
	 *            Fila en la cual se quiere poner la ficha
	 * @param j
	 *            Columna en la cual se quiere poner la ficha
	 * @param c
	 *            Ficha que se quiere poner
	 */
	public void ponerFicha(int i, int j, char c) {
		tablero[i][j] = c;
	}

	/**
	 * Permite comprobar si la ficha c ha ganado el juego.
	 * 
	 * @param c
	 *            Ficha que se desea saber si ganó el juego
	 * @return True - si la ficha c es ganadora en el estado actual del tablero,
	 *         False - en caso contrario
	 */
	public boolean ganador(char c) {

		// Se asume que no hay ganador
		boolean ganador = false;

		// Se recorre toda la matriz, de izquierda a derecha
		// y de arriba a abajo
		for (int i = 0; i < tablero.length; i++) { // Recorre filas

			// Por cada fila se crea un contador en 0
			int k = 0;

			// Se recorren todas las columnas de la fila
			for (int j = 0; j < tablero[i].length; j++) { // Recorre columnas
				if (tablero[i][j] == c) {
					// Por cada elemento igual a c
					// se aumenta el contador k en 1
					++k;
				}
			}

			// Si k == 3 da true, entonces se almacena en la variable ganador
			ganador = ganador || k == 3;

			// NOTA!
			// La parte "ganador ||" permite acarrear cualquier true que hubiera
			// antes
			// si k == 3 da falso, pero en algún momento anterior dio true
		}

		// Se recorre toda la matriz, de arriba a abajo
		// y de izquierda a derecha
		for (int j = 0; j < tablero[0].length; j++) { // Recorre columnas

			// Por cada columna se crea un contador en 0
			int k = 0;

			// Se recorren todas las filas de la columna
			for (int i = 0; i < tablero.length; i++) { // Recorre filas
				if (tablero[i][j] == c) {
					// Por cada elemento igual a c
					// se aumenta el contador k en 1
					++k;
				}
			}

			// Si k == 3 da true, entonces se almacena en la variable ganador
			ganador = ganador || k == 3;

			// NOTA!
			// La parte "ganador ||" permite acarrear cualquier true que hubiera
			// antes
			// si k == 3 da falso, pero en algún momento anterior dio true
		}

		// Se cuentan los elementos iguales en la diagonal A
		int dA = 0;
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i][i] == c) {
				dA++;
			}
		}

		// Se cuentan los elemntos iguales en la diagonal B
		int dB = 0;
		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i][tablero.length - i - 1] == c) {
				dB++;
			}
		}

		// Si alguna de las diagonales da true, entonces se guarda en la
		// variable ganador
		ganador = ganador || dA == 3 || dB == 3;

		// NOTA!
		// Este código se puede optimizar agregando "&& !ganador" a las
		// condiciones de todos los for, sin embargo, esto haría un poco
		// más complicado de entender al código.

		return ganador;
	}

	/**
	 * Indica si el tablero se encuentra en un estado lleno, lo cual se puede
	 * utilizar para inferir que el tablero está en un estado de empate, si no
	 * hay ganadores.
	 * 
	 * @return True - si el tablero está vacío, False si el tablero está lleno
	 */
	public boolean lleno() {
		int c = 0;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == VACIO) {
					// Se cuentan todas las posiciones vacías de la matriz
					c++;
				}
			}
		}
		return c == 0;
	}

	/**
	 * Este método ejecuta el ciclo principal del juego hasta que gane algún
	 * jugador
	 */
	public void jugar() {

		// Variable para almacenar el ganador del juego
		// -1 indica que no hay ganadores
		int ganador = -1;

		// Variable que se utiliza para contar los turnos
		int c = 0;

		// Variable que indica el jugador actual
		int i = 0;

		// NOTA!
		// En vez de la variable i, podría utilizarse c % 2.
		// Pero eso podría hacer el código más complicado de entender

		// Se imprime el estado inicial del juego
		System.out.println("ESTADO INICIAL");
		System.out.println(this);
		System.out.println();

		// Se comienza a jugar
		while (!lleno() && ganador == -1) {

			// Se ejecutan iteraciones, mientras el tablero no esté lleno
			// y no haya ganadores

			// Se imprime el turno actual y de quien es
			System.out.println("TURNO " + c + " juega Jugador " + i);

			// Se le indica al jugador actual que juegue
			jugadores[i].decidir();

			// Si el jugador actual es ganador, luego de poner su ficha
			if (ganador(jugadores[i].getFicha())) {
				// Entonces se actualiza la variable ganador
				// Lo cual va a hacer que el while termine
				ganador = i;
			}

			// Se imprime el estado del tablero
			System.out.println(this);
			System.out.println();

			// Se actualizanlos contadores
			i = (i + 1) % 2; // Va 0, luego 1, luego 0, luego 1, etc
			++c; // Va aumentando de 1 en 1
		}

		// Luego del while, sabemos con seguridad que el juego ya terminó
		
		if (ganador == 0) {
			// Si el ganador es el jugador 0, 
			// se indica así al usuario
			System.out.println("Gana Jugador 0");
		} else if (ganador == 1) {
			// Si el ganador es el jugador 1, 
			// se indica así al usuario
			System.out.println("Gana Jugador 1");
		} else {
			// Si no hay ganadores, 
			// entonces tiene que ser un empate
			System.out.println("Hubo un empate!");
		}

	}

	/**
	 * Devuelve un String con el contenido del tablero
	 */
	@Override
	public String toString() {
		String hilera = "";
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				// Concatena todas las posiciones del tablero
				hilera += tablero[i][j];
				if (j + 1 < tablero.length) {
					// Separadas por tabs
					hilera += "\t";
				}
			}
			// Luego de concatenar todos los elementos de una fila,
			// se concatena un Enter
			hilera += "\n";
		}
		return hilera;
	}
}
