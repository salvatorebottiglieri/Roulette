package roulette;

import java.util.*;

/**
 * Plays a game of roulette.
 * 
 * @author Robert C. Duvall
 */
public class Game {
	// name of the game
	private static final String DEFAULT_NAME = "Roulette";

	private Wheel myWheel;

	/**
	 * Construct the game.
	 */
	public Game() {
		myWheel = new Wheel();
	}

	/**
	 * @return name of the game
	 */
	public String getName() {
		return DEFAULT_NAME;
	}

	/**
	 * Play a round of this game.
	 * 
	 * For Roulette, this means prompting the player to make a bet, spinning the
	 * roulette wheel, and then verifying that the bet is won or lost.
	 * 
	 * @param player
	 *            one that wants to play a round of the game
	 */
	public void play(Gambler player, Set<String> possibileBets,UserInterface userInterface) {
		int amount = userInterface.promptRange("How much do you want to bet",
				0, player.getBankroll());

		String betType = userInterface.promptOneOf("What type of bet you prefer?",possibileBets);
		BetFactory betFactory = new BetFactory();
		Bet bet = betFactory.create(betType);

		String choidedBet = userInterface.promptOneOf("What's your bet?",bet.getBets());

		userInterface.print("....Spinning....");
		myWheel.spin();
		userInterface.print("Dropped into " + myWheel.getColor() + " " + myWheel.getNumber());

		amount *= updateAmount(userInterface, bet, choidedBet);
		player.updateBankroll(amount);
	}

	private int updateAmount(UserInterface userInterface, Bet bet, String choidedBet) {
		if (bet.betIsMade(choidedBet,myWheel)) {
			userInterface.print("*** Congratulations :) You win ***");
			return bet.getPayout();
		} else {
			userInterface.print("*** Sorry :( You lose ***");
			return -1;
		}
	}


}