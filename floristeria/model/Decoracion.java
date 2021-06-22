package floristeria.model;

public class Decoracion extends ProductoFloristeria{
	
	enum TipoMaterial{
		MADERA,
		PLASTICO
	}

	private TipoMaterial material;

	public Decoracion(double precio, TipoMaterial material) {
		super(precio);
		this.material = material;
	}

	public TipoMaterial getMaterial() {
		return material;
	}

	public void setMaterial(TipoMaterial material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return "Decoracion [material=" + material + "]";
	}

	
}
