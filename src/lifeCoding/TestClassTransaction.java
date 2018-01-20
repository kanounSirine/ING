package lifeCoding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class TestClassTransaction {

	public Transaction tr;

	/* test function exctract between two year */
	@Test
	public void testExtractBetweenTwoYear() {

		List<Transaction> tr1 = tr.extractBetweenTwoYear();
		Assert.assertEquals(tr1.size(), 7);
		Assert.assertNotEquals(tr1.size(), 8);
		for (Transaction item : tr1) {
			System.out.println("extract Transaction  Between 2013 and 2018 " + item.getMontant());
		}
	}
	/* test function exctrat By year */
	@Test
	public void testExtractByYear() {

		List<Transaction> tr1 = tr.extractByYear();
		/* test function if list contain 2 element */
		Assert.assertEquals(tr1.size(), 2);
		Assert.assertNotEquals(tr1.size(), 8);
		/* display all the extract transaction by year */
		for (Transaction item : tr1) {
			System.out.println("extract Transaction  By the year 2016 " + item.getMontant());
		}
	}
	

	/* test function exctract By name client */

	@Test
	public void testExtractByName() {
		
		List<Transaction> tr1 = tr.extractByName();
		/* test function if list contain 3 element */
		Assert.assertEquals(tr1.size(), 3);
		/* display all the extract transaction by Name */
		for (Transaction item : tr1) {
			System.out.println("extract Transaction  By Name " + item.getMontant());
		}
	}

	/*test function extract the old transactions */
	@Test
	public void testFirstTransaction() {

		Transaction tr1 = tr.firstTransaction();

		System.out.println("extract first Transaction" + tr1.getMontant());
	}

	/*test function extract the last transactions */
	@Test
	public void  TestlastTransaction() {
		Transaction tr1 = tr.lastTransaction();

		System.out.println("extract last Transaction" + tr1.getMontant());
	}
	
	/*test function extract the min transaction By Montant  */
	
	@Test
	public void testMinTransaction() {

		Transaction tr1 = tr.minTransaction();

		System.out.println("extract min Transaction  " + tr1.getMontant());
	}
	/*test function extract the max  transaction By Montant  */
	@Test
	public void testMaxTransaction() {

		Transaction tr1 = tr.maxTransaction();

		System.out.println("extract max Transaction  " + tr1.getMontant());

	}
	/*test function extract in file  */
	@Test
	public void testExtractToFile() {
       Assert.assertTrue(tr.extractFile());
       System.out.println("create file  " );

	}
}
