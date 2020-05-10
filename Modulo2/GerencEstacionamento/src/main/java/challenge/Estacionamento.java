package challenge;

public class Estacionamento {
    
    private static final int MAX_VAGAS = 10;
    private static final int MIN_IDADE = 18;
    private static final int MAX_PONTOS = 20;
    private static final int IDADE_MAX = 55;
    
    private Carro[] estacionados = new Carro[10];
    public int carrosEstacionados;
    
    public void estacionar(Carro carro) {
        validarMotoristaPermitido(carro);
        if(carrosEstacionados < MAX_VAGAS) {
            estacionarCarro(carro);
        } else {
            removerCarro();
            estacionarCarro(carro);
        }
        carrosEstacionados += carrosEstacionados < MAX_VAGAS ? 1 : 0;
    }

    public int carrosEstacionados() {
        return carrosEstacionados;
    }

    public boolean carroEstacionado(Carro carro) {
        for(Carro x : estacionados) {
            if(x != null && x.equals(carro)) {
                return true;
            }
        }
        return false;
    }
    
    private void validarMotoristaPermitido(Carro carro) {
        if(carro.getMotorista() == null) {
            throw new EstacionamentoException("Carro autônomo não é permitido!");
        }
        if(carro.getMotorista().getIdade() < MIN_IDADE) {
            throw new EstacionamentoException("Motorista não possui idade suficiente!");
        }
        if(carro.getMotorista().getHabilitacao() == null) {
            throw new EstacionamentoException("Motorista sem habilitação não é permitido!");
        }
        if(carro.getMotorista().getPontos() > MAX_PONTOS) {
            throw new EstacionamentoException("Habilitação suspesa!");
        }
        
    }
    
    private void estacionarCarro(Carro carro) {
        for(int i = 0; i < estacionados.length; i++) {
            if(estacionados[i] == null) {
                estacionados[i] = carro;
                return;
            }
        }        
    }

    private void removerCarro() {
        for(int i = 0; i < estacionados.length; i++) {
            if(estacionados[i] != null && estacionados[i].getMotorista().getIdade() < IDADE_MAX) {
                estacionados[i] = null;
                carrosEstacionados--;
                return;
            }
        }
        throw new EstacionamentoException("Não será possível estacionar!");
    }
}
