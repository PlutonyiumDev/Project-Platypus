package model;


import java.awt.*;
import java.util.*;
import java.util.Random;

public class Enemy extends Entity
{
	private static final double DROP_CHANCE = 0.01;
	private int level;

	public Enemy(Entity e, int level)
	{
		super(e);
		this.level = level;
	}

	public boolean action(Hero h)
	{
		if(checkRange(h.getX(), h.getY()))
		{
			attackHero(h);
			return true;
		}
		return false;
			
	}

	public void step()
	{
		setLocation(x-1, y);
		System.out.println("My Location is ("+x+","+y+")");
	}

	public void attackHero(Hero h)
	{
	  	System.out.println(h.getName() + "Health: " + h.getHealth());
		Random r = new Random();
		if (h.getDodge() < r.nextInt(100))
		{
			int setAtk = getAtkDmg();
			if (getCrit() > r.nextInt(100))
				setAtk *= 2;
			h.setHealth(setAtk - h.getDefence());
			System.out.println("Attacked for "+ getAtkDmg());
			System.out.println("Health Remaining: "+h.getHealth());
		}
	}

}