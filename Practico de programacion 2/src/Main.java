public class Main {
    public static void main(String[] args){
        Estudiante e1= new Estudiante("Juanca", "Estudiante", "Masculino",45, 1, "Tarde");
        Estudiante e2=new Estudiante("MamAriel", "Estudiante", "No definido", 65, -1, "Nocturno");
        Estudiante e3=new Estudiante("MamAntuan", "Estudiante", "No definido", 88, 2, "Nocturno");
        Estudiante e4=new Estudiante("Sech", "Estudiante", "Sin registro", 56, 1, "Diurno");
        Profesor p1= new Profesor("PapAlvaro", "Inge", "Masculino", 19, "Programacion", "Todo el dia");
        Profesor p2=new Profesor("Lizarazu", "Profesor", "Masculino", 20, "Adminnistracion", "Noche");
        Profesor p3=new Profesor("Marioly", "Profesora", "Femenino", 30, "Calculo I", "Mañana");
        Director director= new Director();
        director.agregarEstudiantes(e1);
        director.agregarEstudiantes(e2);
        director.agregarEstudiantes(e3);
        director.agregarEstudiantes(e4);
        director.agregarProfesores(p1);
        director.agregarProfesores(p2);
        director.agregarProfesores(p3);
        director.buscarEstudiante("Sech");
        director.buscarProfesor("PapAlvaro");
        }
    }

