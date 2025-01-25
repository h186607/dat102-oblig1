package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
	
	/*
	 * Ting vi skal kunne velge i menyen:
	 * 
	 * - Legg til film
	 * - slett film
	 * - søk filmer etter tittel
	 * - søk filmer etter produsent
	 * - finn film
	 * - finn antall filmer etter sjanger
	 * - finn totalt antall filmer
	 */
	
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}
	
	// legg inn en del forhåndsdefinerte filmer for å teste metodene
	public void start() {
		filmarkiv.leggTilFilm(new Film(1, "Frank Darabont", "The Shawshank Redemption", 1994, "Castle Rock Entertainment", Sjanger.DRAMA));
		filmarkiv.leggTilFilm(new Film(2, "Francis Ford Coppola", "The Godfather", 1972, "Paramount Pictures", Sjanger.DRAMA));
		filmarkiv.leggTilFilm(new Film(3, "Christopher Nolan", "The Dark Knight", 2008, "Warner Bros.", Sjanger.ACTION));
		filmarkiv.leggTilFilm(new Film(4, "Quentin Tarantino", "Pulp Fiction", 1994, "Miramax", Sjanger.DRAMA));
		filmarkiv.leggTilFilm(new Film(5, "Ridley Scott", "Gladiator", 2000, "DreamWorks Pictures", Sjanger.HISTORY));
		filmarkiv.leggTilFilm(new Film(6, "Robert Zemeckis", "Forrest Gump", 1994, "Paramount Pictures", Sjanger.DRAMA));
		filmarkiv.leggTilFilm(new Film(7, "Christopher Nolan", "Inception", 2010, "Warner Bros.", Sjanger.SCIFI));
		filmarkiv.leggTilFilm(new Film(8, "George Lucas", "Star Wars: Episode IV - A New Hope", 1977, "Lucasfilm", Sjanger.SCIFI));
		filmarkiv.leggTilFilm(new Film(9, "Steven Spielberg", "Schindler's List", 1993, "Universal Pictures", Sjanger.HISTORY));
		filmarkiv.leggTilFilm(new Film(10, "James Cameron", "The Terminator", 1984, "Orion Pictures", Sjanger.ACTION));
		
		
		tekstgr.skrivUtMenyAlternativer();
		
		while(true) {
			tekstgr.lesOensketOperasjon();
			
			// finn ut kva input er, og kall på rett metode meny
		}
	}
	
	public void leggTilFilm() {
		Film f = tekstgr.lesFilm();
		filmarkiv.leggTilFilm(f);
	}
	
	public void slettFilm() {
		filmarkiv.slettFilm(tekstgr.lesFilmnr());
	}
	
	public void soekFilm() {
		String tittel = tekstgr.lesFilmTittel();
		tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, tittel);
	}
	
	public void soekProdusent() {
		filmarkiv.soekProdusent(tekstgr.skrivUtFilmProdusent(filmarkiv, null));
	}
	
	public void antall() {
		filmarkiv.antall(tekstgr.skrivUtStatistikk(filmarkiv));
		
	}
	
	
}
