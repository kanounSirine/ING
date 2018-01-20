package lifeCodingJava8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Transaction {
	private Long numCompte;
	private String nameClient;
	private int montant;
	private int year;
	private String motif;

	public Long getNumCompte() {
		return numCompte;
	}

	public void setNumCompte(Long numCompte) {
		this.numCompte = numCompte;
	}

	public String getNameClient() {
		return nameClient;
	}

	public void setNameClient(String nameClient) {
		this.nameClient = nameClient;
	}

	public int getMontant() {
		return montant;
	}

	public void setMontant(int montant) {
		this.montant = montant;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Transaction(Long numCompte, String nameClient, int montant, int year) {
		this.numCompte = numCompte;
		this.nameClient = nameClient;
		this.montant = montant;
		this.year = year;

	}
	// save transaction

	public static List<Transaction> remplirTr() {
		List<Transaction> tr = new ArrayList<Transaction>();
		tr.add(new Transaction(123L, "sirine", 120, 2016));
		tr.add(new Transaction(127L, "lecla", 752, 2014));
		tr.add(new Transaction(127L, "llkk", 120, 2018));
		tr.add(new Transaction(121L, "gggggg", 14, 2015));
		tr.add(new Transaction(127L, "lecla", 100, 2016));
		tr.add(new Transaction(120L, "uu", 89, 2014));
		tr.add(new Transaction(129L, "oo", 7, 2015));
		return tr;
	}

	/* extract all the transactions between the year 2013 and 2018 */

	public static List<Transaction> extractByYear() {
		// call all the transaction exist

		List<Transaction> tr = Transaction.remplirTr();

		/* filter all the transactions between the year 2013 and 2018 */
		List<Transaction> extractTr = tr.stream().filter((i) -> (i.getYear()) == 2016).collect(Collectors.toList());

		/* sorted all transaction by Montant */
		extractTr.sort(Transaction.montantComparator);
		return extractTr;

	}

	/* extract all the transactions between the year 2013 and 2018 */

	public static List<Transaction> extractBetweenYear() {
		// call all the transaction exist

		List<Transaction> tr = Transaction.remplirTr();

		/* filter all the transactions between the year 2013 and 2018 */
		List<Transaction> extractTr = tr.stream().filter((i) -> (i.getYear()) >= 2013 && (i.getYear() <= 2018))
				.collect(Collectors.toList());

		/* sorted all transaction by Montant */
		extractTr.sort(Transaction.montantComparator);
		return extractTr;

	}

	/* extract all the transactions that they have client name lecla */

	public static List<Transaction> extractByName() {
		List<Transaction> tr = Transaction.remplirTr();
		/* filter all the transactions By Name */
		List<Transaction> extractTrByName = tr.stream().filter((i) -> (i.getNameClient().equals("lecla")))
				.collect(Collectors.toList());

		/* sorted all transaction by Montant */

		extractTrByName.sort(Transaction.montantComparator);
		return extractTrByName;

	}

	/* extract the maximum transactions */

	public static Transaction maxTransaction() {
		List<Transaction> tr = Transaction.remplirTr();
		/* sorted all transaction by Montant */
		tr.sort(Transaction.montantComparator);
		return tr.get(tr.size() - 1);

	}

	/* extract the miminum transactions */

	public static Transaction minTransaction() {
		List<Transaction> tr = Transaction.remplirTr();
		/* sorted all transaction by Montant */
		tr.sort(Transaction.montantComparator);
		return tr.get(0);

	}

	/* extract the first transactions */

	public static Transaction firstTransaction() {
		List<Transaction> tr = Transaction.remplirTr();
		/* sorted all transaction by year */
		tr.sort(Transaction.comparatorByYear);
		return tr.get(0);

	}

	/* extract the last transactions */
	public static Transaction lastTransaction() {
		List<Transaction> tr = Transaction.remplirTr();
		/* sorted all transaction by year */
		tr.sort(Transaction.comparatorByYear);
		return tr.get(tr.size() - 1);

	}

	/* extract all the transactions in the file */

	@SuppressWarnings({ "finally", "unused" })
	public static boolean extractFile() {
		List<Transaction> tr = Transaction.remplirTr();
		FileWriter file = null;

		try {
			/* create file */
			file = new FileWriter(new File("Transaction.txt"));
			/* write all the transaction in the file */
			for (Transaction item : tr) {
				file.write(" Numero Compte : " + item.getNumCompte() + ", Name client :   " + item.getNameClient()
						+ ", Montant Tansaction :   " + item.getMontant() + ", Year Transaction :   " + item.getYear()
						+ "\n");
				/* forced write in this file */
				file.flush();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block

			e.printStackTrace();
			return false;
		} finally {
			try {
				/* forced close file */
				file.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			if (file != null)
				return true;
			else
				return false;

		}

	}

	/* create Interface Comparator in order to sort transaction by year */

	public static Comparator<Transaction> comparatorByYear = new Comparator<Transaction>() {
		/* overridding this methode in order to specify the sort By year */
		@Override

		public int compare(Transaction tr1, Transaction tr2) {
			if (tr1.getYear() < tr2.getYear())
				return -1;
			else if (tr1.getYear() == tr1.getYear())
				return 0;
			else
				return 1;

		}
	};
	/* create Interface Comparator in order to sort transaction by montant */

	public static Comparator<Transaction> montantComparator = new Comparator<Transaction>() {
		/* overridding this methode in order to specify the sort By montant */
		@Override

		public int compare(Transaction tr1, Transaction tr2) {
			if (tr1.getMontant() < tr2.getMontant())
				return -1;
			else if (tr1.getMontant() == tr2.getMontant())
				return 0;
			else
				return 1;

		}

	};

}
