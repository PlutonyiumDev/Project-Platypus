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
		LinkedList<JTable> heroTables = new LinkedList<JTable>();
		StatusPanel()
		{
			setVisible(true);
			for(Hero h : heroes)
			{
				heroTables.add(h.heroTable());
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
			for (JTable table : heroTables)
				add(table);
		}
	}
}

