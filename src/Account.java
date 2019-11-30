
public class Account {
	private int brojRacuna;
	private String imeVlasnikaRacuna;
	private double iznosNaRacunu;

	public Account() {

	}

	public Account(int brojRacuna, String imeVlasnikaRacuna, double iznosNaRacunu) {
		this.brojRacuna = brojRacuna;
		this.imeVlasnikaRacuna = imeVlasnikaRacuna;
		this.iznosNaRacunu = iznosNaRacunu;
	}

	// geteri
	public int getBrojRacuna() {
		return brojRacuna;
	}

	public String getImeVlasnikaRacuna() {
		return imeVlasnikaRacuna;
	}

	public double getIznosNaRacunu() {
		return iznosNaRacunu;
	}

	// seteri
	public void setBrojRacuna(int brojRacuna) {
		this.brojRacuna = brojRacuna;
	}

	public void setImeVlasnikaRacuna(String imeVlasnikaRacuna) {
		this.imeVlasnikaRacuna = imeVlasnikaRacuna;
	}

	public void setIznosNaRacunu(double iznosNaRacunu) {
		this.iznosNaRacunu = iznosNaRacunu;
	}

}
