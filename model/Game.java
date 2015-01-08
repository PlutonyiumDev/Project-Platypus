package model;

import java.util.*;

public class Game
{
	private Hero o;
	private int gameTimer;
	private LinkedList<Hero> heroes = new LinkedList<Hero>();
	private LinkedList<Entity> enemies = new LinkedList<Entity>();
	private boolean start;

	public Game()
	{
		start = false;
		gameTimer = 0;
		heroes.add(new Hero(10, 5, 4, 3, 0, 0, "Sam", 3, 20, 3));
		heroes.add(new Hero(10, 7, 4, 3, 0, 0, "Nick", 3, 20, 3));
		heroes.add(new Hero(10, 5, 4, 3, 0, 0, "Chris", 3, 20, 3));
		enemies.add(new Entity(1,1,1,1,1,1));

		for (int i = 0; i < heroes.size(); i++)
		{
			heroes.get(i).setCoordinates(i, 3);
		}

		for(Entity e: enemies)
		{
			e.setCoordinates(19,3);
		}
	}

	public void tick()
	{
		if(start)
			{
			gameTimer++;
			System.out.println("Time is "+ gameTimer +"ms");
			for(Entity e: enemies)
			{
				e.step();
			}
		}
	}

	public void changeState(boolean b)
	{
		start = b;
	}

	public LinkedList<Hero> getHeroes()
	{
	return heroes;
	}

	public LinkedList<Entity> getEnemies()
	{
		return enemies;
	}

	public int getTime()
	{
		return gameTimer;
	}

}