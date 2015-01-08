//package model;

import java.util.*;

public class Item
{
	private int itemID;
	private String name;	
	private int weight;
	//"health", "defence","atkDmg", "atkSpd", "dodge", "crit", "healthRegen", "Stamina", "staminaRegen"
	private Hashtable<String, Integer> stats = new Hashtable<String, Integer>();
	public Item(int itemID, String name, int weight)
	{
		this.itemID = itemID;
		this.name = name;
		this.weight = weight;
	}
	public void setStats(Hashtable<String, Integer> stats)
	{
		this.stats = stats;
	}
	public Integer returnStat(String s)
	{
		Set<String> keys = stats.keySet();
		for (String key : keys)
		{
			if (key.equals(s))
				return stats.get(key);
		}
		return 0;
	}

	public void outputData()
	{
		System.out.println("" + itemID + " " + name + " " + weight);
		System.out.println(stats.toString());
	}
}