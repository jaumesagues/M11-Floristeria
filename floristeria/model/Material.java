package floristeria.model;

public class Material {

	public enum TipoMaterial {

		//aquí también podríamos utilizar valores (1 - 2) en lugar de Strings
		MADERA("madera",0), PLASTICO("plastico",1);

		TipoMaterial(String string, int i) {
			// TODO Auto-generated constructor stub
		}
		
		public static TipoMaterial GetTipoMaterial(int i) {
			switch (i) {
			case 0:
				return TipoMaterial.MADERA;
			case 1:
				return TipoMaterial.PLASTICO;
			default:
				return null;
			}
		}
		
	}

}
