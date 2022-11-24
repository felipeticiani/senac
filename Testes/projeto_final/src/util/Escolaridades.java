package util;

public enum Escolaridades {
    PRIMEIRO_GRAU_INCOMPLETO(0, "1grauincomp"),
    PRIMEIRO_GRAU_COMPLETO(1, "1graucomp"),
    SEGUNDO_GRAU_INCOMPLETO(2, "2grauincomp"),
    SEGUNDO_GRAU_COMPLETO(3, "2graucomp"),
    SUPERIOR(4, "superior"),
    ESPECIALIZACAO(5, "especializao"),
    MESTRADO(6, "mestrado"),
    DOUTORADO(7, "doutorado");

    private final int index;
    private final String descricao;

    Escolaridades(int index, String descricao) {
        this.index = index;
        this.descricao = descricao;
    }

    public int getIndex() {
        return this.index;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
