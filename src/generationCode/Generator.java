package generationCode;

import java.util.ArrayList;
import java.util.Scanner;

// Basically a wrapper for all of the rest of the code.  Generates items.
public class Generator {
	
	public static ArrayList<Descriptor> base = new ArrayList<Descriptor>();
	public static ArrayList<Descriptor> owner = new ArrayList<Descriptor>();
	public static ArrayList<Descriptor> mod = new ArrayList<Descriptor>();
	public static ArrayList<Descriptor> second = new ArrayList<Descriptor>();
	public static ArrayList<Descriptor> lucky = new ArrayList<Descriptor>();
	public static ArrayList<Descriptor> adv = new ArrayList<Descriptor>();
	
	public static void main(String[] args)
	{
		base = readList("./BaseItems", false);
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
	
	public static ArrayList<Descriptor> readList(String filename, boolean ReadPosition)
	{
		Scanner s = new Scanner(filename);
		Object[] stuff = new Object[4];
		while (s.hasNext())
		{
			String curr = s.nextLine();
		}
		if (ReadPosition)
		{}
		return null;
	}
}
