package fr.zenity.appium.utils;

import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Optional<T> {

    private final static Optional<?> EMPTY = new Optional(null);

    protected T value;

    protected Optional(T val){
        value = val;
    }

    public T get(){
        return value;
    }

    public boolean isPresent(){
        return this.value != null;
    }

    public boolean isEmpty(){
        return !isPresent();
    }

    public T orElse(T other){
        return isEmpty() ? other : value;
    }


    public <U extends Exception> T orElseThrow(U exception) throws Exception {
        throw exception;
    }


    public T orElseGet(Supplier<T> other) {
        return orElse(other.get());
    }

    public Object valueOf(){
        return this.value;
    }

    public <U>Optional<U> map(Function<T, U> callback){
        return Optional.ofNullable(callback.apply(get()));
    }

    public Optional<T> filter(Predicate<? super T> predicate){
        if(isEmpty()) return this;
        return predicate.test(get()) ? Optional.of(get()) : Optional.empty();
    }

    @Override
    public boolean equals(Object o){
        if(o == null) return false;
        if(o instanceof Optional && this.get().equals( ((Optional<T>)o).get())) return true;
        return this == o;
    }

    @Override
    public String toString(){
        return isPresent() ? "Optional["+ value.toString() +"]" : "Optional.empty";
    }

    public static <T>Optional<T> of(T value){
        if(value == null) throw new NullPointerException("value can not be null");
        return new Optional<>(value);
    }

    public static <T>Optional<T> ofNullable(T value){
        return new Optional<>(value);
    }

    public static <T>Optional<T> empty(){
        return  (Optional<T>)EMPTY;
    }

}
