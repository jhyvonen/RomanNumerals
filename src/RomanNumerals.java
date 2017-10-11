import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumerals {
	public enum Numerals {
		I, V, X, L, C, D, M
	}
	
	public int convertToInteger(String romanNum) {
		if(illegalNumeral(romanNum))
			return -1;
		
		String[] individualNumbers = splitRomanNumeral(romanNum);
		
		int total = 0;
		
		for(int i = 0; i < individualNumbers.length; i++)
		{
			total += numeralToValue(individualNumbers[i]);
		}
		
		return total;
		
	}
	
	private boolean illegalNumeral(String romanNum) {
		return 	(romanNum.contains("IIII") ||
				romanNum.contains("XXXX") || 
				romanNum.contains("CCCC") || 
				romanNum.contains("MMMM") || 
				romanNum.contains("VV") || 
				romanNum.contains("LL") || 
				romanNum.contains("DD"));
	}

	private int numeralToValue(String numeral) {
		if(numeral.length() == 0)
			return 0;
		if(numeral.length() == 1)
			return getValue(numeral);
		else
		{
			String first = numeral.substring(0, 1);
			String second = numeral.substring(1, 2);
			
			return getValue(second) - getValue(first);
		}
	}
	
	private int getValue(String numeral) {
		switch(numeral)
		{
			case "I": return 1;
			case "V": return 5;
			case "X": return 10;
			case "L": return 50;
			case "C": return 100;
			case "D": return 500;
			case "M": return 1000;
			default: return 0;
		}
	}

	public String[] splitRomanNumeral(String romanNum)
	{
		String[] splitNumerals = romanNum.split("");
		List<String> resultList = new ArrayList<String>();
		
		for(int i = 0; i < splitNumerals.length; i++)
		{
			if(checkNumerals(splitNumerals, i))
			{
				resultList.set(resultList.size() - 1, splitNumerals[i-1] + splitNumerals[i]);
			}
			else
				resultList.add(splitNumerals[i]);
				
		}		

		return resultList.toArray(new String[0]);
	}
	 
	private boolean checkNumerals(String[] splitNumerals, int i)
	{
		if(i - 1 < 0)
			return false;
		int numeralPosition = Numerals.valueOf(splitNumerals[i]).ordinal();
		Numerals previousNumeral = Numerals.valueOf(splitNumerals[i - 1]);
		int previousOrdinal = Numerals.valueOf(splitNumerals[i - 1]).ordinal();
		return (previousNumeralIsLegal(previousNumeral) &&
				(previousOrdinal == numeralPosition - 1 || 
				previousOrdinal == numeralPosition - 2));
	}
	
	private boolean previousNumeralIsLegal(Numerals numeral)
	{
		return	numeral != Numerals.V &&
				numeral != Numerals.L &&
				numeral != Numerals.D;
	}
}
