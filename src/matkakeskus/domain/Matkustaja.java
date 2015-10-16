package matkakeskus.domain;

public class Matkustaja {
	private Lippu lippu;
	private String nimi;

	public Matkustaja(String nimi) {
		this.nimi = nimi;
	}

	public String getNimi() {
		return nimi;
	}

	public void setNimi(String nimi) {
		this.nimi = nimi;
	}

	@Override
	public String toString() {
		return "Matkustaja [nimi=" + nimi + "]";
	}

}
