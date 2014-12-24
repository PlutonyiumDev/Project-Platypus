package model;

 

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Entity
{
	private int health;
	private int defence;
	private int atkDmg;
	private int atkSpd;
	private int dodge;
	private int crit;
	
	private Point coordinates;

	public Entity()
	{

	}
	public Entity(int health, int defence, int atkDmg, int atkSpd, int dodge, int crit)
	{
		this.health = health;
		this.defence = defence;
		this.atkDmg = atkDmg;
		this.atkSpd = atkSpd;
		this.dodge = dodge;
		this.crit = crit;
		coordinates = new Point();
	}

	public Entity(Entity e)
	{
		this(e.health, e.defence, e.atkDmg, e.atkSpd, e.dodge, e.crit);
	}

	public void setCoordinates(int x, int y)
	{
		coordinates.setLocation(x, y);
	}

	public void paintComponent(Graphics g)
	{
			int dx = (int)coordinates.getX();
			int dy = (int)coordinates.getY();
			g.setColor(Color.RED);
        	g.fillRect(dx, dy, 30, 30);
       		g.setColor(Color.BLACK);
       		g.drawRect(dx, dy, 30, 30);
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