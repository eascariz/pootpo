package InterfazGrafica;

import Avion.Avion;

public class MenuInicio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Avion avion = new Avion(3,2000,2);
		System.out.println("AVION");
		System.out.println(avion.toString());
		System.out.println("giro a la izquierda");
		avion.actualizarPosicion("izquierda");
		System.out.println(avion.toString());
		System.out.println("giro a la derecha");
		avion.actualizarPosicion("derecha");
		System.out.println(avion.toString());
		System.out.println("subio");
		avion.actualizarPosicion("arriba");
		System.out.println(avion.toString());
		System.out.println("bajo");
		avion.actualizarPosicion("abajo");
		System.out.println(avion.toString());
		
	}

}
