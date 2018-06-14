import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PwdGeneratorTest {

	PasswordGenerator pG;
	PwdGenerator pG2;
	String[] excludedElementsTest = {"i", "I", "L", "l", "1", "0", "o", "O"};
	ArrayList<Character> excludedListTest= new ArrayList<Character>();
	String symbolsEx = "";
	
	
	private void setSystemVariables(int size, boolean upperCase, boolean lowerCase, boolean numeric, boolean excluded, boolean symbols, String symbolsExcluded) {
		pG.size = size;
		pG.upperCase = upperCase;
		pG.lowerCase = lowerCase;
		pG.numeric = numeric;
		pG.excluded = excluded;
		pG.symbols = symbols;
		pG.symbolsExcluded = symbolsExcluded;	
		excludedListTest.clear();
	}

	private boolean validation(String pass, int scneario) {
        
		switch (scneario) {
        
        case 1: 
			for (int i=0; i < pass.length(); i++) {
				if (Character.isLowerCase(pass.charAt(i))) {
					return false;
				}
			}
			return true;
			
        case 2:
    		for (int i=0; i < pass.length(); i++) {
    			if (Character.isUpperCase(pass.charAt(i))) {
    				return false;
    			}
    		}
    		return true;
    		
        case 3:
    		for (int i=0; i < pass.length(); i++) {
    			if(!Character.isLetter(pass.charAt(i))) {
    				return false;
    			}
    		}
    		return true;
    		
        case 4:
    		for (int i=0; i < pass.length(); i++) {
    			if(!Character.isDigit(pass.charAt(i))) {
    				return false;
    			}
    		}
    		return true;
    	
        case 5:
    		for (int i=0; i < pass.length(); i++) {
    			if(!Character.isLetterOrDigit(pass.charAt(i))){
    				return false;
    			}
    		}
    		return true;
    		
        case 6:
    		for(int i = 0; i < pass.length(); i++) {
    			if (pG2.compareWithExcluded(excludedListTest, pass.charAt(i))) {
    				return true;
    			}
    		}
    		return false;
        }
        
		return true;
	} 
	
	private void addToExcludedElements() {
		for(int i=0; i< excludedElementsTest.length; i++) {
			excludedListTest.add((char)excludedElementsTest[i].charAt(0));
		}
	}

	@Before
	public void setUp() {
		pG = new PasswordGenerator();
		pG2 = new PwdGenerator();
	}
	
	@Test
	public void passGenerator_Size() {
		setSystemVariables(15, false, false, false, false, false, symbolsEx);
		String pass = pG.passGenerator();
		int SizePass = pass.length();
		System.out.println("PassGenerator_Size: "+pass);
		Assert.assertEquals(pG.size, SizePass);
	}
	
	@Test
	public void passGenerator_upperCase() {
		setSystemVariables(15, true, false, false, false, false, symbolsEx);
		String pass = pG.passGenerator();
		System.out.println("passGenerator_upperCase: "+pass);
		Assert.assertEquals(true , validation(pass, 1));
	}

	@Test
	public void passGenerator_lowerCase() {
		
		setSystemVariables(15, false, true, false, false, false, symbolsEx);
		String pass = pG.passGenerator();
		System.out.println("passGenerator_lowerCase: "+pass);
		Assert.assertEquals(true , validation(pass, 2));
	}

	@Test
	public void passGenerator_uppLow() {
		
		setSystemVariables(15, true, true, false, false, false, symbolsEx);
		String pass = pG.passGenerator();
		System.out.println("passGenerator_uppLow: "+pass);
		Assert.assertEquals(true , validation(pass, 3));
		
	}
	
	@Test
	public void passGenerator_isNumeric() {
		
		setSystemVariables(15, false, false, true, false, false, symbolsEx);
		String pass = pG.passGenerator();
		System.out.println("passGenerator_isNumeric: "+pass);
		Assert.assertEquals(true , validation(pass, 4));
	}

	@Test
	public void passGenerator_UppLowNum() {
		
		setSystemVariables(15, true, true, true, false, false, symbolsEx);
		String pass = pG.passGenerator();
		System.out.println("passGenerator_UppLowNum: "+pass);
		Assert.assertEquals(true , validation(pass, 5));
	}
	
	@Test
	public void passGenerator_excluded1() {

		setSystemVariables(15, false, false, false, true, false, symbolsEx);
		String pass = pG.passGenerator();
		addToExcludedElements();
		System.out.println("passGenerator_excluded1: "+pass);
		Assert.assertEquals(false , validation(pass, 6));
	}
	
	@Test
	public void passGenerator_UppLowNumEx() {

		setSystemVariables(15, true, true, true, true, false, symbolsEx);
		String pass = pG.passGenerator();
		addToExcludedElements();
		System.out.println("passGenerator_UppLowNumEx: "+pass);
		Assert.assertEquals(false , validation(pass, 6));
	}
	
	@Test
	public void passGenerator_Symbols() {
		
		setSystemVariables(15, false, false, false, false, true, symbolsEx);
		String pass = pG.passGenerator();
		addToExcludedElements();
		System.out.println("passGenerator_Symbols: "+pass);
		Assert.assertEquals(false , validation(pass, 6));
	}		

	@Test
	public void passGenerator_UppLwExSym() {
		
		setSystemVariables(15, true, true, true, true, true, symbolsEx);
		String pass = pG.passGenerator();
		addToExcludedElements();
		System.out.println("passGenerator_UppLwExSym: "+pass);
		Assert.assertEquals(false , validation(pass, 6));
	}		

	@Test
	public void passGenerator_excludeSymbols() {
		symbolsEx = "./*-[]!#$%&/()=+@<{}>,;:?\\|'_";
		setSystemVariables(15, false, false, false, false, true, symbolsEx);
		String pass = pG.passGenerator();
		addToExcludedElements();
		System.out.println("passGenerator_excludeSymbols: "+pass);
		Assert.assertEquals(false , validation(pass, 6));
	}		

}
