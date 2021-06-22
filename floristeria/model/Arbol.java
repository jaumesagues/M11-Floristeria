package floristeria.model;

public class Arbol extends ProductoFloristeria{
	
	private double altura;

	public Arbol(double precio, double altura) {
		super(precio);
		this.altura = altura;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	@Override
	public String toString() {
		return "Arbol [altura=" + altura + "]";
	}

}
