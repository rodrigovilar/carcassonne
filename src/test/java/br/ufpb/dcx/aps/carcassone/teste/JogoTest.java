package br.ufpb.dcx.aps.carcassone.teste;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ufpb.dcx.aps.carcassone.BolsaDeTiles;
import br.ufpb.dcx.aps.carcassone.ExcecaoJogo;
import br.ufpb.dcx.aps.carcassone.Jogo;
import br.ufpb.dcx.aps.carcassone.Lado;
import br.ufpb.dcx.aps.carcassone.Tile;

import static org.mockito.Mockito.*;
import static br.ufpb.dcx.aps.carcassone.TilesJogoBase.*;
import static br.ufpb.dcx.aps.carcassone.teste.Assertiva.*;

public class JogoTest {

	private Jogo jogo;
	private BolsaDeTiles tiles;

	@Before
	public void novoJogo() {
		tiles = mock(BolsaDeTiles.class);
		jogo = new Jogo(tiles);
	}

	@Test
	public void iniciarPartidaInvalida() {
		ocorreExcecaoJogo(() -> jogo.iniciarPartida(), "Cada partida deve ter uma sequência de pelos dois jogadores");

		ocorreExcecaoJogo(() -> jogo.iniciarPartida(PRETO),
				"Cada partida deve ter uma sequência de pelos dois jogadores");

		ocorreExcecaoJogo(() -> jogo.iniciarPartida(PRETO, PRETO),
				"Não pode haver repetição de cores na sequência de jogadores");

		ocorreExcecaoJogo(() -> jogo.iniciarPartida(PRETO, AMARELO, PRETO),
				"Não pode haver repetição de cores na sequência de jogadores");

		jogo.iniciarPartida(AZUL, VERDE);
		ocorreExcecaoJogo(() -> jogo.iniciarPartida(AMARELO, VERMELHO),
				"Não pode iniciar uma partida enquanto a partida anterior não for finalizada");
	}

	@Test
	public void relatorioPartidaErro() {
		ocorreExcecaoJogo(() -> jogo.relatorioPartida(), "Partida não iniciada");
	}

	@Test
	public void iniciarPartidaValida() {
		mockarTiles(tiles, t45);
		jogo.iniciarPartida(AZUL, VERDE);
		verificarRelatorioPartida("AZUL Início", "AZUL, VERDE", "", "AZUL", "01N");
	}

	@Test
	public void girarTile() {
		mockarTiles(tiles, t45);
		jogo.iniciarPartida(VERDE, PRETO, AMARELO);
		girar(1);
		verificarRelatorioPartida("VERDE Início", "VERDE, PRETO, AMARELO", "", "VERDE", "01L");

		girar(2);
		verificarRelatorioPartida("VERDE Início", "VERDE, PRETO, AMARELO", "", "VERDE", "01O");

		girar(1);
		verificarRelatorioPartida("VERDE Início", "VERDE, PRETO, AMARELO", "", "VERDE", "01N");
	}

	@Test
	public void colocarTileUnico() {
		mockarTiles(tiles, t45);
		jogo.iniciarPartida(VERDE, PRETO, AMARELO, VERMELHO, AZUL);
		rodadaInicial(2, 0, NAO_FINALIZA);
		verificarRelatorioPartida("VERDE Tile", "VERDE, PRETO, AMARELO, VERMELHO, AZUL", "01S", "VERDE", null);
	}

	@Test
	public void posicionarInicialInvalida() {
		mockarTiles(tiles, t45);
		ocorreExcecaoJogo(() -> jogo.posicionarInicial(),
				"O tile inicial não pode ser posicionado antes de iniciar a partida");
	}

	@Test
	public void posicionarInicialInvalida2() {
		mockarTiles(tiles, t45, t19);
		ocorreExcecaoJogo(() -> jogo.posicionarInicial(),
				"O tile inicial não pode ser posicionado antes de iniciar a partida");
	}

	@Test
	public void mudancaPosicaoInicial() {
		mockarTiles(tiles, t45);
		jogo.iniciarPartida(VERMELHO, AZUL);
		rodadaInicial(0, 1, NAO_FINALIZA);

		jogo.posicionarInicial();
		verificarRelatorioPartida("VERMELHO Tile", "VERMELHO, AZUL", "01L", "AZUL", null);
	}

	@Test
	public void mudancaPosicaoInicial2() {
		mockarTiles(tiles, t45, t19);
		jogo.iniciarPartida(VERMELHO, AZUL);
		rodadaInicial(0, 3, NAO_FINALIZA);

		jogo.posicionarInicial();
		verificarRelatorioPartida("VERMELHO Tile", "VERMELHO, AZUL", "01O", "AZUL", null);
	}

	@Test
	public void finalizarRodada() {
		mockarTiles(tiles, t45);
		jogo.iniciarPartida(VERDE, PRETO, AMARELO, VERMELHO, AZUL);
		rodadaInicialSemGirar();
		verificarRelatorioPartida("Fim", "VERDE, PRETO, AMARELO, VERMELHO, AZUL", "01N", null, null);
	}

	@Test
	public void finalizarRodada2() {
		mockarTiles(tiles, t45, t19);
		jogo.iniciarPartida(VERDE, PRETO);
		rodadaInicialSemGirar();
		verificarRelatorioPartida("PRETO Início", "VERDE, PRETO", "01N", "PRETO", "02N");

		girar(3);
		verificarRelatorioPartida("PRETO Início", "VERDE, PRETO", "01N", "PRETO", "02O");
	}

	@Test
	public void posicionarSegundoTileLeste() {
		doisTilesAmareloVermelhoRodada1SemGirar();

		rodada(2, t45, LESTE, 0, NAO_FINALIZA);
		verificarRelatorioPartida("VERMELHO Tile", "AMARELO, VERMELHO", "01N02S", "AMARELO", null);
	}

