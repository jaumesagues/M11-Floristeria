package floristeria.controller;

import java.util.List;
import floristeria.model.*;
import floristeria.model.Material.TipoMaterial;
import floristeria.model.ProductoEnum.TipoProducto;

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
		} else  throw new Exception("No es posible añadir un árbol porque la floristería NO ha sido creada");
	}
	
	public void AddFlorFloristeria(double precio, String color) throws Exception {
		if (floristeria!=null) {
			floristeria.addFlor(color, precio);
		} else  throw new Exception("No es posible añadir una flor porque la floristería NO ha sido creada");
	}
	
	public void AddDecoracionFloristeria(double precio, TipoMaterial material) throws Exception {
		if (floristeria!=null) {
			floristeria.addDecoracion(material, precio);;
		} else  throw new Exception("No es posible añadir una decoración porque la floristería NO ha sido creada");
	}
	
	public String ListarArboles() {
		String list_arboles_str="Listado de árboles:\n";
		List<Arbol> list_arboles=floristeria.getArboles();
		
		for (Arbol arbol:list_arboles) {
			list_arboles_str+=arbol.toString()+"\n";
		}
		
		return list_arboles_str;
	}
	
	public String ListarFlores() {
		String list_flores_str="Listado de flores:\n";
		List<Flor> list_flores=floristeria.getFlores();
		
		for (Flor flor:list_flores) {
			list_flores_str+=flor.toString()+"\n";
		}
		
		return list_flores_str;
	}
	
	public String ListarDecoraciones() {
		String list_decoraciones_str="Listado de decoraciones:\n";
		List<Decoracion> list_decoraciones=floristeria.getDecoraciones();
		
		for (Decoracion decoracion:list_decoraciones) {
			list_decoraciones_str+=decoracion.toString()+"\n";
		}
		
		return list_decoraciones_str;
	}
	
	public void RetirarArbol(int id) throws Exception {
		boolean encontrado=false;
		List<Arbol> list_arboles=floristeria.getArboles();
		
		for (Arbol arbol:list_arboles) {
			if (arbol.getIdArbol()==id) {
				list_arboles.remove(arbol);
				encontrado=true;
				break;
			}
		}
		
		if (!encontrado) throw new Exception("No es posible retirar el árbol seleccionado porque no existe.");
	}
	
	public void RetirarFlor(int id) throws Exception {
		boolean encontrado=false;
		List<Flor> list_flores=floristeria.getFlores();
		
		for (Flor flor:list_flores) {
			if (flor.getIdFlor()==id) {
				list_flores.remove(flor);
				encontrado=true;
				break;
			}
		}
		
		if (!encontrado) throw new Exception("No es posible retirar la flor seleccionada porque no existe.");
	}
	
	public void RetirarDecoracion(int id) throws Exception {
		boolean encontrado=false;
		List<Decoracion> list_decoraciones=floristeria.getDecoraciones();
		
		for (Decoracion decoracion:list_decoraciones) {
			if (decoracion.getIdDecoracion()==id) {
				list_decoraciones.remove(decoracion);
				encontrado=true;
				break;
			}
		}
		
		if (!encontrado) throw new Exception("No es posible retirar la decoracion seleccionada porque no existe.");
	}
	
	public int IniciarVentaProductos() {
		int id_ticket=1;
		
		id_ticket=floristeria.createTicket();
		return id_ticket;
	}
	
	public void VenderProducto(int id_ticket, TipoProducto tipo_producto, int id_producto) {
		floristeria.sellProduct(id_ticket, tipo_producto, id_producto);
	}
	
	public double CalcTotalTicket(int id_ticket) {
		return floristeria.getTicketById(id_ticket).getValorTicket();
	}
	
	public String GetStockFloristeria() {
		return floristeria.getMensajeStock();
	}
	
	public String GetValorTotalFloristeria() {
		return floristeria.getMensajeValorTotal();
	}
	
	public double GetTotalVentasFloristeria() {
		return floristeria.getValorTotalTickets();
	}
}
