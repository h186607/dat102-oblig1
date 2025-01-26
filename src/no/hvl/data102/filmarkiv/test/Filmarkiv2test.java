package no.hvl.data102.filmarkiv.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import no.hvl.data102.filmarkiv.adt.FilmarkivADT;
import no.hvl.data102.filmarkiv.impl.Film;
import no.hvl.data102.filmarkiv.impl.Filmarkiv;
import no.hvl.data102.filmarkiv.impl.Filmarkiv2;
import no.hvl.data102.filmarkiv.impl.Sjanger;

@DisplayName("Filmarkiv2")
class Filmarkiv2test {
	FilmarkivADT arkiv;
	
	@BeforeEach
	void setupAll() {
		arkiv = new Filmarkiv2();
	}
	
	@Test
	@DisplayName("Når vi legger til film, øker antallet")
	void testLeggTilFilm() {
		assertEquals(0, arkiv.antall());
		arkiv.leggTilFilm(new Film(1, "George Lucas", "A new hope", 1977, "Fox studio", Sjanger.SCIFI));
		assertEquals(1, arkiv.antall());
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
	
	@Test
	@DisplayName("Når vi søker etter film med delstreng i tittel det bare finnes en av, finner vi den og returnerer den i et array")
	void testSoekTittel() {
		arkiv.leggTilFilm(new Film(2, "George Lucas", "The Empire Strikes Back", 1980, "Fox studio", Sjanger.SCIFI));
		arkiv.leggTilFilm(new Film(4, "Nick Cassavetes", "The Notebook", 2004, "Unicorn studios", Sjanger.DRAMA));
		Film[] delstrengITittel = arkiv.soekTittel("book");
		assertEquals(1, delstrengITittel.length);
		assertEquals("The Notebook", delstrengITittel[0].getTittel());
	}
	
	@Test
	@DisplayName("Når vi søker etter en film etter tittel med delstreng, som det finnes flere av, returneres de i et array")
	void testSoekTittelFlere() {
		arkiv.leggTilFilm(new Film(2, "George Lucas", "The Empire Strikes Back", 1980, "Fox studio", Sjanger.SCIFI));
		arkiv.leggTilFilm(new Film(4, "Nick Cassavetes", "The Notebook", 2004, "Unicorn studios", Sjanger.DRAMA));
		Film[] delstrengITittel = arkiv.soekTittel("The");
		assertEquals(2, delstrengITittel.length);
	}
	
	@Test
	@DisplayName("Når vi søker etter en film etter tittel med delstreng null, får vi tomt array tilbake")
	void testSoekTittelNull() {
		arkiv.leggTilFilm(new Film(2, "George Lucas", "The Empire Strikes Back", 1980, "Fox studio", Sjanger.SCIFI));
		arkiv.leggTilFilm(new Film(4, "Nick Cassavetes", "The Notebook", 2004, "Unicorn studios", Sjanger.DRAMA));
		Film[] delstrengITittel = arkiv.soekTittel(null);
		assertEquals(0, delstrengITittel.length);
	}
	
	@Test
	@DisplayName("Når vi søker etter en film etter tittel med delstreng, som ikke blir funnet, får vi tilbake tomt array")
	void testSoekTittelIkkeFunnet() {
		arkiv.leggTilFilm(new Film(2, "George Lucas", "The Empire Strikes Back", 1980, "Fox studio", Sjanger.SCIFI));
		arkiv.leggTilFilm(new Film(4, "Nick Cassavetes", "The Notebook", 2004, "Unicorn studios", Sjanger.DRAMA));
		Film[] delstrengITittel = arkiv.soekTittel("hope");
		assertEquals(0, delstrengITittel.length);
	}
	
	@Test
	@DisplayName("Når vi søker etter film med delstreng i navn på produsent det bare finnes en av, finner vi den og returnerer den i et array")
	void testSoekProdusent() {
		arkiv.leggTilFilm(new Film(2, "George Lucas", "The Empire Strikes Back", 1980, "Fox studio", Sjanger.SCIFI));
		arkiv.leggTilFilm(new Film(4, "Nick Cassavetes", "The Notebook", 2004, "Unicorn studios", Sjanger.DRAMA));
		Film[] delstrengIProdusent = arkiv.soekProdusent("Nick");
		assertEquals(1, delstrengIProdusent.length);
		assertEquals("Nick Cassavetes", delstrengIProdusent[0].getProdusent());
	}
	
	@Test
	@DisplayName("Når vi søker etter en film etter produsent med delstreng, som det finnes flere av, returneres de i et array")
	void testSoekProdusentFlere() {
		arkiv.leggTilFilm(new Film(2, "George Lucas", "The Empire Strikes Back", 1980, "Fox studio", Sjanger.SCIFI));
		arkiv.leggTilFilm(new Film(4, "Nick Cassavetes", "The Notebook", 2004, "Unicorn studios", Sjanger.DRAMA));
		arkiv.leggTilFilm(new Film(1, "George Lucas", "A New hope", 1977, "Fox studio", Sjanger.SCIFI));
		Film[] delstrengIProdusent = arkiv.soekProdusent("George Lucas");
		assertEquals(2, delstrengIProdusent.length);
		assertEquals("George Lucas", delstrengIProdusent[0].getProdusent());
		assertEquals("George Lucas", delstrengIProdusent[1].getProdusent());
	}
	
	@Test
	@DisplayName("Når vi søker etter en film etter produsent med delstreng null, får vi tomt array tilbake")
	void testSoekProdusentNull() {
		arkiv.leggTilFilm(new Film(2, "George Lucas", "The Empire Strikes Back", 1980, "Fox studio", Sjanger.SCIFI));
		arkiv.leggTilFilm(new Film(4, "Nick Cassavetes", "The Notebook", 2004, "Unicorn studios", Sjanger.DRAMA));
		Film[] delstrengIProdusent = arkiv.soekProdusent(null);
		assertEquals(0, delstrengIProdusent.length);
	}
	
	@Test
	@DisplayName("Når vi søker etter en film etter produsent med delstreng, som ikke blir funnet, får vi tilbake tomt array")
	void testSoekProdusentIkkeFunnet() {
		arkiv.leggTilFilm(new Film(2, "George Lucas", "The Empire Strikes Back", 1980, "Fox studio", Sjanger.SCIFI));
		arkiv.leggTilFilm(new Film(4, "Nick Cassavetes", "The Notebook", 2004, "Unicorn studios", Sjanger.DRAMA));
		Film[] delstrengIProdusent = arkiv.soekProdusent("hope");
		assertEquals(0, delstrengIProdusent.length);
	}
	
	@Test
	@DisplayName("Når vi søker etter antall filmer med en gitt sjanger, får vi tilbake antallet")
	void testAntallSjanger() {
		arkiv.leggTilFilm(new Film(2, "George Lucas", "The Empire Strikes Back", 1980, "Fox studio", Sjanger.SCIFI));
		arkiv.leggTilFilm(new Film(4, "Nick Cassavetes", "The Notebook", 2004, "Unicorn studios", Sjanger.DRAMA));
		arkiv.leggTilFilm(new Film(1, "George Lucas", "A New hope", 1977, "Fox studio", Sjanger.SCIFI));
		assertEquals(1, arkiv.antall(Sjanger.DRAMA));
		assertEquals(2, arkiv.antall(Sjanger.SCIFI));
		assertEquals(0, arkiv.antall(Sjanger.HISTORY));
	}
	
	@Test
	@DisplayName("Når vi søker etter antall filmer med en gitt sjanger, men gitt null, får vi tilbake 0")
	void testAntallSjangerNull() {
		assertEquals(0, arkiv.antall(null));
	
	}
}
	
	

