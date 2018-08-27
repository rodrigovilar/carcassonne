package br.ufpb.dcx.aps.carcassone;

import java.util.ArrayList;

public class Jogo {

    public Partida criarPartida(BolsaDeTiles tiles, Cor... sequencia) {
        if (tiles == null) {
            throw new ExcecaoJogo("A bolsa de tiles deve ser fornecida na criação de uma partida");
        }
        if (sequencia.length < 2) {
            throw new ExcecaoJogo("Cada partida deve ter uma sequência de pelo menos dois jogadores");
        }
        ArrayList<Cor> sequenciatemp = new ArrayList<Cor>();
        for (int i = 0; i < sequencia.length; i++) {
            for (int e = 0; e < sequenciatemp.size(); e++) {
                if (sequenciatemp.get(e).equals(sequencia[i])) {
                    throw new ExcecaoJogo("Não pode haver repetição de cores na sequência de jogadores");
                }
            }
            sequenciatemp.add(sequencia[i]);
        }
        return new Partida(tiles, sequencia);
    }


}
