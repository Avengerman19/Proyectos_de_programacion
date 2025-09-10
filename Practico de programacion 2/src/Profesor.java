public class Profesor extends Persona {
    protected String materia;
    protected String turno;
    public Profesor(String nombre, String cargo, String sexo, int edad, String materia, String turno) {
        super(nombre, cargo, sexo, edad);
        this.materia=materia;
        this.turno=turno;
    }

    @Override
        public void mostrarInfo() {
            System.out.println("Nombre: " + nombre + " Edad: " + edad+"Materia:"+materia+
                    "Turno: " + turno + "Cargo: " + cargo+ "Sexo: " + sexo);
    }
}
