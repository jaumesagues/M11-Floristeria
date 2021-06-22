package floristeria.model;

public class Flor extends ProductoFloristeria{
	
	private String color;

	public Flor(double precio, String color) {
		super(precio);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return "Flor [color=" + color + "]";
	}

}
