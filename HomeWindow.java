import model.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;

public class HomeWindow extends JFrame
{
	private Game game;
	private LinkedList<Hero> heroes = new LinkedList<Hero>();

	HomeWindow(Game game)
	{
		heroes = game.getHeroes();
		this.game = game;
		setup();
		build();
		setSize(200,600);
	}

	public void setup()
	{
		setLocation(1000,0);
        setVisible(true);
	}

	public void build()
	{
		add(new HomePanel());
	}


	private class HomePanel extends JPanel
	{
		LinkedList<Box> boxes = new LinkedList<Box>();


	HomePanel()
	{
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
		for(int i = 0; i < heroes.size(); i++)
		{
			boxes.add( Box.createVerticalBox());
			boxes.get(i).add(new JLabel(heroes.get(i).getName()));
		}

		Box portrait = Box.createVerticalBox();
		for(Box box: boxes)
		{
			portrait.add(box);
		}
		add(portrait);
	}

	}
}