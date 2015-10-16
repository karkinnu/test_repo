package matkakeskus.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import matkakeskus.domain.Kulkuvaline;
import matkakeskus.domain.Matkustaja;

public class KulkuvalineTest {

	@Test
	public void getId() {
		Kulkuvaline kulkuvaline = new Kulkuvaline(10, "1");
		assertEquals("1", kulkuvaline.getId());
	}

	@Test
	public void getIstuinpaikat() {
		Kulkuvaline kulkuvaline = new Kulkuvaline(10, "1");
		assertEquals(10, kulkuvaline.getIstuinpaikat());
	}

	@Test
	public void getMatkustajaMaara() {
		Kulkuvaline kulkuvaline = new Kulkuvaline(10, "1");
		assertEquals(0, kulkuvaline.getMatkustajaMaara());
	}

	@Test
	public void getVapaatPaikat() {
		Kulkuvaline kulkuvaline = new Kulkuvaline(10, "1");
		assertEquals(10, kulkuvaline.getVapaatPaikat());
		kulkuvaline.lisaaMatkustaja(new Matkustaja("Aku Ankka"));
		assertEquals(9, kulkuvaline.getVapaatPaikat());
	}

	@Test
	public void lisaaMatkustaja() {
		Kulkuvaline kulkuvaline = new Kulkuvaline(2, "1");
		assertEquals(0, kulkuvaline.getMatkustajaMaara());

		boolean result = kulkuvaline.lisaaMatkustaja(new Matkustaja("Mikki Hiiri"));
		assertEquals(true, result);
		assertEquals(1, kulkuvaline.getMatkustajaMaara());
		assertEquals(1, kulkuvaline.getVapaatPaikat());

		result = kulkuvaline.lisaaMatkustaja(new Matkustaja("Roope Ankka"));
		assertEquals(true, result);
		assertEquals(2, kulkuvaline.getMatkustajaMaara());
		assertEquals(0, kulkuvaline.getVapaatPaikat());

		result = kulkuvaline.lisaaMatkustaja(new Matkustaja("Iines Ankka"));
		assertEquals(false, result);
		assertEquals(2, kulkuvaline.getMatkustajaMaara());
		assertEquals(0, kulkuvaline.getVapaatPaikat());
	}

	@Test
	public void poistaMatkustaja() {
		Kulkuvaline kulkuvaline = new Kulkuvaline(10, "1");
		assertEquals(0, kulkuvaline.getMatkustajaMaara());
		assertEquals(10, kulkuvaline.getVapaatPaikat());
		Matkustaja matkustaja = new Matkustaja("Pelle Peloton");

		assertEquals(false, kulkuvaline.poistaMatkustaja(matkustaja));
		assertEquals(0, kulkuvaline.getMatkustajaMaara());
		assertEquals(10, kulkuvaline.getVapaatPaikat());

		kulkuvaline.lisaaMatkustaja(matkustaja);
		assertEquals(1, kulkuvaline.getMatkustajaMaara());
		assertEquals(9, kulkuvaline.getVapaatPaikat());

		assertEquals(true, kulkuvaline.poistaMatkustaja(matkustaja));
		assertEquals(0, kulkuvaline.getMatkustajaMaara());
		assertEquals(10, kulkuvaline.getVapaatPaikat());
	}

	@Test
	public void etsiMatkustaja() {
		Kulkuvaline kulkuvaline = new Kulkuvaline(10, "1");
		boolean result = kulkuvaline.lisaaMatkustaja(new Matkustaja("Pelle Peloton"));
		result = kulkuvaline.lisaaMatkustaja(new Matkustaja("Roope Ankka"));
		result = kulkuvaline.lisaaMatkustaja(new Matkustaja("Iines Ankka"));
		
		assertNotNull(kulkuvaline.etsiMatkustaja("Pelle Peloton"));
		assertEquals("Pelle Peloton", kulkuvaline.etsiMatkustaja("Pelle Peloton").getNimi());

		assertNotNull(kulkuvaline.etsiMatkustaja("Roope Ankka"));
		assertEquals("Roope Ankka", kulkuvaline.etsiMatkustaja("Roope Ankka").getNimi());

		assertNotNull(kulkuvaline.etsiMatkustaja("Iines Ankka"));
		assertEquals("Iines Ankka", kulkuvaline.etsiMatkustaja("Iines Ankka").getNimi());
		
		assertNull(kulkuvaline.etsiMatkustaja("Mikki Hiiri"));
	}

}
