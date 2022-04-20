package roulette;
import java.util.Set;

public interface UserInterface {
    /**
     * Prompts the user to input an integer value.
     *
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    int promptInt(String prompt);

    /**
     * Prompts the user to input a word.
     *
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    String promptString(String prompt);

    /**
     * Prompts the user to input an integer value between the given values,
     * inclusive. Note, repeatedly prompts the user until a valid value is
     * entered.
     *
     * @param prompt output to the user before waiting for input
     * @param low    minimum possible valid value allowed
     * @param hi     maximum possible valid value allowed
     * @return the value entered, waiting if necessary until one is given
     */
    int promptRange(String prompt, int low, int hi);

    /**
     * Prompts the user to input yes or no to the given question. Note,
     * repeatedly prompts the user until yes or no is entered.
     *
     * @param prompt output to the user before waiting for input
     * @return the value entered, waiting if necessary until one is given
     */
    boolean promptYesNo(String prompt);

    /**
     * Prompts the user to input one of the given choices to the question. Note,
     * repeatedly prompts the user until a valid choice is entered.
     *
     * @param prompt  output to the user before waiting for input
     * @param choices possible valid responses user can enter
     * @return the value entered, waiting if necessary until one is given
     */
    String promptOneOf(String prompt, Set<String> choices);


    void print(String str);
}