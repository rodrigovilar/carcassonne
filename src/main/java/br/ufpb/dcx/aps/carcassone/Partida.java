package br.ufpb.dcx.aps.carcassone;

import br.ufpb.dcx.aps.carcassone.tabuleiro.TabuleiroFlexivel;
import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

import java.util.ArrayList;

public class Partida {

    private String status;
    private BolsaDeTiles tiles;
    private Tile proximoTile;
    private TabuleiroFlexivel tabuleiro = new TabuleiroFlexivel("  ");
    private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
    private Turno turno;
    private ArrayList<Turno> turnos;

    Partida(BolsaDeTiles tiles, Cor[] sequencia) {
        this.tiles = tiles;
        this.status = "Em_Andamento";
        adicionarJogadores(sequencia);
        pegarProximoTile();
        turno = new Turno(proximoTile);
        turno.setNumTurno(turno.getNumTurno()+1);
    }

    private void adicionarJogadores(Cor[] sequencia) {
        for (Cor cor : sequencia) {
            this.jogadores.add(new Jogador(cor));
        }
    }

    public String relatorioPartida() {
        String sequencia = "";

        for (int i = 0; i < jogadores.size() - 1; i++) {
            sequencia += jogadores.get(i).status() + "; ";
        }
        sequencia += jogadores.get(jogadores.size() - 1).status();
        return "Status: " + status + "\nJogadores: " + sequencia;
    }

    public String relatorioTurno() {
    	if ( status.equals("Partida_Finalizada")) throw new ExcecaoJogo("Partida finalizada");
        return "Jogador: " + jogadores.get(0) + "\nTile: " + turno.getTile() + "\nStatus: " + turno.getStatus();
    }

    public Partida girarTile() {
        if (this.status == "Partida_Finalizada") {
        	throw new ExcecaoJogo("Não pode girar tiles com a partida finalizada");
        }
        else {
        	proximoTile.girar();
        }
        return this;
    }

    private void pegarProximoTile() {
        proximoTile = tiles.pegar();
        proximoTile.reset();
    }

    public Partida finalizarTurno() {
        //pegarProximoTile();
        turno.setStatus("Finalizado");
        if (tiles.size() > 1) {
            pegarProximoTile();
        } else {
           this.status = "Partida_Finalizada";
        }
        return this;
    }

    public void posicionarPrimeiroTile(Tile tile) {
        tabuleiro.adicionarPrimeiroTile(proximoTile);
        turno.setStatus("Tile_Posicionado");
        pegarProximoTile();
    }

    public Partida posicionarTile(Tile tileReferencia, Lado ladoTileReferencia) {
        tabuleiro.posicionar(tileReferencia, ladoTileReferencia, proximoTile);
        return this;
    }

    public Partida posicionarMeepleEstrada(Lado lado) {
        return this;
    }

    public Partida posicionarMeepleCampo(Vertice vertice) {
        return this;
    }

    public Partida posicionarMeepleCidade(Lado lado) {
        return this;
    }

    public Partida posicionarMeepleMosteiro() {
        return this;
    }

    public String getEstradas() {
        return null;
    }

    public String getCampos() {
        return null;
    }

    public String getCidades() {
        return null;
    }

    public String getMosteiros() {
        return null;
    }

    public String relatorioTabuleiro() {
        return proximoTile.toString();
    }
 
}