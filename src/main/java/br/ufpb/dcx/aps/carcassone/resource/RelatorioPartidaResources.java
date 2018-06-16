package br.ufpb.dcx.aps.carcassone.resource;

import br.ufpb.dcx.aps.carcassone.Partida.Status;
import br.ufpb.dcx.aps.carcassone.Jogadores;

public class RelatorioPartidaResources {

	Jogadores[] jogadores = null;
	Status status;
	
	public RelatorioPartidaResources(Status status, Jogadores...jogadores) {
		this.status = status;
		this.jogadores = jogadores;
	}
	
	public Jogadores[] getJogadores() {
		return jogadores;
}
	
}


/**
 * @author CHAGAS
 */