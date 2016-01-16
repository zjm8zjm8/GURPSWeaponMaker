package generationCode;

public class Item {
	private Descriptor[] underlying;
	private int currentValue;
	
	public Item()
	{
		underlying = new Descriptor[5];
		for(int i = 0; i < 5; i++)
			underlying[0] = new Descriptor(0, 0, null, null, null);
	}
	public void changeOwner(Descriptor newDesc)
	{
		underlying[0] = newDesc;
		currentValue += newDesc.getValue();
	}
	public void changeModifier(Descriptor newDesc)
	{
		underlying[1] = newDesc;
		currentValue += newDesc.getValue();
	}
	public void changeBase(Descriptor newDesc)
	{
		underlying[2] = newDesc;
		currentValue += newDesc.getValue();
	}
	public void changeSecondary(Descriptor newDesc)
	{
		underlying[3] = newDesc;
		currentValue += newDesc.getValue();
	}
	public void changeLucky(Descriptor newDesc)
	{
		underlying[4] = newDesc;
		currentValue += newDesc.getValue();
	}
	public int getValue()
	{
		return currentValue;
	}
	public String toString()
	{
		String fullname = "";
		String fulleffects = "";
		String fulldesc = "";
		for (int i = 0; i < 5; i++)
		{
			if (underlying[i].getName() != null)
			{
				fullname += underlying[i].getName() + " ";
				fulleffects = underlying[i].getEffect() + "\n";
				fulldesc = underlying[i].getDescription() + "\n";
			}
		}
		return fullname + "\n" + currentValue + "\n" + fulleffects + fulldesc;
	}
}
