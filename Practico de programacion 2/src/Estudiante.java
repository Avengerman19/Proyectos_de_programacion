public class Estudiante extends Persona {
    protected int grado;
    protected String turno;

    public Estudiante(String nombre, String cargo, String sexo, int edad, int grado, String turno) {
        super(nombre, cargo, sexo, edad);
        this.grado= grado;
        this.turno=turno;
    }
    public String getNombre() {
        return super.getNombre();
    }
    @Override
    public void mostrarInfo() {
        System.out.println("-Nombre: " + nombre);
        System.out.println("-Cargo: " + cargo);
        System.out.println("-Sexo: " + sexo);
        System.out.println("-Edad: " + edad);
        System.out.println("-Grado: " + grado);
        System.out.println("-Turno: "+ turno);
    }
}
