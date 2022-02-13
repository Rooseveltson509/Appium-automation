package fr.zenity.appium.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

public final class Collectors {

    public static <T>Collector<T, ArrayBuilder<T>> arrayBuilder(){
        return new CollectorImpl<T, ArrayBuilder<T>>(null, null,null){
            @Override
            public Supplier<ArrayBuilder<T>> supplier() {
                return ()-> new ArrayBuilder();
            }

            @Override
            public BiConsumer<ArrayBuilder<T>, T> accumulator() {
                return (ArrayBuilder<T> a, T v)-> a.accept(v);
            }

            @Override
            public Function<ArrayBuilder<T>, ArrayBuilder<T>> finisher() {
                return (ArrayBuilder<T> a)-> a;
            }
        };
    }

    public static <T>Collector<T, List<T>> toList(){
        return new CollectorImpl<T, List<T>>(null, null,null){
            @Override
            public Supplier<List<T>> supplier() {
                return ()-> new ArrayList<>();
            }

            @Override
            public BiConsumer<List<T>, T> accumulator() {
                return (List<T> a, T v)-> a.add(v);
            }

            @Override
            public Function<List<T>, List<T>> finisher() {
                return (List<T> a)-> a;
            }
        };
    }



}
