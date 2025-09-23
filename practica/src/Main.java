import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        IAgenda agendaVirtual = new Agenda();
        Scanner dato = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1. Agregar contacto ");
            System.out.println("2. Buscar contacto por nombre ");
            System.out.println("3. Buscar contacto por numero ");
            System.out.println("4. Mostrar todos los contactos");
            System.out.println("5. Eliminar contacto por nombre");
            System.out.println("0. Salir");
            opcion = Integer.parseInt(dato.nextLine());
            switch (opcion) {
                case 1:
                    System.out.println("Nombre: ");
                    String nombre = dato.nextLine();
                    System.out.println("Telefono: ");
                    int telefono = dato.nextInt();
                    agendaVirtual.agregarContacto(new Contacto(nombre, telefono));
                    System.out.println("Contacto agregado");
                    break;
                case 2:
                    System.out.println("Nombre a buscar");
                    String nombreBuscar = dato.nextLine();
                    agendaVirtual.buscarPorNombre(nombreBuscar);
                    System.out.println("Encontrado: "+ nombreBuscar);
                    break;
                case 3 :
                    System.out.println("Telefono: ");
                    String telefonoBuscado =dato.nextLine();
                    agendaVirtual.buscarTelefono(telefonoBuscado);
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        } while (opcion!=0);
    }
}