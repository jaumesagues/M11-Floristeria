package floristeria.model;

import java.util.*;

public class Ticket {
	
	List<ProductoFloristeria> listaProductos;
	private int idTicket;
	private static int CONTADOR_TICKETS = 1;

	public Ticket() {
		listaProductos = new ArrayList<>();
		idTicket = CONTADOR_TICKETS;
		CONTADOR_TICKETS++;
	}

	public int getIdTicket() {
		return idTicket;
	}

	public static int getCONTADOR_TICKETS() {
		return CONTADOR_TICKETS;
	}
	
	
	public List<ProductoFloristeria> getListaProductos() {
		return listaProductos;
	}

	public void setListaProductos(List<ProductoFloristeria> listaProductos) {
		this.listaProductos = listaProductos;
	}

	public void addProductToList(ProductoFloristeria producto) {
		listaProductos.add(producto);
	}
	
	public double getValorTicket() {
		
		return listaProductos.stream().mapToDouble(producto->producto.getPrecio()).sum();
	}
	
	public String toString() {
		return "Ticket nº: " + idTicket + ", contiene " + listaProductos.size() + " producto(s) : \n";
	}
}
