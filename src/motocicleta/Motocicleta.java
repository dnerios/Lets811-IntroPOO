package motocicleta;

public abstract class Motocicleta {

    private String marca;
    private int cilindradas;

    public Motocicleta(String marca, int cilindradas) {
        this.marca = marca;
        this.cilindradas = cilindradas;
    }

    public final String getMarca() {
        return marca;
    }

    public final void setMarca(String marca) {
        this.marca = marca;
    }

    public final int getCilindradas() {
        return cilindradas;
    }

    public final void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public abstract void cortarGiro();
}
