package Modulo1;

// Todo esse código é substituído pela classe ListaTarefas
public class ArrayTarefas {

    Tarefa[] tarefas;
    int contador;

    public ArrayTarefas(int tamanho) {
        tarefas = new Tarefa[tamanho];
    }

    public void adicionarTarefa(Tarefa tarefa) {
        tarefas[contador] = tarefa;
        contador++;
    }

    public void removerTarefa(int posicao) {
        tarefas[posicao] = null;
    }

    public void exibirTarefa() {
        //for each: específico pra listas e arrays
        for(Tarefa tarefa: tarefas) {
            tarefa.exibirTarefa();
        }

    }
    
}