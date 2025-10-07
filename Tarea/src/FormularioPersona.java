import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioPersona extends JFrame {


    private final JTextField nombreField;
    private final JTextField apellidoField;
    private final JTextField edadField;
    private final JTextField emailField;
    private final JTextField telefonoField;
    private final JTextField direccionField;
    private final JTextArea resultadoArea;

    public FormularioPersona() {
        setTitle("Formulario de Persona");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JPanel panelIzquierdo = new JPanel(new GridLayout(7, 2, 5, 5));
        panelIzquierdo.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        panelIzquierdo.add(new JLabel("Nombre:"));
        nombreField = new JTextField();
        panelIzquierdo.add(nombreField);

        panelIzquierdo.add(new JLabel("Apellido:"));
        apellidoField = new JTextField();
        panelIzquierdo.add(apellidoField);

        panelIzquierdo.add(new JLabel("Edad:"));
        edadField = new JTextField();
        panelIzquierdo.add(edadField);

        panelIzquierdo.add(new JLabel("Email:"));
        emailField = new JTextField();
        panelIzquierdo.add(emailField);

        panelIzquierdo.add(new JLabel("Teléfono:"));
        telefonoField = new JTextField();
        panelIzquierdo.add(telefonoField);

        panelIzquierdo.add(new JLabel("Dirección:"));
        direccionField = new JTextField();
        panelIzquierdo.add(direccionField);


        JButton guardarBtn = new JButton("Guardar");
        JButton borrarBtn = new JButton("Borrar");

        panelIzquierdo.add(guardarBtn);
        panelIzquierdo.add(borrarBtn);


        resultadoArea = new JTextArea();
        resultadoArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultadoArea);


        add(panelIzquierdo, BorderLayout.WEST);
        add(scrollPane, BorderLayout.CENTER);


        guardarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultado = "Datos Ingresados:\n";
                resultado += "Nombre: " + nombreField.getText() + "\n";
                resultado += "Apellido: " + apellidoField.getText() + "\n";
                resultado += "Edad: " + edadField.getText() + "\n";
                resultado += "Email: " + emailField.getText() + "\n";
                resultado += "Teléfono: " + telefonoField.getText() + "\n";
                resultado += "Dirección: " + direccionField.getText() + "\n";

                resultadoArea.setText(resultado);
            }
        });

        borrarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombreField.setText("");
                apellidoField.setText("");
                edadField.setText("");
                emailField.setText("");
                telefonoField.setText("");
                direccionField.setText("");
                resultadoArea.setText("");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new FormularioPersona();
    }
}
