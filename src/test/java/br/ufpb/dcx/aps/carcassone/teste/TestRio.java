package br.ufpb.dcx.aps.carcassone.teste;

import static br.ufpb.dcx.aps.carcassone.teste.Assertiva.ocorreExcecao;
import static org.mockito.Mockito.mock;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ufpb.dcx.aps.carcassone.BolsaDeTiles;
import br.ufpb.dcx.aps.carcassone.ExcecaoJogo;
import br.ufpb.dcx.aps.carcassone.Jogo;
import br.ufpb.dcx.aps.carcassone.Rio;

public class TestRio {

	private Jogo jogo;
	private Rio rio;
	private BolsaDeTiles tiles;
	
	@Before
	public void novoJogo() {
		tiles = mock(BolsaDeTiles.class);
		jogo = new Jogo(tiles);
	}
	
	@Test //#01
	public void IniciarPartidaComRio() {
		ocorreExcecaoRio(() -> jogo.iniciarPartida(), "A partida não pode ser iniciada com tiles de Rio");
		
	}
	
	private void ocorreExcecaoRio(ExceptionThrower et, String mensagem) {
		ocorreExcecao(et).tipoExcecao(ExcecaoJogo.class).mensagem(mensagem);
	}
			
}
