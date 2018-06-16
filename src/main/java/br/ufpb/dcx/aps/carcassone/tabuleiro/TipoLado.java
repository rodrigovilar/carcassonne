package br.ufpb.dcx.aps.carcassone.tabuleiro;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = TipoLado.class)

public interface TipoLado {
	
	String getAbreviacao();

}
