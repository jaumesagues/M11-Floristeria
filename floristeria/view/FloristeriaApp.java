package floristeria.view;

import floristeria.model.Floristeria;

public class FloristeriaApp {
	
	private static InterficieConsola interficie;

	public static void main(String[] args) {
		
		
		//Se crea la floristeria
		Floristeria f = new Floristeria("f");
		
		//Añado stock:
		System.out.println("\nAñadiendo flores: ");
		f.addFlor("verde", 10);
		f.addFlor("roja", 10);
		f.addFlor("azul", 10);
		f.addFlor("marron", 10);
		f.addFlor("amarilla", 10);
		
		System.out.println("\nAñadiendo arboles: ");
		f.addArbol(10, 12);
		f.addArbol(10, 12);
		f.addArbol(10, 12);
		
		System.out.println("\nSTOCK");
		System.out.println(f.getMensajeStock());
		
		//Creo tickets para iniciar compra: 
		System.out.println("\nCreando tickets: ");
		f.createTicket();
		f.createTicket();
		
		System.out.println("\nTICKET 1");
		System.out.println("Vendiendo producto 1");
		f.sellProduct(1, 1, 1);
		System.out.println("Vendiendo producto 2");
		f.sellProduct(1, 1, 2);
		System.out.println("Vendiendo producto 3");
		f.sellProduct(1, 1, 3);
		
		System.out.println("\nTICKET 2");
		System.out.println("Vendiendo producto 1");
		f.sellProduct(2, 0, 1);
		System.out.println("Vendiendo producto 2");
		f.sellProduct(2, 0, 2);
		
		//Datos tras las dos compras (2 tickets): 
		System.out.println("\nSTOCK");
		System.out.println(f.getMensajeStock());
		System.out.println("\nVALOR");
		System.out.println(f.getMensajeValorTotal());
		
		System.out.println("\nINFO TICKETS: ");
		System.out.println("Ticket 1" + f.getTicketById(1).toString());
		System.out.println("Ticket 2" + f.getTicketById(2).toString());
		
		
		System.out.println("\nCompras antiguas: ");
		System.out.println(f.getMensageComprasAntiguas());
		
		interficie=new InterficieConsola();
		interficie.Ejecutar();
		
	}

}
