package fr.zenity.appium.utils;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public interface Collector<T, A> {

    Supplier<A> supplier();

    BiConsumer<A, T> accumulator();

    Function<A, A> finisher();
}
