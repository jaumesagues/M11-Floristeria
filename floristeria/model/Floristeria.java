package floristeria.model;

import java.util.ArrayList;
import java.util.List;

import floristeria.model.Material.TipoMaterial;

public class Floristeria {

	protected String nombreFloristeria;
	
	protected List<Flor> flores;
	protected List<Arbol> arboles;
	protected List<Decoracion> decoraciones;
	
	private static int CONTADOR_FLORISTERIAS = 1;
	
	private int idFloristeria;
	
	
	//CONSTRUCTORES:
	public Floristeria() {
		
	}
	
	public Floristeria(String nombreFloristeria) {
		
		this.nombreFloristeria = nombreFloristeria;
		
		flores = new ArrayList<>();
		arboles = new ArrayList<>();
		decoraciones = new ArrayList<>();
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
	
	public void deleteFlorById(int id) {

		if (!getFlores().isEmpty()) {
			for (Flor flor : getFlores()) {
				if (flor.getIdFlor() == id) {
					getFlores().remove(flor);
					System.out.println("Eliminado arbol: " + flor.toString());
					break;
				}
			}
		} else {
			System.err.println("La lista de flores se encuentra vacía");
		}
	}
	
	public void deleteArbolById(int id) {

		if (!getArboles().isEmpty()) {
			for (Arbol arbol : getArboles()) {
				if (arbol.getIdArbol() == id) {
					getArboles().remove(arbol);
					System.out.println("Eliminado arbol: " + arbol.toString());
					break;
				}	
			}
		} else {
			System.err.println("La lista de árboles se encuentra vacía");
		}
	}

	public void deleteDecoracionById(int id) {

		if (!getDecoraciones().isEmpty()) {
			for (Decoracion decoracion : getDecoraciones()) {
				if (decoracion.getIdDecoracion() == id) {
					getDecoraciones().remove(decoracion);
					System.out.println("Eliminada decoracion: " + decoracion.toString());
					break;
				}
			}
		} else {
			System.err.println("La lista de árboles se encuentra vacía");
		}
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
	
	public String getMensajeValorTotal() {
		return "Valor de la floristeria con id: " + idFloristeria + "\n" + nombreFloristeria + "Precio total -> " + valorProductos() + " €";
	}

	public String getMensajeStock() {
		return "Stock de la floristeria con id: " + idFloristeria + " \n " + nombreFloristeria + 
				" :\n Cantidad de flores= " + flores.size() + " unidades" +
				"\n Cantidad de árboles= " + arboles.size()	+ " unidades" +
				"\n Cantidad de decoraciones= " + decoraciones.size()+" unidades\n";
	}
	
}
