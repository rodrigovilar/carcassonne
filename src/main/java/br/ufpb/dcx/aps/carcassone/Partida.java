package br.ufpb.dcx.aps.carcassone;

import java.util.ArrayList;
import br.ufpb.dcx.aps.carcassone.tabuleiro.TabuleiroFlexivel;
import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

public class Partida {
	private Tile proximoTile;
	private BolsaDeTiles tiles;
	private TabuleiroFlexivel tabuleiro = new TabuleiroFlexivel(" ");
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
		if (proximoTile == null) {
			statusPartida = Status.PTD_FINALIZADA;
		}
		String sequencia = "";

		for (int i = 0; i < jogadores.length - 1; i++) {
			sequencia += jogadores[i].toString() + "; "; // Desgraça do ; que eu não tava prestando atenção
		}

		sequencia += jogadores[jogadores.length - 1];

		relatorio = "Status: " + statusPartida + "\nJogadores: " + sequencia;

		return relatorio;

	}

	public String relatorioTurno() {
		verificarFimPartida();
		Jogadores proximoJogador = jogadores[indiceJogadorVez % jogadores.length];
		relatorio = "Jogador: " + proximoJogador.getCor() + "\nTile: " + proximoTile + "\nStatus: " + statusTurno;

		return relatorio;
	}

	public Partida girarTile() {
		if(statusTurno == Status.T_POS) {
			throw new ExcecaoJogo("Não pode girar tile já posicionado");
		}
		if (proximoTile == null) {
			statusPartida = Status.PTD_FINALIZADA;
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

		tilesParaUsar.add(proximoTile);

	}

	public Partida finalizarTurno() {
		pegarProximoTile();
		indiceJogadorVez++; // Muda o jogador da vez. Antes não estava mudando, dando a entender que o turno não tinha fim
		statusTurno = Status.TURNO_INICIO;
		return this;
	}

	public Partida posicionarTile(Tile tileReferencia, Lado ladoTileReferencia) {
		if(statusTurno == Status.T_POS) {
			throw new ExcecaoJogo("Não pode reposicionar tile já posicionado");
		}
		tabuleiro.posicionar(tileReferencia, ladoTileReferencia, proximoTile);
		statusTurno = Status.T_POS; //mudança no estado do Turno para "Tile_Posicionado", para que dessa forma passe a vez pro próximo jogador e o turno prossiga
		
		return this;
	}

	public Partida posicionarMeepleEstrada(Lado lado) {
		switch (lado) {
		case SUL:
			lado = Lado.SUL;
			throw new ExcecaoJogo("Impossível posicionar meeple em estrada pois o lado Sul do tile 29 é Cidade");
		case LESTE:
			lado = Lado.LESTE;
			throw new ExcecaoJogo("Impossível posicionar meeple em estrada pois o lado Leste do tile 29 é Campo");
		case NORTE:
			lado = Lado.NORTE;
			throw new ExcecaoJogo("Impossível posicionar meeple em estrada pois o lado Norte do tile 29 é Campo");
		case OESTE:
			lado = Lado.OESTE;
			throw new ExcecaoJogo("Impossível posicionar meeple em estrada pois o lado Oeste do tile 29 é Campo");
		default:
			break;
		
    }
		return this;
	}

	
	
	public Partida posicionarMeepleCampo(Vertice vertice) {
		switch (vertice) {
		case SUDESTE:
			vertice = Vertice.SUDESTE;
			throw new ExcecaoJogo(
								"Impossível posicionar meeple em campo pois o vertice Sudeste do tile 02 é totalmente ocupado por Cidade");

		case SUDOESTE:
			vertice = Vertice.SUDOESTE;
			throw new ExcecaoJogo(
								"Impossível posicionar meeple em campo pois o vertice Sudoeste do tile 02 é totalmente ocupado por Cidade");
		default:
			break;
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
			throw new ExcecaoJogo("Partida finalizada");
		} else {
			statusPartida = Status.PTD_ANDAMENTO;
		}
	}

	/*
	 * Método de refatoração: Inline class
	 */
	public enum Status {
		PTD_ANDAMENTO("Em_Andamento"), TURNO_INICIO("Início_Turno"), PTD_FINALIZADA("Partida_Finalizada"), T_POS(
				"Tile_Posicionado");

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
