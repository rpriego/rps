package com.ciklum.rps.services;

import com.ciklum.rps.domain.Shape;

import java.util.function.Supplier;

public interface IShapeStrategy extends Supplier<Shape> {

    public static IShapeStrategy random() {
        return null;
    }

    public static IShapeStrategy rock() {
        return null;
    }
}
