package br.ufpb.dcx.aps.carcassone.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.ufpb.dcx.aps.carcassone.Lado;
import br.ufpb.dcx.aps.carcassone.TabuleiroFlexivel;
import br.ufpb.dcx.aps.carcassone.Tile;
import br.ufpb.dcx.aps.carcassone.TipoLado;
import br.ufpb.dcx.aps.carcassone.TipoTile;

public class TabuleiroFlexivelTest {
	
	private static TipoLado LADO_DUMMY = new TipoLadoDummy();
	private static final TipoTile TIPO_DUMMY = new TipoTile(LADO_DUMMY, LADO_DUMMY, LADO_DUMMY, LADO_DUMMY);

	private static Tile TILE_A = new Tile("A", TIPO_DUMMY);
	private static Tile TILE_B = new Tile("B", TIPO_DUMMY);
	private static Tile TILE_C = new Tile("C", TIPO_DUMMY);
	private static Tile TILE_D = new Tile("D", TIPO_DUMMY);
	private static Tile TILE_E = new Tile("E", TIPO_DUMMY);
	private static Tile TILE_F = new Tile("F", TIPO_DUMMY);
	private static Tile TILE_G = new Tile("G", TIPO_DUMMY);
	private static Tile TILE_H = new Tile("H", TIPO_DUMMY);
	private static Tile TILE_I = new Tile("I", TIPO_DUMMY);
	private static Tile TILE_J = new Tile("J", TIPO_DUMMY);


	private TabuleiroFlexivel tabuleiroFlexivel;
	
	@Before
	public void novoJogo() {
		tabuleiroFlexivel = new TabuleiroFlexivel();
	}
	
	@Test
	public void testeUmaPeca() {
		tabuleiroFlexivel.adicionarPrimeiroTile(TILE_A);
		assertEquals("A\n", tabuleiroFlexivel.toString());
	}

	@Test
	public void testeLeste() {
		tabuleiroFlexivel.adicionarPrimeiroTile(TILE_A);
		tabuleiroFlexivel.posicionar(TILE_A, Lado.LESTE, TILE_B);
		assertEquals("AB\n", tabuleiroFlexivel.toString());
		tabuleiroFlexivel.posicionar(TILE_B, Lado.LESTE, TILE_C);
		assertEquals("ABC\n", tabuleiroFlexivel.toString());		
	}

	@Test
	public void testeOeste() {
		tabuleiroFlexivel.adicionarPrimeiroTile(TILE_A);
		tabuleiroFlexivel.posicionar(TILE_A, Lado.OESTE, TILE_B);
		assertEquals("BA\n", tabuleiroFlexivel.toString());
		tabuleiroFlexivel.posicionar(TILE_B, Lado.OESTE, TILE_C);
		assertEquals("CBA\n", tabuleiroFlexivel.toString());		
	}

	@Test
	public void testeNorte() {
		tabuleiroFlexivel.adicionarPrimeiroTile(TILE_A);
		tabuleiroFlexivel.posicionar(TILE_A, Lado.NORTE, TILE_B);
		assertEquals("B\nA\n", tabuleiroFlexivel.toString());
		tabuleiroFlexivel.posicionar(TILE_B, Lado.NORTE, TILE_C);
		assertEquals("C\nB\nA\n", tabuleiroFlexivel.toString());		
	}
	
	@Test
	public void testeSul() {
		tabuleiroFlexivel.adicionarPrimeiroTile(TILE_A);
		tabuleiroFlexivel.posicionar(TILE_A, Lado.SUL, TILE_B);
		assertEquals("A\nB\n", tabuleiroFlexivel.toString());
		tabuleiroFlexivel.posicionar(TILE_B, Lado.SUL, TILE_C);
		assertEquals("A\nB\nC\n", tabuleiroFlexivel.toString());		
	}

}

class TipoLadoDummy implements TipoLado {

	@Override
	public String getAbreviacao() {
		return "*";
	}
	
}
