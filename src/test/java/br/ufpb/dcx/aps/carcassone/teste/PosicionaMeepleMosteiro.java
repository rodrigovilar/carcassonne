package br.ufpb.dcx.aps.carcassone.teste;

import br.ufpb.dcx.aps.carcassone.Jogo;

public class PosicionaMeepleMosteiro implements PosicionaMeeple {
		
	private PosicionaMeepleMosteiro() {
		super();
		
	}

	@Override
	public void posicionar(Jogo jogo) {
		
		jogo.posicionarMeepleMosteiro();
	}
}
