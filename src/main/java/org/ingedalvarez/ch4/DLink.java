package org.ingedalvarez.ch4;

public class DLink<E> {     //Doubly linked list node.
    private E element;      //Value for this node.
    private DLink<E> next;  //Pointer to next node in list.
    private DLink<E> prev;  //Pointer to previous node.

    //Constructors

    /**
     * Constructor DLink<E> doubly link node.
     * @param it Value for this node.
     * @param n Pointer to next node in list.
     * @param p Pointer to previous node.
     */
    public DLink(E it, DLink<E> n, DLink<E> p){
        element = it;
        next = n;
        prev = p;
    }
    public DLink(DLink<E> n, DLink<E> p){
        next = n;
        prev = p;
    }

    DLink<E> next(){
        return next;
    }

    DLink<E> prev(){
        return prev;
    }

    DLink<E> setNext(DLink<E> nextVal){
        return next = nextVal;
    }

    DLink<E> setPrev(DLink<E> prevVal){
        return prev = prevVal;
    }

    E element(){
        return element;
    }

    E setElement(E it){
        return element = it;
    }

}
