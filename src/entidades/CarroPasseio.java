package entidades;

import interfaces.ICarros;

public class CarroPasseio extends Carro implements ICarros {

    private boolean hasAirBag;

    public CarroPasseio(String marca, String modelo, int quantidadePortas, int quantidadeLugares,
                        String tipoCombustao) {
        super(marca, modelo, quantidadePortas, quantidadeLugares, tipoCombustao);
    }

    public CarroPasseio(String marca, String modelo, int quantidadePortas, int quantidadeLugares,
                        String tipoCombustao, boolean hasAirBag) {
        super(marca, modelo, quantidadePortas, quantidadeLugares, tipoCombustao);
        this.hasAirBag = hasAirBag;
    }

    // Aqui estamos fazendo um polimorfismo de sobreposição (annotation @Override) a partir de um método da superclasse
    @Override
    public String toString() {
        return "CarroPasseio{" + "marca='" + marca + '\'' + ", modelo='" + modelo + '\'' + ", quantidadePortas=" + quantidadePortas + ", quantidadeLugares=" + quantidadeLugares + ", velocidadeAtual=" + velocidadeAtual + ", estaLigado=" + estaLigado + ", tipoMotor='" + tipoMotor + '\'' + ", hasAirBag=" + hasAirBag + '}';
    }

    // Aqui estamos fazendo um polimorfismo de sobreposição (annotation @Override) a partir de uma interface
    @Override
    public String acelerar() {
        this.velocidadeAtual = this.velocidadeAtual + 1;
        return "VRUUUUUUUM";
    }

    @Override
    public String acelerar(int velocidade) {
        this.velocidadeAtual = velocidade;
        return "VRUUUUUUUM";
    }
}
