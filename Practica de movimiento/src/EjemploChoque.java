import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EjemploChoque extends JPanel implements ActionListener, KeyListener {
    int x = 50, y = 50;
    int enemigox = 200, enemigoy = 200;
    Timer timer = new Timer(10, this);
    boolean colision = false;

    public EjemploChoque() {
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.fillRect(x, y, 50, 50);
        g.setColor(Color.BLACK);
        g.fillRect(enemigox, enemigoy, 50, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Rectangle jugador = new Rectangle(x, y, 50, 50);
        Rectangle enemigo = new Rectangle(enemigox, enemigoy, 50, 50);
        colision = jugador.intersects(enemigo);
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int codigoTecla = e.getKeyCode();
        System.out.println(codigoTecla);
        if (codigoTecla == KeyEvent.VK_LEFT) x -= 5;
        if (codigoTecla == KeyEvent.VK_RIGHT) x += 5;
        if (codigoTecla == KeyEvent.VK_UP) y -= 5;
        if (codigoTecla == KeyEvent.VK_DOWN) y += 5;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Colosion");
        JPanel panel = new EjemploChoque();
        ventana.add(panel);
        ventana.setSize(500, 500);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
