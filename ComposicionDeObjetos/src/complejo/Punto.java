package complejo;

public class Punto {

	private double x;
	private double y;

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

	public double distancia(Punto otro) {
		return Math.sqrt(Math.pow(this.x - otro.x, 2) + Math.pow(this.y - otro.y, 2));
	}

	public Punto sumar(Punto otro) {
		Punto p = new Punto();
		p.x = this.x + otro.x;
		p.y = this.y + otro.y;
		return p;
	}

	@Override
	public String toString() {
		return "Punto [x=" + this.getX() + ", y=" + this.getY() + "]";
	}

}
