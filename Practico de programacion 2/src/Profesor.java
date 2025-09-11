public class Profesor extends Persona {
    protected String materia;
    protected String turno;
    public Profesor(String nombre, String cargo, String sexo, int edad, String materia, String turno) {
        super(nombre, cargo, sexo, edad);
        this.materia=materia;
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
        System.out.println("-Materia: " + materia);
        System.out.println("-Turno: "+ turno);
    }
}
