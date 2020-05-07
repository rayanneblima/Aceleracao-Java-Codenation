package Modulo2;

import java.util.List;
import java.util.ArrayList; 

public class Disciplina {
    
    private String nome;
    private List<Aluno> alunos = new ArrayList<>();
    private Professor professor;
    private static final byte LIMITE = 10;

    public Disciplina(String nome, Professor professor) {
        this.nome = nome;
        this.professor = professor;
    }

    public void matricular(Aluno aluno) {
        if(this.alunos.size() < LIMITE) {
            this.alunos.add(aluno);
        } else {
            throw new LimiteAlunosAlcancadoException("Limite de alunos alcançado, o limite é " + LIMITE);
        }
    }

    public void mostrarAlunos() {
        this.alunos.stream().forEach(aluno -> System.out.println(aluno.getNome()););
    }


}