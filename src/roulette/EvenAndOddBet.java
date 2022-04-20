package roulette;

import java.util.Set;
import java.util.TreeSet;

public class EvenAndOddBet extends Bet{

    private final Set<String> possibleBets;

    public EvenAndOddBet(String description, int payout) {
        super(description, payout);
        possibleBets = new TreeSet<String>();
        possibleBets.add("even");
        possibleBets.add("odd");
    }

    private boolean playerWinsWithEven(String betChoice, Wheel wheel){
        return isNumberEven(wheel.getNumber()) && betChoice.equals("even");

    }
    private boolean playerWinsWithOdd(String betChoice, Wheel wheel){
        return !isNumberEven(wheel.getNumber()) && betChoice.equals("odd");

    }

    @Override
    public boolean betIsMade(String betChoice, Wheel wheel) {
        return playerWinsWithEven(betChoice,wheel) || playerWinsWithOdd(betChoice,wheel);
    }

    @Override
    public Set<String> getBets() {
        return possibleBets;
    }

    private boolean isNumberEven(int number){
        return number % 2 == 0;
    }

}
