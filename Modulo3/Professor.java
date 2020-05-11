package Modulo3;

import Modulo3.ValidationException;
import Modulo3.UsuarioAutorizado;

import java.util.Arrays;
import java.util.List;

public class Professor extends UsuarioAutorizado {

    public Professor(String login, String cpf, String nome) throws ValidationException {
        super(login, cpf, nome);
    }

    @Override
    protected List<String> getAutorizacao() {
        return Arrays.asList("ADMIN");
    }

    @Override
    protected boolean verificarAutorizacaoLogin() {
        return true;
    }

}