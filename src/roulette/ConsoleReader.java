package roulette;

import java.io.*;
import java.util.*;

/**
 * Provides variety of methods to simplify getting user input from console.
 * 
 *
 */
public class ConsoleReader implements UserInterface {
	
	// by default, read input from the user's console
	private static Scanner in = new Scanner(new InputStreamReader(System.in));
	
	public static void setInput(InputStreamReader inputStream) {
		in = new Scanner(inputStream);
	}

	public int promptInt(String prompt) {
		while (true) {
			try {
				return Integer.parseInt(promptString(prompt));
			} catch (NumberFormatException e) {
				// silently handle non-numeric input and re-prompt
			}
		}
	}


	public String promptString(String prompt) {
		System.out.print(prompt);
		return in.next();
	}

	public int promptRange(String prompt, int low, int hi) {
		int answer;

		do {
			answer = promptInt(prompt + " between " + low + " and " + hi + "? ");
		} while (low > answer || answer > hi);

		return answer;
	}

	/**
	 * Prompts the user to input yes or no to the given question. Note,
	 * repeatedly prompts the user until yes or no is entered.
	 * 
	 * @param prompt
	 *            output to the user before waiting for input
	 * @return the value entered, waiting if necessary until one is given
	 */
	public boolean promptYesNo(String prompt) {
		String answer;

		do {
			answer = promptString(prompt + " (yes or no)? ");
		} while (!answer.equals("yes") && !answer.equals("no"));

		return (answer.equals("yes"));
	}


	public String promptOneOf(String prompt, Set<String> choices) {
		String result;

		do {
			result = promptString(prompt + " on one of " + choices + "? ");
		} while (!choices.contains(result));

		return result;
	}

	@Override
	public void print(String str) {
		System.out.println(str);
	}


}
