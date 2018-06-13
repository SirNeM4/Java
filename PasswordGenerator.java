import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class PasswordGenerator {
	
	static PwdGenerator pG2;
	static PasswordGenerator pG;
	
	int size;
	boolean upperCase;
	boolean lowerCase;
	boolean numeric;
	boolean excluded;
	boolean symbols;
	String symbolsExcluded;
	
	public String passGenerator() {
		pG2 = new PwdGenerator();
		return pG2.passGenerator(size, upperCase, lowerCase, numeric, excluded, symbols, symbolsExcluded);
	}
	
	/*
	-Size:16 Contraseña de 16 caracteres
	-U Incluir letras en mayúscula (Uppercase)
	-L Incluir letras en minúscula (Lowercase)
	-N Incluir números (Numbers)
	-S Incluir símbolos (Symbols). Entiéndase caracteres como: $%&()=# entre otros.
	-A Excluye los caracteres ambiguos: i, I, L, l, 1, o, O, 0
	-E:[]{}@ Excluir los símbolos suministrados. En este caso la contraseña generada no contendrá los caracteres []{}@
	-T:3 Generar 3 contraseñas (Total)
	-C Copia la contraseña generada en el ClipBoard para solo hacer CTRL + V y utilizarla. (Ver más adelante como hacerlo). Si el usuario genera múltiples contraseñas, solo la última se copiará al Clipboard.
	        	//if (s == "-U")
	 */
	
	public static void main (String[] args) {
		
		pG = new PasswordGenerator();
		pG2 = new PwdGenerator();
		
		pG.size = 16;
		pG.upperCase = true;
		pG.lowerCase = true;
		pG.numeric = true;
		pG.excluded = false;
		pG.symbols = false;
		pG.symbolsExcluded = "";	
		int passCant = 1;
		String[] configParams= {"-S"};
		StringBuilder sb = new StringBuilder();
		String passG;
		String opt;
		boolean toClipB = false;
		
		for (int i = 0; i < args.length; i++) {
			opt = args[i].toString().toUpperCase();
        	
			if (opt.contains("-U")) {
        		pG.upperCase = true;
        	}
        	
        	if (opt.contains("-L")) {
        		pG.lowerCase = true;
        	}
        	if (opt.contains("-N")) {
        		pG.numeric = true;
        	}
        	if (opt.equals(configParams[0])) {
        		pG.symbols = true;
        	}
        	if (opt.contains("-A")) {
        		pG.excluded = true;
        	}
        	if (opt.contains("-SIZE:")) {
        		String[] sizeParts = args[i].split(":");
        		pG.size = Integer.parseInt(sizeParts[1]);
        	}
        	if (opt.contains("-T:")) {
        		String[] passParts = args[i].split(":");
        		passCant = Integer.parseInt(passParts[1]);
        	}
        	if (args[i].contains("-E:")) {
        		String[] passParts = args[i].split(":");
        		for(int j = 0; i < passParts[1].length(); i++)
        			sb.append(passParts[1]);
        	}
        	if (opt.contains("-C")) {
        		toClipB = true;
        	}
        }
		
		pG.symbolsExcluded = sb.toString();
		
        for (int i = 0; i < passCant; i++) {
        	passG = pG2.passGenerator(pG.size, pG.upperCase, pG.lowerCase, pG.numeric, pG.excluded, pG.symbols, pG.symbolsExcluded);
        	System.out.println(passG);
        	
        	if(toClipB) {
        		Clipboard cb = Toolkit.getDefaultToolkit().getSystemClipboard();
        		StringSelection ssPassGen = new StringSelection(passG);
        		cb.setContents(ssPassGen, ssPassGen);	
             }
        }
	}
}
