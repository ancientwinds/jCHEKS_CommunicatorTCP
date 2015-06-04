package com.archosResearch.jCHEKS.communicator;


import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Thomas Lepage
 * @param <T>
 */
public abstract class AbstractObservable<T> {
    protected final Set<T> observers = new HashSet<>();
    
    public void addObserver(T observer){
        this.observers.add(observer);
    }
    
    /*public void removeObserver(T observer) {
        this.observers.remove(observer);
    }*/
}
