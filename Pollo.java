public class Pollo extends Animal {
    protected String nacionalidad;
    public Pollo (String nombre, String nacionalidad) {
        super(nombre);
        this.nacionalidad= nacionalidad;
    }
    @Override
    void hacerSonido(){
        System.out.println("Pio pio");
    }
}

