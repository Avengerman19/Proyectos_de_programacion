public interface IAgenda {
    void  agregarContacto (Contacto c);
    void eliminarPorNombre (String nombre);
    void buscarPorNombre(String nombre);
    void mostrarTodos();
    void buscarTelefono(String telefono);
}
