package br.ufpb.dcx.aps.carcassone;

public class TipoTile {

	private Origem origem;

	private TipoLado ladoNorte;
	private TipoLado ladoLeste;
	private TipoLado ladoSul;
	private TipoLado ladoOeste;

	private boolean escudo;
	private boolean mosteiro;
	private boolean cidadeContinua;

	public TipoTile() {
	}

	public TipoTile(Origem origem, TipoLado ladoNorte, TipoLado ladoLeste, TipoLado ladoSul, TipoLado ladoOeste,
			boolean escudo, boolean mosteiro, boolean cidadeContinua) {
		this.origem = origem;
		this.ladoNorte = ladoNorte;
		this.ladoLeste = ladoLeste;
		this.ladoSul = ladoSul;
		this.ladoOeste = ladoOeste;
		this.escudo = escudo;
		this.mosteiro = mosteiro;
		this.cidadeContinua = cidadeContinua;
	}
	
	public Origem getOrigem() {
		return origem;
	}

	public void setOrigem(Origem origem) {
		this.origem = origem;
	}

	public TipoLado getLadoNorte() {
		return ladoNorte;
	}

	public void setLadoNorte(TipoLado ladoNorte) {
		this.ladoNorte = ladoNorte;
	}

	public TipoLado getLadoLeste() {
		return ladoLeste;
	}

	public void setLadoLeste(TipoLado ladoLeste) {
		this.ladoLeste = ladoLeste;
	}

	public TipoLado getLadoSul() {
		return ladoSul;
	}

	public void setLadoSul(TipoLado ladoSul) {
		this.ladoSul = ladoSul;
	}

	public TipoLado getLadoOeste() {
		return ladoOeste;
	}

	public void setLadoOeste(TipoLado ladoOeste) {
		this.ladoOeste = ladoOeste;
	}

	public boolean isEscudo() {
		return escudo;
	}

	public void setEscudo(boolean escudo) {
		this.escudo = escudo;
	}

	public boolean isMosteiro() {
		return mosteiro;
	}

	public void setMosteiro(boolean mosteiro) {
		this.mosteiro = mosteiro;
	}

	public boolean isCidadeContinua() {
		return cidadeContinua;
	}

	public void setCidadeContinua(boolean cidadeContinua) {
		this.cidadeContinua = cidadeContinua;
	}

}
