import java.util.ArrayList;

public class circularPrimes {
	
	public boolean isACircularPrime2(int number) {
		return true;
	}

	public boolean isACircularPrime_4(int number) {
		if(number == 4)
			return false;
		return true;
	}
	
	public boolean isACircularPrime_7(int number) {
		if(number == 4)
			return false;
		else if (number == 6)
			return false;
		return true;
		
	}

	private boolean modPrime (int i, int number) {
		if((number % i) == 0) {
			return false;
		}
		return true;
	}

	ArrayList<Integer> primeList = new ArrayList<>();

	public boolean isACircularPrime_9(int number) {
		int cont = 0;
		
		if(number == 2 || number == 5 || number == 3)
			return true;
		else if((number % 2 == 0 || number % 5 == 0 || number % 3 == 0))
			return false;
		
		for(int i = 2; i < number; i++) {
			if(!modPrime(i, number))
				cont++;
		}
		
		if (cont < 1) {
			System.out.println(number);
			primeList.add(number);
			return true;
		}
		return false; 
	}
	
	public boolean isACircularPrime(int number) {
		int cont = 0;
		int i = 2;
		
		if(number == 2 || number == 5 || number == 3)
			return true;
		else if((number % 2 == 0 || number % 5 == 0 || number % 3 == 0))
			return false;
		
		while(cont < 1 || i < number) {
			if(!modPrime(i, number)){
				cont++;
			}
			System.out.println(number);
			return true;
		}
		
		return false; 
	}
	
}

