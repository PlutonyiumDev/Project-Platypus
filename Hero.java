public class Hero extends Entity
{
	private int healthRegen;
	private int stamina;
	private int staminaRegen;

	public Hero(Entity e, int healthRegen, int stamina, int staminaRegen)
	{
		super(e);
		this.healthRegen = healthRegen;
		this.stamina = stamina;
		this.staminaRegen = staminaRegen;
	}
}