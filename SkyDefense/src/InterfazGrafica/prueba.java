package InterfazGrafica;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Avion.Avion;
import Drones.Escuadron;
import Puntaje.Juego;
import Puntaje.SistemaPuntaje;

public class prueba {

	public static void main(String[] args) {
		Avion avion = new Avion(300, 400, 2);
		Escuadron escuadron = new Escuadron(800);
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
		JPanel panelContenedorInfo = new JPanel();
		panelContenedorInfo.setLayout(new BorderLayout());
		panelContenedorInfo.add(panelInfo, BorderLayout.WEST);

		
		
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
		panelControl.add(new JLabel());       
		panelControl.add(izq);                 
		panelControl.add(new JLabel());        
		panelControl.add(der);                 
		panelControl.add(new JLabel());        
		panelControl.add(abajo);              
		panelControl.add(new JLabel());        
		/*
		panelControl.add(izq,BorderLayout.WEST);
		panelControl.add(der,BorderLayout.EAST);
		panelControl.add(arriba,BorderLayout.NORTH);
		panelControl.add(abajo,BorderLayout.SOUTH);
		JPanel panelContenedorControl = new JPanel();
		panelContenedorControl.setLayout(new GridLayout(3,3));
		panelContenedorControl.add(panelControl,GridLayout().CENTER);
		*/
		
		// titulo
		JFrame pantalla = new JFrame("SkyDefence");
		pantalla.add(panelContenedorInfo,BorderLayout.NORTH);
		pantalla.add(panelControl,BorderLayout.SOUTH);
		pantalla.setSize(600,400);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setVisible(true);
	}
}