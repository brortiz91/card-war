public class War
{
	public static void main(String[] args)
	{
		final int CARDS_IN_DECK = 52;
		final int CARDS_EACH = CARDS_IN_DECK / 2;
		Card[] cards = new Card[CARDS_IN_DECK];
		
		//creation of a player card
		Card playerCard = new Card();
		//creation of a computer card
		Card computerCard = new Card();
		
		//create a deck for the game
		createDeck(cards, CARDS_IN_DECK);
		
		//counter variables
		int x;
		int y;
		
		//game mechanics
		int playerCardNum;
		int computerCardNum;
		int playerWins = 0;
		int computerWins = 0;
		int ties = 0;
		int cardsLeft = CARDS_IN_DECK;
		
		//gameplay
		for (x = 0; x < CARDS_EACH; ++x)
		{
			playerCardNum = ((int)(Math.random() * 100) % cardsLeft);
			playerCard.setSuit(cards[playerCardNum].getSuit());
			playerCard.setValue(cards[playerCardNum].getValue());
			for(y = playerCardNum; y < cardsLeft -1; ++y)
				cards[y] = cards[y + 1];
			--cardsLeft;
			
			//computer's turn
			computerCardNum = ((int)(Math.random() * 100) % cardsLeft);
			computerCard.setSuit(cards[computerCardNum].getSuit());
			computerCard.setValue(cards[computerCardNum].getValue());
			for(y = computerCardNum; y < cardsLeft -1; ++y)
				cards[y] = cards[y + 1];
			--cardsLeft;
			
			System.out.println("Player has " + playerCard.getRank() + " of " + playerCard.getSuit() + " Computer has " + computerCard.getRank() + " of " + computerCard.getSuit());
			
			//determining the winner
			if(playerCard.getValue() == computerCard.getValue())
			{
				System.out.println("WELP! WE GOT A FREAKIN' TIE!");
				++ties;
			}
			else
			{
				if(playerCard.getValue() > computerCard.getValue())
				{
					System.out.println("Computer: ALL RIGHT ALREADY! YOU WIN! NOW GET OUT OF MY SIGHT!");
					System.out.println();
					++playerWins;
				}
				else
				{
					System.out.println("Computer: YEEEAH!! I WON!");
					System.out.println();
					++computerWins;
				}
			}
		}
		System.out.println("Final Summary of Match:");
		System.out.println("# of Player wins: " + playerWins);
		System.out.println("# of Computer wins: " + computerWins);
		System.out.println("# of FREAKIN' TIES: " + ties);
		if(playerWins > computerWins)
			System.out.println("YOU HAVE DISMANTLED SKYNET! YOU GET TO LIVE YOUR LIFE!");
		else
			if(playerWins < computerWins)
				System.out.println("Uh-oh.... SKYNET IS TAKING OVER! ROBOTS ARE GONNA RULE THE FREAKIN' WORLD!");
			else
				System.out.println("WELP! WE GOT A GIGANTIC FREAKIN' TIE!");
		
	}
	public static void createDeck(Card[] c, int deck)
	{
		final int HIGH_VAL = 13;
		final int LOW_VAL = 1;
		final int HIGH_SUIT = 4;
		int x;
		int suit = 1;
		int value = 1;
		
		for(x = 0; x < deck; ++x)
		{
			c[x] = new Card();
			if(suit == 1)
				c[x].setSuit("Spades");
			else
				if(suit == 2)
					c[x].setSuit("Hearts");
				else	
					if(suit == 3)
						c[x].setSuit("Diamonds");
					else
						c[x].setSuit("Clubs");
			c[x].setValue(value);
			++value;
			
			if(value > HIGH_VAL)
			{
				++suit;
				value = 1;
			}
		}
	}
}