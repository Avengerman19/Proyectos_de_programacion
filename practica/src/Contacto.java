public class Contacto {
    public String nombre;
    public int telefono;
    public  Contacto(String nombre, int telefono){
        this.nombre=nombre;
        this.telefono=telefono;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTelefono() {
        return telefono;
    }
    public void info(){
        System.out.println("Nombre: "+ nombre+ "Telefono: "+ telefono);
    }
}
