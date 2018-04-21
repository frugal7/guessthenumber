

class GuessTheNumberGame
{
	public static void main(String[] args)
	{
		if(args.length != 1)
		{
			System.out.println("This program must take exactly 1 argument");
		}
		else
		{
			try
			{
				int range = Integer.parseInt(args[0]);
				Game newGame = new Game(range);
				newGame.startGame();
			}
			catch(NumberFormatException e)
			{
				System.out.println("Argument is not a number!");
			}
			catch(IllegalArgumentException e)
			{
				System.out.println("Argument musn't be a negative number!");
			}
		}

		

	}
}