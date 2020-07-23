package com.ciklum.rps.services;

import com.ciklum.rps.domain.Shape;

import java.util.Random;
import java.util.function.Supplier;

public interface IShapeStrategy extends Supplier<Shape> {

    static IShapeStrategy random(Random random) {
        return null;
    }

    static IShapeStrategy rock() {
        return null;
    }
}
