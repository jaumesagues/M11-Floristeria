package floristeria.view;

import javax.swing.JOptionPane;

import floristeria.model.Material;
import floristeria.model.Material.TipoMaterial;

public class InterficieConsola {
	
	private static Menu menu_principal;
	private static Menu menu_materiales_decoracion;
	
	public InterficieConsola() {
		CreacionMenu();
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
				System.out.println("Mostrar stock.");
				break;
			}
		} while (menu_principal_opcio!=5);
		System.out.println("El programa ha finalizado.");
	}
	
	private void CrearFloristeria() {
		String nombre_floristeria;
		nombre_floristeria=pedirDato("Crear florister�a", "Introducir el nombre de la florister�a");
		if (nombre_floristeria==null) return;
		System.out.println("Florister�a con nombre " + nombre_floristeria + " creada.");
	}
	
	private void AddArbol() {
		double precio, altura;
		
		precio=pedirDouble("A�adir �rbol", "Introducir precio", -1000);
		if (precio<0.0) return;
		
		altura=pedirDouble("A�adir �rbol", "Introducir altura", -1000);
		if (altura<0.0) return;
		
		System.out.println("�rbol con altura " + altura + " y precio " + precio +" a�adido.");
	}
	
	private void AddFlor() {
		double precio;
		String color;
		
		precio=pedirDouble("A�adir flor", "Introducir precio", -1000);
		if (precio<0.0) return;
		
		color=pedirDato("A�adir flor", "Introducir el color");
		if (color==null) return;
		
		System.out.println("Flor de color " + color + " y precio " + precio +" a�adida.");
	}
	
	private void AddDecoracion() {
		double precio;
		int decoracion_opcion;
		TipoMaterial material;
		
		precio=pedirDouble("A�adir decoraci�n", "Introducir precio", -1000);
		if (precio<0.0) return;
		
		decoracion_opcion=menu_materiales_decoracion.showMenu();
		if (decoracion_opcion==2) return;
		material=TipoMaterial.GetTipoMaterial(decoracion_opcion);
	
		System.out.println("Decoraci�n de " + material.toString() + " y precio " + precio +" a�adida.");
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
					System.out.println("El valor introdu�t no �s correcte."
							+ "Haur� d'introduir una altre valor o pr�mer 'Cancelar'");
				}
			}
		}
		
		return answer;
	}
	
	private void CreacionMenu() {
		menu_principal=new Menu("Escoja una de las siguientes opciones.", 6);
		
		menu_principal.addOptionMenu("Crear florister�a");
		menu_principal.addOptionMenu("A�adir �rbol");
		menu_principal.addOptionMenu("A�adir flor");
		menu_principal.addOptionMenu("A�adir decoraci�n");
		menu_principal.addOptionMenu("Mostrar Stock");
		menu_principal.addOptionMenu("Salir");
		
		menu_materiales_decoracion=new Menu("Escoja un material para la decoraci�n.", 3);
		
		menu_materiales_decoracion.addOptionMenu("Madera");
		menu_materiales_decoracion.addOptionMenu("Pl�stico");
		menu_materiales_decoracion.addOptionMenu("Salir");
	}
}
