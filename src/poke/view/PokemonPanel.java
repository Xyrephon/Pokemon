package poke.view;

import java.awt.Color;
import javax.swing.*;

import poke.controller.PokemonController;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class PokemonPanel extends JPanel
{
	private PokemonController baseController;
	private ImageIcon pokemonIcon;
	private SpringLayout baseLayout;
	private JButton updateButton;
	private JComboBox pokedexSelector;
	private JLabel pokemonPicture;
	private JLabel healthLabel;
	private JLabel combatLabel;
	private JLabel speedLabel;
	private JLabel nameLabel;
	private JLabel numberLabel;
	private JLabel advancedLabel;
	private JTextField healthField;
	private JTextField combatField;
	private JTextField speedField;
	private JTextField nameField;
	private JTextField numberField;
	private JTextArea advancedArea;
	
	public PokemonPanel (PokemonController baseController)
	{
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		this.pokemonIcon = new ImageIcon(getClass().getResource("/poke/view/images/Pokeball.png"));
		this.updateButton = new JButton("Update the stats!");
		this.nameField = new JTextField(25);
		this.combatField = new JTextField(5);
		this.healthField = new JTextField(5);
		this.speedField = new JTextField(5);
		this.numberField = new JTextField(5);
		this.advancedArea = new JTextArea (10, 25);
		this.pokedexSelector = new JComboBox(new String [] {"Pokemon","Charizard", "Clefairy","Geodude","Onyx","Rayquaza"});
		this.advancedLabel = new JLabel("Advanced information");
		this.combatLabel = new JLabel("Combat Points:");
		this.healthLabel = new JLabel("Health Points:");
		this.speedLabel = new JLabel("Speed Rate:");
		this.numberLabel = new JLabel("Pokemon Number:");
		this.nameLabel = new JLabel("Pokemon Name:");
		this.pokemonPicture = new JLabel("Current Pokemon:", pokemonIcon, SwingConstants.CENTER);
		
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void changeColorBasedOnData(String data)
	{
		if (data.contains("Dragon"))
		{
			this.setBackground(Color.DARK_GRAY);
		}
		else if (data.contains("Fire"))
		{
			this.setBackground(Color.RED);
		}
		else if (data.contains("Flying"))
		{
			this.setBackground(Color.CYAN);
		}
		else if (data.contains("Fairy"))
		{
			this.setBackground(Color.PINK);
		}
		else if (data.contains("Ground"))
		{
			this.setBackground(Color.LIGHT_GRAY);
		}
		else if (data.contains("Rock"))
		{
			this.setBackground(Color.GRAY);
		}
	}
	
	private void changeImageDisplay(String name)
	{
		String path = "/poke/view/images/";
		String defaultName = "ultraball";
		String extension = ".png";
		try
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + name + extension));
		}
		catch (NullPointerException missingFile)
		{
			pokemonIcon = new ImageIcon(getClass().getResource(path + defaultName + extension));
		}
		pokemonPicture.setIcon(pokemonIcon);
		repaint();
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		pokemonPicture.setVerticalTextPosition(JLabel.BOTTOM);
		pokemonPicture.setHorizontalTextPosition(JLabel.CENTER);
		this.setPreferredSize(new Dimension(900, 600));
		numberField.setEditable(false);
		advancedArea.setEditable(false);
		advancedArea.setWrapStyleWord(true);
		advancedArea.setLineWrap(true);
		this.setBackground(Color.PINK);
		this.add(updateButton);
		this.add(nameField);
		this.add(combatField);
		this.add(healthField);
		this.add(speedField);
		this.add(numberField);
		this.add(advancedArea);
		this.add(pokedexSelector);
		this.add(advancedLabel);
		this.add(combatLabel);
		this.add(healthLabel);
		this.add(speedLabel);
		this.add(numberLabel);
		this.add(nameLabel);
		this.add(pokemonPicture);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, updateButton, -10, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, updateButton, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.EAST, nameField, -53, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, combatField, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, combatField, 32, SpringLayout.SOUTH, healthField);
		baseLayout.putConstraint(SpringLayout.WEST, healthField, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, speedField, 32, SpringLayout.SOUTH, combatField);
		baseLayout.putConstraint(SpringLayout.EAST, speedField, 0, SpringLayout.EAST, combatField);
		baseLayout.putConstraint(SpringLayout.SOUTH, numberField, -475, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.NORTH, healthField, 29, SpringLayout.SOUTH, numberField);
		baseLayout.putConstraint(SpringLayout.WEST, numberField, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, nameField, -2, SpringLayout.NORTH, pokedexSelector);
		baseLayout.putConstraint(SpringLayout.NORTH, pokedexSelector, 44, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, pokedexSelector, 47, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, combatLabel, -29, SpringLayout.WEST, combatField);
		baseLayout.putConstraint(SpringLayout.NORTH, combatLabel, 6, SpringLayout.NORTH, combatField);
		baseLayout.putConstraint(SpringLayout.NORTH, healthLabel, 6, SpringLayout.NORTH, healthField);
		baseLayout.putConstraint(SpringLayout.WEST, healthLabel, 0, SpringLayout.WEST, combatLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, speedLabel, 6, SpringLayout.NORTH, speedField);
		baseLayout.putConstraint(SpringLayout.WEST, speedLabel, 0, SpringLayout.WEST, combatLabel);
		baseLayout.putConstraint(SpringLayout.NORTH, numberLabel, 6, SpringLayout.NORTH, numberField);
		baseLayout.putConstraint(SpringLayout.WEST, numberLabel, 0, SpringLayout.WEST, combatLabel);
		baseLayout.putConstraint(SpringLayout.WEST, nameLabel, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.SOUTH, nameLabel, -6, SpringLayout.NORTH, nameField);
		baseLayout.putConstraint(SpringLayout.NORTH, advancedArea, 358, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, advancedArea, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.WEST, advancedLabel, 0, SpringLayout.WEST, nameField);
		baseLayout.putConstraint(SpringLayout.SOUTH, advancedLabel, -6, SpringLayout.NORTH, advancedArea);
		baseLayout.putConstraint(SpringLayout.NORTH, pokemonPicture, -185, SpringLayout.NORTH, advancedArea);
		baseLayout.putConstraint(SpringLayout.WEST, pokemonPicture, 34, SpringLayout.WEST, this);
		
	}
	
	private void setupListeners()
	{
		pokedexSelector.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent selection)
			{
				int selected = pokedexSelector.getSelectedIndex();
				nameField.setText(baseController.getPokedex().get(selected).getName());
				numberField.setText(baseController.getPokedex().get(selected).getNumber() + "");
				combatField.setText(baseController.getPokedex().get(selected).getAttackPoints() + "");
				speedField.setText(baseController.getPokedex().get(selected).getSpeed() + "");
				healthField.setText(baseController.getPokedex().get(selected).getHitPoints() + "");
				advancedArea.setText(baseController.getPokedex().get(selected).getPokemonInformation() + "\n" + baseController.getPokedex().get(selected).getPokemonTypes());
				changeColorBasedOnData(baseController.getPokedex().get(selected).getPokemonTypes());
				changeImageDisplay(baseController.getPokedex().get(selected).getClass().getSimpleName());
			}
		});
		
		updateButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				
			}
		});
		
	}
	
}
