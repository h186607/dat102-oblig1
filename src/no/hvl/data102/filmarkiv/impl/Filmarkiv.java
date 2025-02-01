package no.hvl.data102.filmarkiv.impl;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv implements FilmarkivADT {
	private  Film[] filmer;
	private int antall;
	private static final int DEFAULT_KAPASITET = 4;
	
	public Filmarkiv() {
		this(DEFAULT_KAPASITET);
	}
	
	public Filmarkiv(int kapasitet) {
		filmer = new Film[kapasitet];
		antall = 0;
	}
	
	private boolean erFull() {
		return antall == filmer.length;
	}
	
	private Film[] utvid() {
		Film[] utvidetFilmer = new Film[filmer.length*2]; 
		
		for (int i = 0; i < filmer.length; i++) {
			utvidetFilmer[i] = filmer[i];
		}
	
		filmer = utvidetFilmer;
		return filmer;
	}
	
	@Override 
	public Film finnFilm(int nr) {
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getFilmNr() == nr) {
				return filmer[i];
			}
		}
		return null;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		if (erFull()) {
			utvid();
		}
		filmer[antall] = nyFilm;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getFilmNr() == filmnr) {
				filmer[i] = filmer[antall - 1];
				filmer[antall - 1] = null;
				antall--;
				return true;				
			}
		}
		
		return false;
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		if (delstreng == null) {
			return new Film[0];
		}
		
		int funnet = 0;
		Film[] filmerFunnet = new Film[filmer.length];
		
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getTittel().contains(delstreng)) {
				filmerFunnet[funnet++] = filmer[i];
			}
		}
		
		return trimTab(filmerFunnet, funnet);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		if (delstreng == null) {
			return new Film[0];
		}
		
		int funnet = 0;
		Film[] filmerFunnet = new Film[filmer.length];
		
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getProdusent().contains(delstreng)) {
				filmerFunnet[funnet++] = filmer[i];
			}
		}
		
		return trimTab(filmerFunnet, funnet);
	}

	@Override
	public int antall(Sjanger sjanger) {
		if (sjanger == null) {
			return 0;
		}
		
		int funnet = 0;
		
		for (int i = 0; i < antall; i++) {
			if (filmer[i].getSjanger().equals(sjanger)) {
				funnet++;
			}
		}
		
		return funnet;
	}

	@Override
	public int antall() {
		return antall;
	}
	
	private Film[] trimTab(Film[] tab, int n) {
		Film[] nytab = new Film[n];
		int i = 0;
		while (i < n) {
			nytab[i] = tab[i];
			i++;
		}
		return nytab;
	}
}
