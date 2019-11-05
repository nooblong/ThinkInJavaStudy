package generics;

import java.util.ArrayList;

class GenericCast<T> {
    private ArrayList<T> list = new ArrayList<>();
    int count(){
        return list.size();
    }
    void push(T item){
        list.add(item);
    }
    public T pop(){
        return list.remove(list.size()-1);
    }
}
