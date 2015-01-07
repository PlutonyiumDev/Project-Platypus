package model;

public class Enemy extends Entity
{
	private static final double DROP_CHANCE = 0.01;
	private int level;

	public Enemy(Entity e, int level)
	{
		super(e);
		this.level = level;
	}


}