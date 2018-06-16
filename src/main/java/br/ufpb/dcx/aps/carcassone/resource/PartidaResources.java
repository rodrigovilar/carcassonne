package br.ufpb.dcx.aps.carcassone.resource;

import static br.ufpb.dcx.aps.carcassone.TilesJogoBase.AZUL;
import static br.ufpb.dcx.aps.carcassone.TilesJogoBase.VERDE;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ufpb.dcx.aps.carcassone.BolsaDeTiles;
import br.ufpb.dcx.aps.carcassone.Jogadores;
import br.ufpb.dcx.aps.carcassone.Jogo;
import br.ufpb.dcx.aps.carcassone.Partida;
import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

/**
 * @author CHAGAS
 *
 */
public class PartidaResources implements BolsaDeTiles{
	private Jogo jogo;
	private Tile tile;
	private Map<Integer, Partida> partidas;
	private BolsaDeTiles tiles;
	Partida partida = jogo.criarPartida(tiles, AZUL, VERDE);
	
	@Override
	public Tile pegar() {
		// TODO Auto-generated method stub
		return null;
	}
	
}