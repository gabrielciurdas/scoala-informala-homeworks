package stringutility;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

public class StringUtility {
	// p rivate String input;
	private final String[] numbers = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };
	private final String[] digitNumbers = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

	private String[] separateWords;

	/**
	 * @return the separateWords
	 */
	public String[] getSeparateWords() {
		return separateWords;
	}

	/**
	 * @param separateWords
	 *            the separateWords to set
	 */
	public void setSeparateWords(String[] separateWords) {
		this.separateWords = separateWords;
	}

	/**
	 * @return the numbers
	 */
	public String getNumbers(int count) {
		return numbers[count];
	}

	/**
	 * @return the digitnumbers
	 */
	public String getDigitnumbers(int count) {
		return digitNumbers[count];
	}

	// private Scanner in = new Scanner(System.in);

	public String removeWhiteSpace(String input) {
		String noWhiteSpace = input.replaceAll("\\s+", "");
		/*
		 * while (in.hasNext()) { input = in.next(); }
		 * System.out.println(input);
		 */
		return noWhiteSpace;
	}

	private void setSeparateWord(int index, String input) {
		separateWords[index] = input;
	}

	private String getSeparateWord(int index) {
		return separateWords[index];
	}

	private void setSeparateWords(String input) {
		setSeparateWords(input.split(" "));

	}

	private void removeNonAlphabetCharacters() {
		for (int i = 0; i < separateWords.length; i++) {
			setSeparateWord(i, getSeparateWord(i).replaceAll("[^a-zA-Z0-9_-]", ""));
			//System.out.println(separateWords[i]);
		}
	}

	public String castWordsToDigits(String input) {
		setSeparateWords(input);

		String[] listOfNonAlphabeticalChar = new String[separateWords.length];
		String[] copyOfSeparateWords = separateWords.clone();
		/*System.out.println(Arrays.toString(copyOfSeparateWords));
		System.out.println(Arrays.toString(separateWords));*/
		removeNonAlphabetCharacters();
		String[] nonAlphabetCharactersRemoved = separateWords.clone();
		
		for (int i = 0; i < listOfNonAlphabeticalChar.length; i++) {
			listOfNonAlphabeticalChar[i] = "";
			if (copyOfSeparateWords[i].length() > nonAlphabetCharactersRemoved[i].length()) {
				listOfNonAlphabeticalChar[i] = copyOfSeparateWords[i].substring(nonAlphabetCharactersRemoved[i].length(),
						copyOfSeparateWords[i].length());
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
