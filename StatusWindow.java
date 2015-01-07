import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;

public class StatusWindow extends JFrame
{
	private Game game;
	private LinkedList<Hero> heroes = new LinkedList<Hero>();
	private LinkedList<Entity> enemies = new LinkedList<Entity>();
	StatusWindow(Game g)
	{
		game = g;
		setup();
		build();
		pack();
		enemies = game.getEnemies();
		heroes = game.getHeroes();
	}

	private void setup()
	{
		setLocation(600,650);
        setVisible(true);
	}

	private void build()
	{
		add(new StatusPanel());
	}


	private class StatusPanel extends JPanel
	{
		JTable hero1;
		JTable hero2;
		JTable hero3;
		StatusPanel()
		{
			setVisible(true);
			for(Hero h : heroes)
			{
				if(hero1 == null)
				{
					hero1 = h.heroTable();
				}
				else if(hero2 == null)
				{
					hero2 = h.heroTable();
				}
				else if(hero3 == null)
				{
					hero3 = h.heroTable();
				}
				else System.out.println("Error");
			}
			setup();
			build();
		}

		public void setup()
		{
			setLayout(new FlowLayout());
			setVisible(true);
		}

		public void build()
		{
			add(hero1);
			add(hero2);
			add(hero3);
		}
	}
}

