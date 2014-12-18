import model.*;

public class Root
{
	private Game game;
	private int gameticker;
	private GameWindow gameWindow;

	public static void main(String[] args) 
	{
		new Root();
	}

	Root()
	{
		game = new Game();
		gameWindow = new GameWindow(game);
		start();
	}

	public void start()
	{
		gameticker = 0;
		while(winCheck())
		{
			gameticker++;
			gameWindow.update();
		}
	}

	public boolean winCheck()
	{
		return true;
	}
}