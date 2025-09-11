public abstract class Persona {
    protected String nombre;
    protected String sexo;
    protected int edad;
    protected String cargo;
    public Persona ( String nombre, String cargo, String sexo, int edad){
        this.cargo= cargo;
        this.edad=edad;
        this.nombre= nombre;
        this.sexo= sexo;
    }
    public String getNombre() {
        return nombre;
    }
    public abstract void  mostrarInfo();
}
