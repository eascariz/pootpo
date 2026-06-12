package InterfazGrafica;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Puntaje.Juego;

public class prueba {
	private static Juego juego;
	
	public static void setJuego(Juego juego) {
		prueba.juego = juego;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JPanel panelInfo = new JPanel();
		int[] pos = juego.getAvion().obtenerPosicion();
		String posX = String.valueOf(pos[0]);
		String posY = String.valueOf(pos[1]);
		String energia = String.valueOf(juego.getAvion().getEnergia());
		String vidas = String.valueOf(juego.getVidas());
		String puntaje = String.valueOf(juego.getSistemaPuntaje().getPuntaje());
		String nivel = String.valueOf(juego.getNivel());
		panelInfo.setLayout(new GridLayout(6, 2));
		panelInfo.add(new JLabel("Posición X:"));
		panelInfo.add(new JLabel(posX));
		panelInfo.add(new JLabel("Posición Y:"));
		panelInfo.add(new JLabel(posY));
		panelInfo.add(new JLabel("Energia:"));
		panelInfo.add(new JLabel(energia));
		panelInfo.add(new JLabel("Vidas:"));
		panelInfo.add(new JLabel(vidas));
		panelInfo.add(new JLabel("Puntaje:"));
		panelInfo.add(new JLabel(puntaje));
		panelInfo.add(new JLabel("Nivel:"));
		panelInfo.add(new JLabel(nivel));
		
	}

}
