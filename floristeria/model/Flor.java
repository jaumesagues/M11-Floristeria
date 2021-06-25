package floristeria.model;

public class Flor extends ProductoFloristeria{
	
	private int idFlor;
	private String color;
	private static int CONTADOR_FLORES = 1;

	public Flor(double precio, String color) {
		super(precio);
		this.color = color;
		idFlor = CONTADOR_FLORES;
		CONTADOR_FLORES++;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public int getIdFlor() {
		return idFlor;
	}
	
	public int getTotalFlores() {
		return CONTADOR_FLORES;
	}

	@Override
	public String toString() {
		return "Flor [idFlor=" + idFlor + ", color=" + color + "]";
	}

}
