import java.util.ArrayList;

public class PwdGenerator {

	String[] excludedElements = {"i", "I", "L", "l", "1", "0", "o", "O"};
	ArrayList<Character> excludedList= new ArrayList<Character>();
	int startG;
	int endG;
	
	private char genChar(int start, int end) {
		return (char)(start+ Math.random()*(end - start +1));
	}
	
	//return true if letter is it he excludedList
	boolean compareWithExcluded(ArrayList<Character> excludedList, char passLetter) {
		for(int i = 0; i < excludedList.size(); i++) {
			if(passLetter == excludedList.get(i))
				return true; //letter in excludedList
		}
		return false; //can use the letter in actual password (OK)
	}
	
	//return a char ready to use in the password
	private char CharGenerator(int start, int end, ArrayList<Character> excludedList) {
		char passLetter = 'A';
		passLetter = genChar(start, end);
		while (compareWithExcluded(excludedList, passLetter)) {
			passLetter = genChar(start, end);
		}
		return passLetter;
	}
	
	private void excludeElement(int ini, int end) {
		for(int i=ini; i<=end; i++)
			excludedList.add((char)i);
	}

	private void excludeElement(int ini) {
		for(int i=ini; i< excludedElements.length; i++) {
			excludedList.add((char)excludedElements[i].charAt(0));
		}
	}

	public void startEndInitalization(int start, int end) {
		excludedList.clear();
		startG = start;
		endG = end;
	}

	public String passGenerator(int size, boolean upperCase, boolean lowerCase, boolean numeric, boolean excluded, boolean symbols, String symbolsExcluded) {

		StringBuilder sb = new StringBuilder();
		int cont=0;
		
		startEndInitalization(33,126);
		
		if (upperCase)
			startEndInitalization(65,90);

		if (lowerCase)
			startEndInitalization(97,122);
		
		if(numeric)
			startEndInitalization(48,57);
		
		if (upperCase == true && numeric == true) {
			startEndInitalization(48,90);
			excludeElement(58,64);
		}

		if (lowerCase == true && numeric == true) {
			startEndInitalization(48,122);
			excludeElement(58,96);
		}

		if (upperCase == true && lowerCase == true) {
			startEndInitalization(65,122);
			excludeElement(91,96);
		}

		if (upperCase == true && lowerCase == true && numeric == true) {
			startEndInitalization(48,122);
			excludeElement(58,64);
			excludeElement(91,96);
		}		

		if (upperCase == true && lowerCase == true && numeric == true && symbols == true) {
			startEndInitalization(33,126);
			symbols = false;
		}

		if(symbols) {
			startEndInitalization(33,126);
			excludeElement(48,57);
			excludeElement(65,90);
			excludeElement(97,122);
		}

		if (upperCase == true && symbols == true) {
			startEndInitalization(33,126);
			excludeElement(48,57);
			excludeElement(97,122);
		}

		if (lowerCase == true && symbols == true) {
			startEndInitalization(33,126);
			excludeElement(48,57);
			excludeElement(65,90);
		}

		if (numeric == true && symbols == true) {
			startEndInitalization(33,126);
			excludeElement(65,90);
			excludeElement(97,122);
		}

		if (lowerCase == true && symbols == true && upperCase == true) {
			startEndInitalization(33,126);
			excludeElement(48,57);
		}

		if(excluded)
			excludeElement(0);
		
		while(symbolsExcluded.length() > 0 && cont < symbolsExcluded.length()) {
			excludedList.add((char)symbolsExcluded.charAt(cont));
			cont++;
		}
			
		for (int i = 0; i < size; i++) {
			sb.append(CharGenerator(startG, endG, excludedList));
		}
		
		//sb.append("L");
		return sb.toString();
	}

	
}
