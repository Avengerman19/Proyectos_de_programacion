package modelo;

import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class Vibora {
    private ArrayList<Point> segmentos;
    private Direccion direccion;
    private final int tamanoCelda;
    
    public Vibora(int x, int y, int tamanoCelda) {
        this.tamanoCelda = tamanoCelda;
        this.segmentos = new ArrayList<>();
        this.segmentos.add(new Point(x, y));
        this.direccion = Direccion.DERECHA;
    }
    
    public void cambiarDireccion(Direccion nuevaDireccion) {
        if (!direccion.esOpuesta(nuevaDireccion)) {
            this.direccion = nuevaDireccion;
        }
    }
    
    public void mover() {
        Point cabeza = segmentos.get(0);
        int nuevaX = cabeza.x + (direccion.getDeltaX() * tamanoCelda);
        int nuevaY = cabeza.y + (direccion.getDeltaY() * tamanoCelda);
        
        segmentos.add(0, new Point(nuevaX, nuevaY));
        segmentos.remove(segmentos.size() - 1);
    }
    
    public void crecer() {
        Point cola = segmentos.get(segmentos.size() - 1);
        segmentos.add(new Point(cola));
    }
    
    public void reducir() {
        if (segmentos.size() > 1) {
            segmentos.remove(segmentos.size() - 1);
        }
    }
    
    public void aumentarTamano(int cantidad) {
        for (int i = 0; i < cantidad; i++) {
            crecer();
        }
    }
    
    public void reducirTamano(int cantidad) {
        for (int i = 0; i < cantidad && segmentos.size() > 1; i++) {
            reducir();
        }
    }
    
    public Point getCabeza() {
        return segmentos.get(0);
    }
    
    public List<Point> getSegmentos() {
        return new ArrayList<>(segmentos);
    }
    
    public boolean colisionaConCuerpo() {
        Point cabeza = getCabeza();
        for (int i = 1; i < segmentos.size(); i++) {
            if (cabeza.equals(segmentos.get(i))) {
                return true;
            }
        }
        return false;
    }
    
    public boolean colisionaConPunto(Point punto) {
        for (Point segmento : segmentos) {
            if (segmento.equals(punto)) {
                return true;
            }
        }
        return false;
    }
    
    public int getTamanio() {
        return segmentos.size();
    }
}