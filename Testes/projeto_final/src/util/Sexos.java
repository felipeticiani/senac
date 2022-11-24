package util;

public enum Sexos {
    MASCULINO(0, "Masculino"),
    FEMININO(1, "Feminino");

    private final int index;
    private final String descricao;

    Sexos(int index, String descricao) {
        this.index = index;
        this.descricao = descricao;
    }

    public int getIndex() {
        return this.index;
    }

    public String getDescricao() {
        return descricao;
    }
}