	@Test
	public void posicionarSegundoTileSul() {
		doisTilesAmareloVermelhoRodada1SemGirar();

		rodada(1, t45, SUL, 0, NAO_FINALIZA);
		verificarRelatorioPartida("VERMELHO Tile", "AMARELO, VERMELHO", "01N\n02S", "AMARELO", null);
	}

	@Test
	public void posicionarSegundoTileOeste() {
		doisTilesAmareloVermelhoRodada1SemGirar();

		rodada(0, t45, OESTE, 0, NAO_FINALIZA);
		verificarRelatorioPartida("VERMELHO Tile", "AMARELO, VERMELHO", "02N01N", "AMARELO", null);
	}

	@Test
	public void posicionarSegundoTileNorte() {
		doisTilesAmareloVermelhoRodada1SemGirar();

		rodada(0, t45, NORTE, 0, NAO_FINALIZA);
		verificarRelatorioPartida("VERMELHO Tile", "AMARELO, VERMELHO", "02N\n01N", "AMARELO", null);
	}

	@Test
	public void posicionarGirarPosicionarSegundoTile() {
		doisTilesAmareloVermelhoRodada1SemGirar();

		rodada(0, t45, NORTE, 0, NAO_FINALIZA);
		rodada(1, t45, LESTE, 0, NAO_FINALIZA);
		verificarRelatorioPartida("VERMELHO Tile", "AMARELO, VERMELHO", "01N02L", "AMARELO", null);
	}

	@Test
	public void erroPosicionarSegundoTile() {
		doisTilesAmareloVermelhoRodada1SemGirar();

		ocorreExcecaoJogo(() -> rodada(3, t45, LESTE, 0, NAO_FINALIZA),
				"O lado Leste do tile 01 (Campo) é incompatível com o lado Oeste do tile 02 (Cidade)");
		ocorreExcecaoJogo(() -> rodada(2, t45, OESTE, 0, NAO_FINALIZA),
				"O lado Oeste do tile 01 (Campo) é incompatível com o lado Leste do tile 02 (Cidade)");
		ocorreExcecaoJogo(() -> rodada(3, t45, SUL, 0, NAO_FINALIZA),
				"O lado Sul do tile 01 (Campo) é incompatível com o lado Norte do tile 02 (Cidade)");
		ocorreExcecaoJogo(() -> rodada(2, t45, NORTE, 0, NAO_FINALIZA),
				"O lado Norte do tile 01 (Campo) é incompatível com o lado Sul do tile 02 (Cidade)");
	}
	
	@Test
	public void finalizarSegundaRodadaComDoisTiles() {
		doisTilesAmareloVermelhoRodada1SemGirar();
		
		rodada(2, t45, LESTE, 0, FINALIZA);
		verificarRelatorioPartida("Fim", "AMARELO, VERMELHO", "01N02S", null, null);
	}

	@Test
	public void finalizarSegundaRodadaComTresTiles() {
		mockarTiles(tiles, t45, t19, t46);
		jogo.iniciarPartida(AMARELO, VERMELHO);
		rodadaInicialSemGirar();
		
		rodada(2, t45, LESTE, 0, FINALIZA);
		verificarRelatorioPartida("AMARELO Tile", "AMARELO, VERMELHO", "01N02S", "VERMELHO", "01N");
	}

	private static final boolean FINALIZA = true;
	private static final boolean NAO_FINALIZA = false;

	private void girar(int quantidade) {
		for (int i = 0; i < quantidade; i++) {
			jogo.girarTile();
		}
	}

	private void rodadaInicial(int girosAntesPosicionar, int girosDepoisPosicionar, boolean finaliza) {
		girar(girosAntesPosicionar);

		jogo.posicionarInicial();

		girar(girosDepoisPosicionar);

		if (finaliza) {
			jogo.finalizarRodada();
		}
	}

	private void rodada(int girosAntesPosicionar, Tile tileReferencia, Lado ladoTileReferencia,
			int girosDepoisPosicionar, boolean finaliza) {
		for (int i = 0; i < girosAntesPosicionar; i++) {
			jogo.girarTile();
		}
		girar(girosAntesPosicionar);

		jogo.posicionar(tileReferencia, ladoTileReferencia);

		girar(girosDepoisPosicionar);

		if (finaliza) {
			jogo.finalizarRodada();
		}
	}

	// girarTile? - posicionarTile - posicionarMeeple? - finalizarRodada
	// COR Início - COR Tile - COR Meeple - OUTRA COR Início

	private void ocorreExcecaoJogo(ExceptionThrower et, String mensagem) {
		ocorreExcecao(et).tipoExcecao(ExcecaoJogo.class).mensagem(mensagem);
	}

	private void mockarTiles(BolsaDeTiles mock, Tile primeiro, Tile... tiles) {
		when(mock.pegar()).thenReturn(primeiro, tiles);
	}

	private void verificarRelatorioPartida(String status, String sequencia, String tabuleiro, String proximoJogador,
			String proximaPeca) {
		String relatorio = jogo.relatorioPartida();
		Assert.assertEquals("Status: " + status + "\nJogadores: " + sequencia + "\nTabuleiro: " + tabuleiro
				+ "\nPróximo jogador: " + proximoJogador + "\nPróximo tile: " + proximaPeca, relatorio);
	}

	// Pré-condições
	private void rodadaInicialSemGirar() {
		rodadaInicial(0, 0, FINALIZA);
	}

	private void doisTilesAmareloVermelhoRodada1SemGirar() {
		mockarTiles(tiles, t45, t19);
		jogo.iniciarPartida(AMARELO, VERMELHO);
		rodadaInicialSemGirar();
	}

}
