package adts;

import java.util.ArrayList;

/**
 * File:        
 * Description: 
 * @author lunatunez
 * @param <T>
 */

public class List_ArrayList<T> implements ListInterface<T> {
    private ArrayList<T> arrayList;

    @Override
    public int size() {
        return arrayList.size();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public T get(int index) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean contains(T anEntry) {
        return arrayList.contains(anEntry);
    }

    @Override
    public T[] toArray() {
        return (T[]) arrayList.toArray();
    }

    @Override
    public void add(T newEntry) {
        arrayList.add(newEntry);
    }

    @Override
    public boolean insert(int index, T newEntry) {
        arrayList.add(index, newEntry);
        return true;
    }

    @Override
    public T remove() {
        return null;
        // STUB arrayList.remove(); 
    }

    @Override
    public T remove(int index) {
        return arrayList.remove(index);
    }

    @Override
    public boolean replace(int index, T newEntry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void clear() {
        arrayList.clear();
    }
    
}
