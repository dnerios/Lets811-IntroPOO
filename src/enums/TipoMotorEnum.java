package enums;

public enum TipoMotorEnum {
    COMBUSTAO("Combustão"),
    ELETRICO("Elétrico"),
    VAPOR("Vapor");

    private String descricao;

    TipoMotorEnum(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
