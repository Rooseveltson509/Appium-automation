package fr.zenity.appium.utils;

import java.util.function.Consumer;

public class SplitIterator<T> {

    private Object[] tbObj = null;
    private int index;
    private int fence;

    public SplitIterator(Object[] obj, int origin, int fence){
        this.tbObj = obj;
        this.index = origin;
        this.fence = fence;
    }

    public SplitIterator(Object[] obj, int origin){
        this(obj, origin, obj.length);
    }

    public SplitIterator(Object[] obj){
        this(obj, 0, obj.length);
    }


    public void forEachRemaining(Consumer<T> consumer){
        if(consumer == null) throw new NullPointerException("null pointer exception");
        do{}while(tryAdvance(consumer));
    }

    public boolean tryAdvance(Consumer<T> consumer){
        if(index >= 0 && index < fence){
            consumer.accept((T) this.tbObj[index++]);
            return true;
        }
        return false;
    }
}
