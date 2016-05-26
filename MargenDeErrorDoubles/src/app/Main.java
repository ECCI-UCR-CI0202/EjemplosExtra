package app;

public class Main {

	public static void main(String[] args) {

		double cateto11 = 9.0;
		double cateto21 = 7.0;
		double hipotenusa1 = 11.40;
		if (Validador.validarHipotenusa(cateto11, cateto21, hipotenusa1)) {
			System.out.println(
					"Cateto 1: " + cateto11 + " Cateto 2: " + cateto21 + " Hipotenusa: " + hipotenusa1 + " Resultado correcto");
		} else {
			System.out.println("Cateto 1: " + cateto11 + " Cateto 2: " + cateto21 + " Hipotenusa: " + hipotenusa1
					+ " Resultado incorrecto. El resultado correcto es: " + Matematico.hipotenusa(cateto11, cateto21));
		}

		double cateto12 = 3.0;
		double cateto22 = 4.0;
		double hipotenusa2 = 4.0;
		if (Validador.validarHipotenusa(cateto12, cateto22, hipotenusa2)) {
			System.out.println(
					"Cateto 1: " + cateto12 + " Cateto 2: " + cateto22 + " Hipotenusa: " + hipotenusa2 + " Resultado correcto");
		} else {
			System.out.println("Cateto 1: " + cateto12 + " Cateto 2: " + cateto22 + " Hipotenusa: " + hipotenusa2
					+ " Resultado incorrecto. El resultado correcto es: " + Matematico.hipotenusa(cateto12, cateto22));
		}

	}

}
