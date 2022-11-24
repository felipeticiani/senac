package util;

public enum Esportes {
    NATACAO(0, "Natacao"),
    FUTEBOL(1, "Futebol"),
    CORRIDA(2, "Corrida"),
    KARATE(3, "Karate"),
    O_QUE_EH_ESPORTE(4, "O que eh esporte?");

    private final int index;
    private final String descricao;

    Esportes(int index, String descricao) {
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
