package Modulo1;

public class Tarefa {

    String descricao;

    // Construtor
    public Tarefa(String descricao) {
        this.descricao = descricao; // this refere a descricao da própria classe (var. global)
    }
    
    public void exibirTarefa() {
        System.out.println(descricao);
    }

    public int obterTamanhoTarefa() {
        return descricao.length();
    }

}