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
	
	public void setHealth(int i)
	{
		health = i;
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

	public void setHealth(int health)
	{
		this.health = health;
	}

	public void setDefence(int defence)
	{
		this.defence = defence;
	}
	public void setAtkDmg(int atkDmg)
	{
		this.atkDmg = atkDmg;
	}
	public void setAtkSpd(int atkSpd)
	{
		this.atkSpd = atkSpd;
	}

	public void setDodge(int dodge)
	{
		this.dodge = dodge;
	}

	public void setCrit(int crit)
	{
		this.crit = crit;
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


	
	public boolean checkRange(double x, double y)
	{
		int rangeX = (int)this.getX() -  (int)x;
		int rangeY = (int)this.getY() - (int)y;
		return (Math.abs(rangeX) + Math.abs(rangeY)) <= range;
	}
}