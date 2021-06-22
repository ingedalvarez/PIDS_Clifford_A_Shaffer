package org.ingedalvarez.ch4;

public class AList<E> implements List<E> {

    private static final int defaultSize = 10; //default size.
    private int maxSize;    //maximun size of list
    private int listSize;   //number of list elements now
    private int curr;       //position current element
    private E[] listArray;   //Array holding list elements.

    /**
     * Create a list with the default capacity.
     */
    AList() {
        this(defaultSize);
    }

    /** Create a new list object.
     @param size Max number of elements list can contain.
     */
    @SuppressWarnings("unchecked")   //Generic array allocation
    AList(int size) {
        maxSize = size;
        listSize = curr = 0;
        listArray = (E[])new Object[size];
    }


    @Override
    public void clear() {
        listSize = curr = 0;
    }

    /**
     * insert it at current position.
     * @param it
     */
    @Override
    public void insert(E it) {
        assert listSize<maxSize : "List capacity exceeded.";
        for(int i=listSize; i>curr; i--){   //abre espacio para el nuevo elemento
            listArray[i]=listArray[i-1];
        }
        listArray[curr] = it;                 //inserta it en la posicion curr del array
        listSize++;
    }

    @Override
    public void append(E it) {
        assert listSize<maxSize: "List capacity exceeded";
        listArray[listSize++] = it;

    }
    //remove and return current element.
    @Override
    public E remove() {
        if((curr<0) || curr>listSize){return null;} //no current element

        E it = listArray[curr]; //copy the element.
        for(int i = curr; i < listSize-1; i++){
            listArray[i] = listArray[i+1];
        }
        listSize--;
        return it;
    }

    @Override
    public void moveToStart() {
        curr = 0;           //reset position.
    }

    @Override
    public void moveToEnd() {
        curr = listSize;
    }

    @Override
    public void prev() {
        if(curr != 0){curr--;}
    }

    @Override
    public void next() {
        if(curr < listSize){curr++;}
    }

    @Override
    public int length() {
        return listSize;
    }

    @Override
    public int currPos() {
        return curr;
    }

    @Override
    public void moveToPos(int pos) {
        assert pos>=0 && pos <= listSize: "Pos out of range.";
        curr = pos;
    }

    @Override
    public E getValue() {
        assert curr >= 0 && curr < listSize: "No current element.";
        return listArray[curr];
    }

}

