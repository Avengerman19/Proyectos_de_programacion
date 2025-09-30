import javax.swing.*;
import java.awt.*;

public class Funciones extends JPanel{
    public Funciones() {
        setLayout(new GridLayout(4,1));
        add(new JButton("+"));
        add(new JButton("-"));
        add(new JButton("*"));
        add(new JButton("/"));

    }
}
