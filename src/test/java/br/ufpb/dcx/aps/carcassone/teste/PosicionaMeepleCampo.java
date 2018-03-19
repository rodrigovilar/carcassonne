package br.ufpb.dcx.aps.carcassone.teste;

import br.ufpb.dcx.aps.carcassone.Jogo;
import br.ufpb.dcx.aps.carcassone.Vertice;

public class PosicionaMeepleCampo implements PosicionaMeeple {

	public static final PosicionaMeepleCampo NORDESTE = new  PosicionaMeepleCampo(Vertice.NORDESTE);
	public static final PosicionaMeepleCampo SUDESTE = new  PosicionaMeepleCampo(Vertice.SUDESTE);
	public static final PosicionaMeepleCampo SUDOESTE = new  PosicionaMeepleCampo(Vertice.SUDOESTE);
	public static final PosicionaMeepleCampo NOROESTE = new  PosicionaMeepleCampo(Vertice.NOROESTE);
	
	private Vertice vertice;
	
	private PosicionaMeepleCampo(Vertice vertice) {
		super();
		
	}

	@Override
	public void posicionar(Jogo jogo) {
		
		jogo.posicionarMeepleCampo(vertice);
	}
}
