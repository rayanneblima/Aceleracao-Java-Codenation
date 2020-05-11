package Modulo3;

import Modulo3.ValidationException;
import java.util.List;

public abstract class UsuarioAutorizado extends Usuario {

    public UsuarioAutorizado(String login, string cpg, String nome) throws ValidationException {
        super(login, cpf, nome);
    }
    
    public boolean temAutorizacao() {
        List<String> autorizacoes = getAutorizacoes();
        return autorizacoes.contains("ADMIN") || verificarAutorizacaoLogin(); 
    }

    protected abstract List<String> getAutorizacoes();
    protected abstract verificarAutorizacaoLogin();

}