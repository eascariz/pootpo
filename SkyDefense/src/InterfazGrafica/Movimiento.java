package InterfazGrafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;

import Comun.Direccion;
import Puntaje.Juego;

public class Movimiento implements ActionListener {
	private JLabel label;
	private Juego juego;
	private Direccion direccion;
	public Movimiento(JLabel label, Juego juego, Direccion direccion) {
		this.label = label;
		this.juego = juego;
		this.direccion = direccion;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		juego.desplazar(direccion);
		int[] nuevaPos = juego.getAvion().obtenerPosicion();
		switch(direccion) {
        case ARRIBA:
        case ABAJO:
            label.setText(String.valueOf(nuevaPos[1])); // posición Y
            break;
        case IZQUIERDA:
        case DERECHA:
            label.setText(String.valueOf(nuevaPos[0])); // posición X
            break;
		}
		
	}

	
	
}
