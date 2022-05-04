package roulette;

import java.util.Set;

/**
 * Represents player's attempt to bet on outcome of the roulette wheel's spin.
 * 
 * @author Robert C. Duvall
 */
public abstract class Bet {
	
	private String description;
	private int payout;

	/**
	 * Constructs a bet with the given name and odds.
	 * 
	 * @param description
	 *            name of this kind of bet
	 * @param payout
	 *            payout given by the house for this kind of bet
	 */
	public Bet(String description, int payout) {
		this.description = description;
		this.payout = payout;
	}

	/**
	 * @return odds given by the house for this kind of bet
	 */
	public int getPayout() {
		return payout;
	}

	/**
	 * @return name of this kind of bet
	 */
	public String getDescription() {
		return description;
	}


	/**
	 * Checks if the given bet is won or lost given the user's choice and the
	 * result of spinning the wheel.
	 * @param betChoice
	 *            specific value user chose to try to win the bet
	 *
	 * @param wheel
	 * 				wheel used during the game
	 */
	public abstract boolean betIsMade(String betChoice, Wheel wheel);

	public abstract Set<String> getBets();


}


