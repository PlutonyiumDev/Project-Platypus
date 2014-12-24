package model;

import java.util.*;

public class Game
{
	private int gameTimer;
	private LinkedList<Hero> heros = new LinkedList<Hero>();

	public Game()
	{
		gameTimer = 0;
		heros.add(new Hero(10, 5, 4, 3, 0, 0, "Sam", 3, 20, 3));
		heros.add(new Hero(10, 7, 4, 3, 0, 0, "Nick", 3, 20, 3));
		heros.add(new Hero(10, 5, 4, 3, 0, 0, "Chris", 3, 20, 3));
		for (int i = 0; i < heros.size(); i++)
		{
			heros.get(i).setCoordinates(i + 1, 3);
		}
	}

	public void tick()
	{
		gameTimer++;
	}

	public int getTime()
	{
		return gameTimer;
	}

}