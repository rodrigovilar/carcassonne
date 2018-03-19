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

	public Jogo posicionarTile(Tile tileReferencia, Lado ladoTileReferencia) {
		tabuleiro.posicionar(tileReferencia, ladoTileReferencia, proximoTile);
		return this;		
	}
		
	public Jogo posicionarMeepleEstrada(Lado lado) {
		return this;
	}
	
	public Jogo posicionarMeepleCampo(Vertice vertice) {
		return this;
	}
	
	public Jogo posicionarMeepleCidade(Lado lado) {
		return this;
	}
	
	public Jogo posicionarMeepleMosteiro() {
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
	
	public String getScore() {
		return null;
	}
}
