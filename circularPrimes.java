import java.util.ArrayList;

public class circularPrimes {
	
	public boolean isPrime2(int number) {
		return true;
	}

	public boolean isPrime_4(int number) {
		if(number == 4)
			return false;
		return true;
	}
	
	public boolean isPrime_7(int number) {
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

	//ArrayList<Integer> primeList = new ArrayList<>();
	ArrayList<String> primeList = new ArrayList<>();
	ArrayList<Character> charNumber = new ArrayList<>();
	ArrayList<Integer> circularPrimeList = new ArrayList<>();
	

	public boolean isPrime123(int number) {
		int cont = 0;
		
		if(number == 2 || number == 5 || number == 3) {
			System.out.println(number);
			return true;
		}
		else if((number % 2 == 0 || number % 5 == 0 || number % 3 == 0))
			return false;
		
		for(int i = 2; i < number; i++) {
			if(!modPrime(i, number))
				cont++;
		}
		
		if (cont < 1) {
			System.out.println(number);
			primeList.add(String.valueOf(number));
			return true;
		}
		return false; 
	}
	
	private int rotateNumber(int number) {
		String numberX = String.valueOf(number);
		StringBuilder sb = new StringBuilder();

		for(int i = 0; i < numberX.length(); i++ ) {
			charNumber.add(numberX.charAt(i));
		}
		
		for(int i = 0; i < charNumber.size(); i++) {
			if((i+1) < charNumber.size())
				sb.append(charNumber.get(i+1));
			else
				sb.append(charNumber.get(0));
		}
		
		if(isPrime(Integer.parseInt(sb.toString())))
			circularPrimeList.add(number);

		charNumber.clear();
		return Integer.parseInt(sb.toString());
	}
	
	public boolean isPrime(int number) {
		int cont = 0;
		int i = 2;
		
		if(number == 2 || number == 5 || number == 3) {
			primeList.add(String.valueOf(number));
			return true;
		}
		else if((number % 2 == 0 || number % 5 == 0 || number % 3 == 0))
			return false;
		
		while(cont < 1 && i < number) {
			if(!modPrime(i, number)){
				cont++;
			}
			i++;
		}
		
		if (cont < 1) {
			primeList.add(String.valueOf(number));
			return true;
		}
		return false; 
	}
	
	private void addToCircularPrimeList(int number) {
		for(int i=0; i < primeList.size(); i++) {
			if(Integer.parseInt(primeList.get(i)) == number){
				circularPrimeList.add(number);
			}
		}
	}
	
	public boolean isCircularP(int number) {
		int i = 0;
		int numberNew = number;
		if (isPrime(number)){
			
			while(String.valueOf(number).length()>= i) {
				if(number < 19)
					addToCircularPrimeList(number);
								
				numberNew = rotateNumber(numberNew);
				i++;
				return true;
				
			}
			
		}
		return false;
	}
	
	public void printCircularList() {
		for(int i = 0; i < circularPrimeList.size(); i++) {
			System.out.println(circularPrimeList.get(i));
		}
	}
	
	public void printPrimeList() {
		for(int i = 0; i < primeList.size(); i++) {
			System.out.println(primeList.get(i));
		}
	}

}

