package generationCode;

// Basically a wrapper for all of the rest of the code.  Generates items.
public class Generator {
	public static void main(String[] args)
	{
		int[] a = Calculations.doRandomDieRolls(100, 10, true);
		int total = 0;
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 5; j++)
			{
				System.out.print(a[i*5+j]+" ");
				total += a[i*5+j];
			}
			System.out.println();
		}
		System.out.println(total);
	}
}
