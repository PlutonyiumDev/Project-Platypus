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
<<<<<<< HEAD
		System.out.println("Attacking2");
			if(checkRange(h.getX(), h.getY()))
=======
			/*if(checkRange(h.getX(), h.getY()))
			{
				//System.out.println("Attacking2");
>>>>>>> parent of b264501... Attack bug fixed (somehow)
				attackHero(h);
				return true;
			}*/
			return false;
			
	}

	public void step()
	{
		setLocation(x-1, y);
		System.out.println("My Location is ("+x+","+y+")");
	}

	public void attackHero(Hero h)
	{
		
		Random r = new Random();
		if (h.getDodge() < r.nextInt(100))
		{
			int setAtk = getAtkDmg();
			if (h.getCrit() > r.nextInt(100))
				setAtk *= 2;
			h.setHealth(setAtk - h.getDefence());
			System.out.println("Attacked for "+ h.getAtkDmg());
			System.out.println("Health Remaining: "+h.getHealth());
		}
	}
}