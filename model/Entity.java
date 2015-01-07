package model;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Entity extends Point
{
	private int health;
	private int defence;
	private int atkDmg;
	private int atkSpd;
	private int dodge;
	private int crit;

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
	}

	public Entity(Entity e)
	{
		this(e.health, e.defence, e.atkDmg, e.atkSpd, e.dodge, e.crit);
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
	public void attack(Entity e)
	{
		Random r = new Random();
		if (e.dodge < r.nextInt(100))
		{
			int setAtk = atkDmg;
			if (crit > r.nextInt(100))
				setAtk *= 2;
			e.health -= setAtk - e.defence * 0.125;
		}
	}
}