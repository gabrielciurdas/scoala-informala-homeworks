package stringutility;

/**
 * The Main class for StringUtility methods call.
 * 
 * @author Gabriel Ciurdas
 * <p> Date: 02/12/2016
 */
public class Main {

	/**
	 * Main method.
	 * @param args represents the command line arguments.
	 */
	public static void main(String[] args) {
		
		String input = "Alice has one dog. His name is NotSoLucky and he Was born in two thousand sixteen.";
		
		StringUtility stringUtility = new StringUtility();
		
		String noDigitWords = stringUtility.castWordNumberToNumber(input);
		//noDigitWords = stringUtility.removeWhiteSpace(noDigitWords); //works
		System.out.println(noDigitWords);
	}
}
