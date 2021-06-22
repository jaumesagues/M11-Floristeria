package floristeria.model;

import java.util.List;

public class Floristeria {

	protected String nombreFloristeria;
	
				//Los nombres de las variables podemos cambiarlos. "bbdd_flores", "listaFlores", etc
	protected List<Flor> flores;
	protected List<Arbol> arboles;
	protected List<Decoracion> decoracion;
	
				//variable static para llevar recuento de los objetos de tipo Floristeria. Vendrá bien en el Nivel 2
	private static int CONTADOR_FLORISTERIAS = 1;
	
				//id de la floristeria que llevará el número del contador de objetos:
	private int idFloristeria;
	
	
				//Constructor vacio por si es necesario:
	public Floristeria() {
		
	}
	
	//Consutructor con todos los campos:
	public Floristeria(String nombreFloristeria, List<Flor> flores, List<Arbol> arboles, List<Decoracion> decoracion) {
		
		this.nombreFloristeria = nombreFloristeria;
		
		//Manejo de excepciones? Si entra una lista vacia, lanzo excepcion general, o creamos personalizadas?
		
		if(flores!=null)	this.flores = flores;

		if(arboles!=null)	this.arboles = arboles;

		if(decoracion!=null) this.decoracion = decoracion;
		
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

	public void setFlores(List<Flor> flores) {
		this.flores = flores;
	}

	public List<Arbol> getArboles() {
		return arboles;
	}

	public void setArboles(List<Arbol> arboles) {
		this.arboles = arboles;
	}

	public List<Decoracion> getDecoracion() {
		return decoracion;
	}

	public void setDecoracion(List<Decoracion> decoracion) {
		this.decoracion = decoracion;
	}

	public int getIdFloristeria() {
		return idFloristeria;
	}

	public void setIdFloristeria(int idFloristeria) {
		this.idFloristeria = idFloristeria;
	}

	@Override
	public String toString() {
		return "Floristeria [nombreFloristeria=" + nombreFloristeria + ", flores=" + flores + ", arboles=" + arboles
				+ ", decoracion=" + decoracion + ", idFloristeria=" + idFloristeria + "]";
	}
	
}
