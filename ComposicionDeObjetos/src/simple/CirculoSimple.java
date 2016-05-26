package simple;

public class CirculoSimple {

	private double x;
	private double y;
	private double radio;

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public void imprimir() {
		System.out.println("CirculoSimple [ X: " + x + " Y: " + y + " R: " + radio + "]");
	}
	
	public boolean puntoDentro(double x, double y) {
		return this.pitagoras(this.x, this.y, x, y) <= this.radio;
	}

	public boolean sobrepone(CirculoSimple otro) {
		// "this" es un circulo
		// "otro" es un circulo tambien
		return this.pitagoras(this.x, this.y, otro.x, otro.y) <= this.radio + otro.radio;
	}

	private double pitagoras(double x1, double y1, double x2, double y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

}
