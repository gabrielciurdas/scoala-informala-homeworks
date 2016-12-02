package stringutility;

/**
 * This class replaces all numbers written as words in a string with numbers
 * between 0 and 9, where the words are not part of a larger word.
 * 
 * @author Gabriel Ciurdas
 * <p> 02/12/2016
 */
public class StringUtility {
	private final String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	private final String[] digitNumbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	private String[] separateWords;

	public void setSeparateWords(String[] separateWords) {
		this.separateWords = separateWords;
	}

	/**
	 * Removes all the white space from a string.
	 * 
	 * @param input
	 *            is the String from which to remove the white space.
	 * @return the String with no white space.
	 */
	public String removeWhiteSpace(String input) {
		String noWhiteSpace = input.replaceAll("\\s+", "");
		return noWhiteSpace;
	}

	private void setSeparateWord(int index, String input) {
		separateWords[index] = input;
	}

	private void setSeparateWords(String input) {
		setSeparateWords(input.split(" "));

	}

	private void removeNonAlphabetCharacters() {
		for (int i = 0; i < separateWords.length; i++) {
			setSeparateWord(i, separateWords[i].replaceAll("[^a-zA-Z0-9_-]", ""));
		}
	}

	/**
	 * Transforms all the word numbers to numbers 0 to 9. If a null or empty
	 * string is used then an IllegalArgumentException is thrown. The words can
	 * be written both Upper or Lower case letters and they can be followed by
	 * comma, dot or exclamation mark. 
	 * Firstly, the method receives a String
	 * input which is then split word by word into an array of Strings. Then,
	 * three arrays of Strings are used: one to store the non alphabetical
	 * characters for each word, the second is a clone of the original array of
	 * Strings and the third one stores the words with non alphabetical characters
	 * removed. Word numbers are transformed to numbers 0 to 9. Then for each
	 * number, if the original string contains any non alphabetical character,
	 * that corresponding character is added immediately after the number.
	 * Finally the constructed array of strings is transformed into a single String
	 * for user output.
	 * 
	 * @param input
	 *            is the String to be transformed.
	 * @return the String with word numbers transformed to numbers 0 to 9.
	 */
	public String castWordNumberToNumber(String input) {
		if (input == null) {
			throw new IllegalArgumentException("String must not be null.");
		}

		if (input.length() == 0) {
			throw new IllegalArgumentException("String must not be empty.");
		}

		setSeparateWords(input);

		String[] listOfNonAlphabeticalChar = new String[separateWords.length];
		String[] copyOfSeparateWords = separateWords.clone();
		removeNonAlphabetCharacters();
		String[] nonAlphabetCharactersRemoved = separateWords.clone();

		for (int i = 0; i < listOfNonAlphabeticalChar.length; i++) {
			listOfNonAlphabeticalChar[i] = "";
			if (copyOfSeparateWords[i].length() > nonAlphabetCharactersRemoved[i].length()) {
				listOfNonAlphabeticalChar[i] = copyOfSeparateWords[i]
						.substring(nonAlphabetCharactersRemoved[i].length(), copyOfSeparateWords[i].length());
			}
		}

		int j = 0;
		String noDigitWords = null;
		for (int i = 0; i < separateWords.length; i++) {
			for (j = 0; j < numbers.length; j++) {
				if (numbers[j].equalsIgnoreCase(separateWords[i])) {
					setSeparateWord(i, digitNumbers[j]);
					break;
				}
			}
			if (noDigitWords == null) {
				noDigitWords = separateWords[i] + listOfNonAlphabeticalChar[i];

			} else {
				noDigitWords += " " + separateWords[i] + listOfNonAlphabeticalChar[i];
			}
		}

		return noDigitWords;
	}
}
