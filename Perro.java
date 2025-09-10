public class Perro extends Animal {
    protected String raza;
    public Perro(String nombre, String raza) {
        super(nombre);
        this.raza=raza;
    }
    @Override
    void hacerSonido(){
        System.out.println("¡Guau guau!");
    }
}
