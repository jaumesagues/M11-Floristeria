package floristeria.controller;

import floristeria.model.Floristeria;
import floristeria.model.Material;
import floristeria.model.Material.TipoMaterial;

public class FloristeriaController {
	
	private Floristeria floristeria;
	
	public FloristeriaController () {
		floristeria=null;
	}
	
	public void crearFloristeria(String nombre) throws Exception {
		if (floristeria==null) {
			floristeria=new Floristeria(nombre);
		} else  throw new Exception("La floristería ya ha sido creada anteriormente");
	}
	
	public boolean IsFloristeriaCreada() {
		return (floristeria!=null);
	}
	
	public void AddArbolFloristeria(double precio, double altura) throws Exception {
		if (floristeria!=null) {
			floristeria.addArbol(altura, precio);
		} else  throw new Exception("No es posible añadir un árbol porque la floristería no ha sido creada");
	}
	
	public void AddFlorFloristeria(double precio, String color) throws Exception {
		if (floristeria!=null) {
			floristeria.addFlor(color, precio);
		} else  throw new Exception("No es posible añadir una flor porque la floristería no ha sido creada");
	}
	
	public void AddDecoracionFloristeria(double precio, TipoMaterial material) throws Exception {
		if (floristeria!=null) {
			floristeria.addDecoracion(material, precio);;
		} else  throw new Exception("No es posible añadir una decoración porque la floristería no ha sido creada");
	}
	
	public String GetStockFloristeria() {
		return floristeria.toString();
	}
}
