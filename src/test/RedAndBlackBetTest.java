package test;


import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import roulette.RedAndBlackBet;
import roulette.Wheel;

import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class RedAndBlackBetTest {

     RedAndBlackBet redAndBlackBet;
     Wheel wheelMock;

    @BeforeEach
    public void init(){
        redAndBlackBet = new RedAndBlackBet("Some Description",1);
        wheelMock = mock(Wheel.class);
        when(wheelMock.getColor()).thenReturn("red");
    }

    @Test
    public void shouldGetBetsReturnAllPossibleBets(){
        Set<String> expected = new TreeSet<>();
        expected.add("red");
        expected.add("black");

        Set<String> actual = redAndBlackBet.getBets();

        assertThat(actual,is(equalTo(expected)));
    }

    @Test
    public void shouldBetIsMadeReturnTrueWhenPlayerChooseRedAndWheelGiveRed(){
        boolean expected = true;

        boolean actual = redAndBlackBet.betIsMade("red",wheelMock);

        assertThat(expected,is(equalTo(actual)));
    }

    @Test
    public void shouldBetIsMadeReturnFalseWhenPlayerChooseBlackAndWheelGiveRed(){
        boolean expected = false;

        boolean actual = redAndBlackBet.betIsMade("black",wheelMock);

        assertThat(expected,is(equalTo(actual)));
    }

}
