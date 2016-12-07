package poke.controller;

import java.util.ArrayList;

import poke.model.*;
import poke.view.PokemonFrame;

public class PokemonController
{
	private PokemonFrame baseFrame;
	private ArrayList<Pokemon> pokedex;
	
	public PokemonController()
	{
		pokedex = new ArrayList<Pokemon>();
		buildPokedex();
		
		baseFrame = new PokemonFrame(this);
	}

	public void start()
	{
		
	}
	
	private void buildPokedex()
	{
		pokedex.add(new Charizard());
		pokedex.add(new Geodude());
		pokedex.add(new Onyx());
		pokedex.add(new Rayquaza());
		pokedex.add(new Clefairy());
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
	
	public PokemonFrame getBaseFrame()
	{
		return baseFrame;
	}

	public ArrayList<Pokemon> getPokedex()
	{
		return pokedex;
	}

}	

