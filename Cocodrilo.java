public class Cocodrilo extends Animal {
    protected int tamano;
    public Cocodrilo (String nombre, int tamano) {
        super(nombre);
        this.tamano= tamano;
    }
    @Override
    void hacerSonido(){
        System.out.println("¡Rawr!");
    }
}
