package loja;

import carro.Carro;

public class Loja {

    private String nome;
    private int limiteCarros;
    private Carro[] listaCarros;

    // Overload - Sobrecarga de métodos
    public Loja(String nome, int limiteCarros) {
        this.nome = nome;
        this.limiteCarros = limiteCarros;
        this.listaCarros = new Carro[limiteCarros];
    }

    public Loja(String nome, int limiteCarros, Carro[] listaCarros) {
        this.nome = nome;
        this.limiteCarros = limiteCarros;
        this.listaCarros = listaCarros;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getLimiteCarros() {
        return limiteCarros;
    }

    public void setLimiteCarros(int limiteCarros) {
        this.limiteCarros = limiteCarros;
    }

    public Carro[] getListaCarros() {
        return listaCarros;
    }

    public void setListaCarros(Carro[] listaCarros) {
        this.listaCarros = listaCarros;
    }

    // Podemos trbalhar dentro dos métodos utilizando os dados que estão armazenados em cada instância
    public String comprarCarro(Carro carro) {

        if (this.listaCarros.length == this.limiteCarros) {
            return "Você atingiu o limite de carros para sua loja!";
        }

        Carro[] listaCarroAtualizada = new Carro[this.listaCarros.length + 1];

        for (int i = 0; i < this.listaCarros.length; i++) {
            listaCarroAtualizada[i] = this.listaCarros[i];
        }

        listaCarroAtualizada[listaCarros.length] = carro;
        this.listaCarros = listaCarroAtualizada;

        return "Compra efetuada com sucesso. Seu estoque agora é de " + this.listaCarros.length + " veículos";
    }

    @Override
    public String toString() {
        return "Bem-vindo a loja " + this.nome + "\nHoje temos " + this.listaCarros.length + " modelos disponíveis!";
    }
}
