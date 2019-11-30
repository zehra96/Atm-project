import java.util.ArrayList;

public class Manager {
	ArrayList<Account> list = new ArrayList<>();

	public Manager() {

	}

	public void napraviRacun(int brojRacuna, String imeVlasnikaRacuna, double iznosNaRacunu) {
		Account acount = new Account(brojRacuna, imeVlasnikaRacuna, iznosNaRacunu);
		list.add(acount);
	}

	public boolean daLiRacunPostoji(int brojRacuna) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getBrojRacuna() == brojRacuna)
				return false;
		}
		return true;
	}

	public void transferNovca(int sourceAccount, int targetAccount, double iznosNovca) {
		int sourceIndex = 0;
		int targetIndex = 0;
		for (int i = 0, j = 0; i < list.size(); i++, j++) {
			if (list.get(i).getBrojRacuna() == sourceAccount)
				sourceIndex = i;
			if (list.get(j).getBrojRacuna() == targetAccount)
				targetIndex = j;
		}
		double source = list.get(sourceIndex).getIznosNaRacunu();
		double target = list.get(targetIndex).getIznosNaRacunu();

		double transferSource = source - iznosNovca;
		double transferTarget = target + iznosNovca;

		list.get(sourceIndex).setIznosNaRacunu(transferSource);
		list.get(targetIndex).setIznosNaRacunu(transferTarget);
		System.out.println("\n Transfer novca uspijesno izvrsen!");
	}

	public void info() {
		if (list.size() < 1) {
			System.out.println("Nema kreiranih racuna!");

		}
		Account acc = new Account();
		for (int i = 0; i < list.size(); i++) {
			acc = list.get(i);
			System.out.println("\nIme vlasnika racuna: " + acc.getImeVlasnikaRacuna() + "\nBroj racun: "
					+ acc.getBrojRacuna() + "\nIznos na racunu: " + acc.getIznosNaRacunu());

		}
	}

	// Pokusaj da iskoristim scanner u drugoj klasi
//	public void validacijaRacuna(int brojRacuna) {
//		while (brojRacuna < 1 || daLiRacunPostoji(brojRacuna)) {
//			Atm atm = new Atm();
//			if (brojRacuna < 1) {
//				System.out.println("Broj racuna ne moze biti negativan broj ili nula! Pokusajte ponovo: ");
//				brojRacuna = atm.input.nextInt();
//			} else {
//				System.out.println("Broj racuna vec postoji! Pokusajte ponovo: ");
//				brojRacuna = input.nextInt();
//			}
//		}
//	}

}
