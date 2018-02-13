import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CrazyEightConsole
	{
		static ArrayList<Card> playerHand = new ArrayList<Card>();
		static ArrayList<Card> player2Hand = new ArrayList<Card>();
		static Object[] option =
			{ "Play", "Draw" };
		static int choice1;
		static int choice2;
		static boolean settingCard1;
		static boolean settingCard2;
		static Card pile;
		static int cardPlayed1;
		static int cardPlayed2;
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

		private static void dealCardPlayer2()
			{
				player2Hand.add(Deck.deck.get(0));
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
						dealCardPlayer2();

						System.out.println(Deck.deck.size());
					}

			}

		public static void gameStart()
			{
				System.out.println("Welcome to Crazy Eights");
				System.out.println("Would you like to check the deck?");
				String answer1 = userInput.nextLine();
				System.out.println();

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
				System.out.println();
				System.out.println("You and player 2 have both been dealt 5 cards.");

			}

		private static void gamePlay()
			{

				while (playing)
					{
						System.out.println("Player 1, these are your cards:");
						for (int i = 0; i < playerHand.size(); i++)
							{
								System.out.println(i + 1 + ". " + playerHand.get(i).getRank() + " of "
										+ playerHand.get(i).getSuit());
							}

						choice1 = JOptionPane.showOptionDialog(frame, "What would you like to do?", "Your turn",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, null);

						switch (choice1)
							{
							case 0:
								{
									while (settingCard1)
										{
											if (playerHand.get(cardPlayed2 - 1).getValue() == pile.getValue()
													|| playerHand.get(cardPlayed2 - 1).getSuit() == pile.getSuit())
												{
													JOptionPane.showMessageDialog(frame,
															" Please choose a card and type the number that it in coresponds on the console.");
													cardPlayed1 = userInput.nextInt();

													pile = playerHand.get(cardPlayed1 - 1);
													playerHand.remove(cardPlayed1 - 1);

													System.out.println();
													System.out.println("You played the " + pile.getRank() + " of " + pile.getSuit());
													System.out.println();

												} 
											else
												{
													System.out.println(
															"Please choose a number that corresponds to the card you want to play.");
												}
										}
								}
								break;

							case 1:
								{
									dealCardPlayer();
									break;
								}

							}
						///

						System.out.println("Player 2, these are your cards:");
						for (int i = 0; i < player2Hand.size(); i++)
							{
								System.out.println(i + 1 + ". " + player2Hand.get(i).getRank() + " of "
										+ player2Hand.get(i).getSuit());
							}

						choice2 = JOptionPane.showOptionDialog(frame, "What would you like to do?", "Your turn",
								JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, null);

						switch (choice2)
							{
							case 0:
								{
									while (settingCard2)
										{
											JOptionPane.showMessageDialog(frame,
													" Please choose a card and type the number that it in coresponds on the console.");
											cardPlayed2 = userInput.nextInt();

											if (playerHand.get(cardPlayed2 - 1).getValue() == pile.getValue()
													|| playerHand.get(cardPlayed2 - 1).getSuit() == pile.getSuit())
												{
													pile = playerHand.get(cardPlayed2 - 1);
													playerHand.remove(cardPlayed2 - 1);
													settingCard2 = false;
													System.out.println();
													System.out.println("You played the " + pile.getRank() + " of " + pile.getSuit());
													System.out.println();
													
												} 
											else
												{
													System.out.println("Please choose a number that corresponds to the card you want to play.");

												}
										}
								}
								break;

							case 1:
								{
									dealCardPlayer2();
									break;
								}

							}
					
					}
			}

	}
