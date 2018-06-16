package br.ufpb.dcx.aps.carcassone;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author CHAGAS
 * 
 * Criação da classe Jogadores para não poluir a classe 'Partida'.
 * Pois, já que jogador deve possuir um array de duas posições (Meeples, pontuação), 
 * melhor separá-lo em uma outra classe. 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Jogadores implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Cor jogadores;
	// private int id;
	private int pontosJogadores = 0;
	private int meeplesJogadores = 7;
	
	public Jogadores(Cor jogadores) {
		this(jogadores,0,7);
	}
	
	
	@JsonCreator
	public Jogadores(@JsonProperty("cor") Cor jogadores, @JsonProperty("pontos")Integer pontosJogadores , @JsonProperty("meeples") Integer meeplesJogadores) {
		//this.id = id; // Adicionei o ID
		this.jogadores = jogadores;
		this.pontosJogadores = pontosJogadores;
		this.meeplesJogadores = meeplesJogadores;
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
	
	public void tirarMeeple() {
		--meeplesJogadores;
	}
	
	public void reset() {
		meeplesJogadores = 7;
		pontosJogadores = 0;
}
	
	@Override
	public String toString() {
		return jogadores+"("+pontosJogadores+","+meeplesJogadores+")";
}

/*	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
*/
}