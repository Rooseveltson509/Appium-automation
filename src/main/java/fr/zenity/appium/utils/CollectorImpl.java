package fr.zenity.appium.utils;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class CollectorImpl<T, A> implements Collector<T, A>{

    private Supplier<A> supplier;
    private BiConsumer<A, T> biConsumer;
    private Function<A, A> finisher;

    public CollectorImpl(Supplier<A> supplier, BiConsumer<A, T> biConsumer, Function<A, A> finisher) {
        this.supplier = supplier;
        this.biConsumer = biConsumer;
        this.finisher = finisher;
    }


    public Supplier<A> supplier() {
        return supplier;
    }

    public BiConsumer<A, T> accumulator() {
        return biConsumer;
    }

    public Function<A, A> finisher() {
        return  finisher;
    }

}
