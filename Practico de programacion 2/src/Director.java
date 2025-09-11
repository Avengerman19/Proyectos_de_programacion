import java.util.ArrayList;

public class Director {
    ArrayList<Profesor> listaProfesores = new ArrayList<>();
    ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();

    public void agregarEstudiantes(Estudiante e) {
        listaEstudiantes.add(e);
    }

    public void agregarProfesores(Profesor p) {
        listaProfesores.add(p);
    }

    public void buscarEstudiante(String nombre) {
        for (Estudiante e : listaEstudiantes) {
            if (e.getNombre().equals(nombre)) {
                System.out.println("///Estudiante encontrado///");
                e.mostrarInfo();
                return;
            }
        }
        System.out.println("///Estudiante no encontrado///");
    }

    public void buscarProfesor(String nombre) {
        for (Profesor p : listaProfesores) {
            if (p.getNombre().equals(nombre)) {
                System.out.println("///Profesor encontrado///");
                p.mostrarInfo();
                return;
            }
        }
        System.out.println("///Profesor no encontrado///");
    }
    public void mostrarListaprofesores(){
        for (Profesor p: listaProfesores){
            System.out.println("///Informacion del Profesor///");
            p.mostrarInfo();
        }
    }
    public void mostrarListaEstudiantes() {
        for (Estudiante e : listaEstudiantes) {
            System.out.println("///Informacion del Estudiante///");
            e.mostrarInfo();
        }
    }
}


