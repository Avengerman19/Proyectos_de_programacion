package modelo;

import java.awt.Point;
import java.util.Random;

public class Comida {
    private Point posicion;
    private final Random random;
    private int anchoTablero;
    private int altoTablero;
    private final int tamanoCelda;
    private int limiteAncho;
    private int limiteAlto;
    
    public Comida(int anchoTablero, int altoTablero, int tamanoCelda) {
        this.anchoTablero = anchoTablero;
        this.altoTablero = altoTablero;
        this.tamanoCelda = tamanoCelda;
        this.limiteAncho = anchoTablero;
        this.limiteAlto = altoTablero;
        this.random = new Random();
        generar();
    }
    
    public void generar() {
        int x = random.nextInt(limiteAncho / tamanoCelda) * tamanoCelda;
        int y = random.nextInt(limiteAlto / tamanoCelda) * tamanoCelda;
        posicion = new Point(x, y);
    }
    
    public void generarEvitando(Vibora vibora) {
        do {
            generar();
        } while (vibora.colisionaConPunto(posicion));
    }
    
    public void setLimites(int ancho, int alto) {
        this.limiteAncho = ancho;
        this.limiteAlto = alto;
    }
    
    public Point getPosicion() {
        return posicion;
    }
}