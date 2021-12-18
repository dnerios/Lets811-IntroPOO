import entidades.Carro;
import entidades.CarroCorrida;
import entidades.CarroPasseio;
import entidades.Loja;
import enums.TipoMotorEnum;
import exceptions.LimiteAtingidoException;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class POOCodeApplication {
    public static void main(String[] args){

        /*
           Instanciando um carro!
           Lembre-se: Tudo que está dentro do () são os parâmetros que estão sendo passados para o construtor.
         */
        System.out.println("========== TRABALHANDO E TESTANDO AS INSTÂNCIAS DE OBJETOS E SEUS COMPORTAMENTOS " +
                "============");
        System.out.println();
        Carro carro = new Carro("Toyota", "Corola", 5, 5, TipoMotorEnum.COMBUSTAO.getDescricao());

        CarroPasseio carroPasseio = new CarroPasseio("Toyota", "Corola", 5, 5, TipoMotorEnum.COMBUSTAO.getDescricao()
                , true);

        Carro carroPasseioDerivado = new CarroPasseio("Toyota", "Corola", 5, 5, TipoMotorEnum.COMBUSTAO.getDescricao());

        //Lembre-se: quando pedimos para um objeto ser impresso, o método invocado é o .toString()
        //Se não reescrevermos o .toString() na classe, por padrão, será impresso o endereço de memória
        System.out.println("========== PRINTANDO DADOS DA CLASSE MÃE E FILHA ==========");
        System.out.println("Superclasse: " + carro);
        System.out.println("Derivado: " + carroPasseioDerivado);
        carro = carroPasseioDerivado;
        System.out.println(carro);

        //Criando um array com os objetos de uma classe
        //1 - Criando uma instância de array, já informando os objetos que serão atribuídos
        // Tudo que está entre {} e separado por vírgula, são os objetos que estão sendo alocados no array
        // Os objetos são inseridos na sequência em que são informados, ou seja, primeiro objeto vai na posição 0,
        // segundo na posição 1 e assim por diante
        Carro[] arrayCarro = new Carro[]{carro, new Carro("Toyota", "Corola", 5, 5,
                TipoMotorEnum.COMBUSTAO.getDescricao())};

        /* Lembre-se: ao criar um array, as posições são criadas como 'null'. É necessário atribuir um objeto para as
         posições
         * Exemplo de atribuição:
         * arrayCarro[0] = new Carro("Toyota", "Corola", 5, 5);
         *  */

        Carro carroNovo = new Carro(carro.getMarca(), carro.getModelo(), 5, 5, TipoMotorEnum.COMBUSTAO.getDescricao());

        //O que acontece quando atribuímos um objeto a outro?
        //Assim como quando pedimos o .toString() é impresso o endereço de memória, quando atribuímos um objeto a outro
        //é repassado o endereço de memória, ou seja, ambos passarão a ter as mesmas informações e sofrerão as mesmas
        // alterações
        System.out.println();
        System.out.println("========== TESTANDO ATRIBUIÇÃO DE OBJETOS ============");
        carroNovo = carro;

        carro.setMarca("Nova Marca");
        carroNovo.setMarca("Outra marca");

        //Veja que ambos objetos estão com os mesmos dados.
        System.out.println(carro);
        System.out.println(carroNovo);

        System.out.println();
        System.out.println("========== POLIMORFISMO ACELERAÇÃO CARRO ============");

        String result = carroPasseio.acelerar(carroPasseio.getVelocidadeAtual());

        CarroCorrida carroCorrida = new CarroCorrida();
        System.out.println("Antes de acelerar: " + carroCorrida.getVelocidadeAtual());
        String resultado = carroCorrida.acelerar();
        System.out.println("Depois de acelerar: " + carroCorrida.getVelocidadeAtual());

        System.out.println("Antes de acelerar: " + carroPasseio.getVelocidadeAtual());
        resultado = carroPasseio.acelerar();
        System.out.println("Depois de acelerar: " + carroPasseio.getVelocidadeAtual());

        System.out.println();
        System.out.println("========== USANDO DEFAULT EM UMA INTERFACE ============");
        String hello = carroCorrida.hello();
        System.out.println("Usando o poilimorfismo de sobreposição: " + hello);

        hello = carroPasseio.hello();
        System.out.println("Usando o default: " + hello);


        System.out.println();
        System.out.println("============================================");
        System.out.println("=========== INAUGURAÇÃO DA LOJA ============");
        System.out.println("============================================");
        System.out.println();

        /*
            UTLIZANDO OBJETOS COMO TIPOS!
         */

        //Criando uma nova loja
        Loja loja = new Loja("Feirão da Let's", 4, new Carro[]{carro, carroNovo});

        //Com a utilização dos construtores, podemos iniciar objetos com valores já setados
        //Ou atribuir utilizando os setters
        loja.setNome("Feirão da Let's");
        loja.setListaCarros(new Carro[]{carro, carroNovo});


        System.out.println(loja);


        // QUE TAL COMPRAR UM CARRO AGORA? Podemos passar objetos como parâmetros também!


        try {
            System.out.println(loja.comprarCarro(carro));
        } catch (LimiteAtingidoException e) {
            System.out.println("{" + e.TITLE +"} - " + e.getMessage());
        }
        //System.out.println(loja.comprarCarro(carroNovo));

        System.out.println();
        System.out.println("Fim do programa :)");
    }
}
