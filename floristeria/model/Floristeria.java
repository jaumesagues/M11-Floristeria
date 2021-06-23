package floristeria.model;

import java.util.ArrayList;
import java.util.List;

public class Floristeria {

	protected String nombreFloristeria;
	
				//Los nombres de las variables podemos cambiarlos. "bbdd_flores", "listaFlores", etc
	protected List<Flor> flores;
	protected List<Arbol> arboles;
	protected List<Decoracion> decoraciones;
	
				//variable static para llevar recuento de los objetos de tipo Floristeria. Vendrá bien en el Nivel 2
	private static int CONTADOR_FLORISTERIAS = 1;
	
				//id de la floristeria que llevará el número del contador de objetos:
	private int idFloristeria;
	
	
				//Constructor vacio por si es necesario:
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


	//Getters y setters por defecto
	
	public String getNombreFloristeria() {
		return nombreFloristeria;
	}

	public void setNombreFloristeria(String nombreFloristeria) {
		this.nombreFloristeria = nombreFloristeria;
	}

	public List<Flor> getFlores() {
		return flores;
	}

	public void addFlor(String colorFlor, double precioFlor) {
		
		if(flores!=null)	flores.add(new Flor(precioFlor, colorFlor));
		else System.err.println("La lista de flores no está creada");
		
	}

	public List<Arbol> getArboles() {
		return arboles;
	}

	public void addArbol(double alturaArbol, double precioArbol) {
		if(arboles!=null)	arboles.add(new Arbol(precioArbol, alturaArbol));
		else System.err.println("La lista de arboles no está creada");
	}
	
	public void addDecoracion(String nombreMaterial, double precioDecoracion) {
		if(decoraciones!=null) decoraciones.add(new Decoracion(precioDecoracion, nombreMaterial));
		else System.err.println("La lista de decoraciones no está creada");
	}

	public List<Decoracion> getDecoraciones() {
		return decoraciones;
	}

	public int getIdFloristeria() {
		return idFloristeria;
	}

	public int getStock() {
		return CONTADOR_FLORISTERIAS;
	}

	@Override
	public String toString() {
		return "Floristeria [nombreFloristeria=" + nombreFloristeria + ", flores=" + flores + ", arboles=" + arboles
				+ ", decoracion=" + decoraciones + ", idFloristeria=" + idFloristeria + "]";
	}
	
}
