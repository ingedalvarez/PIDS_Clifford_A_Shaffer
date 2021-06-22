package org.ingedalvarez.ch4;

public class LList<E> implements List<E> {

    Link<E> head;      //Pointer to list header
    Link<E> tail;      //Pointer to list tail
    Link<E> curr;     //Access to current element
    int cnt;

    //Constructor
    public LList(int size){
        this();
    }
    public LList(){
        curr = tail = head = new Link<E>(null);
        cnt = 0;
    }

    @Override
    public void clear() {       //remove all elements
        head.setNext(null);     //Drop acces to links.
        curr = tail = head = new Link<E>(null);
        cnt = 0;

    }

    @Override
    public void insert(E it) {    //insert it at current position.
        curr.setNext(new Link<E>(it, curr.next()));
        if(tail == curr) tail = curr.next(); //new tail.
        cnt++;
    }

    @Override
    public void append(E it) {    //append it to list.
        tail = tail.setNext(new Link<E>(it, null));
        cnt++;
    }

    @Override
    public E remove() {     //remove and return current element.
        if(curr.next() == null) return null;
        E it = curr.next().element();
        if(tail == curr.next()) tail = curr;
        curr.setNext(curr.next().next());
        cnt--;
        return it;
    }

    @Override
    public void moveToStart() {     //set current at list start
        curr = head;
    }

    @Override
    public void moveToEnd() {       //set curr at list tail
        curr = tail;
    }

    @Override
    public void prev() {        //move curr one step left; no change if already at front
        if(curr == head) return;    //no previous element
        Link<E> temp = head;
        while (temp.next() != curr) temp = temp.next();
        curr = temp;
    }

    @Override
    public void next() {
        if(curr != tail) curr = curr.next();
    }

    @Override
    public int length() {
        return cnt;
    }

    @Override
    public int currPos() {  //return the position of the current element
        Link<E> temp = head;
        int i;
        for(i=0; curr != temp; i++) temp = temp.next();
        return i;
    }

    @Override
    public void moveToPos(int pos) {    //move down list to "pos" position
        assert (pos >= 0 && pos <= cnt): "Position out of range";
        curr = head;
        for(int i = 0; i<pos; i++) curr = curr.next();
    }

    @Override
    public E getValue() {   //return current element.
        if(curr.next() == null) return null;
        return curr.next().element();
    }

}