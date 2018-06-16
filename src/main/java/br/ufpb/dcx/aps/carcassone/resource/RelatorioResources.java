package br.ufpb.dcx.aps.carcassone.resource;

import br.ufpb.dcx.aps.carcassone.Partida.Status;;

public class RelatorioResources {

	Status status;
	
	RelatorioResources(Status status) {
		this.status = status;
	}
	
	public Status getStatus() {
		return status;
	}
}
