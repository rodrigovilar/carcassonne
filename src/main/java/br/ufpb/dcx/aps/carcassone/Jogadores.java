package br.ufpb.dcx.aps.carcassone;

/**
 * @author CHAGAS
 * 
 * Criação da classe Jogadores para não poluir a classe 'Partida'.
 * Pois, já que jogador deve possuir um array de duas posições (Meeples, pontuação), 
 * melhor separá-lo em uma outra classe. 
 */

public class Jogadores {

	private Cor jogadores;
	private int pontosJogadores = 0;
	private int meeplesJogadores = 7;
	
	public Jogadores(Cor cor) {
		jogadores = cor;
	}
	
	public Cor getCor() {
		return jogadores;
	}
	
	public int getPontos() {
		return pontosJogadores;
	}
	
	public int quantidadeMeeples() {
		return meeplesJogadores;
	}
	
	@Override
	public String toString() {
		return jogadores+"("+pontosJogadores+","+meeplesJogadores+")";
}
}