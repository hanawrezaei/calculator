package com.example.calculator;

import  java.util.Stack;

public class ArrayStack<E> extends Stack<E> {
    public static final int CAPACITY = 50;
    private E[] data;
    private int t = -1;
    public ArrayStack()
    {
        this(CAPACITY);
    }
    public ArrayStack(int capacity)
    {
        data = (E[]) new Object[capacity];
    }
    public int size()
    {
        return (t + 1);
    }

    public boolean isEmpty()
    {
        return (t == -1);
    }

    public E push(E e) throws IllegalStateException
    {
        if(size() == data.length)
            throw new IllegalStateException("Stack is full");
        data[++t] = e;
        return e;
    }

    public E top()
    {
        if(isEmpty())
            return null;
        return data[t];
    }

    public E pop()
    {
        if(isEmpty())
            return null;
        E answer = data[t];
        data[t] = null;
        t--;
        return answer;
    }

}
