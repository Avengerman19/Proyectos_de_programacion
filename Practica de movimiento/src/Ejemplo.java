import javax.swing.*;
import java.awt.*;

public class Ejemplo extends JPanel {
    public void paintComponent(Graphics g){
     super.paintComponent(g);
     g.setColor(Color.black);
     g.fillOval(50,50,50,50);
     g.setColor(Color.BLUE);
     g.fillRect(100,100,50,50);
    }
    public static void main (String[] args){
        JFrame ventana = new JFrame("Hola Juanca");
        JPanel panel= new Ejemplo();
        ventana.add(panel);
        ventana.setSize(500,500);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
