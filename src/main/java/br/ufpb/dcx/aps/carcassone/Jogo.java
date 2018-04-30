package br.ufpb.dcx.aps.carcassone;

public class Jogo {

	private boolean jogoIniciado = false;
	
	public Partida criarPartida(BolsaDeTiles tiles, Cor... sequencia) {
		
		if(tiles == null){
			throw new ExcecaoJogo("A bolsa de tiles deve ser fornecida na criação de uma partida"); 			
		}
		
		if (sequencia.length < 2) {
			throw new ExcecaoJogo("Cada partida deve ter uma sequência de pelo menos dois jogadores");
		}

		if (jogoIniciado == true) {
			throw new ExcecaoJogo("Não pode iniciar uma partida enquanto a partida anterior não for finalizada");
		}

		for (int i = 0; i < sequencia.length - 1; ++i) {
			for (int j = i + 1; j < sequencia.length; ++j) {
				if (sequencia[i] == sequencia[j]) {
					throw new ExcecaoJogo("Não pode haver repetição de cores na sequência de jogadores");
				}
			}
		}
		
		return new Partida(tiles,sequencia);
	}
	


}
