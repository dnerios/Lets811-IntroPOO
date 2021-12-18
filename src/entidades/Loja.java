package entidades;

import exceptions.LimiteAtingidoException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.time.LocalDateTime;

public class Loja extends Exception{

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
    public String comprarCarro(Carro carro) throws LimiteAtingidoException{

        if (this.listaCarros.length > 0) {
            throw new LimiteAtingidoException("Você atingiu o limite de carros para sua loja!");
            //return "Você atingiu o limite de carros para sua loja!";
        }

        Carro[] listaCarroAtualizada = new Carro[this.listaCarros.length + 1];

        for (int i = 0; i < this.listaCarros.length; i++) {
            listaCarroAtualizada[i] = this.listaCarros[i];

            /*try{
                listaCarroAtualizada[i] = this.listaCarros[25];
            } catch (ArrayIndexOutOfBoundsException e) {
                //throw new ArrayIndexOutOfBoundsException();
                System.out.println("Explodiu o index: " + e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Acessando objetos nulos: " + e.getMessage());
            } finally {
                System.out.println("PASSEI NO FINALLY");
            }*/
        }

        listaCarroAtualizada[listaCarros.length] = carro;
        this.listaCarros = listaCarroAtualizada;

        PrintWriter writer = null;
        try {
            writer = new PrintWriter("log-letscode.txt", "UTF-8");
            writer.println("LOGGER - " + LocalDateTime.now() + " - Antes existiam: X carros - Compra efetuada com sucesso. Seu estoque agora é de " + this.listaCarros.length + " veículos");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }

        return "Compra efetuada com sucesso. Seu estoque agora é de " + this.listaCarros.length + " veículos";
    }

    @Override
    public String toString() {
        return "Bem-vindo a loja " + this.nome + "\nHoje temos " + this.listaCarros.length + " modelos disponíveis!";
    }
}
