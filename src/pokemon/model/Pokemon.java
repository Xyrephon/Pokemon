package pokemon.model;

public abstract class Pokemon
{
	private int hitPoints;
	private int number;
	private int attackPoints;
	private double speed;
	private String name;
	
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

