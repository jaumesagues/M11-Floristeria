package floristeria.model;

public class Arbol extends ProductoFloristeria{
	
	private int idArbol;
	private double altura;
	private static int CONTADOR_ARBOLES = 1;

	public Arbol(double precio, double altura) {
		super(precio);
		this.altura = altura;
		idArbol = CONTADOR_ARBOLES;
		CONTADOR_ARBOLES++;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}
	
	public int getIdArbol()
	{
		return idArbol;
	}
	
	public int getTotalArboles() {
		return CONTADOR_ARBOLES;
	}

	@Override
	public String toString() {
		return "Arbol [idArbol=" + idArbol + ", altura=" + altura + ", precio= "+ super.precio+ " ]";
	}
	

}
