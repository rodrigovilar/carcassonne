package br.ufpb.dcx.aps.carcassone;

import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

public class Turno {
    private String status;
    private Tile tile;
    private Jogador jogador;
    private int numTurno;

	public Turno(Tile tile){
        this.tile = tile;
        this.status = "Tile_Posicionado";
        this.jogador = null;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }

    public Jogador getJogador() {
        return jogador;
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
    }
    
    public int getNumTurno() {
		return numTurno;
	}

	public void setNumTurno(int numTurno) {
		this.numTurno = numTurno;
	}
}
