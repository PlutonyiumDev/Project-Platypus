import java.util.*;

public class Hero extends Entity
{
	private String name;
	private int healthRegen;
	private int stamina;
	private int staminaRegen;

	private LinkedList<Item> inventory = new LinkedList<Item>();

	public Hero(Entity e, String name, int healthRegen, int stamina, int staminaRegen)
	{
		super(e);
		this.healthRegen = healthRegen;
		this.stamina = stamina;
		this.staminaRegen = staminaRegen;
	}

	public Hero(int health, int defence, int atkDmg, int atkSpd, float dodge, float crit, String name, int healthRegen, int stamina, int staminaRegen)
	{
		this(new Entity(health, defence, atkDmg, atkSpd, dodge, crit), name, healthRegen, stamina, staminaRegen);
	}
}