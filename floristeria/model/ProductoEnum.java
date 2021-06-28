package floristeria.model;

public class ProductoEnum {
	public enum TipoProducto {
		ARBOL(0), FLOR(1), DECORACION(2);
		
		TipoProducto(int i) {
			// TODO Auto-generated constructor stub
		}
		
		public static TipoProducto GetTipoProducto(int i) {
			switch (i) {
			case 0:
				return TipoProducto.ARBOL;
			case 1:
				return TipoProducto.FLOR;
			case 2:
				return TipoProducto.DECORACION;
			default:
				return null;
			}
		}
	}
}
