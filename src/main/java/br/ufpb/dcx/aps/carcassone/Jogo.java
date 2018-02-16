package br.ufpb.dcx.aps.carcassone;

import br.ufpb.dcx.aps.carcassone.tabuleiro.TabuleiroFlexivel;
import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

public class Jogo {
	
	private Tile proximoTile;
	private BolsaDeTiles tiles;
	private TabuleiroFlexivel tabuleiro = new TabuleiroFlexivel("  ");
	
	
	public Jogo(BolsaDeTiles tiles) {
		this.tiles = tiles;
	}

	public Jogo iniciarPartida(Cor... sequencia) {
		pegarProximoTile();
		return this;
	}

	public String relatorioPartida() {
		return null;
	}
	
	public Jogo girarTile() {		
		proximoTile.girar();
		return this;
	}

	public Jogo posicionarInicial() {
		tabuleiro.adicionarPrimeiroTile(proximoTile);
		return this;
	}

	private void pegarProximoTile() {
		proximoTile = tiles.pegar();
		proximoTile.reset();
	}

	public Jogo finalizarRodada() {
		pegarProximoTile();
		return this;
	}

	public Jogo posicionar(Tile tileReferencia, Lado ladoTileReferencia) {
		tabuleiro.posicionar(tileReferencia, ladoTileReferencia, proximoTile);
		return this;		
	}
	
}
