package vista;

import javax.swing.*;

public class VentanaJuego extends JFrame {
    private static final int ANCHO = 600;
    private static final int ALTO = 600;
    
    public VentanaJuego() {
        setTitle("Juego de la Víbora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        
        PanelJuego panelJuego = new PanelJuego(ANCHO, ALTO);
        add(panelJuego);
        
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VentanaJuego());
    }
}