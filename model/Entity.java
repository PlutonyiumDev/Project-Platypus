package model;

import javax.swing.*;
import java.awt.*;

public class Entity
{
	private int health;
	private int defence;
	private int atkDmg;
	private int atkSpd;
	private float dodge;
	private float crit;
	private Point coordinates;

	public Entity()
	{

	}
	public Entity(int health, int defence, int atkDmg, int atkSpd, float dodge, float crit)
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
		e.health -= atkDmg - e.defence * 0.125;
	}
}