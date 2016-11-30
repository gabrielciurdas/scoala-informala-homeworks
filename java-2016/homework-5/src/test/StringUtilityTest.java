
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

}
