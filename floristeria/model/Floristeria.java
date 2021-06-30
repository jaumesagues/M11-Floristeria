package floristeria.model;

import java.util.ArrayList;
import java.util.List;

import floristeria.model.Material.TipoMaterial;
import floristeria.model.ProductoEnum.TipoProducto;

public class Floristeria {

	protected String nombreFloristeria;
	
	protected List<Flor> flores;
	protected List<Arbol> arboles;
	protected List<Decoracion> decoraciones;
	protected List<Ticket> tickets;
	
	private static int CONTADOR_FLORISTERIAS = 1;
	
	private int idFloristeria;

	public Floristeria(String nombreFloristeria) {
		
		this.nombreFloristeria = nombreFloristeria;
		
		flores = new ArrayList<>();
		arboles = new ArrayList<>();
		decoraciones = new ArrayList<>();
		tickets = new ArrayList<>();
		idFloristeria = CONTADOR_FLORISTERIAS;
		CONTADOR_FLORISTERIAS++;
	}

	//GETTERS/SETTERS
	public String getNombreFloristeria() {
		return nombreFloristeria;
	}

	public void setNombreFloristeria(String nombreFloristeria) {
		this.nombreFloristeria = nombreFloristeria;
	}

	public List<Flor> getFlores() {
		return flores;
	}

	public List<Arbol> getArboles() {
		return arboles;
	}

	public List<Decoracion> getDecoraciones() {
		return decoraciones;
	}

	public int getIdFloristeria() {
		return idFloristeria;
	}

	//OTROS METODOS
	
	public void addArbol(double alturaArbol, double precioArbol) {
		if(arboles!=null)	arboles.add(new Arbol(precioArbol, alturaArbol));
		else System.err.println("La lista de arboles no está creada");
	}
	
	public void addDecoracion(TipoMaterial material, double precioDecoracion) {
		if(decoraciones!=null) decoraciones.add(new Decoracion(precioDecoracion, material));
		else System.err.println("La lista de decoraciones no está creada");
	}

	public void addFlor(String colorFlor, double precioFlor) {
		
		if(flores!=null)	flores.add(new Flor(precioFlor, colorFlor));
		else System.err.println("La lista de flores no está creada");
		
	}

	
	//METODO PARA EL NIVEL 3: Recibirá 3 parámetros
	//		Primer paramtro: idTicket -> para el ticket de la compra en cuestion
	//		Segundo: numTipoProducto -> 0 (arbol), 1(flor), 2(decoracion)
	//		Tercero: idProducto -> el id del producto
	
	public void sellProduct(int idTicket, TipoProducto tipo_producto, int idProducto) {
		Ticket ticket = getTicketById(idTicket);								//ticket de la compra actual
		
		if(tipo_producto == TipoProducto.ARBOL) {		//IF-ELSEIF para cada uno de los 3 productos
			deleteArbolById(idProducto);										//elimino del "stock"
			ticket.addProductToList(getArbolById(idProducto));					//lo añado al ticket actual
			System.out.println("Añadido producto al ticket");
			
		}else if(tipo_producto==TipoProducto.FLOR) {
			deleteFlorById(idProducto);
			ticket.addProductToList(getFlorById(idProducto));
			System.out.println("Añadido producto al ticket");
			
		}else if(tipo_producto==TipoProducto.DECORACION) {
			deleteDecoracionById(idProducto);
			ticket.addProductToList(getDecoracionById(idProducto));
			System.out.println("Añadido producto al ticket");
			
		}else System.err.println("El producto no corresponde con ninguno de los productos de la Floristeria");
		
	}
	
	public void deleteFlorById(int id) {

		if (!getFlores().isEmpty()) {
		flores.remove(getFlorById(id));
		System.out.println("Eliminada flor");

		} else System.err.println("La lista de flores se encuentra vacía");
	}
	
	public void deleteArbolById(int id) {

		if (!arboles.isEmpty()) {
			arboles.remove(getArbolById(id));
			System.out.println("Eliminado arbol");

		} else System.err.println("La lista de árboles se encuentra vacía");

	}

	public void deleteDecoracionById(int id) {

		if (!getDecoraciones().isEmpty()) {
			decoraciones.remove(getDecoracionById(id));
			System.out.println("Eliminada decoracion");
			
		} else System.err.println("La lista de árboles se encuentra vacía");
	}

	public int getTotalFloristerias() {
		return CONTADOR_FLORISTERIAS;
	}
	
	public double valorProductos() {
		
		double valorTotal = 0;
		
		for(Flor flor: flores) {
			valorTotal+=flor.getPrecio();
		}
		for(Arbol arbol: arboles) {
			valorTotal+=arbol.getPrecio();
		}
		for(Decoracion decoracion: decoraciones) {
			valorTotal+=decoracion.getPrecio();
		}
		
		return valorTotal;
	}
	
	public Arbol getArbolById(int idArbol) {
		Arbol arbolEncontrado = null;
		
		for(Arbol arbol: arboles) {
			if (arbol.getIdArbol() == idArbol) {
				
				arbolEncontrado = arbol;
				System.out.println("Arbol encontrado con ID: " + arbolEncontrado.getIdArbol());
				break;
			}	
		}
		return arbolEncontrado;
	}
	
	public Flor getFlorById(int idFlor) {
		Flor florEncontrada = null;
		
		for(Flor flor: flores) {
			if(flor.getIdFlor() == idFlor) {
				florEncontrada = flor;
				System.out.println("Flor encontrada con ID: " + florEncontrada.getIdFlor());
				break;
			}
		}
		return florEncontrada;
	}
	
	public Decoracion getDecoracionById(int idDecoracion) {
		Decoracion decoracionEncontrada = null;
		
		for(Decoracion decoracion: decoraciones) {
			if(decoracion.getIdDecoracion() == idDecoracion) {
				decoracionEncontrada = decoracion;
				System.out.println("Decoracion encontrada con ID: " + decoracionEncontrada.getIdDecoracion());
				break;
			}
		}
		return decoracionEncontrada;
	}
	
	public Ticket getTicketById(int idTicket) {
		Ticket ticketEncontrado = null;
		
		for(Ticket ticket: tickets) {
			if(ticket.getIdTicket() == idTicket) {
				ticketEncontrado = ticket;
				break;
			}
		}
		return ticketEncontrado;
	}
	
	public int createTicket() {
		Ticket ticket = new Ticket();
		if(tickets==null) tickets = new ArrayList<>();
		tickets.add(ticket);
		return ticket.getIdTicket();
	}
	
	public String getMensageComprasAntiguas() {
		
		StringBuilder sb = new StringBuilder();
		
		for(Ticket ticket: tickets) {
			sb.append(ticket.toString());
		}
		
		return sb.toString();
	}
	
	public String getMensajeValorTotal() {
		return "Valor de la floristeria '" + nombreFloristeria +"' con id: " + idFloristeria + "\n" + nombreFloristeria + " Precio total -> " + valorProductos() + " €";
	}
	
	public double getValorTotalTickets() {
		
		return tickets.stream().mapToDouble(ticket->ticket.getValorTicket()).sum();
	}

	public String getMensajeStock() {
		return "Stock de la floristeria con id: " + idFloristeria + " \n " + nombreFloristeria + 
				" :\n Cantidad de flores= " + flores.size() + " unidades" +
				"\n Cantidad de árboles= " + arboles.size()	+ " unidades" +
				"\n Cantidad de decoraciones= " + decoraciones.size()+" unidades\n";
	}
	
}
