/**
 * 
 */
package br.ufpb.dcx.aps.carcassone;

import br.ufpb.dcx.aps.carcassone.tabuleiro.Tile;

import java.util.Collections;
import java.util.ArrayList;;


/**
 * @author CHAGAS
 *
 */
public class TilesConcretos implements BolsaDeTiles {

	ArrayList<Tile> tiles = new ArrayList<Tile>();
	
	public TilesConcretos(Tile primeiroTile, Tile... tiles) {
		for (int i = 0; i < tiles.length; ++i) {
			this.tiles.add(tiles[i]);
		}
		Collections.shuffle(this.tiles);
		this.tiles.add(0,primeiroTile);
	}

	@Override
	public Tile pegar() {
		if (tiles.isEmpty()) {
			return null;
		}
		return tiles.get(tiles.size()-1);
	}

}