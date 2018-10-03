package br.ufpb.dcx.aps.carcassone;

public interface TilesJogo {
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

    boolean COM_ESCUDO = true;
    boolean SEM_ESCUDO = false;

    boolean COM_MOSTEIRO = true;
    boolean SEM_MOSTEIRO = false;

    boolean COM_LINGOTE = true;
    boolean SEM_LINGOTE = false;

    boolean UMA_CIDADE = false;
    boolean DUAS_CIDADES = true;
    boolean SEM_CIDADES = false;
}
