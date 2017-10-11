import static org.junit.Assert.*;

import org.junit.Test;

public class TestRomanNumerals {

	@Test
	public void testConvertToInteger() {
		RomanNumerals romanNumerals = new RomanNumerals();
		
		String romanNum = "III";
		
		assertEquals(3, romanNumerals.convertToInteger(romanNum));
		
		romanNum = "IV";
		
		assertEquals(4, romanNumerals.convertToInteger(romanNum));
		
		romanNum = "VI";
		
		assertEquals(6, romanNumerals.convertToInteger(romanNum));
		
		romanNum = "CVI";
		
		assertEquals(106, romanNumerals.convertToInteger(romanNum));
		
		romanNum = "MCVXI";
		
		assertEquals(1116, romanNumerals.convertToInteger(romanNum));
		
		romanNum = "MCDLVXI";
		
		assertEquals(1466, romanNumerals.convertToInteger(romanNum));
		
		romanNum = "A";
		
		assertEquals(0, romanNumerals.convertToInteger(romanNum));
		
		romanNum = "";
		
		assertEquals(0, romanNumerals.convertToInteger(romanNum));
	}
	
	@Test
	public void testRegexes()
	{
		RomanNumerals romanNumerals = new RomanNumerals();
		
		String romanNum = "IIII";
		
		assertEquals(-1, romanNumerals.convertToInteger(romanNum));	
		
		romanNum = "VV";
		
		assertEquals(-1, romanNumerals.convertToInteger(romanNum));	
	}
	
	@Test
	public void testNumeralSplit()
	{
		RomanNumerals romanNumerals = new RomanNumerals();
		
		String numeralToSplit = "MCMLXXXIV";
		
		String[] splitNumerals = romanNumerals.splitRomanNumeral(numeralToSplit);
		
		String[] expectedSplit = new String[] {"M", "CM", "L", "X", "X", "X", "IV"};
		
		assertArrayEquals(expectedSplit, splitNumerals);
	}

}
