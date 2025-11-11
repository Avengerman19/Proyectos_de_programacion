import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class EjemploMovimiento extends JPanel implements ActionListener, KeyListener {
    int x=50, y= 50;
    Timer timer= new Timer(10, this);
    public EjemploMovimiento(){
        timer.start();
        setFocusable(true);
        addKeyListener(this);
    }
    public void  paintComponent(Graphics g){
        g.setColor(Color.black);
        g.fillOval(x,y,50,50);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        int codigoTecla=e.getKeyCode();
        System.out.println(codigoTecla);
        if (codigoTecla==KeyEvent.VK_RIGHT) x+=5;
        if (codigoTecla==KeyEvent.VK_LEFT) x-=5;
        if (codigoTecla==KeyEvent.VK_UP)y-=5;
        if ((codigoTecla==KeyEvent.VK_DOWN)) y+=5;
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    public static void main(String[] args){
        JFrame ventana=new JFrame("Waos");
        JPanel panel= new EjemploMovimiento();
        ventana.add(panel);
        ventana.setSize(500,500);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ventana.setVisible(true);
    }
}
