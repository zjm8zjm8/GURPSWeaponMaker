package generationCode;

public class Descriptor {
	private int position;
	private int value;
	private String name;
	private String description;
	private String effect;
	
	public Descriptor(int p, int v, String n, String d, String e)
	{
		position = p;
		value = v;
		name = n;
		description = d;
		effect = e;
	}
	public Descriptor()
	{
		position = 0;
		value = 0;
		name = "";
		description = "";
		effect = "";
	}
	public int getPosition()
	{
		return position;
	}
	public int getValue()
	{
		return value;
	}
	public String getName()
	{
		return name;
	}
	public String getDescription()
	{
		return description;
	}
	public String getEffect()
	{
		return effect;
	}
	
}
