public abstract class  EquipoElectrico {
    protected String nombre;
    protected int potencia;
    public EquipoElectrico( String nombre, int potencia){
        this.nombre= nombre;
        this.potencia= potencia;
    }
    public void mostrarInfo(){
        System.out.println();
    }

    public int getPotencia() {
        return potencia;
    }
}
