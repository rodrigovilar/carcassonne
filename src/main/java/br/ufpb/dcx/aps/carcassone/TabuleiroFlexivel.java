package br.ufpb.dcx.aps.carcassone;

import java.util.ArrayList;

public class TabuleiroFlexivel {

	CelulaTabuleiro celulaInicial;
	
	CelulaTabuleiro extremoNorte;
	CelulaTabuleiro extremoLeste;
	CelulaTabuleiro extremoSul;
	CelulaTabuleiro extremoOeste;
	
	private String espacoVazio;
	
	public TabuleiroFlexivel() {
		this(" ");
	}

	public TabuleiroFlexivel(String espacoVazio) {
		this.espacoVazio = espacoVazio;
	}
	
	public void adicionarPrimeiroTile(Tile tile) {
		celulaInicial = new CelulaTabuleiro(tile, 0, 0);
		extremoNorte = extremoLeste = extremoSul = extremoOeste = celulaInicial;
	}

	public void posicionar(Tile tileReferencia, Lado ladoTileReferencia, Tile novoTile) {
		CelulaTabuleiro celulaAchada = encontrarCelula(celulaInicial, tileReferencia);
		CelulaTabuleiro novaCelula;

		switch (ladoTileReferencia) {
		case NORTE:
			novaCelula = new CelulaTabuleiro(novoTile, celulaAchada.getX(), celulaAchada.getY() + 1);
			celulaAchada.setNorte(novaCelula);
			novaCelula.setSul(celulaAchada);
			if (celulaAchada == extremoNorte) {
				extremoNorte = novaCelula;
			}
			break;

		case LESTE:
			novaCelula = new CelulaTabuleiro(novoTile, celulaAchada.getX() + 1, celulaAchada.getY());
			celulaAchada.setLeste(novaCelula);
			novaCelula.setOeste(celulaAchada);
			if (celulaAchada == extremoLeste) {
				extremoLeste = novaCelula;
			}
			break;

		case SUL:
			novaCelula = new CelulaTabuleiro(novoTile, celulaAchada.getX(), celulaAchada.getY() - 1);
			celulaAchada.setSul(novaCelula);
			novaCelula.setNorte(celulaAchada);
			if (celulaAchada == extremoSul) {
				extremoSul = novaCelula;
			}
			break;

		case OESTE:
			novaCelula = new CelulaTabuleiro(novoTile, celulaAchada.getX() - 1, celulaAchada.getY());
			celulaAchada.setOeste(novaCelula);
			novaCelula.setLeste(celulaAchada);
			if (celulaAchada == extremoOeste) {
				extremoOeste = novaCelula;
			}
			break;
		}
	}

	private CelulaTabuleiro encontrarCelula(CelulaTabuleiro celulaAtual, Tile tileReferencia) {
		ArrayList<CelulaTabuleiro> celulasVisitadas = new ArrayList<>();
		return encontrarCelulaInterno(celulaAtual, tileReferencia, null, celulasVisitadas);
	}

	private CelulaTabuleiro encontrarCelulaInterno(CelulaTabuleiro celulaAtual, Tile tileReferencia, Lado movimento,
			ArrayList<CelulaTabuleiro> celulasVisitadas) {

		if (celulaAtual == null || celulasVisitadas.contains(celulaAtual)) {
			return null;
		}

		celulasVisitadas.add(celulaAtual);

		if (celulaAtual.getTile().equals(tileReferencia)) {
			return celulaAtual;
		}

		CelulaTabuleiro tentativa = encontrarLado(celulaAtual, celulaAtual.getNorte(), tileReferencia, movimento,
				Lado.NORTE, celulasVisitadas);
		if (tentativa != null) {
			return tentativa;
		}

		tentativa = encontrarLado(celulaAtual, celulaAtual.getLeste(), tileReferencia, movimento, Lado.LESTE,
				celulasVisitadas);
		if (tentativa != null) {
			return tentativa;
		}

		tentativa = encontrarLado(celulaAtual, celulaAtual.getSul(), tileReferencia, movimento, Lado.SUL,
				celulasVisitadas);
		if (tentativa != null) {
			return tentativa;
		}

		return encontrarLado(celulaAtual, celulaAtual.getOeste(), tileReferencia, movimento, Lado.OESTE,
				celulasVisitadas);
	}

	private CelulaTabuleiro encontrarLado(CelulaTabuleiro celulaAtual, CelulaTabuleiro novaCelula, Tile tileReferencia,
			Lado movimentoAnterior, Lado novoMovimento, ArrayList<CelulaTabuleiro> celulasVisitadas) {

		if (movimentoAnterior == null || !movimentoAnterior.equals(novoMovimento)) {
			return encontrarCelulaInterno(novaCelula, tileReferencia, novoMovimento, celulasVisitadas);
		}

		return null;
	}
	
	@Override
	public String toString() {
		String s = "";
		
		int largura = extremoLeste.getX() - extremoOeste.getX() + 1;
		int altura = extremoNorte.getY() - extremoSul.getY() + 1;
		CelulaTabuleiro[][] tabuleiro = new CelulaTabuleiro[largura][altura];
		
		povoar(celulaInicial, tabuleiro, new ArrayList<>());
		
		for (int i = altura - 1; i >= 0; i--) {
			for (int j = 0; j < largura; j++) {
				s += (tabuleiro[j][i] == null) ? espacoVazio : tabuleiro[j][i].getTile().getId();
			}
			s += "\n";
		}
		
		return s;
	}

	private void povoar(CelulaTabuleiro celulaAtual, CelulaTabuleiro[][] tabuleiro, ArrayList<CelulaTabuleiro> celulasVisitadas) {
		if (celulaAtual == null || celulasVisitadas.contains(celulaAtual)) {
			return;
		}

		celulasVisitadas.add(celulaAtual);
		
		tabuleiro[celulaAtual.getX() - extremoOeste.getX()][celulaAtual.getY() - extremoSul.getY()] = celulaAtual;
		povoar(celulaAtual.getNorte(), tabuleiro, celulasVisitadas);
		povoar(celulaAtual.getLeste(), tabuleiro, celulasVisitadas);
		povoar(celulaAtual.getSul(), tabuleiro, celulasVisitadas);
		povoar(celulaAtual.getOeste(), tabuleiro, celulasVisitadas);
	}
}

class CelulaTabuleiro {

	private Tile tile;
	private CelulaTabuleiro norte, sul, leste, oeste;
	private int x, y;

	public static CelulaTabuleiro celulaVazia(int x, int y) {
		return new CelulaTabuleiro(null, x, y);
	}

	public CelulaTabuleiro(Tile tile, int x, int y) {
		this.tile = tile;
		this.x = x;
		this.y = y;
	}

	public Tile getTile() {
		return tile;
	}

	public void setTile(Tile tile) {
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

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
