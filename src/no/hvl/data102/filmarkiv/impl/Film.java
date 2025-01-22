package no.hvl.data102.filmarkiv.impl;

import java.util.Objects;

public class Film {
	private int filmNr;
	private String produsent;
	private String tittel;
	private int lanseringsÅr;
	private String filmSelskap;
	private Sjanger sjanger;
	
	public Film() {	
		
	}
	
	public Film(int filmNr, String filmSkaper, String tittel, int lanseringsÅr, String filmSelskap, Sjanger sjanger) {
		this.filmNr = filmNr;
		this.produsent = filmSkaper;
		this.tittel = tittel;
		this.lanseringsÅr = lanseringsÅr;
		this.filmSelskap = filmSelskap;
		this.sjanger = sjanger;
		
	}

	public int getFilmNr() {
		return filmNr;
	}

	public void setFilmNr(int filmNr) {
		this.filmNr = filmNr;
	}

	public String getFilmSkaper() {
		return produsent;
	}

	public void setFilmSkaper(String filmSkaper) {
		this.produsent = filmSkaper;
	}

	public String getTittel() {
		return tittel;
	}

	public void setTittel(String tittel) {
		this.tittel = tittel;
	}

	public int getLanseringsÅr() {
		return lanseringsÅr;
	}

	public void setLanseringsÅr(int lanseringsÅr) {
		this.lanseringsÅr = lanseringsÅr;
	}

	public String getFilmSelskap() {
		return filmSelskap;
	}

	public void setFilmSelskap(String filmSelskap) {
		this.filmSelskap = filmSelskap;
	}

	@Override
	public int hashCode() {
		return Objects.hash(filmNr, filmSelskap, produsent, lanseringsÅr, tittel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Film other = (Film) obj;
		return filmNr == other.filmNr && Objects.equals(filmSelskap, other.filmSelskap)
				&& Objects.equals(produsent, other.produsent) && lanseringsÅr == other.lanseringsÅr
				&& Objects.equals(tittel, other.tittel);
	}
	
	
	
	
}
