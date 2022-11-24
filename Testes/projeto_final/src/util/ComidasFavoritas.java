package util;

public enum ComidasFavoritas {
    CARNE(0, "Carne"),
    FRANGO(1, "Frango"),
    PIZZA(2, "Pizza"),
    VEGETARIANO(3, "Vegetariano");

    private final int index;
    private final String descricao;

    ComidasFavoritas(int index, String descricao) {
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
