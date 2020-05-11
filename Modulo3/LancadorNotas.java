package Modulo3;

import Modulo3.UsuarioAutorizado;

public class LancadorNotas {

    public void login(UsuarioAutorizado usuarioAutorizado) {
        boolean temAut = usuarioAutorizado.temAutorizacao();
        if(temAut) {
            System.out.println("Usuário autorizado!");
        } else {
            System.out.println("Usuário NÃO autorizado!");
        }
    }

}