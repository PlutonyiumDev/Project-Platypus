
public class Game
{
	private int gameTimer;

	Game()
	{
		gameTimer = 0;
	}

	private void tick()
	{
		gameTimer++;
	}

	private int getTick()
	{
		return gameTimer;
	}

}