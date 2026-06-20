package InterfazGrafica;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.util.List;

import Avion.Avion;
import Drones.Dron;
import Drones.Escuadron;
import Drones.Misil;

public class PanelJuego extends JPanel {
    private Avion avion;
    private Escuadron escuadron;

    private static final int ALTURA_PANEL = 400;
    private static final int ANCHO_PANEL = 800;

    public PanelJuego(Avion avion, Escuadron escuadron) {
        this.avion = avion;
        this.escuadron = escuadron;
        setBackground(Color.CYAN);
        setPreferredSize(new java.awt.Dimension(ANCHO_PANEL, ALTURA_PANEL));
    }

    private int escalarY(int posicionYJuego) {
        int rango = 5000 - 1000;
        int proporcion = (posicionYJuego - 1000) * ALTURA_PANEL / rango;
        return ALTURA_PANEL - proporcion;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // dibujar avion (rectangulo azul)
        int[] posAvion = avion.obtenerPosicion();
        int avionX = posAvion[0];
        int avionY = escalarY(posAvion[1]);
        g.setColor(Color.BLUE);
        g.fillRect(avionX, avionY, 30, 15);

        // dibujar drones (cuadrados rojos)
        List<Dron> drones = escuadron.getDrones();
        g.setColor(Color.RED);
        for(Dron dron : drones) {
            int[] posDron = dron.getPosicion();
            int dronY = escalarY(posDron[1]);
            g.fillRect(posDron[0], dronY, 25, 25);
        }

        // dibujar misiles (circulos negros)
        List<Misil> misiles = escuadron.getMisiles();
        g.setColor(Color.BLACK);
        for(Misil misil : misiles) {
            int[] posMisil = misil.getPosicion();
            int misilY = escalarY(posMisil[1]);
            g.fillOval(posMisil[0], misilY, 10, 10);
        }
    }
}