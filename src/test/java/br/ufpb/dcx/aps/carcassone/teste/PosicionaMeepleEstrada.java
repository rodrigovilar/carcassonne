package br.ufpb.dcx.aps.carcassone.teste;

import br.ufpb.dcx.aps.carcassone.Jogo;
import br.ufpb.dcx.aps.carcassone.Lado;

public class PosicionaMeepleEstrada implements PosicionaMeeple {

	public static final PosicionaMeepleEstrada NORTE = new  PosicionaMeepleEstrada(Lado.NORTE);
	public static final PosicionaMeepleEstrada LESTE = new  PosicionaMeepleEstrada(Lado.LESTE);
	public static final PosicionaMeepleEstrada SUL = new  PosicionaMeepleEstrada(Lado.SUL);
	public static final PosicionaMeepleEstrada OESTE = new  PosicionaMeepleEstrada(Lado.OESTE);
	
	private Lado lado;
	
	private PosicionaMeepleEstrada(Lado lado) {
		super();
		
	}

	@Override
	public void posicionar(Jogo jogo) {
		
		jogo.posicionarMeepleEstrada(lado);
	}

}
