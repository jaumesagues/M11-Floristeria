package floristeria.view;

import javax.swing.JOptionPane;

public class InterficieConsola {
	
	private static Menu menu_principal;
	
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
				System.out.println("Añadiendo árbol nuevo.");
				break;
			case 2:
				System.out.println("Añadiendo flor nueva.");		
				break;
			case 3:
				System.out.println("Añadiendo decoración nueva.");
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
		nombre_floristeria=pedirDato("Crear floristería", "Introducir el nombre de la floristería");
		System.out.println("Floristería con nombre " + nombre_floristeria + " creada.");
	}
	
	private String pedirDato(String titol, String textSobreLaDadaAdemanar) {
		String dada = JOptionPane.showInputDialog(null, textSobreLaDadaAdemanar, titol, JOptionPane.QUESTION_MESSAGE);
		return dada;
	}
	
	private void CreacionMenu() {
		menu_principal=new Menu("Escoja una de las siguientes opciones.", 6);
		
		menu_principal.addOptionMenu("Crear floristería");
		menu_principal.addOptionMenu("Añadir árbol");
		menu_principal.addOptionMenu("Añadir flor");
		menu_principal.addOptionMenu("Añadir decoración");
		menu_principal.addOptionMenu("Mostrar Stock");
		menu_principal.addOptionMenu("Salir");
	}
}
