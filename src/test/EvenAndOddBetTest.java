package test;

import org.junit.experimental.theories.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import roulette.EvenAndOddBet;
import roulette.Wheel;

import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class EvenAndOddBetTest {


    EvenAndOddBet evenAndOddBet;
    Wheel wheelMock;


    @BeforeEach
    public void init(){
        evenAndOddBet = new EvenAndOddBet("Some Description",1);
        wheelMock = mock(Wheel.class);
        int evenNumber =10;
        when(wheelMock.getNumber()).thenReturn(evenNumber);
    }

    @Test
    public void shouldGetBetsReturnAllPossibleBets(){
        Set<String> expected = new TreeSet<>();
        expected.add("even");
        expected.add("odd");

        Set<String> actual = evenAndOddBet.getBets();

        assertThat(actual,is(equalTo(expected)));
    }


    @Test
    public void shouldBetIsMadeReturnTrueWhenPlayerChooseEvenAndWheelGiveEven(){
        boolean expected = true;

        boolean actual = evenAndOddBet.betIsMade("even",wheelMock);

        assertThat(expected,is(equalTo(actual)));
    }

    @Test
    public void shouldBetIsMadeReturnFalseWhenPlayerChooseOddAndWheelGiveEven(){
        boolean expected = false;

        boolean actual = evenAndOddBet.betIsMade("odd",wheelMock);

        assertThat(expected,is(equalTo(actual)));
    }


}
