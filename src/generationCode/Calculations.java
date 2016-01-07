package generationCode;

import java.util.Random;

public class Calculations {
	public static Random r = new Random(System.currentTimeMillis());
	
	/***
	 * Rolls a number of dice based on the parameters given to it.
	 * @param numberOfDice Number of dice to roll.
	 * @param maxDieNumber Greatest possible number per die, inclusive.
	 * @param diceHaveZeroes True if zero is a possible result.
	 * @return An array of the dice results.
	 */
	public static int getItemScore()
	{
		return r.nextInt(1001);
	}
	public static int[] doRandomDieRolls(int numberOfDice, int maxDieNumber, boolean diceHaveZeroes)
	{
		int[] nums = new int[numberOfDice];
		for (int i = 0; i < numberOfDice; i++)
		{
			nums[i] = r.nextInt(maxDieNumber+1);
			if(!diceHaveZeroes)
				nums[i]++;
		}
		return nums;
	}
	
	public static String parseRandomDieRolls(int[] dice)
	{
		String result = "";
		int total = 0;
		
		return result;
	}
}
