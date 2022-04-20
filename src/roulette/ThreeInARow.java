package roulette;

import java.util.Set;
import java.util.TreeSet;

public class ThreeInARow extends Bet{

    private final Set<String> possibleBets;

    public ThreeInARow(String description, int payout) {
        super(description, payout);
        possibleBets = new TreeSet<>();
        for (int i=1;i<=34;i++)possibleBets.add(String.valueOf(i));
    }

    @Override
    public boolean betIsMade(String bet, Wheel wheel) {
        int start = Integer.parseInt(bet);
        return (start <= wheel.getNumber() && wheel.getNumber() < start + 3);
    }

    @Override
    public Set<String> getBets() {
        return possibleBets;

    }

}
