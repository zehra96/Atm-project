import java.util.Scanner;

public class Atm {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Manager manager = new Manager();
		boolean running = true;
		int unos = 0;

		while (running) {
			System.out.println("______________________________________________________"
					+ "\n______________________________________________________" + "\nUnesite: \n1 za kreiranje racuna,"
					+ "\n2 za prebacivanje novca sa jednog racuna na drugi,"
					+ "\n3 za ispisivanje detalja postojecih racuna." + "\n4 za izlaz.\n"
					+ "______________________________________________________"
					+ "\n______________________________________________________\n");
			int izbor = input.nextInt();
			switch (izbor) {
			// Kreiranje racuna (izbor 1)
			case 1:
				System.out.println("Kreiranje racuna potvrdite unosom broja 1, za izlaz unesite broj 2: ");
				unos = input.nextInt();
				if (unos == 1) {
					System.out.println("Unesite broj racuna: ");
					int brojRacuna = input.nextInt();
					while (brojRacuna < 1 || !manager.daLiRacunPostoji(brojRacuna)) {
						if (brojRacuna < 1) {
							System.out.println("Broj racuna ne moze biti negativan broj ili nula! Pokusajte ponovo: ");
							brojRacuna = input.nextInt();
						} else {
							System.out.println("Broj racuna vec postoji! Pokusajte ponovo: ");
							brojRacuna = input.nextInt();
						}
					}
					input.nextLine();
					System.out.println("Unesite ime vlasnika racuna: ");
					String imeVlasnikaRacuna = input.nextLine();
					System.out.println("Unesite iznos na racunu: ");
					double iznosNaRacunu = input.nextDouble();
					while (iznosNaRacunu < 0) {
						System.out.println("Stanje na racunu ne moze biti negativno! Pokusajte ponovo: ");
						iznosNaRacunu = input.nextDouble();
					}
					manager.napraviRacun(brojRacuna, imeVlasnikaRacuna, iznosNaRacunu);
					break;
				} else
					break;
				// transfer novca
			case 2:
				int sourceIndex = 0;
				System.out.println("Transfer novca potvrdite unosom broja 1, za izlaz unesite broj 2: ");
				unos = input.nextInt();
				if (unos == 1) {
					System.out.println("Unesite racun sa kojeg zelite da prebacite racun: ");
					int sourceAccount = input.nextInt();
					while (manager.daLiRacunPostoji(sourceAccount)) {
						System.out.println("Source account ne postoji! Pokusajte ponovo: ");
						sourceAccount = input.nextInt();
					}
					System.out.println("Unesite racun na koji zelite da prebacite racun: ");
					int targetAccount = input.nextInt();
					while (manager.daLiRacunPostoji(targetAccount)) {
						System.out.println("Target account ne postoji! Pokusajte ponovo: ");
						targetAccount = input.nextInt();
					}

					System.out.println("Unesite koliko novca zelite da prebacite: ");
					double iznosNovca = input.nextDouble();
					for (int i = 0; i < manager.list.size(); i++) {
						if (manager.list.get(i).getBrojRacuna() == sourceAccount)
							sourceIndex = i;
					}
					while (manager.list.get(sourceIndex).getIznosNaRacunu() < iznosNovca) {
						System.out
								.println("Nemate dovoljno sredstava da izvrsite transfer novca. Unesite novi iznos: ");
						iznosNovca = input.nextDouble();
					}
					manager.transferNovca(sourceAccount, targetAccount, iznosNovca);
					break;
				} else
					break;

				// Detalji postojecih racuna
			case 3:
				System.out.println("\nDetalji postojecih racuna: \n");
				manager.info();

				// Izlaz
				break;
			case 4:
				running = false;
				break;
			}

		}
		input.close();
	}
}
