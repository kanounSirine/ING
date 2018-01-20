package lifeCoding;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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
		tr.add(new Transaction(127L, "lecla", 152, 2014));
		tr.add(new Transaction(127L, "lecla", 120, 2014));
		tr.add(new Transaction(121L, "bb", 14, 2016));
		tr.add(new Transaction(127L, "lecla", 78, 2013));
		tr.add(new Transaction(120L, "uu", 89, 2014));
		tr.add(new Transaction(129L, "oo", 7, 2015));
		return tr;
	}
	/* extract all the transactions By the year 2016 */

	@SuppressWarnings("unused")
	public static List<Transaction> extractByYear() {
		// call all the transaction exist
		List<Transaction> tr = Transaction.remplirTr();
		List<Transaction> extractTr = new ArrayList<Transaction>();
		/* filter all the transactions by the year 2016 */
		for (Transaction i : tr) {
			if ((i.getYear()) == 2016) {
				extractTr.add(i);
			}
		}
		/* sorted all transaction by Montant */
		if (extractTr == null)
			return null;
		else {

			Collections.sort(extractTr, Transaction.montantComparator);
			return extractTr;
		}

	}

	/* extract all the transactions between the year 2013 and 2018 */

	@SuppressWarnings("unused")
	public static List<Transaction> extractBetweenTwoYear() {
		// call all the transaction exist
		List<Transaction> tr = Transaction.remplirTr();
		List<Transaction> extractTr = new ArrayList<Transaction>();
		/* filter all the transactions between the year 2013 and 2018 */
		for (Transaction i : tr) {
			if ((i.getYear()) >= 2013 && (i.getYear() <= 2018)) {
				extractTr.add(i);
			}
		}
		/* sorted all transaction by Montant */
		if (extractTr == null)
			return null;
		else {

			Collections.sort(extractTr, Transaction.montantComparator);
			return extractTr;
		}

	}

	/* extract all the transactions that they have client name lecla */
	
	@SuppressWarnings("unused")
	public static List<Transaction> extractByName() {
		List<Transaction> tr = Transaction.remplirTr();
		List<Transaction> extractTrByName = new ArrayList<Transaction>();
		/* filter all the transactions By */
		for (Transaction i : tr) {
			if ((i.getNameClient().equals("lecla"))) {
				extractTrByName.add(i);
			}
		}
		/* sorted all transaction by Montant */
		if (extractTrByName == null)
			return null;
		else {
			Collections.sort(extractTrByName, Transaction.montantComparator);
			return extractTrByName;
		}

	}

	/* extract the maximum transactions */
	
	public static Transaction maxTransaction() {
		List<Transaction> tr = Transaction.remplirTr();
		/* sorted all transaction by Montant */
		Collections.sort(tr, Transaction.montantComparator);
		return tr.get(tr.size() - 1);

	}

	/* extract the miminum transactions */
	
	public static Transaction minTransaction() {
		List<Transaction> tr = Transaction.remplirTr();
		/* sorted all transaction by Montant */
		Collections.sort(tr, Transaction.montantComparator);
		return tr.get(0);

	}

	/* extract the first transactions */
	
	public static Transaction firstTransaction() {
		List<Transaction> tr = Transaction.remplirTr();
		/* sorted all transaction by year */
		Collections.sort(tr, Transaction.comparatorByYear);
		return tr.get(0);

	}

	/* extract the last transactions */
	
	public static Transaction lastTransaction() {
		List<Transaction> tr = Transaction.remplirTr();
		/* sorted all transaction by year */
		Collections.sort(tr, Transaction.comparatorByYear);
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
