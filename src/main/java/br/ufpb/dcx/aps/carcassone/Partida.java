package br.ufpb.dcx.aps.carcassone;

import java.util.ArrayList;
import br.ufpb.dcx.aps.carcassone.tabuleiro.TabuleiroFlexivel;
import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

public class Partida {

	private BolsaDeTiles tiles;
	private Tile proximoTile;
	private TabuleiroFlexivel tabuleiro = new TabuleiroFlexivel("");
	private String status = "Início";
	private boolean partidaEncerrada = true;
	private Cor proximaPecaJogador;
	private Cor[] pecaJogador;
	private String relatorioPartida = "";
	
	static int indiceDaListaDePecas = 0;

	ArrayList<Tile> tilesParaUsar = new ArrayList<Tile>();
	
	Partida(BolsaDeTiles tiles, Cor[] sequencia) {
		this.tiles = tiles;
		pegarProximoTile();
	}

	public String relatorioPartida() {
		return null;
	}

	public String relatorioTurno() {
		return null;
	}

	public Partida girarTile() {
		if(proximoTile == null && partidaEncerrada){
			throw new ExcecaoJogo("Não pode girar tiles com a partida finalizada");
		}
		
		proximoTile.girar();
		return this;
	}

	private void pegarProximoTile() {
		Tile tile = tiles.pegar();
		if (tile != null){
			tile.reset();
		}
			
	}

	public Partida finalizarTurno() {
				
		if (proximoTile == null && partidaEncerrada) {
			status = "Fim";
			proximaPecaJogador = null;

		} else {
			status = "Início";
			indiceDaListaDePecas++;
			partidaEncerrada = false;
			proximaPecaJogador = pecaJogador[indiceDaListaDePecas % pecaJogador.length];
		}

		pegarProximoTile();
		return this;
	}

	public Partida posicionarTile(Tile tileReferencia, Lado ladoTileReferencia) {
		status = "Tile";
		proximoTile = tilesParaUsar.get(tilesParaUsar.size() - 1);
		tabuleiro.posicionar(tileReferencia, ladoTileReferencia, proximoTile);
		pegarProximoTile();
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
		return null;
	}
}
