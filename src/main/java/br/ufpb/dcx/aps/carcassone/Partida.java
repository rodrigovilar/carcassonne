package br.ufpb.dcx.aps.carcassone;

import java.util.ArrayList;
import br.ufpb.dcx.aps.carcassone.tabuleiro.TabuleiroFlexivel;
import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

public class Partida {

	private BolsaDeTiles tiles;
	private Tile proximoTile;
	private TabuleiroFlexivel tabuleiro = new TabuleiroFlexivel("");
	int indiceJogadorVez = 0;
	String relatorio = "";
	Status statusTurno = Status.TURNO_INICIO;
	Status statusPartida;

	
	Jogadores[] jogadores;
	

	ArrayList<Tile> tilesParaUsar = new ArrayList<Tile>();

	Partida(BolsaDeTiles tiles, Cor[] sequencia) {
		this.tiles = tiles;
		pegarProximoTile();

		jogadores = new Jogadores[sequencia.length];
		for (int i = 0; i < sequencia.length; ++i) {
			jogadores[i] = new Jogadores(sequencia[i]);
		}
		
		statusPartida = Status.PTD_ANDAMENTO;
		tabuleiro.adicionarPrimeiroTile(proximoTile);
		pegarProximoTile();
		

	}

	public String relatorioPartida() {
		String sequencia = "";

		for (int i = 0; i < jogadores.length - 1; i++) {
			sequencia += jogadores[i].toString() + "; ";  //Desgraça do ; que eu não tava prestando atenção 
		}

		sequencia += jogadores[jogadores.length - 1];

		relatorio = "Status: " + statusPartida + "\nJogadores: " + sequencia;

		return relatorio;

	}

	public String relatorioTurno() {
		Jogadores proximoJogador = jogadores[indiceJogadorVez%jogadores.length];
		relatorio = "Jogador: " + proximoJogador.getCor() + "\nTile: " + proximoTile + "\nStatus: " + statusTurno;

		
		return relatorio;
	}

	public Partida girarTile() {
		if (proximoTile == null ) {
			throw new ExcecaoJogo("Não pode girar tiles com a partida finalizada");
		}
		proximoTile.girar();
		return this;
	}

	private void pegarProximoTile() {
		proximoTile = tiles.pegar();
		if (proximoTile != null) {
			proximoTile.reset();
		}
		

	}

	public Partida finalizarTurno() {
		pegarProximoTile();
		return this;
	}

	public Partida posicionarTile(Tile tileReferencia, Lado ladoTileReferencia) {
		tabuleiro.posicionar(tileReferencia, ladoTileReferencia, proximoTile);
		return this;
	}

	public Partida posicionarMeepleEstrada(Lado lado) {
		
		if(lado == Lado.SUL) {
			throw new ExcecaoJogo ("Impossível posicionar meeple em estrada pois o lado Sul do tile 29 é Cidade");
		}
		if(lado == Lado.LESTE) {
			throw new ExcecaoJogo ("Impossível posicionar meeple em estrada pois o lado Leste do tile 29 é Campo");
		}
		if (lado == Lado.OESTE){
			throw new ExcecaoJogo ("Impossível posicionar meeple em estrada pois o lado Oeste do tile 29 é Campo");
		}
		return this;
	}

	public Partida posicionarMeepleCampo(Vertice vertice) {
		if(vertice == Vertice.SUDESTE) {
			throw new ExcecaoJogo ("Impossível posicionar meeple em campo pois o vertice Sudeste do tile 02 é totalmente ocupado por Cidade");
		}
		if(vertice == Vertice.SUDOESTE){
			throw new ExcecaoJogo ("Impossível posicionar meeple em campo pois o vertice Sudeste do tile 02 é totalmente ocupado por Cidade");
		}
		
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
		return tabuleiro.toString();
	}

	public void verificarFimPartida() {
		if (proximoTile == null) {
			statusPartida = Status.PTD_FINALIZADA;
		}
	}

	/*
	 * Método de refatoração: Inline class
	 */
	public enum Status {
		PTD_ANDAMENTO("Em_Andamento"), TURNO_INICIO("Início_Turno"), PTD_FINALIZADA("Partida_Finalizada"), T_POS("Tile_Posicionado");

		final private String nStatus;

		Status(String status) {
			this.nStatus = status;
		}

		public String getStatus() {
			return nStatus;
		}

		@Override
		public String toString() {
			return nStatus;
		}

	}
	/*
	 * FIM do Inline class
	 */
}
