package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Sjanger;

@DisplayName("Filmarkiv")
class Filmarkivtest {
	FilmarkivADT arkiv;
	
	@BeforeEach
	void setupAll() {
		arkiv = new Filmarkiv();
	}
	
	@Test
	@DisplayName("Når vi legger til film, øker antallet")
	void testLeggTilFilm() {
		assertEquals(0, arkiv.antall());
		arkiv.leggTilFilm(new Film(1, "George Lucas", "A new hope", 1977, "Fox studio", Sjanger.SCIFI));
		assertEquals(1, arkiv.antall());
	}
	
	@Test
	@DisplayName("Når vi legger til film utover kapasitet, økes kapasiteten")
	void testLeggTilFilmKapasitet() {
		arkiv = new Filmarkiv(2);
		assertEquals(0, arkiv.antall());
		arkiv.leggTilFilm(new Film(1, "George Lucas", "A New hope", 1977, "Fox studio", Sjanger.SCIFI));
		arkiv.leggTilFilm(new Film(2, "George Lucas", "The Empire Strikes Back", 1980, "Fox Studio", Sjanger.SCIFI));
		arkiv.leggTilFilm(new Film(3, "Quentin Tarantino", "Pulp Fiction", 1994, "Miramax Films", Sjanger.DRAMA));
		assertEquals(3, arkiv.antall());
	}	
	
	@Test
	@DisplayName("Når vi finner en film etter nummer, skal den returnere filmen hvis filmen eksisterer")
	void testFinnFilm() {
		arkiv.leggTilFilm(new Film(1, "George Lucas", "A new hope", 1977, "Fox studio", Sjanger.SCIFI));
		Film filmenmin = arkiv.finnFilm(1);
		assertEquals(1, filmenmin.getFilmNr());
	}
	
	@Test
	@DisplayName("Når vi skal finne en film etter nummer, og den ikke eksisterer")
	void testFinnFilm2() {
		arkiv.leggTilFilm(new Film(1, "George Lucas", "A new hope", 1977, "Fox studio", Sjanger.SCIFI));
		Film filmenmin = arkiv.finnFilm(0);
		assertNull(filmenmin, "Denne filmen eksisterer ikke");
	}
	
	@Test
	@DisplayName("Når vi sletter en film etter nummer, så blir den slettet")
	void testSlett() {
		arkiv.leggTilFilm(new Film(1, "George Lucas", "A new hope", 1977, "Fox studio", Sjanger.SCIFI));
		boolean filmen = arkiv.slettFilm(1);
		assertTrue(filmen, "Filmen er slettet");
	}
	@Test
	@DisplayName("Når vi sletter en film etter nummer, og filmen ikke finnes")
	void testSlett2() {
		boolean filmen = arkiv.slettFilm(1);
		assertFalse(filmen, "Filmen finnes ikke");
	}
	
	
}

