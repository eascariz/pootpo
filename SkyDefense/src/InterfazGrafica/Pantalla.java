package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Avion.Avion;
import Comun.Direccion;
import Drones.Escuadron;
import Puntaje.Juego;
import Puntaje.SistemaPuntaje;

public class 	Pantalla {

	public static void main(String[] args) {
		Avion avion = new Avion(300, 1500, 2);
		Escuadron escuadron = new Escuadron(100);
		SistemaPuntaje sistemaPuntaje = new SistemaPuntaje();
		Juego juego = new Juego(1, 3, avion, escuadron, sistemaPuntaje);

		JPanel panelInfo = new JPanel();
		int[] pos = juego.getAvion().obtenerPosicion();
		String posX = String.valueOf(pos[0]);
		String posY = String.valueOf(pos[1]);
		String energia = String.valueOf(juego.getAvion().getEnergia());
		String vidas = String.valueOf(juego.getVidas());
		String puntaje = String.valueOf(juego.getSistemaPuntaje().getPuntaje());
		String nivel = String.valueOf(juego.getNivel());
		panelInfo.setLayout(new GridLayout(6, 2));

		JLabel lblPosY = new JLabel(posY);
		JLabel lblPosX = new JLabel(posX);
		JLabel lblEnergia = new JLabel(energia);
		JLabel lblVidas = new JLabel(vidas);
		JLabel lblPuntaje = new JLabel(puntaje);
		JLabel lblNivel = new JLabel(nivel);
		panelInfo.add(new JLabel("Posición X:"));
		panelInfo.add(lblPosX);
		panelInfo.add(new JLabel("Posición Y:"));
		panelInfo.add(lblPosY);
		panelInfo.add(new JLabel("Energia:"));
		panelInfo.add(lblEnergia);
		panelInfo.add(new JLabel("Vidas:"));
		panelInfo.add(lblVidas);
		panelInfo.add(new JLabel("Puntaje:"));
		panelInfo.add(lblPuntaje);
		panelInfo.add(new JLabel("Nivel:"));
		panelInfo.add(lblNivel);
		JPanel panelContenedorInfo = new JPanel();
		panelContenedorInfo.setLayout(new BorderLayout());
		panelContenedorInfo.add(panelInfo, BorderLayout.WEST);

		// panel de juego (visual)
		PanelJuego panelJuego = new PanelJuego(avion, escuadron);

		// botones de control
		JPanel panelControl = new JPanel();
		panelControl.setLayout(new GridLayout(3,3));
		JButton izq = new JButton();
		JButton der = new JButton();
		JButton arriba = new JButton();
		JButton abajo = new JButton();
		izq.setText("️️⬅️️");
		der.setText("➡️");
		arriba.setText("⬆️");
		abajo.setText("⬇️");
		panelControl.add(new JLabel());
		panelControl.add(arriba);
		arriba.addActionListener(new Movimiento(lblPosY, juego, Direccion.ARRIBA));
		panelControl.add(new JLabel());
		panelControl.add(izq);
		izq.addActionListener(new Movimiento(lblPosX, juego, Direccion.IZQUIERDA));
		panelControl.add(new JLabel());
		panelControl.add(der);
		der.addActionListener(new Movimiento(lblPosX, juego, Direccion.DERECHA));
		panelControl.add(new JLabel());
		panelControl.add(abajo);
		abajo.addActionListener(new Movimiento(lblPosY, juego, Direccion.ABAJO));
		panelControl.add(new JLabel());

		JFrame pantalla = new JFrame("SkyDefence");
		pantalla.add(panelContenedorInfo, BorderLayout.NORTH);
		pantalla.add(panelJuego, BorderLayout.CENTER);
		pantalla.add(panelControl, BorderLayout.SOUTH);
		pantalla.pack();
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla.setVisible(true);

		juego.iniciarNivel();
		new CicloJuego(lblEnergia, lblVidas, lblPuntaje, juego, escuadron, panelJuego);
	}
}













		/*
		panelControl.add(izq,BorderLayout.WEST);
		panelControl.add(der,BorderLayout.EAST);
		panelControl.add(arriba,BorderLayout.NORTH);
		panelControl.add(abajo,BorderLayout.SOUTH);
		JPanel panelContenedorControl = new JPanel();
		panelContenedorControl.setLayout(new GridLayout(3,3));
		panelContenedorControl.add(panelControl,GridLayout().CENTER);
		*/