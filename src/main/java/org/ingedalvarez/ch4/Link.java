package org.ingedalvarez.ch4;

public class Link<E> {      //Singly linked list node
    private E element;      //Value for this node
    private Link<E> next;   //Pointer to next node in List

    //constructor
    public Link(E it, Link<E> nextval){
        element = it;
        next = nextval;
    }
    public Link(Link<E> nextval){
        next = nextval;
    }

    public Link<E> next(){
        return next;
    }
    public E element(){
        return element;
    }
    public Link<E> setNext(Link<E> nextVal){
        return next = nextVal;
    }
    public E setElement(E it){
        return element = it;
    }
}
