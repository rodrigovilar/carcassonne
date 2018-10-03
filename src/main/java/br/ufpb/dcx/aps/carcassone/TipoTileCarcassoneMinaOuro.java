package br.ufpb.dcx.aps.carcassone;

import br.ufpb.dcx.aps.carcassone.tabuleiro.TipoLado;

public class TipoTileCarcassoneMinaOuro extends TipoTileCarcassonne{

    private boolean lingote;

    public TipoTileCarcassoneMinaOuro(Origem origem, TipoLado ladoNorte, TipoLado ladoLeste, TipoLado ladoSul, TipoLado ladoOeste, boolean escudo, boolean mosteiro, boolean cidadeContinua, boolean lingote) {
        super(origem, ladoNorte, ladoLeste, ladoSul, ladoOeste, escudo, mosteiro, cidadeContinua);
        this.lingote = lingote;
    }
}
