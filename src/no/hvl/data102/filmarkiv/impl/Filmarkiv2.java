package no.hvl.data102.filmarkiv.impl;


import dat102.f04.lenketbag.LenketBag.Node;
import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	
	private LinearNode<Film> forste;
	private int antall;
	
	public Filmarkiv2() {
		this.forste = null;
		this.antall = 0;
	}

	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> p = forste;
		while (p != null ) {
			if (p.data.getFilmNr() == nr) {
				return p.data;
			}
				p = p.neste;
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> ny = new LinearNode<>(nyFilm);
		ny.neste = forste;
		forste = ny;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int antall(Sjanger sjanger) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int antall() {
		return antall;
	}

}
