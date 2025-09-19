public class Ventilador extends EquipoElectrico {
    protected  String uso;
    public Ventilador( String uso, String nombre, int potencia){
        super(nombre,potencia);
        this.uso= uso;
    }
    @Override
    public void mostrarInfo(){
        System.out.println("Nombre:"+nombre+"Uso:"+ uso+"Potencia: "+ potencia);
    }
}
