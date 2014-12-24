package model;

public class Game
{
	private Hero o;
	private int gameTimer;

	public Game()
	{
		gameTimer = 0;
	}

	public void tick()
	{
		gameTimer++;
	}

	public int getTime()
	{
		return gameTimer;
	}

}