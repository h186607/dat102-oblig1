package no.hvl.data102.filmarkiv.klient;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Meny {
	private Tekstgrensesnitt tekstgr;
	private FilmarkivADT filmarkiv;
	
	public Meny(FilmarkivADT filmarkiv) {
		tekstgr = new Tekstgrensesnitt();
		this.filmarkiv = filmarkiv;
	}
	
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
		
		while(true) {
			tekstgr.skrivUtMenyAlternativer();
			
			int menyValg = tekstgr.lesOensketOperasjon();
			
			switch (menyValg) {
				case 1: leggTilFilm();
					break;
				case 2: slettFilm();
					break;
				case 3: soekFilm();
					break;
				case 4: soekProdusent();
					break;
				case 5: antall();
					break;	
				case 6: System.exit(0);
					break;
			}
			
			System.out.println();
		}
	}
	
	public void leggTilFilm() {
		Film f = tekstgr.lesFilm();
		filmarkiv.leggTilFilm(f);
		tekstgr.menyValgUtfort();
	}
	
	public void slettFilm() {
		filmarkiv.slettFilm(tekstgr.lesFilmnr());
		tekstgr.menyValgUtfort();
	}
	
	public void soekFilm() {
		String tittel = tekstgr.lesFilmTittel();
		tekstgr.skrivUtFilmDelstrengITittel(filmarkiv, tittel);
	}
	
	public void soekProdusent() {
		String produsent = tekstgr.lesFilmProdusent();
		tekstgr.skrivUtFilmProdusent(filmarkiv, produsent);
	}
	
	public void antall() {
		tekstgr.skrivUtStatistikk(filmarkiv);
		
	}
	
	
}
