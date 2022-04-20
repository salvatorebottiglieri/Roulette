package roulette;

public class BetFactory {

    public Bet create(String type){
        Bet bet = null;
        switch (type){
            case "EvenAndOddBet" -> bet = new EvenAndOddBet("Odd or Even",1);
            case "RedAndBlackBet" -> bet = new RedAndBlackBet("Red or Black",1);
            case "ThreeInARow" -> bet = new ThreeInARow("Three in a Row",11);
        }
        return bet;
    }
}
