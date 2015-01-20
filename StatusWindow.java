import model.*;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;

public class StatusWindow extends JFrame
{
	private Game game;
	private LinkedList<Hero> heroes = new LinkedList<Hero>();
	private LinkedList<Enemy> enemies = new LinkedList<Enemy>();
	StatusWindow(Game g)
	{
		game = g;
		enemies = game.getEnemies();
		heroes = game.getHeroes();
		setup();
		build();
		pack();
	}

	private void setup()
	{
		setLocation(0,0);
        setVisible(true);
	}

	private void build()
	{
		add(new StatusPanel());
	}


	private class StatusPanel extends JPanel implements View
	{
		LinkedList<JTable> heroTables = new LinkedList<JTable>();
		StatusPanel()
		{
			game.attach(this);
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

		public void update()
		{
			repaint();
		}
	}
}

