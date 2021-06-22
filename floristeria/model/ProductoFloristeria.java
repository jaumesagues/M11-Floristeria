package floristeria.model;

public abstract class ProductoFloristeria {
	
	protected double precio;
	
						//variable static para llevar recuento de los objetos de tipo ProductoFloristeria. Vendrá bien en el Nivel 2
	private static int CONTADOR_PRODUCTOS_FLORISTERIA = 1;
	
	public ProductoFloristeria(double precio){
		this.precio = precio;
		CONTADOR_PRODUCTOS_FLORISTERIA++;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "ProductoFloristeria [precio=" + precio + "]";
	}
	
}
