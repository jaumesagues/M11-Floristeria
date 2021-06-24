package floristeria.controller;

import floristeria.model.Floristeria;

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
}
