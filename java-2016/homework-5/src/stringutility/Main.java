package stringutility;

public class Main {

	public static void main(String[] args) {
		
		String input = "Alcie has one dog, three towsand nine hundreds eighty eight is a year";
		
		StringUtility stringUtility = new StringUtility();
		
		String noDigitWords = stringUtility.castWordsToDigits(input);
		noDigitWords = stringUtility.removeWhiteSpace(noDigitWords);
		
		System.out.println(noDigitWords);
	}
}
