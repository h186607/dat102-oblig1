package no.hvl.data102.filmarkiv.impl;


import no.hvl.data102.filmarkiv.adt.FilmarkivADT;

public class Filmarkiv2 implements FilmarkivADT {
	
	private LinearNode<Film> start;
	private int antall;
	
	public Filmarkiv2() {
		this.start = null;
		this.antall = 0;
	}
	
	private LinearNode<Film> finnFilmNode(int nr) {
		LinearNode<Film> p = start;
		
		while (p != null) {
			if (p.data.getFilmNr() == nr) {
				return p;
			}
			
			p = p.neste;
		}
		
		return null;
	}

	@Override
	public Film finnFilm(int nr) {
		LinearNode<Film> film = finnFilmNode(nr);
		
		if (film == null) return null;
		return film.data;
	}

	@Override
	public void leggTilFilm(Film nyFilm) {
		LinearNode<Film> ny = new LinearNode<>(nyFilm);
		ny.neste = start;
		start = ny;
		antall++;
	}

	@Override
	public boolean slettFilm(int filmnr) {
		boolean slettet = false;
		LinearNode<Film> film = finnFilmNode(filmnr);
		
		if (film != null) {
			film.data = start.data;
			start = start.neste;
			antall--;
			slettet = true;	
		}
		
		return slettet;
			
	}

	@Override
	public Film[] soekTittel(String delstreng) {
		LinearNode<Film> node = start;
		Film[] filmer = new Film[antall];
		int index = 0;
		
		if (delstreng == null) {
			return new Film[0];
		}
		
		while (node != null) {
			if (node.data.getTittel().contains(delstreng)) {
				filmer[index] = node.data;
				index++;
			}
			
			node = node.neste;
		}
		
		return trimTab(filmer, index);
	}

	@Override
	public Film[] soekProdusent(String delstreng) {
		LinearNode<Film> node = start;
		Film[] filmer = new Film[antall];
		int index = 0;
		
		if (delstreng == null) {
			return new Film[0];
		}
		
		while (node != null) {
			if (node.data.getProdusent().contains(delstreng)) {
				filmer[index] = node.data;
				index++;
			}
			
			node = node.neste;
		}
		
		return trimTab(filmer, index);
	}

	@Override
	public int antall(Sjanger sjanger) {
		LinearNode<Film> node = start;
		
		if (sjanger == null) {
			return 0;
		}
		
		int funnet = 0;
		
		while (node != null) {
			if (node.data.getSjanger().equals(sjanger)) {
				funnet++;
			}
			
			node = node.neste;
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
