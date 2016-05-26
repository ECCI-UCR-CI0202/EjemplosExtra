package app;
import java.util.Arrays;
import java.util.Random;

/**
 * Esta clase demuestra 3 métodos distintos para contar la cantidad de veces que
 * se repiten los valores dentro de un vector.
 * 
 * @author Rubén Jiménez Goñi
 */
public class Contador {

	/**
	 * Para generar números aleatorios en cualquier método
	 */
	private Random r = new Random();

	/**
	 * Método que genera un vector y prueba los 3 distintos métodos de contar.
	 */
	public void probar() {

		// Se genera un vector con un tamaño en el rango [10, 20[
		int v[] = new int[r.nextInt(10) + 10];
		
		// Se imprime el contenido del vector
		System.out.print("El vector es: ");
		for (int i = 0; i < v.length; i++) {
			v[i] = r.nextInt(10);
			System.out.print(v[i] + " ");
		}
		System.out.println();

		// NOTA!
		// El método Arrays.copyOf pertenece a la librería de Java y
		// se encarga de crear una copia del vector que entre por parámetro.
		// Esto no es necesariamente contenido del curso.
		
		// Se prueba el método A
		System.out.println("METODO A:");
		contarNumerosA(Arrays.copyOf(v, v.length));

		// Se prueba el método B
		System.out.println("METODO B:");
		contarNumerosB(Arrays.copyOf(v, v.length));

		// Se prueba el método C
		System.out.println("METODO C:");
		contarNumerosC(Arrays.copyOf(v, v.length));

		// Los resultados de los 3 métodos deberían
		// contener la misma cantidad de repeticiones
		
	}

	/**
	 * Método que imprime en la pantalla la cantidad de veces 
	 * que se repiten los números dentro del vector que viene
	 * por parámetro.
	 * 
	 * Este método utilizar 2 fors y una estructura alterna de
	 * booleanos
	 * 
	 * @param v Vector dentro del cual se cuentan las repeticiones
	 */
	public void contarNumerosA(int v[]) {
		
		//Se crea un vector que indica si una posición ya se contó o no
		boolean b[] = new boolean[v.length];
		
		// Este for recorre todo el vector
		for (int i = 0; i < v.length; i++) {
			
			// Si la posición i no se ha contado
			if (!b[i]) {
				
				// Se indica que esta posición ya se contó
				b[i] = true;
				
				// y se pone el contador en 1
				int c = 1;
				
				// Se recorren todos los valores hacia la derecha...
				for (int j = i + 1; j < b.length; j++) {
					
					// ... en busca de valores iguales a i
					if (v[i] == v[j]) {
						
						// Si se encuentran, se aumenta el contador
						c++;
						// y se indica en el vector alterno, que ya se contó
						// la posición j
						b[j] = true;
					}
				}
				System.out.println("Hay " + c + " de " + v[i]);
			}
		}
	}

	/**
	 * Método que imprime en la pantalla la cantidad de veces 
	 * que se repiten los números dentro del vector que viene
	 * por parámetro 
	 * 
	 * Este método ordenar los contenidos del vector y luego los cuenta
	 * conforme van apareciendo
	 * 
	 * @param v Vector dentro del cual se cuentan las repeticiones
	 */
	public void contarNumerosB(int v[]) {
		
		// Se ordena el vector
		ordenar(v);
		
		// �?ndice con el cual se va a recorrer el vector ordenado
		int i = 0;
		
		// Se inicia el contador en 1
		int c = 1;
		
		// Mientras i no se salga del vector
		while (i < v.length) {
			
			// Si lo que está en la posción actual es igual a lo de la derecha
			if (i < v.length - 1 && v[i] == v[i + 1]) {
				// Se aumenta el contador
				++c;
			} else {
				// En caso contrario, se imprime la cantidad de elementos encontrados
				System.out.println("Hay " + c + " de " + v[i]);
				
				// y se reinicia el contador
				c = 1;
			}
			
			// Se aumenta el índice que recorre el vector
			++i;
		}
	}

	/**
	 * Método que ordena los contenidos de un vector que viene por parámetro.
	 * se ordena de menor a mayor.
	 * 
	 * @param v Vector a ordenar
	 */
	private void ordenar(int v[]) {
		// Este tipo de algoritmo se llama burbuja o Bubble Sort.
		
		// La idea es que se recorre el vector de izquierda a derecha
		// y si se encuentra un número que es mayor al que se encuentra 
		// inmediatamente a la derecha, entonces ambos se intercambian
		// y se indica que, una vez que termine el for, debe repetirse
		// para seguir moviendo todos los valores grandes hacia la derecha
		
		// Leer más en: https://en.wikipedia.org/wiki/Bubble_sort
		
		// Esta variable controla si se repite el for
		boolean repetir = true;
		while (repetir) {
			repetir = false;
			
			// Este for recorre todo el vector
			for (int i = 0; i < v.length - 1; i++) {
				
				// Si lo que está en la posición i es mayor a lo que está en i + 1
				if (v[i] > v[i + 1]) {
					
					// Se intercambia el contenido de ambas posiciones con un swap
					int tmp = v[i];
					v[i] = v[i + 1];
					v[i + 1] = tmp;
					
					// y se indica que tiene que repetirse el for
					repetir = true;
				}
			}
		}
	}

	/**
	 * Método que imprime en la pantalla la cantidad de veces 
	 * que se repiten los números dentro del vector que viene
	 * por parámetro 
	 * 
	 * @param v Vector dentro del cual se cuentan las repeticiones
	 */
	public void contarNumerosC(int v[]) {
		
		// Se crea un vector de 10 contadores
		// Funciona porque los elementos del vector están en el rango [0, 10[
		int c[] = new int[10]; 
		
		// Se cuenta cada elemento
		for (int i = 0; i < v.length; i++) {
			// Se utiliza el valor en la posición i del vector
			// como índice del vector c y se aumenta dicho contador en 1
			c[v[i]]++;
		}
		
		// Posteriormente se imprimen los contadores
		for (int i = 0; i < c.length; i++) {
			
			// Solo si el contador es distinto de 0
			if (c[i] != 0) {
				System.out.println("Hay " + c[i] + " de " + i);
			}
		}
		
		// Este método está basado en el algoritmo Counting Sort.
		// Leer más en: https://en.wikipedia.org/wiki/Counting_sort
		
	}

}
