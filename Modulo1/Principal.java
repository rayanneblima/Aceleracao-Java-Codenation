package Modulo1;

/* Aula 2: Métodos, Construtores e Controles de Acesso
public : É o menos restritivo de todos. Atributos e métodos declaradoscomo public em uma
classe podem ser acessados pelos métodos da própria classe, por classes derivadas desta e
por qualquer outra classe em qualquer outro pacote.

protected : Atributos e métodos definidos como protected são acessíveis pelos métodos da
própria classe e pelas classes derivadas. 

private : É o mais restritivo. Atributos e métodos declarados como private só podem ser
acessados pelos métodos da própria classe. 

Quando nenhum modificador é definido (acesso do tipo “package”), os atributos e métodos
podem ser acessados pelos métodos da própria classe, pelas classes derivadas e por qualquer
outra classe dentro do mesmo pacote.
*/

// Aula 3: Arrays, ArrayLists e Controler de Fluxo (regras)

public class Principal {
    
    public static void main(String[] args) {
        //ArrayTarefas tarefas = new ArrayTarefas(3);
        ListaTarefas tarefas = new ListaTarefas();
        
        //Tarefa tarefa1 = new Tarefa("Regar as Plantas após a hora do jantar");
        //Tarefa tarefa2 = new Tarefa("Estudar");
        //Tarefa tarefa3 = new Tarefa("Trabalhar");
        //tarefa1.exibirTarefa();
        //System.out.println("A tarefa tem " + tarefa1.obterTamanhoTarefa() + " caracteres.");
        
        tarefas.adicionarTarefa("Regar as Plantas");
        tarefas.adicionarTarefa("Estudar");
        tarefas.adicionarTarefa("Trabalhar");

        System.out.println("Minhas Tarefas:");
        System.out.println("-----------------");
        tarefas.exibirTarefa();
        System.out.println("-----------------");

        //tarefas.removerTarefa(3);
        //tarefas.removerTarefa(tarefa2);

        /*System.out.println("\nMinhas Tarefas após Remover:");
        System.out.println("-----------------");
        tarefas.exibirTarefa();
        System.out.println("-----------------");*/

        Tarefa buscaTarefa1 = tarefas.buscarTarefa("Estudar");
        buscaTarefa1.exibirTarefa();

    }

}