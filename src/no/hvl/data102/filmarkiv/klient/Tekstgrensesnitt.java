package no.hvl.data102.filmarkiv.klient;

import java.util.Scanner;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Sjanger;

public class Tekstgrensesnitt {
	
	 Scanner inn = new Scanner(System.in);
	
	// Leser inn opplysninger om en film fra tastatur og returnere et Film-objekt
	public Film lesFilm() {
		System.out.println("Oppgi filmnr: ");	
		int filmnr = inn.nextInt(); 
		inn.nextLine();
		
		System.out.println("Oppgi produsent: ");
		String produsent = inn.nextLine();
		inn.nextLine();
		
		System.out.println("Oppgi filmtittel: ");
		String tittel = inn.nextLine();
		inn.nextLine();
		
		System.out.println("Hva er lanseringsår: ");
		int lanseringsår = inn.nextInt();
		inn.nextLine();
		
		System.out.println("Oppgi filmstudio: ");
		String filmstudio = inn.nextLine();
		inn.nextLine();
		
		System.out.println("Oppgi hvilken sjanger filmen er (action, drama, historie, sci-fi: ");
		String s = inn.nextLine();
		inn.nextLine();
		
		Sjanger sjanger = Sjanger.valueOf(s);
		
		Film film = new Film(filmnr, produsent, tittel, lanseringsår, filmstudio, sjanger);
		return film;
	}
	
	// Skriver ut en film med alle opplysninger på skjerm (husk tekst for sjanger)
	public void skrivUtFilm(Film film) {
		System.out.println(film.toString());
	}
	
	// Skriver ut alle filmer med en spesiell delstreng i tittelen
	public void skrivUtFilmDelstrengITittel(FilmarkivADT arkiv, String delstreng) {
		Film[] filmer = arkiv.soekTittel(delstreng);
		 
		for (int i = 0; i < filmer.length; i++) {
			skrivUtFilm(filmer[i]);
		}
	}
	
	public void skrivUtFilmProdusent(FilmarkivADT arkiv, String delstreng) {
		Film[] produsenter = arkiv.soekProdusent(delstreng);
		 
		for (int i = 0; i < produsenter.length; i++) {
			skrivUtFilm(produsenter[i]);
		}
	}
	
	// Skriver ut en enkel statistikk som inneholder antall filmer totalt
	// og hvor mange det er i hver sjanger.
	public void skrivUtStatistikk(FilmarkivADT arkiv) {
		System.out.println("Antall filmer: " + arkiv.antall());
		System.out.println("Antall filmer i drama: " + arkiv.antall(Sjanger.DRAMA));
		System.out.println("Antall filmer i action: " + arkiv.antall(Sjanger.ACTION));
		System.out.println("Antall filmer i historie: " + arkiv.antall(Sjanger.HISTORY));
		System.out.println("Antall filmer i sci-fi: " + arkiv.antall(Sjanger.SCIFI));
	}
	
	public void skrivUtMenyAlternativer() {
		System.out.println("Hva ønsker du å gjøre? ");
		System.out.println("Trykk 1 for å legge til film");
		System.out.println("Trykk 2 for å slette film");
		System.out.println("Trykk 3 for å søke etter film med tittel");
		System.out.println("Trykk 4 for å søke etter film med produsent");
		System.out.println("Trykk 5 for å se antall filmer i arkivet");
	}
	
	public int lesOensketOperasjon() {
		int operasjon = inn.nextInt(); 
		inn.nextLine();
		return operasjon;
	}
	
	public int lesFilmnr() {
		System.out.println("Skriv ønsker filmnr: ");
		int nr = inn.nextInt();
		inn.nextLine();
		return nr;
		// Skriv ut "Skriv ønsket filmnr: "
		// Les inn og returner
	}
	
	public String lesFilmTittel() {
		System.out.println("Skriv ønsket filmtittel: ");
		String tittel = inn.nextLine();
		return tittel;
	}
	
	public String lesFilmProdusent() {
		System.out.println("Skriv ønsket film produsent: ");
		String produsent = inn.nextLine();
		return produsent;
	}
	
	public void menyValgUtfort() {
		 System.out.println("Menyvalg utført.");
	}

	//public String lesStringFraBruker(String beskjedTilBruker) {
		
			
	
	// osv ... andre metoder
}
