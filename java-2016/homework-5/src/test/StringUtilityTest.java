
import org.junit.Assert;
import org.junit.Test;

import stringutility.StringUtility;

/**
 * This class tests {@link StringUtility} class.
 * 
 * @author Gabriel Ciurdas
 * <p> Date: 02/12/2016
 */
public class StringUtilityTest {

	/**
	 * Tests castWordNumberToNumber method. Fails if word numbers followed by comma 
	 * are not transformed to numbers.
	 */
	@Test
	public void castWordNumbersFollowedByComma() {
		String input = "Alice has one, not two or three apples..";

		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordNumberToNumber(input);

		String correctlyCastedString = "Alice has 1, not 2 or 3 apples..";

		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}

	/**
	 * Tests castWordNumberToNumber method. Fails if word numbers followed by multiple 
	 * dots are not transformed to numbers.
	 */
	@Test
	public void castWordNumbersFollowedByMultipleDots() {
		String input = "Alice has one... not two or three apples..";

		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordNumberToNumber(input);

		String correctlyCastedString = "Alice has 1... not 2 or 3 apples..";

		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	/**
	 * Tests castWordNumberToNumber method. Fails if composed word numbers are
	 * transformed to numbers.
	 */
	@Test
	public void doNotCastComposedWordNumbers() {
		String input = "I want twenty-nine dollars.";

		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordNumberToNumber(input);

		String correctlyCastedString = "I want twenty-nine dollars.";

		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}

	/**
	 * Tests castWordNumberToNumber method. Fails if word numbers written in combined
	 * Upper Case or Lower Case letters are not transformed to numbers.
	 */
	@Test
	public void checkUpcaseNumbersCast() {
		String input = "I want FIVE or at least tHREE dollars.";

		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordNumberToNumber(input);

		String correctlyCastedString = "I want 5 or at least 3 dollars.";

		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	/**
	 * Tests castWordNumberToNumber method. Fails if word numbers followed by exclamation 
	 * mark are not transformed to numbers.
	 */
	@Test
	public void checkNumbersFollowedByExclamationMark() {
		String input = "Five six SEVEN eiGHt!!";

		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordNumberToNumber(input);

		String correctlyCastedString = "5 6 7 8!!";

		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	/**
	 * Tests removeWhiteSpace method. Fails if the white space is not removed from 
	 * the String.
	 */
	@Test
	public void removeWhiteSpace() {
		String input = "two tousand sixteen";

		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordNumberToNumber(input);
		actualCastedString = stringUtility.removeWhiteSpace(actualCastedString);

		String correctlyCastedString = "2tousandsixteen";

		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	/**
	 * Tests removeWhiteSpace method. Fails if the white space is not removed from 
	 * new lines.
	 */
	@Test
	public void removeWhiteSpaceFromNewLine() {
		String input = "two tousand sixteen                                   "
				+ "new                   " + "lines!" + "\n" + "     " + "\n";

		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordNumberToNumber(input);
		actualCastedString = stringUtility.removeWhiteSpace(actualCastedString);

		String correctlyCastedString = "2tousandsixteennewlines!";

		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	/**
	 * Tests removeWhiteSpace method. Fails if the white space is not removed from 
	 * new lines and tabs.
	 */
	@Test
	public void removeWhiteSpaceFromTabs() {
		String input = "two tousand " + "\t" + "\t" + " sixteen"                                                           
				+ "new " + "\t" + " lines!" + "\n" + "     " + "\n";
		System.out.println(input);
		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordNumberToNumber(input);
		actualCastedString = stringUtility.removeWhiteSpace(actualCastedString);

		String correctlyCastedString = "2tousandsixteennewlines!";

		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	/**
	 * Tests castWordNumberToNumber method. Fails if word numbers followed by comma 
	 * are not transformed to numbers.
	 */
	@Test
	public void castNumbersFollowedByMultipleDifferentNonAlphapeticalCharacters() {
		String input = "I have one~!@##$%^^&*( new test";

		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordNumberToNumber(input);

		String correctlyCastedString = "I have 1~!@##$%^^&*( new test";

		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	/**
	 * Tests castWordNumberToNumber method. Fails if the original string is modified.
	 */
	@Test
	public void stringIsUnmodifiedIfNoWordNumbersAreFound() {
		String input = "I have 3 apples and 2 bananas.";

		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordNumberToNumber(input);

		String correctlyCastedString = "I have 3 apples and 2 bananas.";

		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	/**
	 * Tests castWordNumberToNumber method. Fails if duplicated word numbers in a single
	 * word are transformed to numbers.
	 */
	@Test
	public void stringIsUnmodifiedForDuplicateWordNumbersInASingleWord() {
		String input = "I have threethree apples and five bananas.";

		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordNumberToNumber(input);

		String correctlyCastedString = "I have threethree apples and 5 bananas.";

		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	/**
	 * Tests castWordNumberToNumber method. Fails if no error is thrown when an empty
	 * String is used as input.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void whenEmptyStringUsed_ExceptionIsThrown() {
		String input = "";
		StringUtility stringUtility = new StringUtility();
		stringUtility.castWordNumberToNumber(input);
	}

	/**
	 * Tests castWordNumberToNumber method. Fails if no error is thrown when a null
	 * String is used as input.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void whenNullStringUsed_ExceptionIsThrown() {
		String input = null;
		StringUtility stringUtility = new StringUtility();
		stringUtility.castWordNumberToNumber(input);
	}
}
