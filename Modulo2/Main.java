package Modulo2;

/* Aula 1: POO

A Interface define um padrão para especificação do comportamento de classes. Porém, os
métodos de uma interface são implementados de maneira particular a cada classe; ou seja,
permitem expressar comportamento sem se preocupar com a implementação. Uma interface não
possui atributos. Uma classe pode implementar várias interfaces, mas pode ter apenas uma
superclasse.

Uma classe abstrata nada mais é do que uma especificação conceitual para outras classes.
Isso que dizer que nunca iremos instanciá-la. Ela apenas fornece um modelo para geração de
outras classes. Esta nunca está completa, ou seja, servirá apenas para criação de
funcionalidades genéricas de casses filhas. Podemos também chamar as classes abstratas de
super classe. 

Para utilizar modificadores de acesso, basta que o escreva antes do nome do atributo,
método ou classe.
Public: O modificador public deixará visível a classe ou membro para todas as outras classes,
subclasses e pacotes do projeto Java.
Protected: O modificador protected deixará visível o atributo para todas as outras classes e
subclasses que pertencem ao mesmo pacote. A principal diferença é que apenas as classes do
mesmo pacote têm acesso ao membro. O pacote da subclasse não tem acesso ao membro.
Private: O modificador private deixará visível o atributo apenas para a classe em que este
atributo se encontra.
Package-Private: é o modificador padrão quando outro não é definido. Isto torna acessível na
própria classe, nas classes e subclasses do mesmo pacote. Ele geralmente é utilizado para
construtores e métodos que só dever ser invocados pelas classes e subclasses do pacote,
constantes estáticas que são úteis apenas dentro do pacote em que estive inserido. 

O Encapsulamento serve para controlar o acesso aos atributos e métodos de uma classe. É uma
forma eficiente de proteger os dados manipulados dentro da classe, além de determinar onde
esta classe poderá ser manipulada.

*/

/* Programação Procedural costuma ter falhas nas chamadas de função, sendo resolvida pela POO
public class Main {

    public static void main(String[] args) {
        String loginAluno = "login";
        if(validateLogin(loginAluno, "nome")) {
            System.out.println("Login Válido!");
        } else {
            System.out.println("Login Inválido!");
        }
    }

    private static boolean validateLogin(String login, String primeiroNome) {
        return login != null && !login.isEmpty() && login.length() < 20 && login.contains(primeiroNome); 
    }

}*/

/* Aula 2: Exceptions

public class Main {

    public static void main(String[] args) {
        Aluno aluno = null;
        try {
            aluno = new Aluno("12345", "78067412451", "nome");
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            
        }//System.out.println(aluno);
    
    }

}

*/
// Aula 3: Herança e Polimorfismo

//Resolvendo a validação de objetos:

import Professor;
import Aluno;
import Disciplina;
import ValidationException;
import LimiteAlunosAlcancadosException;
import Usuario;
import RepositorioUsuario;

public class Main {

    public static void main(String[] args) {
        RepositorioUsuario repositorioUsuario = new RepositorioUsuario();
        try {
            Professor professor = new Profesor("professor", "06552897654", "Professor dos Teste");
            Aluno aluno = new Aluno("aluno1", "06579853654", "Aluno dos Testes");
            
            repositorioUsuario.add(professor);
            repositorioUsuario.add(aluno);
            repositorioUsuario.findALl().stream().forEach(System.out::println);
        } catch(ValidationException e) {
            System.out.println(e.getMessage());
        }
        
    }

}