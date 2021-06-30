package floristeria.model;

public abstract class ProductoFloristeria {
	
	protected double precio;
	
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
	
	public int getTotalProducts()
	{
		return CONTADOR_PRODUCTOS_FLORISTERIA;
	}
	@Override
	public String toString() {
		return "ProductoFloristeria [precio=" + precio + "]";
	}
	
}
