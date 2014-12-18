public class Root
{
	private int gameticker;
	private GameWindow gameWindow;

	public static void main(String[] args) 
	{
		new Root();
	}

	Root()
	{
		gameWindow = new GameWindow();
		game();
	}

	public void game()
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