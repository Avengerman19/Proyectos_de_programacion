import java.util.ArrayList;

public class Generador {
    public int consumo=0;
    public int capacidad= 1500;
    double capacidadMaxima = capacidad * 0.25;
    ArrayList<EquipoElectrico> dispositivosConectados= new ArrayList<>();
    public void agregarDispositivo( EquipoElectrico d){
        dispositivosConectados.add(d);
        if(consumo <=1500){
           consumo += d.getPotencia();
            System.out.println("EL generador a aumentado su capacidad maxima en 25%");
        }
        if (consumo>capacidadMaxima){
            System.out.println("Se alcanzo la capacidad maxima, se apago el generador");
        }
    }
    public void desconectar(EquipoElectrico e){
        dispositivosConectados.remove(e);
    }
    public void mostrarDispositivos(){
        System.out.println(dispositivosConectados);
    }
    public void  encender(){
        System.out.println("Se encendio el generador");
    }
}
