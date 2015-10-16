package matkakeskus.domain;

public class Lippu {
	private String nimi;
	//private Kulkuvaline kulkuvaline;
	//private String paikka;
	private double hinta;
	//private Reitti reitti;

	public Lippu(String nimi, double hinta) {
		this.nimi = nimi;
		this.hinta = hinta;
	}
	public String getNimi() {
		return nimi;
	}

	public double getHinta() {
		return hinta;
	}

	public void setHinta(double hinta) {
		this.hinta = hinta;
	}

}
