package Drones;

public class Misil extends EntidadVoladora {
	
	private int altitudDeDetonacion;
	private int velocidadDeCaida;
	
	public Misil(int altitudDeDetonacion, int velocidadDeCaida, int posicionX, int posicionY) {
		super(posicionX, posicionY);
		// TODO Auto-generated constructor stub
		this.altitudDeDetonacion = altitudDeDetonacion;
		this.velocidadDeCaida = velocidadDeCaida;
	}
	
	@Override
	public void actualizarPosicion(String dir) {
		// TODO Auto-generated method stub
	}

	public boolean verificarAltitud(){
		if(altitudDeDetonacion == posicionY) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void aumentarVelocidad(int porcentaje) {
		
	}
	
	public int limiteAltMisil() {
		
	}
	
	public void newMisil(int posX, int posY, int altitud, float vel) {
		
	}
	
	public void detonar(int radio) {
		Explosion explosion = new Explosion(posicionX,posicionY,radio);
	}
}
