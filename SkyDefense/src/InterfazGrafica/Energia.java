package InterfazGrafica;

import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import Puntaje.Juego;

public class Energia {
	private int energia;
	private JLabel label;
	private Juego juego;
	public Energia(JLabel label, Juego juego) {
		super();
		this.energia = juego.getAvion().getEnergia();
		this.label = label;
		this.juego = juego;
	}
	
	public void actionPerformed(ActionEvent dato) {
		label.setText(String.valueOf(energia));
	}
	
}
