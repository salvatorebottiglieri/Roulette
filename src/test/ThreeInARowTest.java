package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import roulette.ThreeInARow;
import roulette.Wheel;

import java.util.Set;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ThreeInARowTest {

    ThreeInARow threeInARowBet;
    Wheel wheelMock;


    @BeforeEach
    public void init(){
        threeInARowBet = new ThreeInARow("Some Description",1);
        wheelMock = mock(Wheel.class);

        when(wheelMock.getNumber()).thenReturn(12);
    }

    @Test
    public void shouldGetBetsReturnAllPossibleBets(){
        Set<String> expected = new TreeSet<>();
        for (int i=1;i<=34;i++)expected.add(String.valueOf(i));

        Set<String> actual = threeInARowBet.getBets();

        assertThat(actual,is(equalTo(expected)));
    }


    @ParameterizedTest
    @ValueSource(strings = {"10","11","12"})
    public void shouldBetIsMadeReturnTrue(String bet){
        boolean expected = true;

        boolean actual = threeInARowBet.betIsMade(bet,wheelMock);

        assertThat(expected,is(equalTo(actual)));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0","1","5","7","8","13","14","100","1000"})
    public void shouldBetIsMadeReturnFalse(String bet){
        boolean expected = false;

        boolean actual = threeInARowBet.betIsMade(bet,wheelMock);

        assertThat(expected,is(equalTo(actual)));
    }
}
