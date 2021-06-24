package floristeria.view;

import javax.swing.JOptionPane;

import floristeria.controller.FloristeriaController;
import floristeria.model.Material;
import floristeria.model.Material.TipoMaterial;

public class InterficieConsola {
	
	private static Menu menu_principal;
	private static Menu menu_materiales_decoracion;
	private static FloristeriaController floristeria_control;
	
	public InterficieConsola() {
		CreacionMenu();
		floristeria_control=new FloristeriaController();
	}
	
	public void Ejecutar() {
		int menu_principal_opcio;
		
		do {
			menu_principal_opcio=menu_principal.showMenu();
			switch (menu_principal_opcio) {
			case 0:
				CrearFloristeria();
				break;
			case 1:
				AddArbol();
				break;
			case 2:
				AddFlor();		
				break;
			case 3:
				AddDecoracion();
				break;
			case 4:
				MostrarStock();
				break;
			}
		} while (menu_principal_opcio!=5);
		System.out.println("El programa ha finalizado.");
	}
	
	private void CrearFloristeria() {
		String nombre_floristeria;
		
		if (floristeria_control.IsFloristeriaCreada()) {
			System.err.println("La floristería ya ha sido creada");
			return;
		}
		
		nombre_floristeria=pedirDato("Crear floristería", "Introducir el nombre de la floristería");
		if (nombre_floristeria==null) return;
		
		try {
			floristeria_control.crearFloristeria(nombre_floristeria);
			System.out.println("Floristería con nombre " + nombre_floristeria + " creada.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
	}
	
	private void AddArbol() {
		double precio, altura;
		
		if (!floristeria_control.IsFloristeriaCreada()) {
			System.err.println("No es posible añadir un árbol porque la floristería NO ha sido creada todavía.");
			return;
		}
		
		precio=pedirDouble("Añadir árbol", "Introducir precio", -1000);
		if (precio<0.0) return;
		
		altura=pedirDouble("Añadir árbol", "Introducir altura", -1000);
		if (altura<0.0) return;
		
		try {
			floristeria_control.AddArbolFloristeria(precio, altura);
			System.out.println("Árbol con altura " + altura + " y precio " + precio +" añadido.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}	
	}
	
	private void AddFlor() {
		double precio;
		String color;
		
		if (!floristeria_control.IsFloristeriaCreada()) {
			System.err.println("No es posible añadir una flor porque la floristería NO ha sido creada todavía.");
			return;
		}
		
		precio=pedirDouble("Añadir flor", "Introducir precio", -1000);
		if (precio<0.0) return;
		
		color=pedirDato("Añadir flor", "Introducir el color");
		if (color==null) return;
		
		try {
			floristeria_control.AddFlorFloristeria(precio, color);
			System.out.println("Flor de color " + color + " y precio " + precio +" añadida.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	private void AddDecoracion() {
		double precio;
		int decoracion_opcion;
		TipoMaterial material;
		
		if (!floristeria_control.IsFloristeriaCreada()) {
			System.err.println("No es posible añadir una decoración porque la floristería NO ha sido creada todavía.");
			return;
		}
		
		precio=pedirDouble("Añadir decoración", "Introducir precio", -1000);
		if (precio<0.0) return;
		
		decoracion_opcion=menu_materiales_decoracion.showMenu();
		if (decoracion_opcion==2) return;
		material=TipoMaterial.GetTipoMaterial(decoracion_opcion);
		
		try {
			floristeria_control.AddDecoracionFloristeria(precio, material);
			System.out.println("Decoración de " + material.toString() + " y precio " + precio +" añadida.");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public void MostrarStock() {
		if (!floristeria_control.IsFloristeriaCreada()) {
			System.err.println("No es posible mostrar el stock de la floristería porque NO ha sido creada todavía.");
			return;
		}
		
		System.out.println(floristeria_control.GetStockFloristeria());
	}

	private String pedirDato(String titol, String textSobreLaDadaAdemanar) {
		String dada = JOptionPane.showInputDialog(null, textSobreLaDadaAdemanar, titol, JOptionPane.QUESTION_MESSAGE);
		return dada;
	}
	
	public static double pedirDouble(String titulo, String message, double nullnumber) {
		String answer_str;
		double answer=nullnumber;
		boolean answer_ok=false;
		
		while (!answer_ok) {
			answer_str = JOptionPane.showInputDialog(null, message, titulo, JOptionPane.QUESTION_MESSAGE);
			if (answer_str == null) {
				return nullnumber;
			} else {
				try {
					answer = Double.parseDouble(answer_str);
					answer_ok = true;
				} catch (Exception e) {
					System.out.println("El valor introduït no és correcte."
							+ "Haurà d'introduir una altre valor o prèmer 'Cancelar'");
				}
			}
		}
		
		return answer;
	}
	
	private void CreacionMenu() {
		menu_principal=new Menu("Escoja una de las siguientes opciones.", 6);
		
		menu_principal.addOptionMenu("Crear floristería");
		menu_principal.addOptionMenu("Añadir árbol");
		menu_principal.addOptionMenu("Añadir flor");
		menu_principal.addOptionMenu("Añadir decoración");
		menu_principal.addOptionMenu("Mostrar Stock");
		menu_principal.addOptionMenu("Salir");
		
		menu_materiales_decoracion=new Menu("Escoja un material para la decoración.", 3);
		
		menu_materiales_decoracion.addOptionMenu("Madera");
		menu_materiales_decoracion.addOptionMenu("Plástico");
		menu_materiales_decoracion.addOptionMenu("Salir");
	}
}
