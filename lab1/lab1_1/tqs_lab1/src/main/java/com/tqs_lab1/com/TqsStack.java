package com.tqs_lab1.com;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class TqsStack<T> {
    private ArrayList<T> t;
    private int stackSize;

    public TqsStack(){
        this.t = new ArrayList<>();
    }

    public TqsStack(int size){
        this.t = new ArrayList<>();
        this.stackSize = size;
    }

    public void push(T n){
        if (this.stackSize > 0) {  // only if max size of stack is > 0
            if (this.t.size() < stackSize){ // the actual stack size must be lower than the maximum stack size
                this.t.add(n);
            } else {
                throw new IllegalStateException("Maximum stack size already reached...");
            }
        } else {
            this.t.add(n);
        }
    }

    public T pop(){
        if (this.t.size() > 0){
            return  this.t.remove(this.t.size() - 1);
        } else {
            throw new NoSuchElementException("Something went wrong...");
        }
    }
    
    public T peek(){
        if (this.t.size() != 0) { // stack is not empty
            return this.t.get(this.t.size() - 1);
        } else {
            throw new NoSuchElementException("The stack is empty...");
        }
    }

    public int size(){
        return this.t.size();
    }

    public Boolean isEmpty() {
        return this.t.isEmpty();
    }

    public void clear() {
        this.t.clear();
    }
}
