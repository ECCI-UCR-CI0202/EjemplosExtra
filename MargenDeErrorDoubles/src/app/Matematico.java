package app;

/**
 * 
 * @author ruben.jimenez
 *
 */
public class Matematico {

	/**
	 * 
	 * @param m
	 * @param a
	 * @return
	 */
	public static double hipotenusa(double cateto1, double cateto2) {
		return Math.sqrt(cateto1 * cateto1 + Math.pow(cateto2, 2));
	}
}
