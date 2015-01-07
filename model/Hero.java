package model;

import java.util.*;
import javax.swing.table.*;
import java.awt.*;
import javax.swing.*;

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
		this.healthRegen = healthRegen;
		this.stamina = stamina;
		this.staminaRegen = staminaRegen;
	}

	public Hero(int health, int defence, int atkDmg, int atkSpd, int dodge, int crit, String name, int healthRegen, int stamina, int staminaRegen)
	{
		this(new Entity(health, defence, atkDmg, atkSpd, dodge, crit), name, healthRegen, stamina, staminaRegen);
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
				case 0: return "name"; break;
				case 1:	return "health"; break;
				case 2:	return "defence"; break;
				case 3:	return "atkDmg"; break;
				case 4: return "atkSpd"; break;
				case 5:	return "dodge"; break;
				case 6: return "crit"; break;
				case 7: return "healthRegen"; break;
				case 8:	return "Stamina"; break;
				case 9: return "staminaRegen"; break;
				}
			}
			else if(col == 1)
			{
				switch(row)
				{
				case 0: return name; break;
				case 1:	return this.getHealth(); break;
				case 2:	return this.getDefence(); break;
				case 3:	return this.getAtkDmg(); break;
				case 4: return this.getAtkSpd(); break;
				case 5:	return this.getDodge(); break;
				case 6: return this.getCrit(); break;
				case 7: return healthRegen; break;
				case 8:	return stamina; break;
				case 9: return staminaRegen; break;
				}
			}
			else return "";	
		}

 }
}