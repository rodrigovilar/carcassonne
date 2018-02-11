package br.ufpb.dcx.aps.carcassone;

public class TabuleiroFlexivel {
	
	CelulaTabuleiro superiorEsquerda;
	
	public void adicionarPrimeiroTile(TipoTile tile) {
		CelulaTabuleiro celula = new CelulaTabuleiro(tile);
	}
	

}

class CelulaTabuleiro {

	private TipoTile tile;
	private CelulaTabuleiro norte, sul, leste, oeste;

	public static CelulaTabuleiro celulaVazia() {
		return new CelulaTabuleiro(null);
	}
	
	public CelulaTabuleiro(TipoTile tile) {
		this.tile = tile;
	}

	public TipoTile getTile() {
		return tile;
	}

	public void setTile(TipoTile tile) {
		this.tile = tile;
	}

	public CelulaTabuleiro getNorte() {
		return norte;
	}

	public void setNorte(CelulaTabuleiro norte) {
		this.norte = norte;
	}

	public CelulaTabuleiro getSul() {
		return sul;
	}

	public void setSul(CelulaTabuleiro sul) {
		this.sul = sul;
	}

	public CelulaTabuleiro getLeste() {
		return leste;
	}

	public void setLeste(CelulaTabuleiro leste) {
		this.leste = leste;
	}

	public CelulaTabuleiro getOeste() {
		return oeste;
	}

	public void setOeste(CelulaTabuleiro oeste) {
		this.oeste = oeste;
	}

}
