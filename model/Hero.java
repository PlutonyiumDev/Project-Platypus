package model;

import java.util.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.*;
import java.util.Random;

public class Hero extends Entity
{
	private String name;
	private int healthRegen;
	private int stamina;
	private int staminaRegen;
	private JTable data;
	private LinkedList<Item> inventory = new LinkedList<Item>();

	public Hero(Entity e, String name, int healthRegen, int stamina, int staminaRegen)
	{
		super(e);
		this.name = name;
		this.healthRegen = healthRegen;
		this.stamina = stamina;
		this.staminaRegen = staminaRegen;
	}

	public Hero(int health, int defence, int atkDmg, int atkSpd, int dodge, int crit, String name, int healthRegen, int stamina, int staminaRegen)
	{
		this(new Entity(health, defence, atkDmg, atkSpd, dodge, crit), name, healthRegen, stamina, staminaRegen);
	}

	public void attack(Enemy e)
	{
		Random r = new Random();
		if (e.getDodge() < r.nextInt(100))
		{
			//int setAtk = getAtkDmg();
			//if (getCrit() > r.nextInt(100))
				//setAtk *= 2;
			e.takeDamage(dealDamage(e.getDefence()));
			//System.out.println("Health Remaining: "+h.getHealth());
		}
		else
		{
			System.out.println("Dodged");
		}
	}

	public void action(LinkedList<Enemy> e, int time)
	{
		boolean attacked = false;
		for(Enemy enemy: e)
		{
			if(checkRange(enemy.getX(), enemy.getY()))
			{
				if(!attacked && time % getAtkSpd() == 0)
					attack(enemy);
			
		}
	}
}

	public int dealDamage(int a)
	{
		int dmg = getAtkDmg() - a;
		if(dmg > 0)
		{
			System.out.println(getName() + " Attacking for "+ dmg);
			return dmg;
		}
		else 
			{
				System.out.println("Attacking for default 1");
				return 1;
			}
	}

	public String getName()
	{
		return name;
	}

	public int getHealthRegen()
	{
		return healthRegen;
	}

	public int getStamina()
	{
		return stamina;
	}

	public int getStaminaRegen()
	{
		return staminaRegen;
	}

	public JTable heroTable()
    {
    	HeroTable temp = new HeroTable();
        data = new JTable(temp);
        return data;
    }

	private class HeroTable extends AbstractTableModel
	{
		private final String[] headers = {"Stat", "Number"};
		 public String getColumnName(int col)
          { return headers[col];}

		public int getRowCount()
		{
			return 10;
		}

		public int getColumnCount()
		{
			return 2;
		}
		public Object getValueAt(int row, int col)
		{
			if(col == 0)
			{
				switch(row)
				{
				case 0: return "name";
				case 1:	return "health"; 
				case 2:	return "defence";
				case 3:	return "atkDmg"; 
				case 4: return "atkSpd"; 
				case 5:	return "dodge"; 
				case 6: return "crit"; 
				case 7: return "healthRegen"; 
				case 8:	return "Stamina";
				case 9: return "staminaRegen"; 
				default: return "error";
				}
			}
			else if(col == 1)
			{
				switch(row)
				{
				case 0: return getName(); 
				case 1:	return getHealth(); 
				case 2:	return getDefence(); 
				case 3:	return getAtkDmg(); 
				case 4: return getAtkSpd(); 
				case 5:	return getDodge(); 
				case 6: return getCrit();
				case 7: return healthRegen; 
				case 8:	return stamina; 
				case 9: return staminaRegen; 
				default: return 0;
				}
			}
			else return "error";	
		}

 }
}