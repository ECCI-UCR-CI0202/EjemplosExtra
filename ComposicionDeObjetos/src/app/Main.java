package app;

import complejo.CirculoComplejo;
import complejo.Punto;
import simple.CirculoSimple;

public class Main {

	public static void main(String[] args) {
		// pruebaSimple();
		pruebaCompleja();
	}

	public static void pruebaSimple() {

		CirculoSimple c1 = new CirculoSimple();
		c1.setX(5.0);
		c1.setY(7.0);
		c1.setRadio(4.0);
		c1.imprimir();

		CirculoSimple c2 = new CirculoSimple();
		c2.setX(3.0);
		c2.setY(0.0);
		c2.setRadio(5.0);
		c2.imprimir();

		CirculoSimple c3 = new CirculoSimple();
		c3.setX(-5.0);
		c3.setY(-5.0);
		c3.setRadio(1.0);
		c3.imprimir();

		double x1 = 7.0;
		double y1 = 7.0;
		if (c1.puntoDentro(x1, y1)) {
			System.out.println("El punto (" + x1 + ", " + y1 + ") esta dentro de c1");
		} else {
			System.out.println("El punto (" + x1 + ", " + y1 + ") no esta dentro de c1");
		}

		double x2 = 10.0;
		double y2 = 7.0;
		if (c1.puntoDentro(x2, y2)) {
			System.out.println("El punto (" + x2 + ", " + y2 + ") esta dentro de c1");
		} else {
			System.out.println("El punto (" + x2 + ", " + y2 + ") no esta dentro de c1");
		}


		if (c1.sobrepone(c1)) {
			System.out.println("Los circulos se sobreponen");
		} else {
			System.out.println("Los circulos no se sobreponen");
		}
		
		if (c1.sobrepone(c2)) {
			System.out.println("Los circulos se sobreponen");
		} else {
			System.out.println("Los circulos no se sobreponen");
		}

		if (c1.sobrepone(c3)) {
			System.out.println("Los circulos se sobreponen");
		} else {
			System.out.println("Los circulos no se sobreponen");
		}
		
		if (c3.sobrepone(c1)) {
			System.out.println("Los circulos se sobreponen");
		} else {
			System.out.println("Los circulos no se sobreponen");
		}

	}

	public static void pruebaCompleja() {
		Punto p1 = new Punto();
		Punto p2 = new Punto();
		Punto p3 = new Punto();
		Punto p4 = new Punto();

		p1.setX(5.0);
		p1.setY(6.0);

		p2.setX(3.0);
		p2.setY(4.0);

		p3.setX(0.0);
		p3.setY(-1.0);

		p4.setX(-2.0);
		p4.setY(7.0);

		System.out.println(p1.toString());
		System.out.println(p2.toString());
		System.out.println(p3.toString());
		System.out.println(p4.toString());

		System.out.println("La distancia entre p1 y p1 es: " + p1.distancia(p1));
		System.out.println("La distancia entre p1 y p2 es: " + p1.distancia(p2));
		System.out.println("La distancia entre p2 y p3 es: " + p2.distancia(p3));
		System.out.println("La distancia entre p1 y p4 es: " + p1.distancia(p4));

		Punto pSuma = p1.sumar(p2);
		System.out.println("La suma de p1 y p2 es: " + pSuma.toString());
		
		CirculoComplejo c1 = new CirculoComplejo();
		CirculoComplejo c2 = new CirculoComplejo();
		CirculoComplejo c3 = new CirculoComplejo();

		c1.setOrigen(p1);
		c2.setOrigen(p4);
		c3.setOrigen(p3);

		c1.setRadio(5.0);
		c2.setRadio(3.0);
		c3.setRadio(7.0);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);

		Punto p5 = new Punto();
		p5.setX(7.0);
		p5.setY(7.0);
		if (c1.puntoDentro(p5)) {
			System.out.println("El punto " + p5.toString() + " esta dentro de c1");
		} else {
			System.out.println("El punto " + p5.toString() + " no esta dentro de c1");
		}

		Punto p6 = new Punto();
		p6.setX(8.0);
		p6.setY(15.0);
		if (c1.puntoDentro(p6)) {
			System.out.println("El punto " + p6.toString() + " esta dentro de c1");
		} else {
			System.out.println("El punto " + p6.toString() + " no esta dentro de c1");
		}

		if (c1.sobrepone(c2)) {
			System.out.println("Los circulos c1 y c2 se sobreponen");
		} else {
			System.out.println("Los circulos c1 y c2  no se sobreponen");
		}

		if (c1.sobrepone(c3)) {
			System.out.println("Los circulos c1 y c3 se sobreponen");
		} else {
			System.out.println("Los circulos c1 y c3 no se sobreponen");
		}


	}

}
