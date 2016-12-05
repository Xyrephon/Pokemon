package pokemon.controller;

import java.util.ArrayList;
import pokemon.view.PokemonFrame;
import pokemon.model.*;

public class PokemonController
{
	private PokemonFrame appFrame;
	private ArrayList<Pokemon> pokedex;
	
	public PokemonController()
	{
		pokedex = new ArrayList<Pokemon>();
		buildPokedex();
		
		appFrame = new PokemonFrame(this);
	}

	public void start()
	{
		
	}
	
	private void buildPokedex()
	{
		pokedex.add(new Charizard());
	}
	
	public String[] buildPokedexText()
	{
		String [] pokemonNames = new String[pokedex.size()];
		for(int index = 0; index < pokedex.size(); index++)
		{
			pokemonNames[index] = pokedex.get(index).getName();
		}
		
		return pokemonNames;
	}
	
	public void updateSelected(int index, String name, int combat, int health, double speed)
	{
		Pokemon current = pokedex.get(index);
		current.setName(name);
		current.setAttackPoints(combat);
		current.setSpeed(speed);
		current.setHitPoints(health);
	}
	
	public PokemonFrame getAppFrame()
	{
		return appFrame;
	}

	public ArrayList<Pokemon> getPokedex()
	{
		return pokedex;
	}

}	

