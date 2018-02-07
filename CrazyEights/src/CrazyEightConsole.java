import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CrazyEightConsole
	{
		static ArrayList<Card> deck = new ArrayList<Card>();
		static ArrayList<Card> playerHand = new ArrayList<Card>();
		static ArrayList<Card> consoleHand = new ArrayList<Card>();
		static Card pile;
		static int numberOfPlayers;
		static boolean playing = true;
		static int randomNum;
		static int randomNum2;
		private static final long serialVersionUID = 1L;
		static JFrame frame = new JFrame();
		static Scanner userInput = new Scanner(System.in);
		
		public static void main(String[] args)
			{
				fillDeck();
				shuffle();
				dealCardPlayer();
				dealCardConsole();
				initialDeal();
				gameStart();
				gamePlay();
			}

		public static void fillDeck()
			{
			deck.add(new Card("king", "hearts", 13));
			deck.add(new Card("king", "clubs", 13));
			deck.add(new Card("king", "spades", 13));
			deck.add(new Card("king", "diamonds", 13));
			deck.add(new Card("queen", "hearts", 12));
			deck.add(new Card("queen", "clubs", 12));
			deck.add(new Card("queen", "spades", 12));
			deck.add(new Card("queen", "diamonds", 12));
			deck.add(new Card("jack", "hearts", 11));
			deck.add(new Card("jack", "clubs", 11));
			deck.add(new Card("jack", "spades", 11));
			deck.add(new Card("jack", "diamonds", 11));
			deck.add(new Card("ten", "hearts", 10));
			deck.add(new Card("ten", "clubs", 10));
			deck.add(new Card("ten", "spades", 10));
			deck.add(new Card("ten", "diamonds", 10));
			deck.add(new Card("nine", "hearts", 9));
			deck.add(new Card("nine", "clubs", 9));
			deck.add(new Card("nine", "spades", 9));
			deck.add(new Card("nine", "diamonds", 9));
			deck.add(new Card("eight", "hearts", 8));
			deck.add(new Card("eight", "clubs", 8));
			deck.add(new Card("eight", "spades", 8));
			deck.add(new Card("eight", "diamonds", 8));
			deck.add(new Card("seven", "hearts", 7));
			deck.add(new Card("seven", "clubs", 7));
			deck.add(new Card("seven", "spades", 7));
			deck.add(new Card("seven", "diamonds", 7));
			deck.add(new Card("six", "hearts", 6));
			deck.add(new Card("six", "clubs", 6));
			deck.add(new Card("six", "spades", 6));
			deck.add(new Card("six", "diamonds", 6));
			deck.add(new Card("five", "hearts", 5));
			deck.add(new Card("five", "clubs", 5));
			deck.add(new Card("five", "spades", 5));
			deck.add(new Card("five", "diamonds", 5));
			deck.add(new Card("four", "hearts", 4));
			deck.add(new Card("four", "clubs", 4));
			deck.add(new Card("four", "spades", 4));
			deck.add(new Card("four", "diamonds", 4));
			deck.add(new Card("three", "hearts", 3));
			deck.add(new Card("three", "clubs", 3));
			deck.add(new Card("three", "spades", 3));
			deck.add(new Card("three", "diamonds", 3));
			deck.add(new Card("two", "hearts", 2));
			deck.add(new Card("two", "clubs", 2));
			deck.add(new Card("two", "spades", 2));
			deck.add(new Card("two", "diamonds", 2));
			deck.add(new Card("ace", "hearts", 1));
			deck.add(new Card("ace", "clubs", 1));
			deck.add(new Card("ace", "spades", 1));
			deck.add(new Card("ace", "diamonds", 1));
			}
		
		public static void shuffle()
			{
			Collections.shuffle(deck);
			}
		
		private static void dealCardPlayer()
			{
				playerHand.add(deck.get(0));
				deck.remove(0);
			}
		
		private static void dealCardConsole()
			{
				consoleHand.add(deck.get(0));
				deck.remove(0);
				
			}
		
		private static void initialDeal()
			{
				for(int i = 0; i < 5; i++)
					{
						dealCardPlayer();
						dealCardConsole();
					}
				
			}

		public static void gameStart()
			{
				System.out.println("Welcome to Crazy Eights");
				System.out.println("Would you like to check the deck?");
				String answer1 = userInput.nextLine();
				
				if(answer1.equals("yes") || answer1.equals("Yes"))
					{
						for(int i = 0; i < deck.size();i++)
							{
								System.out.println(deck.get(i).getRank() + " of " + deck.get(i).getSuit());
							}
					}
				else if(answer1.equals("no") || answer1.equals("No"))
					{
						System.out.println("ok");
					}
				
				System.out.println("You and the dealer have both been dealt 5 cards.");
				
			}
		
		private static void gamePlay()
			{
				playing = true;
				
				while(playing)
					{
				pile = JOptionPane.showOptionDialog(frame, "What would you like to do?",
						"Your turn",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE,
						null, playerHand, null);
					}
			}

	}
