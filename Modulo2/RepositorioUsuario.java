package Modulo2;

import java.util.List;
import java.util.ArrayList;

public class RepositorioUsuario {

    private List<Usuario> usuarios = new ArrayList<>();

    public void add(Usuario usuario) {
        this.usuarios.add(usuario);
    }

    public void delete(Usuario usuario) {
        this.usuarios.remove(usuario);
    }

    public Usuario search(String cpf) {
        for(Usuario usuario : usuarios) {
            if(usuario.getCpf().equals(cpf)) {
                return usuario;
            }
        }
        return null;
    }

    public List<Usuario> findAll() {
        return this.usuarios;
    }

}