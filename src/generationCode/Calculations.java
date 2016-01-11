package generationCode;

import java.util.Random;

public class Calculations {
	public static Random r = new Random(System.currentTimeMillis());
	
	/***
	 * Gives an unweighted number between 0-100, inclusive.
	 * @return
	 */
	public static int getItemScore()
	{
		return r.nextInt(101);
	}
	
	/***
	 * Translates an Item Score into a Value.
	 * Breakdowns are as follows:
	 * 0: 		-12
	 * 1-4: 	-8
	 * 5-9:		-6
	 * 10-19:	-4
	 * 20-34: 	-2
	 * 35-49:	-1
	 * 50-64:	1
	 * 65-79:	2
	 * 80-89:	4
	 * 90-94:	6
	 * 95-99:	8
	 * 100:		12
	 * @param itemScore
	 * @return
	 */
	public static int translateScoreIntoValue(int itemScore)
	{
		int score = -12;
		if (itemScore > 0)
			score += 4;	//-8
		if (itemScore > 4)
			score += 2; //-6
		if (itemScore > 9)
			score += 2; //-4
		if (itemScore > 19)
			score += 2; //-2
		if (itemScore > 34)
			score += 1;	//-1
		if (itemScore > 49)
			score += 2;	//1
		if (itemScore > 64)
			score += 1; //2
		if (itemScore > 79)
			score += 2; //4
		if (itemScore > 89)
			score += 2; //6
		if (itemScore > 94)
			score += 2; //8
		if (itemScore > 99)
			score += 4; //12
		return score;
	}
	
	/***
	 * Rolls a number of dice based on the parameters given to it.
	 * @param numberOfDice Number of dice to roll.
	 * @param maxDieNumber Greatest possible number per die, inclusive.
	 * @param diceHaveZeroes True if zero is a possible result.
	 * @return An array of the dice results.
	 */
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
