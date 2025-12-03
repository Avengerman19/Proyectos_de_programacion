package controlador;

import modelo.*;
import java.awt.Point;
import java.util.Random;

public class GameLogic {
    private Vibora vibora;
    private Comida comida;
    private PowerUp powerUp;
    private int puntuacion;
    private boolean jugando;
    private final int anchoTableroOriginal;
    private final int altoTableroOriginal;
    private int anchoTableroActual;
    private int altoTableroActual;
    private final int tamanoCelda;
    private long ultimaPuntuacion;
    private static final long TIEMPO_REDUCCION = 5000;
    private int velocidadBase;
    private int velocidadActual;
    private long tiempoEfectoVelocidad;
    private boolean efectoVelocidadActivo;
    private Random random;
    private long tiempoUltimoPowerUp;
    private static final long INTERVALO_POWERUP = 10000;
    private boolean powerUpActivo;
    
    public GameLogic(int anchoTablero, int altoTablero, int tamanoCelda) {
        this.anchoTableroOriginal = anchoTablero;
        this.altoTableroOriginal = altoTablero;
        this.anchoTableroActual = anchoTablero;
        this.altoTableroActual = altoTablero;
        this.tamanoCelda = tamanoCelda;
        this.velocidadBase = 100;
        this.velocidadActual = velocidadBase;
        this.random = new Random();
        iniciar();
    }
    
    public void iniciar() {
        vibora = new Vibora(anchoTableroOriginal / 2, altoTableroOriginal / 2, tamanoCelda);
        comida = new Comida(anchoTableroOriginal, altoTableroOriginal, tamanoCelda);
        comida.generarEvitando(vibora);
        puntuacion = 0;
        jugando = true;
        ultimaPuntuacion = System.currentTimeMillis();
        anchoTableroActual = anchoTableroOriginal;
        altoTableroActual = altoTableroOriginal;
        velocidadActual = velocidadBase;
        efectoVelocidadActivo = false;
        tiempoUltimoPowerUp = System.currentTimeMillis();
        powerUpActivo = false;
        powerUp = new PowerUp();
    }
    
    public void actualizar() {
        if (!jugando) return;
        
        vibora.mover();
        
        Point cabeza = vibora.getCabeza();
        if (cabeza.x < 0 || cabeza.x >= anchoTableroActual ||
            cabeza.y < 0 || cabeza.y >= altoTableroActual) {
            gameOver();
            return;
        }
        
        if (vibora.colisionaConCuerpo()) {
            gameOver();
            return;
        }
        
        if (cabeza.equals(comida.getPosicion())) {
            vibora.crecer();
            puntuacion += 10;
            ultimaPuntuacion = System.currentTimeMillis();
            comida.generarEvitando(vibora);
        }
        
        if (powerUpActivo && cabeza.equals(powerUp.getPosicion())) {
            aplicarPowerUp(powerUp.getTipo());
            powerUpActivo = false;
        }
        
        long tiempoActual = System.currentTimeMillis();
        
        if (tiempoActual - ultimaPuntuacion > TIEMPO_REDUCCION) {
            reducirMapa();
            ultimaPuntuacion = tiempoActual;
        }
        
        if (efectoVelocidadActivo && tiempoActual - tiempoEfectoVelocidad > 3000) {
            velocidadActual = velocidadBase;
            efectoVelocidadActivo = false;
        }
        
        if (!powerUpActivo && tiempoActual - tiempoUltimoPowerUp > INTERVALO_POWERUP) {
            generarPowerUp();
            tiempoUltimoPowerUp = tiempoActual;
        }
    }
    
    private void aplicarPowerUp(TipoPowerUp tipo) {
        switch (tipo) {
            case VELOCIDAD_ALTA:
                velocidadActual = velocidadBase / 2;
                efectoVelocidadActivo = true;
                tiempoEfectoVelocidad = System.currentTimeMillis();
                break;
            case VELOCIDAD_BAJA:
                velocidadActual = velocidadBase * 2;
                efectoVelocidadActivo = true;
                tiempoEfectoVelocidad = System.currentTimeMillis();
                break;
            case AUMENTAR_TAMANO:
                vibora.aumentarTamano(3);
                break;
            case REDUCIR_TAMANO:
                vibora.reducirTamano(3);
                break;
        }
    }
    
    private void generarPowerUp() {
        if (random.nextInt(100) < 30) {
            powerUp.cambiarTipo();
            powerUp.generarPosicion(anchoTableroActual, altoTableroActual, tamanoCelda, vibora);
            powerUpActivo = true;
        }
    }
    
    private void reducirMapa() {
        int nuevoAncho = anchoTableroActual - (anchoTableroOriginal / 4);
        int nuevoAlto = altoTableroActual - (altoTableroOriginal / 4);
        
        if (nuevoAncho > tamanoCelda * 5 && nuevoAlto > tamanoCelda * 5) {
            anchoTableroActual = nuevoAncho;
            altoTableroActual = nuevoAlto;
            comida.setLimites(anchoTableroActual, altoTableroActual);
            comida.generarEvitando(vibora);
        }
    }
    
    public void cambiarDireccion(Direccion direccion) {
        vibora.cambiarDireccion(direccion);
    }
    
    private void gameOver() {
        jugando = false;
    }
    
    public Vibora getVibora() {
        return vibora;
    }
    
    public Comida getComida() {
        return comida;
    }
    
    public PowerUp getPowerUp() {
        return powerUp;
    }
    
    public boolean isPowerUpActivo() {
        return powerUpActivo;
    }
    
    public int getPuntuacion() {
        return puntuacion;
    }
    
    public boolean isJugando() {
        return jugando;
    }
    
    public int getAnchoTableroActual() {
        return anchoTableroActual;
    }
    
    public int getAltoTableroActual() {
        return altoTableroActual;
    }
    
    public long getTiempoRestante() {
        long transcurrido = System.currentTimeMillis() - ultimaPuntuacion;
        long restante = TIEMPO_REDUCCION - transcurrido;
        return restante > 0 ? restante / 1000 : 0;
    }
    
    public int getVelocidadActual() {
        return velocidadActual;
    }
}