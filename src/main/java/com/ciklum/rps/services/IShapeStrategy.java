package com.ciklum.rps.services;

import com.ciklum.rps.domain.Shape;

import java.util.Random;
import java.util.function.Supplier;

import static com.ciklum.rps.domain.Shape.ROCK;

public interface IShapeStrategy extends Supplier<Shape> {

    static IShapeStrategy random(Random random) {
        return () -> Shape.values()[random.nextInt(Shape.values().length)];
    }

    static IShapeStrategy rock() {
        return () -> ROCK;
    }
}
