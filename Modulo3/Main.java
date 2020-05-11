package Modulo3;

public class Main {

    public static void main(String[] args) throws ValidationException {
        UsuarioAutorizado usuario = new Professor("professor", "06784465692", "Professor Teste");
        new LancadorNotas().login(usuario);
    }

}