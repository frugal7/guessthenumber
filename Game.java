import java.util.Random;
import java.util.Scanner;

class Game
{
	static int range;
	static int drawedNumber;
	static int usersNumber;
	static int usersAttempts;
	static boolean GameOver = false;
	static Scanner reader;

	public Game(int range)
	{
		this.range = range;
	}


	public static void startGame()
	{
		do
		{
			reader = new Scanner(System.in);
			Random rand = new Random();
			drawedNumber = rand.nextInt(range + 1);	
			usersAttempts = 0;
			System.out.println("\n\nHi there! I've choosen one number from 0 to " + Integer.toString(range) + ". Can you guess it?");
			getNumbersWhileSucces();	
			checkIfOver();
		}
		while(!GameOver);

		reader.close();
	}



	private static void getNumbersWhileSucces()		
	{
		System.out.print("Enter a number from 0 to " + Integer.toString(range) + ". ");

	//	usersNumber = reader.nextInt();	//zabezpieczyć !!! wywala gdy float

		getInteger();


		usersAttempts += 1;
		while(usersNumber != drawedNumber)
		{
			if(usersNumber > drawedNumber)
			{
				System.out.print("My number is lower! Try again: ");
			}
			else
			{
				System.out.print("My number is higher! Try again: ");
			}
			//usersNumber = reader.nextInt();	//zabezpieczyć !!!
			getInteger();
			usersAttempts += 1;
		}
		
		System.out.println("That's right! You've tried " + usersAttempts + " times.");
	}

	private static void checkIfOver()	
	{
		System.out.print("Do you want to play again?(y/n): ");
		reader.nextLine();
		String c = reader.next();	
		/*String c = 	reader.next();*/
		if(c.length() != 1)
		{
			checkIfOver();	
		}
		else if(c.charAt(0) == 'n')
		{
			GameOver = true;
		}
		else if(c.charAt(0) == 'y')
		{
			GameOver = false;
		}
		else
		{
			checkIfOver();
		}
	}



	private static void getInteger()
	{
		while (!reader.hasNextInt()) 
		{        
	  	  reader.next(); 
	  	  System.out.print("Please enter correct number: ");
		}
		usersNumber = reader.nextInt();
	}


}
	




//w destruktorze zamknac scanner