package matkakeskus.domain;

import java.util.ArrayList;
import java.util.Collection;

public class Kulkuvaline {
	private Collection<Matkustaja> matkustajaLista = new ArrayList<Matkustaja>();
	private int istuinpaikat = 0;
	private String id = "";

	public Kulkuvaline(int istuinpaikat, String id) {
		this.istuinpaikat = istuinpaikat;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public int getIstuinpaikat() {
		return istuinpaikat;
	}

	public int getMatkustajaMaara() {
		return matkustajaLista.size();
	}

	public int getVapaatPaikat() {
		return istuinpaikat - matkustajaLista.size();
	}

	public boolean lisaaMatkustaja(Matkustaja matkustaja) {
		boolean result = false;
		if (matkustajaLista.size() < istuinpaikat) {
			matkustajaLista.add(matkustaja);
			result = true;
		}
		
		return result;
	}

	public boolean poistaMatkustaja(Matkustaja matkustaja) {
		return matkustajaLista.remove(matkustaja);
	}

	public Matkustaja etsiMatkustaja(String nimi) {
		Matkustaja etsittava = null;
		
		for (Matkustaja matkustaja : matkustajaLista) {
			if (matkustaja.getNimi().equals(nimi)) {
				etsittava = matkustaja;
				break;
			}
		}

		return etsittava;
	}

	@Override
	public String toString() {
		return "Kulkuvaline [matkustajaLista=" + matkustajaLista + "]";
	}


}
