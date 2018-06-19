import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class circulaPrimesTest {
	circularPrimes cP;
	
	@Before
	public void setUp() {
		cP = new circularPrimes();
	}
/*
	@Test
	public void isPrime_2() {
		Assert.assertEquals(true, cP.isPrime(2));
	}

	
	@Test
	public void isPrime_3() {
		Assert.assertEquals(true, cP.isPrime(3));
	}

	
	@Test
	public void isPrime_4() {
		Assert.assertEquals(false, cP.isPrime(4));
	}

	@Test
	public void isPrime_5() {
		Assert.assertEquals(true, cP.isPrime(5));
	}

	@Test
	public void isPrime_6() {
		Assert.assertEquals(false, cP.isPrime(6));
	}

	@Test
	public void isPrime_7() {
		Assert.assertEquals(true, cP.isPrime(7));
	}

	@Test
	public void isPrime_8() {
		Assert.assertEquals(false, cP.isPrime(8));
	}

	
	@Test
	public void isPrime_9() {
		Assert.assertEquals(false, cP.isPrime(9));
	}

	@Test
	public void isPrime_10() {
		Assert.assertEquals(false, cP.isPrime(10));
	}
	
	@Test
	public void isPrime_11() {
		Assert.assertEquals(true, cP.isPrime(11));
	}

	@Test
	public void primes11to25() {
		Assert.assertEquals(true, cP.isPrime(2));
		Assert.assertEquals(true, cP.isPrime(3));
		Assert.assertEquals(true, cP.isPrime(5));
		Assert.assertEquals(true, cP.isPrime(7));
		Assert.assertEquals(true, cP.isPrime(11));
		Assert.assertEquals(true, cP.isPrime(13));
		Assert.assertEquals(true, cP.isPrime(17));
		Assert.assertEquals(true, cP.isPrime(19));
		Assert.assertEquals(true, cP.isPrime(23));
		Assert.assertEquals(true, cP.isPrime(29));
		Assert.assertEquals(true, cP.isPrime(31));
		Assert.assertEquals(true, cP.isPrime(37));
		Assert.assertEquals(true, cP.isPrime(41));
		Assert.assertEquals(true, cP.isPrime(43));
		Assert.assertEquals(true, cP.isPrime(47));
		Assert.assertEquals(true, cP.isPrime(53));
		Assert.assertEquals(true, cP.isPrime(59));
		Assert.assertEquals(true, cP.isPrime(61));
		Assert.assertEquals(true, cP.isPrime(67));
		Assert.assertEquals(true, cP.isPrime(71));
		Assert.assertEquals(true, cP.isPrime(73));
		Assert.assertEquals(true, cP.isPrime(79));		
		Assert.assertEquals(true, cP.isPrime(83));
		Assert.assertEquals(true, cP.isPrime(89));
		Assert.assertEquals(true, cP.isPrime(97));
	}
	
	@Test
	public void noPrimerNumbers() {
		Assert.assertEquals(false, cP.isPrime(4));
		Assert.assertEquals(false, cP.isPrime(6));
		Assert.assertEquals(false, cP.isPrime(8));
		Assert.assertEquals(false, cP.isPrime(9));
		Assert.assertEquals(false, cP.isPrime(14));
		Assert.assertEquals(false, cP.isPrime(15));
		Assert.assertEquals(false, cP.isPrime(16));
		Assert.assertEquals(false, cP.isPrime(22));
		Assert.assertEquals(false, cP.isPrime(30));
		Assert.assertEquals(false, cP.isPrime(35));
		Assert.assertEquals(false, cP.isPrime(38));
		Assert.assertEquals(false, cP.isPrime(42));
		Assert.assertEquals(false, cP.isPrime(44));
		Assert.assertEquals(false, cP.isPrime(100));

	}
	
	@Test
	public void isPrime_49() {
		Assert.assertEquals(false, cP.isPrime(49));
	}
	

	@Test
	public void printPrimeNumber1to1M() {
		int cont = 0;
		for (int i = 2 ; i <= 1000000 ; i++) {
			if(cP.isPrime(i))
				cont ++;
		}
		cP.printPrimeList();
		System.out.println("primes number between 1 to 1000000: "+cont);
	}
*/

	@Test
	public void printCircularNumber1to1M() {
		int cont = 0;
		for (int i = 2 ; i <= 1000000 ; i++) {
			cP.isCircularP(i);
		}
		cP.printCircularList();
		System.out.println("primes number between 1 to 1000000: "+ cP.noRepeat.size());
		cP.primeList.clear();
		cP.circularPrimeList.clear();
	}

/*
	@Test
	public void istestRotator() {
		cP.isCircularP(101);
		cP.printCircularList();
		cP.primeList.clear();
		cP.circularPrimeList.clear();
	}
*/
}
