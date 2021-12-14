package interfaces;

public interface ICarros {

    String acelerar();

    String acelerar(int velocidade);

    // Implementação default de um método em uma interface (disponível para versões >= 9 do Java)
    default String hello() {
        return "Hello";
    }
}
