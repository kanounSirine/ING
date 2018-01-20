package lifeCodingJava8;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestClassTransaction {
	public Transaction tr;

	/* test function exctrat By year */
	@Test
	public void testExtractByYear() {

		List<Transaction> tr1 = tr.extractByYear();
		/* test function if list contain 2 element */
		Assert.assertEquals(tr1.size(), 2);
		/* display all the extract transaction by year */

		tr1.forEach((item) -> System.out.println("extract Transaction  By the year 2016  " + item.getMontant()));

	}
	
	
	/* test function exctract between two year */
	@Test
	public void testExtractBetweenTwoYear() {

		List<Transaction> tr1 = tr.extractBetweenYear();
		/* test function if list contain 7 element */
		Assert.assertEquals(tr1.size(), 7);
		/* display all the extract transaction by year */

		tr1.forEach((item) -> System.out.println("extract Transaction between 2013 and 2018  " + item.getMontant()));

	}

	/* test function exctract By name client */
	@Test
	public void testExtractByName() {
		/* test function if list contain 2 element */
		List<Transaction> tr1 = tr.extractByName();
		Assert.assertEquals(tr1.size(), 2);
		/* display all the extract transaction by Name */
		tr1.forEach((item) -> System.out.println("extract Transaction  By Name " + item.getMontant()));

	}
	
	/*test function extract the last transaction */
	
	@Test
	public void testLastTransaction() {

		Transaction tr1 = tr.lastTransaction();
		/* test function last Transaction */
		System.out.println("extract last Transaction" + tr1.getMontant());
	}
	
	/*test function extract the first transaction */
	
	
	@Test
	public void testFirstTransaction() {

		Transaction tr1 = tr.firstTransaction();
		/* test function old Transaction */
		System.out.println("extract first Transaction" + tr1.getMontant());
	}
	/*test function extract the min transaction By Montant  */

	@Test
	public void testMinTransaction() {

		Transaction tr1 = tr.minTransaction();
		/* test function min Transaction */
		System.out.println("extract min Transaction  " + tr1.getMontant());
	}
	/*test function extract the max transaction By Montant  */
	@Test
	public void testMaxTransaction() {

		Transaction tr1 = tr.maxTransaction();
		/* test function max Transaction */
		System.out.println("extract max Transaction  " + tr1.getMontant());

	}
	/*test function extract in file  */
	@Test
	public void testExtractToFile() {
		/* test function extract Transction in the file */
		Assert.assertTrue(tr.extractFile());
		 System.out.println("create file  " );
	}
}
