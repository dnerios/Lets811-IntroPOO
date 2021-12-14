package entidades;

import interfaces.ICarros;

public class CarroCorrida extends Carro implements ICarros {

    @Override
    public String acelerar() {
        this.velocidadeAtual = this.velocidadeAtual + 50;
        return "VRUUUUUUUMZÃO";
    }

    @Override
    public String acelerar(int velocidade) {
        this.velocidadeAtual = velocidade + 10;
        return "VRUUUUUUUM";
    }

    @Override
    public String hello() {
        return "Olá! Aqui é Brasil.";
    }
}
