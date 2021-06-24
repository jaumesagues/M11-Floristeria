package floristeria.model;

import floristeria.model.Material.TipoMaterial;

public class Decoracion extends ProductoFloristeria{

	private TipoMaterial material;

	public Decoracion(double precio, TipoMaterial material) {
		super(precio);
		this.material=material;
	}

	public TipoMaterial getMaterial() {
		return material;
	}

	public void establecerMaterial(String nombreMaterial) {
		
		if(nombreMaterial.equalsIgnoreCase("madera")) {
			material = material.MADERA;
		}else if(nombreMaterial.equalsIgnoreCase("plastico")) {
			material = material.PLASTICO;
		}else {
			System.err.println("ERROR: Solo hay dos tipos de materiales, plastico o madera");
		}
		
	}

	@Override
	public String toString() {
		return "Decoracion [material=" + material + "]";
	}
	
}
