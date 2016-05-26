package complejo;

public class CirculoComplejo {

	private Punto origen;
	private double radio;

	public Punto getOrigen() {
		return origen;
	}

	public void setOrigen(Punto origen) {
		this.origen = origen;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public boolean puntoDentro(Punto p) {
		return origen.distancia(p) <= this.radio;
	}

	public boolean sobrepone(CirculoComplejo otro) {
		return this.origen.distancia(otro.origen) <= this.radio + otro.radio;
	}

	@Override
	public String toString() {
		return "Circulo [origen=" + origen.toString() + ", radio=" + radio + "]";
	}

}
