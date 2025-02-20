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
	
	public Film(int filmNr, String produsent, String tittel, int lanseringsÅr, String filmSelskap, Sjanger sjanger) {
		this.filmNr = filmNr;
		this.produsent = produsent;
		this.tittel = tittel;
		this.lanseringsÅr = lanseringsÅr;
		this.filmSelskap = filmSelskap;
		this.sjanger = sjanger;
		
	}

	@Override
	public String toString() {
		return "Film [filmNr = " + filmNr + ", produsent = " + produsent + ", tittel = " + tittel + ", lanseringsÅr = "
				+ lanseringsÅr + ", filmSelskap = " + filmSelskap + ", sjanger = " + sjanger + "]";
	}

	public int getFilmNr() {
		return filmNr;
	}

	public void setFilmNr(int filmNr) {
		this.filmNr = filmNr; 
	}

	public String getProdusent() {
		return produsent;
	}

	public void setProdusent(String produsent) {
		this.produsent = produsent;
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

	public Sjanger getSjanger() {
		return sjanger;
	}

	public void setSjanger(Sjanger sjanger) {
		this.sjanger = sjanger;
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
