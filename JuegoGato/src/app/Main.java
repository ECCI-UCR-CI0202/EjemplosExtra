package app;
/**
 * 
 * Esta es la clase Main que contiene el punto de entrada de la aplicación
 * 
 * @author Rubén Jiménez Goñi
 */
public class Main {

	/**
	 * Punto de entrada de la aplicación
	 * 
	 * @param args
	 *            Argumentos que vienen fuera del programa
	 */
	public static void main(String[] args) {

		// Se crea un objeto Tablero
		Tablero t = new Tablero();

		// Se le indica al objeto Tablero que empiece a jugar
		t.jugar();

	}

}
