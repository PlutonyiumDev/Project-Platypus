package model;


import java.awt.*;
import java.util.*;
import java.util.Random;

public class Enemy extends Entity
{
	private static final double DROP_CHANCE = 0.01;
	private int level;
	private int moveSpeed;
	private int lastAction;

	public Enemy(Entity e, int level, int moveSpeed)
	{
		super(e);
		this.level = level;
		this.moveSpeed = moveSpeed;
		lastAction = 0;
	}

	public void action(LinkedList<Hero> h, int time)
	{
		boolean movable = true;
		for(Hero hero: h)
		{
			if(lastAction != time && checkRange(hero.getX(), hero.getY()) && time % getAtkSpd() == 0)
			{
				attackHero(hero);
				lastAction = time;

			}
		}

		for(Hero hero: h)
		{
			if(checkRange(hero.getX(), hero.getY()))
			movable = false;
		}
			if(time%moveSpeed == 0 && movable)
				step();

	}

	public int getMoveSpeed()
	{
		return moveSpeed;
	}

	public void step()
	{
		setLocation(x-1, y);
		//System.out.println("My Location is ("+x+","+y+")");
	}

	public void attackHero(Hero h)
	{
		Random r = new Random();
		if (h.getDodge() < r.nextInt(100))
		{
			//int setAtk = getAtkDmg();
			//if (getCrit() > r.nextInt(100))
				//setAtk *= 2;
			h.takeDamage(dealDamage(h.getDefence()));
			//System.out.println("Health Remaining: "+h.getHealth());
		}
		else
		{
			System.out.println("Dodged");
		}
	}

//enemies deal minimum 1 damage

	public int dealDamage(int a)
	{
		int dmg = getAtkDmg() - a;
		if(dmg > 0)
		{
			System.out.println("Attacking for "+ dmg);
			return dmg;
		}
		else 
			{
				System.out.println("Attacking for default 1");
				return 1;
			}
	}

}