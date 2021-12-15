package motocicleta;

public class MotocicletaEsportiva extends Motocicleta {

    public MotocicletaEsportiva(String marca, int cilindradas) {
        super(marca, cilindradas);
    }

    @Override
    public void cortarGiro() {
        System.out.println("Cortando giro...");
    }
}
