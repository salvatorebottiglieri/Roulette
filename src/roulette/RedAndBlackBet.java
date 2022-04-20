package roulette;

import java.util.Set;
import java.util.TreeSet;

public class RedAndBlackBet extends Bet{

    private final Set<String> possibleBets;

    public RedAndBlackBet(String description, int payout) {
        super(description, payout);
        possibleBets = new TreeSet<String>();
        possibleBets.add(Wheel.BLACK);
        possibleBets.add(Wheel.RED);
    }

    @Override
    public boolean betIsMade(String betChoice, Wheel wheel) {
        return wheel.getColor().equals(betChoice);
    }

    @Override
    public Set<String> getBets() {
        return possibleBets;
    }


}
