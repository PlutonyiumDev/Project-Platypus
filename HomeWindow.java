import model.*;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.*;

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
		JButton start = new JButton("Start");
		JButton surrender = new JButton("Surrender");


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
		Listener listener = new Listener();
		start.addActionListener(listener);
		surrender.addActionListener(listener);
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

		Box status = Box.createHorizontalBox();
		status.add(start);
		status.add(surrender);
		portrait.add(status);
		add(portrait);
	}

	 private class Listener implements ActionListener
        {
            public void actionPerformed(ActionEvent e)
            {
            	if(e.getActionCommand().equals("Start"))
            	{
            		game.changeState(true);
            		System.out.println("You have started the dungeon");
            	}
            	else if(e.getActionCommand().equals("Surrender"))
            	{
            		game.changeState(false);
            		System.out.println("You have surrendered");
            	}
            }
        }    

	}
}