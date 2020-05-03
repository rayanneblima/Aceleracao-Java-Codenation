package Modulo1;

import java.util.ArrayList;

public class ListaTarefas {

    ArrayList<Tarefa> tarefas = new ArrayList<>();

    public void adicionarTarefa(Tarefa tarefa) {
        if(tarefa != null && tarefa.obterTamanhoTarefa() <= 20) {
            this.tarefas.add(tarefa);
        } else {
            System.out.println("A tarefa é inválida!\n");
        }
    }

    // Sobrecarga com aproveitamento do método acima
    public void adicionarTarefa(String descricao) {
        Tarefa tarefa = new Tarefa(descricao);
        adicionarTarefa(tarefa);
    }

    public void removerTarefa(int posicao) {
        if(posicao < this.tarefas.size()) {
            this.tarefas.remove(posicao);
        } else {
            System.out.println("A tarefa não existe!\n");
        }
    }

    // Sobrecarga do método acima
    public void removerTarefa(Tarefa tarefa) {
        this.tarefas.remove(tarefa);
    }

    public Tarefa buscarTarefa(String descricao) {
        //for each: específico pra listas e arrays
        for(Tarefa tarefa: tarefas) {
            if(descricao.equals(tarefa.descricao)) {
                return tarefa;
            }
        }
        System.out.println("Tarefa não encontrada!");
        return null;
    }

    public void exibirTarefa() {
        //for each: específico pra listas e arrays
        for(Tarefa tarefa: tarefas) {
            tarefa.exibirTarefa();
        }
    }
    
}