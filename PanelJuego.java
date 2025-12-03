package vista;

import controlador.GameLogic;
import modelo.Direccion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelJuego extends JPanel implements ActionListener {
    private static final int TAMANO_CELDA = 20;
    private final GameLogic gameLogic;
    private Timer timer;
    private final int anchoTotal;
    private final int altoTotal;
    
    public PanelJuego(int ancho, int alto) {
        this.anchoTotal = ancho;
        this.altoTotal = alto;
        setPreferredSize(new Dimension(ancho, alto));
        setBackground(Color.BLACK);
        setFocusable(true);
        
        gameLogic = new GameLogic(ancho, alto, TAMANO_CELDA);
        timer = new Timer(gameLogic.getVelocidadActual(), this);
        timer.start();
        
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                manejarTecla(e);
            }
        });
    }
    
    private void manejarTecla(KeyEvent e) {
        int tecla = e.getKeyCode();
        
        if (tecla == KeyEvent.VK_SPACE && !gameLogic.isJugando()) {
            gameLogic.iniciar();
            timer.setDelay(gameLogic.getVelocidadActual());
            repaint();
            return;
        }
        
        if (!gameLogic.isJugando()) return;
        
        switch (tecla) {
            case KeyEvent.VK_UP:
                gameLogic.cambiarDireccion(Direccion.ARRIBA);
                break;
            case KeyEvent.VK_DOWN:
                gameLogic.cambiarDireccion(Direccion.ABAJO);
                break;
            case KeyEvent.VK_LEFT:
                gameLogic.cambiarDireccion(Direccion.IZQUIERDA);
                break;
            case KeyEvent.VK_RIGHT:
                gameLogic.cambiarDireccion(Direccion.DERECHA);
                break;
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (gameLogic.isJugando()) {
            dibujarJuego(g);
        } else {
            dibujarGameOver(g);
        }
    }
    
    private void dibujarJuego(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        
        int anchoActual = gameLogic.getAnchoTableroActual();
        int altoActual = gameLogic.getAltoTableroActual();
        
        g2d.setColor(new Color(50, 50, 50));
        g2d.setStroke(new BasicStroke(3));
        g2d.drawRect(0, 0, anchoActual, altoActual);
        
        g2d.setColor(new Color(30, 30, 30));
        for (int i = anchoActual; i < anchoTotal; i += 20) {
            g2d.fillRect(i, 0, 20, altoTotal);
        }
        for (int i = altoActual; i < altoTotal; i += 20) {
            g2d.fillRect(0, i, anchoTotal, 20);
        }
        
        Point comida = gameLogic.getComida().getPosicion();
        g.setColor(Color.RED);
        g.fillOval(comida.x, comida.y, TAMANO_CELDA, TAMANO_CELDA);
        
        if (gameLogic.isPowerUpActivo()) {
            Point powerUpPos = gameLogic.getPowerUp().getPosicion();
            g.setColor(gameLogic.getPowerUp().getColor());
            g.fillRect(powerUpPos.x, powerUpPos.y, TAMANO_CELDA, TAMANO_CELDA);
            g.setColor(Color.BLACK);
            g.drawRect(powerUpPos.x, powerUpPos.y, TAMANO_CELDA, TAMANO_CELDA);
        }
        
        var segmentos = gameLogic.getVibora().getSegmentos();
        for (int i = 0; i < segmentos.size(); i++) {
            Point segmento = segmentos.get(i);
            if (i == 0) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(new Color(0, 200, 0));
            }
            g.fillRect(segmento.x, segmento.y, TAMANO_CELDA, TAMANO_CELDA);
            g.setColor(Color.BLACK);
            g.drawRect(segmento.x, segmento.y, TAMANO_CELDA, TAMANO_CELDA);
        }
        
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Puntuación: " + gameLogic.getPuntuacion(), 10, 25);
        
        String tiempoRestante = "Tiempo: " + gameLogic.getTiempoRestante() + "s";
        FontMetrics fm = g.getFontMetrics();
        g.drawString(tiempoRestante, anchoTotal - fm.stringWidth(tiempoRestante) - 10, 25);
    }
    
    private void dibujarGameOver(Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        String mensaje = "Game Over";
        FontMetrics fm = g.getFontMetrics();
        g.drawString(mensaje, (getWidth() - fm.stringWidth(mensaje)) / 2, getHeight() / 2 - 50);
        
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        String puntos = "Puntuación Final: " + gameLogic.getPuntuacion();
        g.drawString(puntos, (getWidth() - g.getFontMetrics().stringWidth(puntos)) / 2, getHeight() / 2);
        
        String reiniciar = "Presiona ESPACIO para reiniciar";
        g.drawString(reiniciar, (getWidth() - g.getFontMetrics().stringWidth(reiniciar)) / 2, getHeight() / 2 + 40);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (gameLogic.isJugando()) {
            gameLogic.actualizar();
            timer.setDelay(gameLogic.getVelocidadActual());
            repaint();
        }
    }
}