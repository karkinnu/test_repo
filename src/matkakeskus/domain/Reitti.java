package matkakeskus.domain;

public class Reitti {
	private String mista;
	private String mihin;
	private String lahtoAika;
	private String perillaAika;

	public Reitti(String mista, String mihin, String lahtoAika, String perillaAika) {
		this.mista = mista;
		this.mihin = mihin;
		this.lahtoAika = lahtoAika;
		this.perillaAika = perillaAika;
	}

}
