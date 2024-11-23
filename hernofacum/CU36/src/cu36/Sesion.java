package cu36;
public class Sesion {
    private Usuario usuario;
    public Sesion(Usuario user){
        usuario=user;
    }
    public String conocerUsuario(){
        return usuario.getNombre();
    }
}
