package br.ufpb.dcx.aps.carcassone;


	import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;
	import br.ufpb.dcx.aps.carcassone.tabuleiro.TipoTile;

	public interface NovoTileJogoBase {
		
		Cor AMARELO = Cor.AMARELO;
		Cor AZUL = Cor.AZUL;
		Cor PRETO = Cor.PRETO;
		Cor VERDE = Cor.VERDE;
		Cor VERMELHO = Cor.VERMELHO;

		Lado NORTE = Lado.NORTE;
		Lado LESTE = Lado.LESTE;
		Lado SUL = Lado.SUL;
		Lado OESTE = Lado.OESTE;
		
		Vertice NORDESTE = Vertice.NORDESTE;
		Vertice SUDESTE = Vertice.SUDESTE;
		Vertice SUDOESTE = Vertice.SUDOESTE;
		Vertice NOROESTE = Vertice.NOROESTE;
		
		Origem BASE = Origem.BASE;

		TipoLadoCarcassonne CAMPO = TipoLadoCarcassonne.CAMPO;
		TipoLadoCarcassonne CIDADE = TipoLadoCarcassonne.CIDADE;
		TipoLadoCarcassonne ESTRADA = TipoLadoCarcassonne.ESTRADA;
		TipoLadoCarcassonne RIO = TipoLadoCarcassonne.RIO;
		
		Rio COM_RIO = Rio.COM_RIO;
		Rio SEM_RIO = Rio.SEM_RIO;
		
		boolean COM_ESCUDO = true;
		boolean SEM_ESCUDO = false;

		boolean COM_MOSTEIRO = true;
		boolean SEM_MOSTEIRO = false;

		Cidades UMA_CIDADE = Cidades.UMA_CIDADE;
		Cidades DUAS_CIDADES = Cidades.DUAS_CIDADES;
		Cidades TRES_CIDADES = Cidades.TRES_CIDADES;
		Cidades QUATRO_CIDADES = Cidades.QUATRO_CIDADES;
		Cidades SEM_CIDADES = Cidades.SEM_CIDADES;
		
		//1 peça
		TipoTile RRTTL50 = new TipoTileCarcassonneComRio(BASE, RIO, CAMPO,RIO, CAMPO, false, false, null, null);
		//2 peça
		TipoTile RRRT50 = new TipoTileCarcassonneComRio(BASE, RIO, CAMPO,CAMPO,CAMPO, false,false,null,null);
		//3 PEÇA
		TipoTile FFRR50 = new TipoTileCarcassonneComRio(BASE, RIO,RIO, CAMPO,CAMPO,false,false,null,null);
		//4 PEÇA
		TipoTile SSSLC50 = new TipoTileCarcassonneComRio(BASE, RIO, CAMPO,CAMPO,CAMPO,false,false,null,null);
		//5 PEÇA
		TipoTile STRFC50 = new TipoTileCarcassonneComRio(BASE, RIO,CAMPO,CAMPO,RIO,false,false,null,null);
		//6 PEÇA
		TipoTile RCFFT50 = new TipoTileCarcassonneComRio(BASE, RIO,CIDADE,RIO,CIDADE,false,false,null,null);
		//7 PEÇA
		TipoTile FCFR50 = new TipoTileCarcassonneComRio(BASE, CAMPO,RIO,CAMPO,RIO,false,false,null,null);
		//8 PEÇA
		TipoTile CFRT50 = new TipoTileCarcassonneComRio(BASE, CIDADE,CIDADE,RIO,RIO,false,false,null,null);
		//9 PEÇA
		TipoTile DFRC50 = new TipoTileCarcassonneComRio(BASE, ESTRADA,RIO,ESTRADA,RIO,false,false,null,null);
		//10 PEÇA
		TipoTile RRTFD50 = new TipoTileCarcassonneComRio(BASE, ESTRADA,RIO,ESTRADA,RIO,false,false,null,null);
		//11 PEÇA
		TipoTile SSFFT50 = new TipoTileCarcassonneComRio(BASE, CIDADE,RIO,ESTRADA,RIO,false,false,null,null);
		//12 PEÇA
		TipoTile CCFRS50 = new TipoTileCarcassonneComRio(BASE, CAMPO,RIO,ESTRADA,RIO,false,false,null,null);
	
		
		
		Tile t73 = new Tile("73", RRTTL50);
		Tile t74 = new Tile("74", RRRT50);
		Tile t75 = new Tile("75", FFRR50);
		Tile t76 = new Tile("76", SSSLC50);
		Tile t77 = new Tile("77", STRFC50);
		Tile t78 = new Tile("78", RCFFT50);
		Tile t79 = new Tile("79", FCFR50);
		Tile t80 = new Tile("80", CFRT50);
		Tile t81 = new Tile("81", DFRC50);
		Tile t82 = new Tile("82", RRTFD50);
		Tile t83 = new Tile("83", SSFFT50);
		Tile t84 = new Tile("84", CCFRS50);
	
	}


