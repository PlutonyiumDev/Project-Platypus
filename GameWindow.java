import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class GameWindow extends JFrame
{
	GameWindow()
	{
		setup();
		build();
	}

	private void setup()
	{
		setLayout(new FlowLayout());
		setLocation(300,200);
        setTitle("Game Window");
        setSize(600, 300);
        setVisible(true);
	}

	private void build()
	{
		add(new GamePanel());
	}

	private class GamePanel extends JPanel
	{
		private JTextField timer = new JTextField(10);
		GamePanel()
		{
			setup();
			build();
		}


		private void setup()
		{
			setVisible(true);
		}

		private void build()
		{
			add(timer);
		}
	}

}
