import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CrazyEightConsole
	{
		static ArrayList<Card> playerHand = new ArrayList<Card>();
		static ArrayList<Card> consoleHand = new ArrayList<Card>();
		static Object[] option =
			{ "Play", "Draw" };
		static int choice;
		static Card pile;
		static int cardPlayed;
		static int numberOfPlayers;
		static boolean player1Playing = true;
		static boolean player2Playing = false;
		static boolean playing = true;
		static int randomNum;
		static int randomNum2;
		private static final long serialVersionUID = 1L;
		static JFrame frame = new JFrame();
		static Scanner userInput = new Scanner(System.in);

		public static void main(String[] args)
			{
				Deck.fillDeck();
				Deck.shuffle();
				dealCardPlayer();
				dealCardConsole();
				initialDeal();
				gameStart();
				gamePlay();
			}

		private static void dealCardPlayer()
			{
				playerHand.add(Deck.deck.get(0));
				Deck.deck.remove(0);

				if (Deck.deck.size() == 0)
					{
						playing = false;
					}
			}

		private static void dealCardConsole()
			{
				consoleHand.add(Deck.deck.get(0));
				Deck.deck.remove(0);

				if (Deck.deck.size() == 0)
					{
						playing = false;
					}
			}

		private static void initialDeal()
			{
				for (int i = 0; i < 5; i++)
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

				if (answer1.equals("yes") || answer1.equals("Yes"))
					{
						for (int i = 0; i < Deck.deck.size(); i++)
							{
								System.out.println(Deck.deck.get(i).getRank() + " of " + Deck.deck.get(i).getSuit());
							}
					} else if (answer1.equals("no") || answer1.equals("No"))
					{
						System.out.println("ok");
					}

				System.out.println("You and player 2 have both been dealt 5 cards.");

			}

		private static void gamePlay()
			{
				
				while (playing)
					{
						System.out.println("Player1, these are your cards:");
						for (int i = 0; i < playerHand.size(); i++)
							{
								System.out.println(i + 1 + ". " + playerHand.get(i).getRank() + " of "
										+ playerHand.get(i).getSuit());
							}

						choice = JOptionPane.showOptionDialog(frame, "What would you like to do?", "Your turn",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, null);

						switch (choice)
							{
							case 0:
								{
									JOptionPane.showMessageDialog(frame,
											" Please choose a card and type the number that it in coresponds on the console.");
									cardPlayed = userInput.nextInt();

									pile = playerHand.get(cardPlayed - 1);
									playerHand.remove(cardPlayed - 1);

								}
								break;

							case 1:
								{
									dealCardPlayer();
									break;
								}

							}
						System.out.println();
						System.out.println("You played the " + pile.getRank() + " of " + pile.getSuit());
						System.out.println();
						
						///
						
						System.out.println("Player 2, these are your cards:");
						for (int i = 0; i < playerHand.size(); i++)
							{
								System.out.println(i + 1 + ". " + playerHand.get(i).getRank() + " of "
										+ playerHand.get(i).getSuit());
							}

						choice = JOptionPane.showOptionDialog(frame, "What would you like to do?", "Your turn",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, null);

						switch (choice)
							{
							case 0:
								{
									JOptionPane.showMessageDialog(frame,
											" Please choose a card and type the number that it in coresponds on the console.");
									cardPlayed = userInput.nextInt();

									pile = playerHand.get(cardPlayed - 1);
									playerHand.remove(cardPlayed - 1);

								}
								break;

							case 1:
								{
									dealCardPlayer();
									break;
								}

							}
						System.out.println();
						System.out.println("You played the " + pile.getRank() + " of " + pile.getSuit());
						System.out.println();

					}
			}

	}
