import java.util.ArrayList;

public class Director {
    ArrayList<Profesor> listaProfesores=new ArrayList<>();
    ArrayList<Estudiante> listaEstudiantes= new ArrayList<>();
    public void agregarEstudiantes(Estudiante e) {
        listaEstudiantes.add(e);
    }
    public void agregarProfesores(Profesor p) {
        listaProfesores.add(p);
    }

}
