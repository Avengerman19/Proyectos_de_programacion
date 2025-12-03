package modelo;

import java.awt.Point;
import java.awt.Color;
import java.util.Random;

public class PowerUp {
    private Point posicion;
    private TipoPowerUp tipo;
    private final Random random;
    
    public PowerUp() {
        this.random = new Random();
        this.tipo = TipoPowerUp.values()[random.nextInt(TipoPowerUp.values().length)];
    }
    
    public void generarPosicion(int anchoLimite, int altoLimite, int tamanoCelda, Vibora vibora) {
        do {
            int x = random.nextInt(anchoLimite / tamanoCelda) * tamanoCelda;
            int y = random.nextInt(altoLimite / tamanoCelda) * tamanoCelda;
            posicion = new Point(x, y);
        } while (vibora.colisionaConPunto(posicion));
    }
    
    public void cambiarTipo() {
        this.tipo = TipoPowerUp.values()[random.nextInt(TipoPowerUp.values().length)];
    }
    
    public Point getPosicion() {
        return posicion;
    }
    
    public TipoPowerUp getTipo() {
        return tipo;
    }
    
    public Color getColor() {
        switch (tipo) {
            case VELOCIDAD_ALTA: return Color.CYAN;
            case VELOCIDAD_BAJA: return Color.MAGENTA;
            case AUMENTAR_TAMANO: return Color.YELLOW;
            case REDUCIR_TAMANO: return Color.ORANGE;
            default: return Color.WHITE;
        }
    }
}