
import org.junit.Assert;
import org.junit.Test;

import stringutility.StringUtility;

public class StringUtilityTest {

	@Test
	public void castWordNumbersWithComma() {
		String input = "Alice has one, not two or three apples..";
		
		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordsToDigits(input);
		
		String correctlyCastedString = "Alice has 1, not 2 or 3 apples..";
		
		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	@Test
	public void castWordNumbersWithMultipleDots() {
		String input = "Alice has one... not two or three apples..";
		
		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordsToDigits(input);
		
		String correctlyCastedString = "Alice has 1... not 2 or 3 apples..";
		
		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	@Test
	public void doNotCastComposedNumbers() {
		String input = "I want twenty-nine dollars.";
		
		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordsToDigits(input);
		
		String correctlyCastedString = "I want twenty-nine dollars.";
		
		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	@Test
	public void checkUpcaseNumbersCast() {
		String input = "I want FIVE or at least tHREE dollars.";
		
		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordsToDigits(input);
		
		String correctlyCastedString = "I want 5 or at least 3 dollars.";
		
		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	@Test
	public void checkNumbersFollowedByExclamationMark() {
		String input = "I want FIVE!! or at least tHREE dollars.";
		
		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordsToDigits(input);
		
		String correctlyCastedString = "I want 5!! or at least 3 dollars.";
		
		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	@Test
	public void removeWhiteSpace() {
		String input = "two tousand sixteen";
		
		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordsToDigits(input);
		actualCastedString = stringUtility.removeWhiteSpace(actualCastedString);
		
		String correctlyCastedString = "2tousandsixteen";
		
		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}
	
	@Test
	public void castNumbersFollowedByMultipleDifferentNonAlphapeticalCharacters() {
		String input = "I have one~!@##$%^^&*( new test";
		
		StringUtility stringUtility = new StringUtility();
		String actualCastedString = stringUtility.castWordsToDigits(input);
		
		String correctlyCastedString = "I have 1~!@##$%^^&*( new test";
		
		Assert.assertEquals(actualCastedString, correctlyCastedString);
	}

}
