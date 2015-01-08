import model.*;

public class Root
{
	private Game game;
	private GameWindow gameWindow;
	private StatusWindow statusWindow;
	private HomeWindow homeWindow;

	public static void main(String[] args) 
	{
		new Root();
	}

	Root()
	{
		game = new Game();
		gameWindow = new GameWindow(game);
		statusWindow = new StatusWindow(game);
		homeWindow = new HomeWindow(game);

		start();
	}

	public void start()
	{
		while(winCheck())
		{
			try{
			game.tick();
			Thread.sleep(1000);
		}
		catch(InterruptedException e){
			System.out.println("Interrupted");
		}
		}
	}



	public boolean winCheck()
	{
		return true;
	}
}