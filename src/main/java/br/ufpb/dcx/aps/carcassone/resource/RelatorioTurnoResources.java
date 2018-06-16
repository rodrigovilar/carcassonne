package br.ufpb.dcx.aps.carcassone.resource;

import br.ufpb.dcx.aps.carcassone.Partida.Status;
import br.ufpb.dcx.aps.carcassone.Jogadores;
import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

public class RelatorioTurnoResources extends RelatorioResources{

	private Tile tile;
	private Jogadores jogadores;
	
	RelatorioTurnoResources(Jogadores jogadores, Tile tile, Status status) {
		super(status);
		this.jogadores = jogadores;
		this.tile = tile;
	}
	
	public Jogadores getJogador() {
		return jogadores;
	}
	
	public Tile getTile() {
		return tile;
}

}


/**
 * @author CHAGAS
 */