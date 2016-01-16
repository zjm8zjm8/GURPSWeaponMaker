package generationCode;

import java.io.File;
import java.io.FileNotFoundException;
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
	
	public static void main(String[] args) throws FileNotFoundException
	{
		base = readList("./BaseItems", 2);
		owner = readList("./OwnerDesc", 0);
		mod = readList("./Modifiers", 1);
		second = readList("./Secondaries", 3);
		lucky = readList("./Lucky", 4);
		adv = readList("./Advantages", -1);
		System.out.println(base.get(0).getName());
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
	
	/***
	 * Reads the list, which should be formatted Name, Value, Description, Effect.
	 * If assumedPosition is not -1, the position of the descriptor will be set to that.
	 * If assumedPosition IS -1, the position will be read as a line after Value.
	 * 
	 * @param filename
	 * @param assumedPosition
	 * @return
	 * @throws FileNotFoundException
	 */
	public static ArrayList<Descriptor> readList(String filename, int assumedPosition) throws FileNotFoundException
	{	
		Scanner sean = new Scanner(new File(filename));
		ArrayList<Descriptor> Items = new ArrayList<Descriptor>();
		String[] buffer = new String[5];
		int bufferIndex = 0;
		while(sean.hasNext())
		{
			if (bufferIndex == 2 && assumedPosition != -1)
			{
				bufferIndex++;
				buffer[2] = Integer.toString(assumedPosition);
				continue;
			}
			String curr = sean.nextLine();
			if (curr.length() == 0 || curr.charAt(0) == '#' || curr.equals(""))
			{
				continue;
			}
			buffer[bufferIndex] = curr;
			bufferIndex++;
			if (bufferIndex > 4)
			{
				bufferIndex = 0;
				int a = Integer.parseInt(buffer[1]);
				int b = Integer.parseInt(buffer[2]);
				Items.add(new Descriptor(b, a, buffer[0], buffer[3], buffer[4]));
			}
		}
		sean.close();
		return Items;
	}
	
}
