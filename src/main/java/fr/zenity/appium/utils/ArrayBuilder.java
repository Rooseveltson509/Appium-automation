package fr.zenity.appium.utils;

import java.util.function.Consumer;

public class ArrayBuilder<T> implements Consumer<T> {


    private T[] charType = null;

    @Override
    public void accept(T val) {
        if (charType == null){
            charType = (T[]) new Object[1];
            charType[0] = val;
            return;
        }
        grow(val);
    }

    private void grow(T val){
        int sz = charType.length;
        Object[] tmp = new Object[sz+1];
        for (int i = 0; i < sz; i++){
            tmp[i] = charType[i];
        }
        tmp[sz] = val;
        charType = (T[]) tmp;
    }

    public SplitIterator<T> splitIterator(){
        return new SplitIterator<>(charType);
    }

    public T[] get(){
        return charType;
    }


}
