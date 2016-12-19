package poke.model;

public abstract class Pokemon
{
	private int hitPoints;
	private int number;
	private int attackPoints;
	private double speed;
	private String name;
	
	public Pokemon(String name, int number)
	{
		this.name = name;
		this.number = number;
		
	}
	
	public String getPokemonTypes()
	{
		String pokemonTypes = "This Pokemon has the following types: \n";
		Class<?> [] types = getClass().getInterfaces();
		String [] pokeTypes = new String[types.length];
		for(int index = 0; index < types.length; index++)
		{
			String temp = types[index].getCanonicalName();
			
			pokeTypes[index] = temp;
		}
		
		for(String current : pokeTypes)
		{
			String temp = current.replace(this.getClass().getPackage().getName() + ".", "");
			pokemonTypes += temp + "\n";
		}
		return pokemonTypes;
	}
	
	public String getPokemonInformation()
	{
		String pokemonInfo = "This pokemon is of type: " + this.getClass().getSimpleName();
		
		return pokemonInfo;
	}
	
	public void setHitPoints(int hitPoints)
	{
		this.hitPoints = hitPoints;
	}
	
	public void setNumber(int number)
	{
		this.number = number;
	}
	
	public void setAttackPoints(int attackPoints)
	{
		this.attackPoints = attackPoints;
	}
	
	public void setSpeed(double speed)
	{
		this.speed = speed;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public int getHitPoints()
	{
		return hitPoints;
	}
	
	public int getNumber()
	{
		return number;
	}
	
	public int getAttackPoints()
	{
		return attackPoints;
	}
	
	public double getSpeed()
	{
		return speed;
	}
	
	public String getName()
	{
		return name;
	}
	
	
}

