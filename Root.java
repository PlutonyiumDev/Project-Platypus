import model.*;

public class Root
{
	private Game game;
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
		while(winCheck())
		{
			try{
			game.tick();
			gameWindow.update();
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