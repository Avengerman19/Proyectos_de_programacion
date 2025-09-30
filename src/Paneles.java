import javax.swing.*;
import java.awt.*;

public class Paneles extends JFrame {
    public  Paneles(){
        setTitle("Teclado");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel teclado= new Teclado();
        JPanel funciones= new Funciones();
        JLabel titulo= new JLabel("Teclado");
        add(teclado, BorderLayout.CENTER);
        add(titulo, BorderLayout.NORTH);
        add(funciones, BorderLayout.EAST);
        add(new JButton("Aceptar"), BorderLayout.SOUTH);
        setVisible(true);
    }
}
