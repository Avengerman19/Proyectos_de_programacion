public class Estudiante extends Persona {
    protected int grado;
    protected String turno;

    public Estudiante(String nombre, String cargo, String sexo, int edad, int grado, String turno) {
        super(nombre, cargo, sexo, edad);
        this.grado= grado;
        this.turno=turno;
    }
    @Override
    public void mostrarInfo() {
        System.out.println("Nombre: " + nombre + " Edad: " + edad+ "Grado: " +
                grado + "Turno: " + turno + "Cargo: " + cargo+ "Sexo: " + sexo);
    }
}
