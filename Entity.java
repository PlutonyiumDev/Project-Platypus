public class Root
{
	public static void main(String[] args) {
		new Entity();
	}
}

public class Entity
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
}