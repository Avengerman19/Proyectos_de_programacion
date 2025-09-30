import javax.swing.*;
import java.awt.*;

public class Teclado extends JPanel {
    public Teclado (){
        setLayout(new GridLayout(4,3));
        JButton boton1= new JButton("1");
        JButton boton2= new JButton("2");
        JButton boton3= new JButton("3");
        JButton boton4= new JButton("4");
        JButton boton5= new JButton("5");
        JButton boton6= new JButton("6");
        JButton boton7= new JButton("7");
        JButton boton8= new JButton("8");
        JButton boton9= new JButton("9");
        JButton boton10= new JButton("0");
        JButton boton11= new JButton("%");
        JButton boton12= new JButton(".");
        add(boton1);
        add(boton2);
        add(boton3);
        add(boton4);
        add(boton5);
        add(boton6);
        add(boton7);
        add(boton8);
        add(boton9);
        add(boton10);
        add(boton11);
        add(boton12);
    }
}
