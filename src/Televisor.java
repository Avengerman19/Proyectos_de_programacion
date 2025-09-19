public class Televisor extends EquipoElectrico{
    protected String uso;
    public Televisor(String uso, String nombre, int potencia){
        super(nombre, potencia);
        this.uso= uso;
    }
    @Override
    public void mostrarInfo(){
        System.out.println("Nombre:"+nombre+"Uso:"+ uso+"Potencia: "+ potencia);
    }
}
