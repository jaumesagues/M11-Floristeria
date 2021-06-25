package floristeria.view;

import floristeria.model.Floristeria;

public class FloristeriaApp {
	
	private static InterficieConsola interficie;

	public static void main(String[] args) {
		
		Floristeria fl = new Floristeria("Floristeria1");
		fl.addArbol(2.5, 4.6);
		fl.addArbol(2.5, 4.6);
		fl.addArbol(2.5, 4.6);
		fl.addArbol(2.5, 4.6);
		fl.addArbol(2.5, 4.6);
		
		fl.deleteFlorById(1);
		fl.deleteFlorById(2);
		
		fl.addFlor("Rojo", 34.6);
		fl.addFlor("Verde", 34.6);
		fl.addFlor("Azul", 34.6);
		fl.addFlor("Azul", 34.6);
		
		fl.deleteArbolById(2);
		fl.deleteArbolById(5);
		
		System.out.println(fl.getMensajeStock());
		
		System.out.println(fl.getMensajeValorTotal());
		
		fl.deleteFlorById(1);
		
		interficie=new InterficieConsola();
		interficie.Ejecutar();
		
	}

}
