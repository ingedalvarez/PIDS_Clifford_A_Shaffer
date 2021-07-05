package org.ingedalvarez.ch4;

public class AStack<E> implements Stack<E>{
    public static final int defaultSize = 10;
    private int top;
    private int maxSize;
    private E[] listArray;

    public AStack(){
        this(defaultSize);
    }




    @SuppressWarnings("unchecked")
    public AStack(int size){
        maxSize = size;
        top = 0;
        listArray = (E[]) new Object[size];
    }

    /**
     * Reinitialize the stack. The user is responsible for
     * reclaiming the storage used by the stack elements.
     */
    @Override
    public void clear() {
        top = 0;
        listArray = (E[]) new Object[maxSize];
    }

    /**
     * Push an element onto the top of the stack.
     *
     * @param it The element being pushed onto the stack.
     */
    @Override
    public void push(E it) {
        assert top != maxSize: "Stack is full.";
        listArray[top++] = it;
    }

    /**
     * Remove and return the element at the top of the stack.
     *
     * @return The element at the top of the stack.
     */
    @Override
    public E pop() {
        assert top != 0: "Stack is empty.";
        return listArray[--top];
    }

    /**
     * @return A copy of the top element.
     */
    @Override
    public E topValue() {
        assert top != 0: "Stack is empty.";
        return listArray[top-1];
    }

    /**
     * @return The number of elements in the stack.
     */
    @Override
    public int length() {
        return top;
    }

}
