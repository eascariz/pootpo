package InterfazGrafica;

import Avion.Avion;
import Comun.Direccion;

public class MenuInicio {

	public static void main(String[] args) {
		Avion avion = new Avion(3, 2000, 2);
		System.out.println("AVION");
		System.out.println(avion.toString());
		System.out.println("giro a la izquierda");
		avion.actualizarPosicion(Direccion.IZQUIERDA);
		System.out.println(avion.toString());
		System.out.println("giro a la derecha");
		avion.actualizarPosicion(Direccion.DERECHA);
		System.out.println(avion.toString());
		System.out.println("subio");
		avion.actualizarPosicion(Direccion.ARRIBA);
		System.out.println(avion.toString());
		System.out.println("bajo");
		avion.actualizarPosicion(Direccion.ABAJO);
		System.out.println(avion.toString());
	}
}