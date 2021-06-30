package floristeria.view;

import javax.swing.JOptionPane;
import floristeria.controller.FloristeriaController;
import floristeria.model.Material.TipoMaterial;
import floristeria.model.ProductoEnum.TipoProducto;

public class InterficieConsola {
	
	private static Menu menu_principal;
	private static Menu menu_productos;
	private static Menu menu_materiales_decoracion;
	private static Menu menu_operaciones_productos;
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
				AddProducto();
				break;
			case 2:
				ListarProductos();
				break;
			case 3:
				VenderProductos();
				break;
			case 4:
				MostrarStock();
				break;
			case 5:
				MostrarValorTotalVentas();
				break;
			case 6:
				MostrarValorTotal();
				break;
			}
		} while (menu_principal_opcio!=7);
		System.out.println("El programa ha finalizado.");
	}
	
	// Creación floristería
	
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
	
	// Añadir productos
	
	private void AddProducto() {
		int menu_producto_opcio;
		
		if (!floristeria_control.IsFloristeriaCreada()) {
			System.err.println("No es posible agregar ningún producto porque la floristería NO ha sido creada.");
			return;
		}
		
		do {
			menu_producto_opcio=menu_productos.showMenu();
			switch (menu_producto_opcio) {
			case 0:
				AddArbol();
				break;
			case 1:
				AddFlor();
				break;
			case 2:
				AddDecoracion();
				break;
			}
		} while (menu_producto_opcio!=3);
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
	
	// Listar y retirar productos
	
	private void ListarProductos() {
		int menu_producto_opcio;
		
		if (!floristeria_control.IsFloristeriaCreada()) {
			System.err.println("No es posible mostrar los productos porque la floristería NO ha sido creada.");
			return;
		}
		
		do {
			menu_producto_opcio=menu_productos.showMenu();
			switch (menu_producto_opcio) {
			case 0:
				System.out.println(floristeria_control.ListarArboles());
				break;
			case 1:
				System.out.println(floristeria_control.ListarFlores());
				break;
			case 2:
				System.out.println(floristeria_control.ListarDecoraciones());
				break;
			}
			if (menu_producto_opcio!=3) {
				Operacion(TipoProducto.GetTipoProducto(menu_producto_opcio));
			}
		} while (menu_producto_opcio!=3);	
	}
	
	private void Operacion(TipoProducto prod) {
		int menu_operacion_opcion;
		
		do {
			menu_operacion_opcion=menu_operaciones_productos.showMenu();
			
			switch (menu_operacion_opcion) {
			case 0:
				Retirar(prod);
				break;
			}
		
		} while(menu_operacion_opcion!=1);
	}
	
	private void Retirar(TipoProducto prod) {
		int id_producto;
		String titulo="";
		String mensaje="";
		
		switch (prod) {
		case ARBOL:
			titulo="Retirar árbol";
			mensaje="Indique un id de un árbol de la lista para ser eliminado.";
			break;
		case FLOR:
			titulo="Retirar flor";
			mensaje="Indique un id de una flor de la lista para ser eliminada.";
			break;
		case DECORACION:
			titulo="Retirar decoración";
			mensaje="Indique un id de una decoración de la lista para ser eliminada.";
			break;
		}
		
		id_producto=pedirInteger(titulo, mensaje,-1);
		if (id_producto==-1) return;
		
		try {
			switch (prod) {
			case ARBOL:
				floristeria_control.RetirarArbol(id_producto);
				System.out.println("Árbol con id " + id_producto + " ha sido retirado.");
				break;
			case FLOR:
				floristeria_control.RetirarFlor(id_producto);
				System.out.println("Flor con id " + id_producto + " ha sido retirada.");
				break;
			case DECORACION:
				floristeria_control.RetirarDecoracion(id_producto);
				System.out.println("Decoracion con id " + id_producto + " ha sido retirada.");
				break;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	// Vender productos
	
	private void VenderProductos() {
		int id_producto;
		int id_ticket;
		TipoProducto tipo_producto;
		int menu_producto_opcio;
		String titulo="";
		String mensaje="";
		boolean terminar_venta=false;
		double totalticket;
		
		if (!floristeria_control.IsFloristeriaCreada()) {
			System.err.println("No es posible mostrar los productos porque la floristería NO ha sido creada.");
			return;
		}
		
		// Crear ticket
		id_ticket=floristeria_control.IniciarVentaProductos();
		
		//Añadir productos
		do {
			menu_producto_opcio=menu_productos.showMenu();
			if (menu_producto_opcio==3) {
				terminar_venta=true;
			} else {
				tipo_producto=TipoProducto.GetTipoProducto(menu_producto_opcio);
				switch (tipo_producto) {
				case ARBOL:
					System.out.println(floristeria_control.ListarArboles());
					titulo="Vender árbol";
					mensaje="Indique un id de un árbol de la lista para venderlo.\n Hacer click en 'Cancelar' para terminar la venta.";
					break;
				case FLOR:
					System.out.println(floristeria_control.ListarFlores());
					titulo="Vender flor";
					mensaje="Indique un id de una flor de la lista para venderla.\n Hacer click en 'Cancelar' para terminar la venta.";
					break;
				case DECORACION:
					System.out.println(floristeria_control.ListarDecoraciones());
					titulo="Vender decoración";
					mensaje="Indique un id de una decoración de la lista para venderla.\n Hacer click en 'Cancelar' para terminar la venta.";
					break;
				}
				id_producto=pedirInteger(titulo, mensaje,-1);
				if (id_producto!=-1) {
					try {
						floristeria_control.VenderProducto(id_ticket, tipo_producto, id_producto);
						switch (tipo_producto) {
						case ARBOL:
							System.out.println("Árbol con id " + id_producto + " ha sido vendida.");
							break;
						case FLOR:
							System.out.println("Flor con id " + id_producto + " ha sido vendida.");
							break;
						case DECORACION:
							System.out.println("Decoracion con id " + id_producto + " ha sido vendida.");
							break;
						}
					} catch (Exception e) {
						System.err.println(e.getMessage());
					}
				}
			}
		} while (!terminar_venta);
	
		// Mostrar total ticket
		totalticket=floristeria_control.CalcTotalTicket(id_ticket);
		System.out.println("La venta del ticket id = " + id_ticket + " asciende a un total de "+ totalticket + " euros.");
	}
	
	private void MostrarStock() {
		if (!floristeria_control.IsFloristeriaCreada()) {
			System.err.println("No es posible mostrar el stock de la floristería porque NO ha sido creada todavía.");
			return;
		}
		
		System.out.println(floristeria_control.GetStockFloristeria());
	}
	
	private void MostrarValorTotalVentas() {
		if (!floristeria_control.IsFloristeriaCreada()) {
			System.err.println("No es posible mostrar el stock de la floristería porque NO ha sido creada todavía.");
			return;
		}
		
		System.out.println("El valor total de las ventas realizadas es de "+ 
		floristeria_control.GetTotalVentasFloristeria() + " euros.");
	}
	
	private void MostrarValorTotal() {
		if (!floristeria_control.IsFloristeriaCreada()) {
			System.err.println("No es posible mostrar el stock de la floristería porque NO ha sido creada todavía.");
			return;
		}
		
		System.out.println(floristeria_control.GetValorTotalFloristeria());
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
					System.out.println("El valor introducido es incorrecto."
							+ "Deberá introducir otro valor o hacer click en 'Cancelar'");
				}
			}
		}
		
		return answer;
	}
	
	public static int pedirInteger(String titulo, String message, int nullnumber) {
		String answer_str;
		boolean answer_ok=false;
		int answer= nullnumber;
		
		while (!answer_ok) {
			answer_str=JOptionPane.showInputDialog(null, message, titulo, JOptionPane.QUESTION_MESSAGE);
			if (answer_str==null) {
				return nullnumber;
			} else {
				try {
					answer=Integer.parseInt(answer_str);
					answer_ok=true;
				} catch (Exception e) {
					System.out.println("El valor introducido es incorrecto."
							+ "Deberá introducir otro valor o hacer click en 'Cancelar'");
				}
			}
		}
		
		return answer;
	}
	
	private void CreacionMenu() {
		menu_principal=new Menu("Escoja una de las siguientes opciones.", 8);
		
		menu_principal.addOptionMenu("Crear floristería");
		menu_principal.addOptionMenu("Agregar producto");
		menu_principal.addOptionMenu("Listar productos");
		menu_principal.addOptionMenu("Realizar venta");
		menu_principal.addOptionMenu("Mostrar stock");
		menu_principal.addOptionMenu("Mostrar ventas realizadas");
		menu_principal.addOptionMenu("Mostrar valor total floristeria");
		menu_principal.addOptionMenu("Salir");
		
		menu_productos= new Menu("Escoja uno de los siguientes productos.", 4);
		
		menu_productos.addOptionMenu("Árbol");
		menu_productos.addOptionMenu("Flor");
		menu_productos.addOptionMenu("Decoración");
		menu_productos.addOptionMenu("Retroceder");
		
		menu_materiales_decoracion=new Menu("Escoja un material para la decoración.", 3);
		
		menu_materiales_decoracion.addOptionMenu("Madera");
		menu_materiales_decoracion.addOptionMenu("Plástico");
		menu_materiales_decoracion.addOptionMenu("Retroceder");
		
		menu_operaciones_productos=new Menu("Escoja una de las siguientes operaciones.", 2);
		menu_operaciones_productos.addOptionMenu("Retirar");
		menu_operaciones_productos.addOptionMenu("Retroceder");
	}
}
