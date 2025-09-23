import java.util.ArrayList;

public class Agenda implements IAgenda {
    private ArrayList<Contacto> contactos;

    public Agenda() {
        contactos = new ArrayList<>();
    }

    @Override
    public void agregarContacto(Contacto c) {
        contactos.add(c);
        System.out.println("Contacto Agregado");
    }

    @Override
    public void eliminarPorNombre(String nombre) {

    }

    @Override
    public void buscarPorNombre(String nombre) {
        boolean encontrado = false;
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                c.info();
                encontrado = true;
                break;
            }
        }

        if (!encontrado)
            System.out.println("Contacto no encontrado");
    }


    @Override
    public void mostrarTodos() {

    }

    @Override
    public void buscarTelefono(String telefono) {

    }
}


