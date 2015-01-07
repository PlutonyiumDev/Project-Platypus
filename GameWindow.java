import model.*;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class GameWindow extends JFrame
{

	private final int BOX_HEIGHT = 30;
    private final int BOX_WIDTH = 30;
    private final int GRID_WIDTH = 20;
    private final int GRID_HEIGHT = 6;
    private Graphics dbg;
    private Image dbImage;

	Game game;
	GamePanel mainPanel;
	GameWindow(Game g)
	{
		game = g;
		setup();
		build();
		pack();
	}

	private void setup()
	{
		setLayout(new FlowLayout());
		setLocation(300,200);
        setTitle("Game Window");
        setSize(BOX_WIDTH * GRID_WIDTH + 1, BOX_HEIGHT * GRID_HEIGHT + 1);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	private void build()
	{
		mainPanel = new GamePanel();
		add(mainPanel);
	}

	private class GamePanel extends JPanel
	{
		private JTextField timer = new JTextField(10);

		GamePanel()
		{
			setVisible(true);
		}

		public void update()
		{
			timer.setText("" + game.getTime());
		}
		
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			drawGrid(g);
			LinkedList<Hero> heroes = game.getHeroes();
			for(Hero h: heroes)
			{
				h.paintComponent(g);
				h.shoutCoordinate();
			}
		}

		@Override
		public Dimension getPreferredSize()
		{
			return new Dimension(BOX_WIDTH * GRID_WIDTH + 1, BOX_HEIGHT * GRID_HEIGHT + 1);
		}

		public void drawGrid(Graphics g)
   		{
	        g.drawRect(0, 0, GRID_WIDTH * BOX_WIDTH, GRID_HEIGHT * BOX_HEIGHT);
	        for (int x = BOX_WIDTH; x < GRID_WIDTH * BOX_WIDTH; x+=BOX_WIDTH){
	            g.drawLine(x,0,x,BOX_HEIGHT * GRID_HEIGHT);
	        }
	        for (int y = BOX_HEIGHT; y < GRID_HEIGHT * BOX_HEIGHT; y+=BOX_HEIGHT)
	        {
	            g.drawLine(0,y,GRID_WIDTH * BOX_WIDTH, y);
        }

    	
	}
	
}
}
