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
	
	@Test //#02
	public void IniciarRio() {
		ocorreExcecaoRio(() -> verificarRio("NASCENTE"), "Rio só pode ser iniciado com nascente");
	}
	
	@Test //#03
	//Teste Andreza
	public void FinalizarRio() {
		ocorreExcecaoRio(() -> verificarRio("LAGO"), "Rio só pode ser finalizado com lago"); 
	}
	
	
	private void ocorreExcecaoRio(ExceptionThrower et, String mensagem) {
		ocorreExcecao(et).tipoExcecao(ExcecaoJogo.class).mensagem(mensagem);
	}
	
	private void verificarRio(String verRio) {
		String rio = jogo.getRio();
		Assert.assertEquals("Rio: " + verRio, rio);
	}
			
}
