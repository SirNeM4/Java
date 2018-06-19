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
	
	@Test
	public void isACircularPrime_2() {
		Assert.assertEquals(true, cP.isACircularPrime(2));
	}

	
	@Test
	public void isACircularPrime_3() {
		Assert.assertEquals(true, cP.isACircularPrime(3));
	}

	
	@Test
	public void isACircularPrime_4() {
		Assert.assertEquals(false, cP.isACircularPrime(4));
	}

	@Test
	public void isACircularPrime_5() {
		Assert.assertEquals(true, cP.isACircularPrime(5));
	}

	@Test
	public void isACircularPrime_6() {
		Assert.assertEquals(false, cP.isACircularPrime(6));
	}

	@Test
	public void isACircularPrime_7() {
		Assert.assertEquals(true, cP.isACircularPrime(7));
	}

	@Test
	public void isACircularPrime_8() {
		Assert.assertEquals(false, cP.isACircularPrime(8));
	}

	
	@Test
	public void isACircularPrime_9() {
		Assert.assertEquals(false, cP.isACircularPrime(9));
	}

	@Test
	public void isACircularPrime_10() {
		Assert.assertEquals(false, cP.isACircularPrime(10));
	}
	
	@Test
	public void isACircularPrime_11() {
		Assert.assertEquals(true, cP.isACircularPrime(11));
	}

	@Test
	public void primes11to25() {
		Assert.assertEquals(true, cP.isACircularPrime(2));
		Assert.assertEquals(true, cP.isACircularPrime(3));
		Assert.assertEquals(true, cP.isACircularPrime(5));
		Assert.assertEquals(true, cP.isACircularPrime(7));
		Assert.assertEquals(true, cP.isACircularPrime(11));
		Assert.assertEquals(true, cP.isACircularPrime(13));
		Assert.assertEquals(true, cP.isACircularPrime(17));
		Assert.assertEquals(true, cP.isACircularPrime(19));
		Assert.assertEquals(true, cP.isACircularPrime(23));
		Assert.assertEquals(true, cP.isACircularPrime(29));
		Assert.assertEquals(true, cP.isACircularPrime(31));
		Assert.assertEquals(true, cP.isACircularPrime(37));
		Assert.assertEquals(true, cP.isACircularPrime(41));
		Assert.assertEquals(true, cP.isACircularPrime(43));
		Assert.assertEquals(true, cP.isACircularPrime(47));
		Assert.assertEquals(true, cP.isACircularPrime(53));
		Assert.assertEquals(true, cP.isACircularPrime(59));
		Assert.assertEquals(true, cP.isACircularPrime(61));
		Assert.assertEquals(true, cP.isACircularPrime(67));
		Assert.assertEquals(true, cP.isACircularPrime(71));
		Assert.assertEquals(true, cP.isACircularPrime(73));
		Assert.assertEquals(true, cP.isACircularPrime(79));		
		Assert.assertEquals(true, cP.isACircularPrime(83));
		Assert.assertEquals(true, cP.isACircularPrime(89));
		Assert.assertEquals(true, cP.isACircularPrime(97));
	}
	
	@Test
	public void noPrimerNumbers() {
		Assert.assertEquals(false, cP.isACircularPrime(4));
		Assert.assertEquals(false, cP.isACircularPrime(6));
		Assert.assertEquals(false, cP.isACircularPrime(8));
		Assert.assertEquals(false, cP.isACircularPrime(9));
		Assert.assertEquals(false, cP.isACircularPrime(14));
		Assert.assertEquals(false, cP.isACircularPrime(15));
		Assert.assertEquals(false, cP.isACircularPrime(16));
		Assert.assertEquals(false, cP.isACircularPrime(22));
		Assert.assertEquals(false, cP.isACircularPrime(30));
		Assert.assertEquals(false, cP.isACircularPrime(35));
		Assert.assertEquals(false, cP.isACircularPrime(38));
		Assert.assertEquals(false, cP.isACircularPrime(42));
		Assert.assertEquals(false, cP.isACircularPrime(44));
		Assert.assertEquals(false, cP.isACircularPrime(100));

	}
	
	@Test
	public void printPrimeNumber1to1M() {
		int cont = 0;
		for (int i = 2 ; i <= 1000000 ; i++) {
			if(cP.isACircularPrime(i))
				cont ++;
		}
		System.out.println("----");
		System.out.println("primes number between 1 to 1000000: "+cont);
		System.out.println("----");
	}

}
