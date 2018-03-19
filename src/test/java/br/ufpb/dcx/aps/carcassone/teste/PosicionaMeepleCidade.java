package br.ufpb.dcx.aps.carcassone.teste;

import br.ufpb.dcx.aps.carcassone.Jogo;
import br.ufpb.dcx.aps.carcassone.Lado;

public class PosicionaMeepleCidade implements PosicionaMeeple {
	
	public static final PosicionaMeepleCidade NORTE = new  PosicionaMeepleCidade(Lado.NORTE);
	public static final PosicionaMeepleCidade LESTE = new  PosicionaMeepleCidade(Lado.LESTE);
	public static final PosicionaMeepleCidade SUL = new  PosicionaMeepleCidade(Lado.SUL);
	public static final PosicionaMeepleCidade OESTE = new  PosicionaMeepleCidade(Lado.OESTE);
	
	private Lado lado;
	
	private PosicionaMeepleCidade(Lado lado) {
		super();
		
	}

	@Override
	public void posicionar(Jogo jogo) {
		
		jogo.posicionarMeepleEstrada(lado);
	}
}
