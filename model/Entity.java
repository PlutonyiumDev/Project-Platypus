package model;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Entity extends Point
{
	//0 = weapon
	private LinkedList<Item> equipment = new LinkedList<Item>();
	private int health;
	private int defence;
	private int atkDmg;
	private int atkSpd;
	private int dodge;
	private int crit;
	private int range;

	public Entity()
	{

	}
	public Entity(int health, int defence, int atkDmg, int atkSpd, int dodge, int crit)
	{
		super();
		this.health = health;
		this.defence = defence;
		this.atkDmg = atkDmg;
		this.atkSpd = atkSpd;
		this.dodge = dodge;
		this.crit = crit;
		range = 1;		
	}

	public Entity(Entity e)
	{
		this(e.health, e.defence, e.atkDmg, e.atkSpd, e.dodge, e.crit);
	}

	public int getHealth()
	{
		return health;
	}

	public int getDefence()
	{
		return defence;
	}
	public int getAtkDmg()
	{
		return atkDmg;
	}
	public int getAtkSpd()
	{
		return atkSpd;
	}

	public int getDodge()
	{
		return dodge;
	}

	public int getCrit()
	{
		return crit;
	}

	public void setCoordinates(int x, int y)
	{
		setLocation(x, y);
	}

	public void paintComponent(Graphics g)
	{
			g.setColor(Color.RED);
			g.drawOval(x * 30, y * 30, 30, 30);
        	g.fillOval(x * 30, y * 30, 30, 30);
       		g.setColor(Color.BLACK);
       		
	}
/*
	public void attack(Entity e)
	{
		Random r = new Random();
		if (e.dodge < r.nextInt(100))
		{
			int setAtk = atkDmg;
			if (crit > r.nextInt(100))
				setAtk *= 2;
			e.health -= setAtk - e.defence * 0.125;
			System.out.println("Attacked for "+ atkDmg);
			system.out.println("Health Remaining: "+e.health);
		}
	}
	*/



	public boolean checkRange(Entity e)
	{
		int rangeX = (int)this.getX() -  (int)e.getX();
		int rangeY = (int)this.getY() - (int)e.getY();
		System.out.println("Detected entity");
		return (Math.abs(rangeX) + Math.abs(rangeY)) <= range;
	}
	
	
}