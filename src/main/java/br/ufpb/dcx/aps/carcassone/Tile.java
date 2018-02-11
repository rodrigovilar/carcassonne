package br.ufpb.dcx.aps.carcassone;

public class Tile {

	private String id;
	private Lado orientacao;
	private TipoTile tipoTile;
	private TipoLado ladoNorte;
	private TipoLado ladoLeste;
	private TipoLado ladoSul;
	private TipoLado ladoOeste;

	public Tile(String id, TipoTile tipoTile) {
		this.id = id;
		this.tipoTile = tipoTile;
		this.orientacao = Lado.NORTE;
		setLadoLeste(tipoTile.getLadoLeste());
		setLadoSul(tipoTile.getLadoSul());
		setLadoOeste(tipoTile.getLadoOeste());
		setLadoNorte(tipoTile.getLadoNorte());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TipoTile getTipoTile() {
		return tipoTile;
	}

	Lado getOrientacao() {
		return orientacao;
	}

	public TipoLado getLadoNorte() {
		return ladoNorte;
	}

	private void setLadoNorte(TipoLado ladoNorte) {
		this.ladoNorte = ladoNorte;
	}

	public TipoLado getLadoLeste() {
		return ladoLeste;
	}

	private void setLadoLeste(TipoLado ladoLeste) {
		this.ladoLeste = ladoLeste;
	}

	public TipoLado getLadoSul() {
		return ladoSul;
	}

	private void setLadoSul(TipoLado ladoSul) {
		this.ladoSul = ladoSul;
	}

	public TipoLado getLadoOeste() {
		return ladoOeste;
	}

	private void setLadoOeste(TipoLado ladoOeste) {
		this.ladoOeste = ladoOeste;
	}

	void girar() {
		switch (orientacao) {
		case NORTE:
			orientacao = Lado.LESTE;
			break;
		case LESTE:
			orientacao = Lado.SUL;
			break;
		case SUL:
			orientacao = Lado.OESTE;
			break;
		case OESTE:
			orientacao = Lado.NORTE;
			break;
		}

		TipoLado temp = ladoNorte;
		ladoNorte = ladoOeste;
		ladoOeste = ladoSul;
		ladoSul = ladoLeste;
		ladoLeste = temp;
	}

	void reset() {
		while (orientacao != Lado.NORTE) {
			girar();
		}
	}

	public String toString() {
		return getId() + getOrientacao().getAbreviacao();
	}

}
