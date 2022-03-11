package com.tqs_lab1.com;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TqsStackTest {

    private TqsStack<String> cities;
    private TqsStack<String> emptyCities;

    @BeforeEach
    public void initialize(){
        cities = new TqsStack<>();
        emptyCities = new TqsStack<>();

        cities.push("Aveiro");
        cities.push("Porto");
        cities.push("Guarda");
        cities.push("Lisboa");
    }

    @AfterEach
    public void afterClear() {
        cities.clear();
    }


    @DisplayName("The stack is empty on construction")
    @Test
    void testEmptyOnConstruction() {
        assertEquals(true, emptyCities.isEmpty());
    }

    @DisplayName("The stack has size 0 on construction")
    @Test
    void testSizeOnConstruction() {
        assertEquals(0, emptyCities.size());
    }

    @DisplayName("After n pushes to an empty stack, n > 0, the stack is not empty and its size is n")
    @Test
    void testPush() {
        assertEquals(!true, cities.isEmpty());
        assertEquals(4, cities.size());
    }

    @DisplayName("If one pushes x then pops, the value popped is x")
    @Test
    void testPop() {
        cities.push("Málaga");
        assertEquals("Málaga", cities.pop());
    }

    @DisplayName("If one pushes x then peeks, the value returned is x, but the size stays the same")
    @Test
    void testPeekAfterPush() {
        cities.push("Málaga");
        assertEquals("Málaga", cities.peek());
        assertEquals(5, cities.size());
    }

    @DisplayName("If the size is n, then after n pops, the stack is empty and has a size 0")
    @Test
    void testStackSizeAfterPop() {
        int size = cities.size();
        for (int i = 0; i < size; i++){
            cities.pop();
        }
        assertEquals(0, cities.size());
        assertEquals(true, cities.isEmpty());
    }

    @DisplayName("Popping from an empty stack does throw a NoSuchElementException")
    @Test
    void tryPopFromEmptyStack() {
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            emptyCities.pop();
        });
    }

    @DisplayName("Peeking into an empty stack does throw a NoSuchElementException")
    @Test
    void tryPeekEmptyStack() {
        Exception exception = assertThrows(NoSuchElementException.class, () -> {
            emptyCities.peek();
        });
    }

    @DisplayName("For bounded stacks only, pushing onto a full stack does throw an IllegalStateException")
    @Test
    void tryPushIntoFullStack() {
        TqsStack<String> t = new TqsStack<>(5);
        t.push("Aveiro");
        t.push("Porto");
        t.push("Guarda");
        t.push("Lisboa");
        t.push("Albufeira");

        Exception exception = assertThrows(IllegalStateException.class, () -> {
            t.push("Another City");
        });
    }
}
