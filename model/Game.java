package model;

import java.util.*;

public class Game extends Viewable
{
	private Hero o;
	private int gameTimer;
	private LinkedList<Hero> heroes = new LinkedList<Hero>();
	private LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	private boolean start;
	private int gold = 0;

	public Game()
	{
		start = false;
		gameTimer = 0;
		heroes.add(new Hero(10, 5, 4, 3, 0, 0, "Sam", 3, 20, 3));
		heroes.add(new Hero(10, 7, 4, 3, 0, 0, "Nick", 3, 20, 3));
		heroes.add(new Hero(10, 5, 4, 3, 0, 0, "Chris", 3, 20, 3));
		enemies.add(new Enemy(new Entity(1,1,1,1,1,1),1));

		for (int i = 0; i < heroes.size(); i++)
		{
			heroes.get(i).setCoordinates(i, 3);
		}

		for(Enemy e: enemies)
		{
			e.setCoordinates(6,3);
		}
	}

	public void tick()
	{
		if(start)
		{
			gameTimer++;
			System.out.println("Time is "+ gameTimer +"ms");
			for(Enemy e: enemies)
			{
				boolean attacked = false;
				
				for(Hero h: heroes)
				{
					
					if(e.action(h))
					{
						System.out.println("Attacking");
						//attacked = true;
					}
					
				}
				

				if(!attacked)
				{
					e.step();
				}
			}
			gold++;
			update();
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

	public LinkedList<Enemy> getEnemies()
	{
		return enemies;
	}

	public int getTime()
	{
		return gameTimer;
	}

	public int getGold()
	{
		return gold;
	}

}