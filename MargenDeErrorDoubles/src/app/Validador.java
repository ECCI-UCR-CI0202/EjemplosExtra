package app;

/**
 * 
 * @author ruben.jimenez
 */
public class Validador {
	
	public static final double MARGEN = 1e-2;
	
	/**
	 * 
	 * 
	 * @param cateto1 Cateto 1
	 * @param cateto2 Cateto 2
	 * @param hipotenusa Hipotenusa a comprobar
	 * @return true - El resultado es correcto, false - el resultado es incorrecto
	 */
	public static boolean validarHipotenusa(double cateto1, double cateto2, double hipotenusa) {
		boolean b = false;
		double tmp = Matematico.hipotenusa(cateto1, cateto2); 
		if (Math.abs(tmp - hipotenusa) < MARGEN) {
			b = true;
		}
		return b;
	}
}
