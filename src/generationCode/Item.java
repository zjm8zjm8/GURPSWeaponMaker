package generationCode;

public class Item {
	private Descriptor[] underlying;
	private int currentValue;
	
	public Item()
	{
		underlying = new Descriptor[5];
		for(int i = 0; i < 5; i++)
			underlying[i] = new Descriptor(0, 0, "", "", "");
		currentValue = 0;
	}
	public void changeOwner(Descriptor newDesc)
	{
		underlying[0] = newDesc;
		updateCurrentValue();
	}
	public void changeModifier(Descriptor newDesc)
	{
		underlying[1] = newDesc;
		updateCurrentValue();
	}
	public void changeBase(Descriptor newDesc)
	{
		underlying[2] = newDesc;
		updateCurrentValue();
	}
	public void changeSecondary(Descriptor newDesc)
	{
		underlying[3] = newDesc;
		updateCurrentValue();
	}
	public void changeLucky(Descriptor newDesc)
	{
		underlying[4] = newDesc;
		updateCurrentValue();
	}
	public int getValue()
	{
		return currentValue;
	}
	private void updateCurrentValue()
	{
		currentValue = underlying[0].getValue() + underlying[1].getValue() + underlying[2].getValue() + underlying[3].getValue() + underlying[4].getValue();
	}
	public String toString()
	{
		String fullname = "";
		String fulleffects = underlying[2].getEffect() + "\n";
		String fulldesc = underlying[2].getDescription() + "\n";
		for (int i = 0; i < 5; i++)
		{
			if (underlying[i].getName().length() > 0)
			{ 
				fullname += underlying[i].getName() + " ";
				if (i == 2)
					continue;
				fulleffects += underlying[i].getEffect() + "\n";
				fulldesc += underlying[i].getDescription() + "\n";
			}
		}
		return fullname + "\nValue: " + currentValue + "\nEffects:\n" + fulleffects + "Description:\n" + fulldesc;
	}
}
