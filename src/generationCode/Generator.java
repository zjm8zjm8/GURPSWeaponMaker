package generationCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

// Basically a wrapper for all of the rest of the code.  Generates items.
public class Generator {
	
	public static ArrayList<Descriptor> base = new ArrayList<Descriptor>();
	public static ArrayList<Descriptor> owner = new ArrayList<Descriptor>();
	public static ArrayList<Descriptor> mod = new ArrayList<Descriptor>();
	public static ArrayList<Descriptor> second = new ArrayList<Descriptor>();
	public static ArrayList<Descriptor> lucky = new ArrayList<Descriptor>();
	public static ArrayList<Descriptor> adv = new ArrayList<Descriptor>();
	public static Random r = new Random(System.currentTimeMillis());
	
	public static void main(String[] args) throws FileNotFoundException
	{
		base = readList("./BaseItems", 2);
		owner = readList("./OwnerDesc", 0);
		mod = readList("./Modifiers", 1);
		second = readList("./Secondaries", 3);
		lucky = readList("./Lucky", 4);
		adv = readList("./Advantages", -1);
		int score = Calculations.getItemScore();
		int value = Calculations.translateScoreIntoValue(score);
		Item result = generateItem(value);
		System.out.println(result.toString());
	}
	
	public static Item generateItem(int value)
	{
		Item done = new Item();
		//Step 1: Get weapon type.
		done.changeBase(pickFromList(base));
		//Step 2: Start picking random stuff until we get a match!
		int tries = 0;
		while(done.getValue() != value && tries < 1000){
			tries++;
			int choice = r.nextInt(4);
			switch(choice)
			{
			case 0:
				done.changeOwner(pickFromList(owner));
				break;
			case 1:
				done.changeModifier(pickFromList(mod));
				break;
			case 3:
				done.changeSecondary(pickFromList(second));
			default:
				continue;
			}
		}
		System.out.println("tries: " + tries);
		if (r.nextInt(30) == 0)
			done.changeLucky(pickFromList(lucky));
		if (r.nextInt(150) == 0)
		{
			Descriptor advantage = pickFromList(adv);
			switch(advantage.getPosition())
			{
			case 0:
				done.changeOwner(advantage);
				break;
			case 1:
				done.changeModifier(advantage);
				break;
			case 3:
				done.changeSecondary(advantage);
				break;
			case 4:
				done.changeLucky(advantage);
				break;
			}
		}
		return done;
	}
	
	public static <T> T pickFromList(ArrayList<T> list)
	{
		int where = r.nextInt(list.size());
		return list.get(where);
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
