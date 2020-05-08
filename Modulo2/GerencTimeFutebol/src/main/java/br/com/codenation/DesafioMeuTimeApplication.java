package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;
import br.com.codenation.desafio.exceptions.TimeNaoEncontradoException;
import br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException;
import br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException;
import br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

public class DesafioMeuTimeApplication implements MeuTimeInterface {
    
    private final List<Time> times = new ArrayList<>();
    private final List<Jogador> jogadores = new ArrayList<>();
    
    //Pode não haver um time com o ID especificado.
    private Optional<Time> buscarTime(Long id) {
        return times.stream().filter(time -> time.getId().equals(id)).findFirst();
    }
    
    //Pode não haver um jogador com o ID especificado.
    private Optional<Jogador> buscarJogador(Long id) {
        return jogadores.stream().filter(jogador -> jogador.getId().equals(id)).findFirst();
    }

    @Desafio("incluirTime")
    public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
        if(buscarTime(id).isPresent()) throw new IdentificadorUtilizadoException("Identificador existente!");
        times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
    }

    @Desafio("incluirJogador")
    public void incluirJogador(Long id, Long idTime, String nome,LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
	if(buscarJogador(id).isPresent()) throw new IdentificadorUtilizadoException("Identificador existente!");
        buscarTime(idTime).orElseThrow(() -> new TimeNaoEncontradoException("Time inexistente!"));
        jogadores.add(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
    }

    @Desafio("definirCapitao")
    public void definirCapitao(Long idJogador) {
        Jogador capitao = buscarJogador(idJogador).orElseThrow(() -> new JogadorNaoEncontradoException("Jogador inexistente!"));
        buscarTime(capitao.getIdTime()).get().setIdCapitao(idJogador);
    }

    @Desafio("buscarCapitaoDoTime")
    public Long buscarCapitaoDoTime(Long idTime) {
	Time time = buscarTime(idTime).orElseThrow(() -> new TimeNaoEncontradoException("Time inexistente!"));
        if(time.getIdCapitao() == null) throw new CapitaoNaoInformadoException("Time sem o capitão informado!");
        return time.getIdCapitao();
    }

    @Desafio("buscarNomeJogador")
    public String buscarNomeJogador(Long idJogador) {
         return buscarJogador(idJogador).map(Jogador::getNome).orElseThrow(() -> new JogadorNaoEncontradoException("Jogador inexistente!"));
    }

    @Desafio("buscarNomeTime")
    public String buscarNomeTime(Long idTime) {
	return buscarTime(idTime).map(Time::getNome).orElseThrow(() -> new TimeNaoEncontradoException("Time inexistente!"));
    }

    @Desafio("buscarJogadoresDoTime")
    public List<Long> buscarJogadoresDoTime(Long idTime) {
    	buscarTime(idTime).orElseThrow(() -> new TimeNaoEncontradoException("Time inexistente!"));
        return jogadores.stream()
                .filter(jogador -> jogador.getIdTime().equals(idTime))
                .sorted(Comparator.comparing(Jogador::getId))
                .map(Jogador::getId).collect(Collectors.toList());
    }

    @Desafio("buscarMelhorJogadorDoTime")
    public Long buscarMelhorJogadorDoTime(Long idTime) {
	buscarTime(idTime).orElseThrow(() -> new TimeNaoEncontradoException("Time inexistente!"));
        return jogadores.stream().filter(jogador -> jogador.getIdTime().equals(idTime))
                .min(Comparator.comparing(Jogador::getNivelHabilidade).reversed()
                        .thenComparing(Comparator.comparing(Jogador::getId))).get().getId();
    }

    @Desafio("buscarJogadorMaisVelho")
    public Long buscarJogadorMaisVelho(Long idTime) {
	buscarTime(idTime).orElseThrow(() -> new TimeNaoEncontradoException("Time inexistente!"));
        return jogadores.stream().filter(jogador -> jogador.getIdTime().equals(idTime))
                .min(Comparator.comparing(Jogador::getDataNascimento)
                        .thenComparing(Comparator.comparing(Jogador::getId))).get().getId();
    }

    @Desafio("buscarTimes")
    public List<Long> buscarTimes() {
    	 return times.stream().sorted(Comparator.comparing(Time::getId)).map(Time::getId).collect(Collectors.toList());
    }

    @Desafio("buscarJogadorMaiorSalario")
    public Long buscarJogadorMaiorSalario(Long idTime) {
    	buscarTime(idTime).orElseThrow(() -> new TimeNaoEncontradoException("Time inexistente!"));
        return jogadores.stream().filter(jogador -> jogador.getIdTime().equals(idTime))
                .max(Comparator.comparing(Jogador::getSalario)).get().getId();
    }

    @Desafio("buscarSalarioDoJogador")
    public BigDecimal buscarSalarioDoJogador(Long idJogador) {
    	return buscarJogador(idJogador).map(Jogador::getSalario)
                .orElseThrow(() -> new JogadorNaoEncontradoException("Jogador inexistente!"));
    }

    @Desafio("buscarTopJogadores")
    public List<Long> buscarTopJogadores(Integer top) {
    	return jogadores.stream()
                .sorted(Comparator.comparing(Jogador::getNivelHabilidade).reversed().thenComparing(Jogador::getId))
                .map(Jogador::getId).limit(top).collect(Collectors.toList());
    }

    @Desafio("buscarCorCamisaTimeDeFora")
    public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
	Optional<Time> timeMandante = buscarTime(timeDaCasa), timeVisitante = buscarTime(timeDeFora);
        if (!timeMandante.isPresent() || !timeVisitante.isPresent())
            throw new TimeNaoEncontradoException("Time inexistente!");
        if (timeMandante.get().getCorUniformePrincipal().equals(timeVisitante.get().getCorUniformePrincipal()))
            return timeVisitante.get().getCorUniformeSecundario();
        return timeVisitante.get().getCorUniformePrincipal();
    }

}
