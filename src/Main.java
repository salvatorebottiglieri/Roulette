import roulette.*;

import java.util.Set;
import java.util.TreeSet;

/**
 * Plays as many games of roulette until the player runs out of money.
 * 
 * @author Robert C. Duvall
 */
public class Main {
	public static void main(String[] args) {
		UserInterface userInterface = new ConsoleReader();
		Game game = new Game(userInterface);
		Gambler player = new Gambler("Robert", 1000);
		Set<String> possibileBets = new TreeSet<>();
		possibileBets.add("EvenAndOddBet");
		possibileBets.add("RedAndBlackBet");
		possibileBets.add("ThreeInARow");


		System.out.println("Hello " + player.getName() + ", let's play "
				+ game.getName());
		System.out.println();

		do {
			game.play(player,possibileBets);
		} while (player.isSolvent());

		System.out.println();
		System.out.println("Goodbye " + player.getName()
				+ ", thanks for playing!");
	}
}
