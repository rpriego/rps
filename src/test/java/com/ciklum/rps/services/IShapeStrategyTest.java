package com.ciklum.rps.services;

import com.ciklum.rps.domain.Shape;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Random;

import static com.ciklum.rps.domain.Shape.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class IShapeStrategyTest {

    @Mock
    private Random randomMock;

    @Test
    public void randomShouldSelectRock() {
        //given
        when(randomMock.nextInt(3)).thenReturn(0);

        //when
        Shape shape = IShapeStrategy.random(randomMock).get();

        //then
        assertThat(shape, is(ROCK));
    }

    @Test
    public void randomShouldSelectPaper() {
        //given
        when(randomMock.nextInt(3)).thenReturn(1);

        //when
        Shape shape = IShapeStrategy.random(randomMock).get();

        //then
        assertThat(shape, is(PAPER));
    }

    @Test
    public void randomShouldSelectScissors() {
        //given
        when(randomMock.nextInt(3)).thenReturn(2);

        //when
        Shape shape = IShapeStrategy.random(randomMock).get();

        //then
        assertThat(shape, is(SCISSORS));
    }

    @Test
    public void rockShouldSelectRock() {
        //given

        //when
        Shape shape = IShapeStrategy.rock().get();

        //then
        assertThat(shape, is(ROCK));
    }
}