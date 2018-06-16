package br.ufpb.dcx.aps.carcassone.resource;


/**
 * @author CHAGAS
 */

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static br.ufpb.dcx.aps.carcassone.TilesJogoBase.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import br.ufpb.dcx.aps.carcassone.resource.RelatorioPartidaResources;
import br.ufpb.dcx.aps.carcassone.BolsaDeTiles;
import br.ufpb.dcx.aps.carcassone.TilesConcretos;
import br.ufpb.dcx.aps.carcassone.Cor;
import br.ufpb.dcx.aps.carcassone.Jogadores;
import br.ufpb.dcx.aps.carcassone.Lado;
import br.ufpb.dcx.aps.carcassone.Partida;
import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@RestController
//@RequestMapping("/partida")

public class JogoResources {

	ServicosRecursos servicos = new ServicosRecursos();
	
	@ApiOperation("Cria a partida uma lista com jogadores")
    @RequestMapping(value = "/partida", method = RequestMethod.POST)
    public ResponseEntity<?> criarPartida(@RequestBody Cor... sequencia){
    	return servicos.criarPartida(sequencia);
    }
    
	@ApiOperation("Quando solicitado, devolve o relatório da partida")
	@RequestMapping(value = "/relatorio", method = RequestMethod.GET)
	public ResponseEntity<RelatorioPartidaResources> relatorioPartida() {
		return servicos.relatorioPartida();
	}

	@ApiOperation("Quando solicitado, devolve o relatório do turno")
	@RequestMapping(value = "relatorio/turno", method = RequestMethod.GET)
	public ResponseEntity<RelatorioTurnoResources> relatorioTurno() {
		return servicos.relatorioTurno();
	}
	
	@ApiOperation("Posiciona o tile que está na vez")
	@RequestMapping(value = "/tile", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE, produces =MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody ResponseEntity<Tile> posicionarTile(@RequestBody Tile tile) {
		return new ResponseEntity<Tile>(tile, HttpStatus.OK);
	}
	
	@ApiOperation("Retorna todos os jogadores da partida")
	@RequestMapping(value = "/jogador", method = RequestMethod.GET)
	public ResponseEntity<Jogadores[]> recuperarJogadores() {
		return servicos.recuperarPecas();
	}

	@ApiOperation("Retorna um jogador específico")
	@RequestMapping(value = "jogador/{cor}", method = RequestMethod.GET)
	public ResponseEntity<Jogadores> recuperarJogador(@PathVariable(value = "cor") Cor cor) {
		return servicos.pegarPecasJogador(cor);
	}

	@ApiOperation("Retorna o tile que está na vez")
	@RequestMapping(value = "/tile", method = RequestMethod.GET)
	public ResponseEntity<Tile> pegarTile() {
		return servicos.pegarTile();
	}
	
	@ApiOperation("Gira o tile")
	@RequestMapping(value = "/girartile", method = RequestMethod.PUT)
	public ResponseEntity<Tile> girarTile() {
		return servicos.girarTile();
	}
}

