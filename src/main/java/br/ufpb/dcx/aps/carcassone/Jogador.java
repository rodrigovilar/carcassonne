package br.ufpb.dcx.aps.carcassone;

public class Jogador {
    private int pontuacao = 0;
    private int meeples = 7;
    private Cor cor;

    public Jogador(Cor cor) {
        this.cor = cor;
    }

    public String status() {
        return this.cor.name() + "(" + this.pontuacao + "," + this.meeples + ")";
    }

    @Override
    public String toString() {
        return this.cor.name();
    }
}
