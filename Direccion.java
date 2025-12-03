package modelo;

public enum Direccion {
    ARRIBA(0, -1),
    ABAJO(0, 1),
    IZQUIERDA(-1, 0),
    DERECHA(1, 0);
    
    private final int deltaX;
    private final int deltaY;
    
    Direccion(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }
    
    public int getDeltaX() {
        return deltaX;
    }
    
    public int getDeltaY() {
        return deltaY;
    }
    
    public boolean esOpuesta(Direccion otra) {
        return (this == ARRIBA && otra == ABAJO) ||
               (this == ABAJO && otra == ARRIBA) ||
               (this == IZQUIERDA && otra == DERECHA) ||
               (this == DERECHA && otra == IZQUIERDA);
    }
}