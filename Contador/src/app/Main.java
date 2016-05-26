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

		// Se crea un Contador
		Contador c = new Contador();
		
		// Se llama al método que prueba todos los contadores
		c.probar();

	}

}
