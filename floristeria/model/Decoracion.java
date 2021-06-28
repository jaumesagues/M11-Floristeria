package floristeria.model;

import floristeria.model.Material.TipoMaterial;

public class Decoracion extends ProductoFloristeria{

	private int idDecoracion;
	private TipoMaterial material;
	private static int CONTADOR_DECORACIONES = 1;

	public Decoracion(double precio, TipoMaterial material) {
		super(precio);
		this.material=material;
		idDecoracion = CONTADOR_DECORACIONES;
		CONTADOR_DECORACIONES++;
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
	
	public int getIdDecoracion() {
		return idDecoracion;
	}
	
	public int getTotalDecoraciones() {
		return CONTADOR_DECORACIONES;
	}

	@Override
	public String toString() {
		return "Decoracion [idDecoracion=" + idDecoracion + ", material=" + material + ", precio= "+ super.precio+ " ]";
	}
	
}
