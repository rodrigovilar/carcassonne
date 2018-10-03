package br.ufpb.dcx.aps.carcassone;

import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;
import br.ufpb.dcx.aps.carcassone.tabuleiro.TipoTile;

public interface TilesMinaOuro extends TilesJogo{

    TipoTile RRRRL51 = new TipoTileCarcassonneMinaOuro(BASE, ESTRADA, ESTRADA, ESTRADA, ESTRADA, SEM_ESCUDO, COM_MOSTEIRO, SEM_CIDADES, COM_LINGOTE);
    TipoTile CRRCL51 = new TipoTileCarcassonneMinaOuro(BASE, CIDADE, ESTRADA, ESTRADA, CIDADE, SEM_ESCUDO, COM_MOSTEIRO, SEM_CIDADES, COM_LINGOTE);
    TipoTile CFRCL51 = new TipoTileCarcassonneMinaOuro(BASE, CIDADE, CAMPO, ESTRADA, CIDADE, SEM_ESCUDO, COM_MOSTEIRO, SEM_CIDADES, COM_LINGOTE);
    TipoTile RCRC1 = new TipoTileCarcassonneMinaOuro(BASE, ESTRADA, CIDADE, ESTRADA, CIDADE, SEM_ESCUDO, SEM_MOSTEIRO, SEM_CIDADES, COM_LINGOTE);
    TipoTile CRRC51 = new TipoTileCarcassonneMinaOuro(BASE, CIDADE, ESTRADA, ESTRADA, CIDADE, SEM_ESCUDO, SEM_MOSTEIRO, SEM_CIDADES, COM_LINGOTE);
    TipoTile RRRRO51 = new TipoTileCarcassonneMinaOuro(BASE, ESTRADA, ESTRADA, ESTRADA, ESTRADA, SEM_ESCUDO, SEM_MOSTEIRO, UMA_CIDADE, COM_LINGOTE);
    TipoTile FRRFL51 = new TipoTileCarcassonneMinaOuro(BASE, CAMPO, ESTRADA, ESTRADA, CAMPO, SEM_ESCUDO, COM_MOSTEIRO, SEM_CIDADES, COM_LINGOTE);
    TipoTile RRRR51 = new TipoTileCarcassonneMinaOuro(BASE, ESTRADA, ESTRADA, ESTRADA, ESTRADA, SEM_ESCUDO, SEM_MOSTEIRO, SEM_CIDADES, COM_LINGOTE);

    Tile t73 = new Tile("73", RRRRL51);
    Tile t74 = new Tile("74", CRRCL51);
    Tile t75 = new Tile("75", CFRCL51);
    Tile t76 = new Tile("76", RCRC1);
    Tile t77 = new Tile("77", CRRC51);
    Tile t78 = new Tile("78", RRRRO51);
    Tile t79 = new Tile("79", FRRFL51);
    Tile t80 = new Tile("80", RRRR51);

}
