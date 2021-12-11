package entidades;

import enums.TipoMotorEnum;

public class Carro {

    //Atributos
    private String marca;
    private String modelo;
    private int quantidadePortas;
    private int quantidadeLugares;
    private int velocidadeAtual;
    private boolean estaLigado;
    private String tipoMotor;

    //Construtor
    public Carro(String marca, String modelo, int quantidadePortas, int quantidadeLugares, String tipoCombustao){
        this.marca = marca;
        this.modelo = modelo;
        this.quantidadePortas = quantidadePortas;
        this.quantidadeLugares = quantidadeLugares;
        this.velocidadeAtual = 0;
        this.estaLigado = false;
        this.tipoMotor = tipoCombustao;
    }

    //Getters and Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getQuantidadePortas() {
        return quantidadePortas;
    }

    public void setQuantidadePortas(int quantidadePortas) {
        this.quantidadePortas = quantidadePortas;
    }

    public int getQuantidadeLugares() {
        return quantidadeLugares;
    }

    public void setQuantidadeLugares(int quantidadeLugares) {
        this.quantidadeLugares = quantidadeLugares;
    }

    public int getVelocidadeAtual() {
        return velocidadeAtual;
    }

    //Os getters e setters nos dão maior controle sobre como queremos dar opções de manipulação dos dados dentro do nosso código.
    //Nesse caso, estamos controlando a permissão de alteração de velocidade ou não dado o estado do carro.
    //Não conseguimos acelerar um carro desligado, certo? Então não poderíamos atribuir uma velocidade para um veículo parado.
    //
    //Este é um exemplo simples, mas devemos lembrar que nem sempre seremos nós que utilizaremos o código ou sistema.
    //Portanto é importante que sejam criadas instruções que sempre garantam o correto funcionamento do código, sem depender do usuário.

    //Acredite: depender do usuário, é bug na certa! rs Eles sempre encontram um jeito de quebrar nossos sistemas.
    public void setVelocidadeAtual(int velocidadeAtual) {
        //Conferindo se a variável 'estaLigado', que determina se o carro está ligado ou não, está como true
        //Em todos os ifs, é validade uma condição true ou false, no exemplo abaixo, não é necessário colocar o '== true'
        //por ser uma variável booleana (true/false), o if validará apenas o conteúdo dela. Se for 'true' entra, se for 'false' não entra.

        //Caso não estivéssemos utilizando essa condicional, qualquer classe com acesso poderia alterar a velocidade da forma que bem entender
        //podendo gerar alguam inconsistência na lógica do nosso código.
        if(estaLigado) {
            this.velocidadeAtual = velocidadeAtual;
        } else {
            System.out.println("O carro deve estar ligado para você conseguir alterar sua velocidade.");
        }
    }

    public boolean isEstaLigado() {
        return estaLigado;
    }

    public void setEstaLigado(boolean estaLigado) {
        this.estaLigado = estaLigado;
    }

    //Métodos
    public String acelerar() {
        this.velocidadeAtual = this.velocidadeAtual + 1;
        return "VRUUUUUUUM";
    }

    public String acelerar(int velocidade) {
        this.velocidadeAtual = velocidade;
        return "VRUUUUUUUM";
    }

    public void ligar() {
        this.estaLigado = true;
    }

    //Sobrescrita - permite alterar o comportamento do método já existente
    @Override
    public String toString() {
        return "Carro{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", quantidadePortas=" + quantidadePortas +
                ", quantidadeLugares=" + quantidadeLugares +
                ", velocidadeAtual=" + velocidadeAtual +
                ", estaLigado=" + estaLigado +
                ", tipoMotor='" + tipoMotor + '\'' +
                '}';
    }
}
