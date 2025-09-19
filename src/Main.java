public class Main{
    public static void main(String[] args){
        EquipoElectrico v= new Ventilador("Normal", "Ventilador",220);
        EquipoElectrico c= new Cargador("Proolongado", "Cargador", 60);
        EquipoElectrico t= new Televisor("Medio", "Televisor", 220);
        Generador g= new Generador();
        g.encender();
        g.agregarDispositivo(v);
        g.agregarDispositivo(c);
        g.agregarDispositivo(t);
        g.mostrarDispositivos();
    }
}