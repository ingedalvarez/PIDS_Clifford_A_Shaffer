package org.ingedalvarez.ch4;


public class DLList<E> implements List<E> {
    private DLink<E> head;
    private DLink<E> tail;
    private DLink<E> curr;
    private int cnt;

    public DLList(int size){
        this();
    }
    public DLList(){
        head = curr = new DLink<>(null, null);
        tail = new DLink<>(null, head);
        head.setNext(tail);
        cnt = 0;
    }

    /**
     * Remove all contents from the list, so it is once again
     * empty. Client is responsible for reclaiming storage
     * used by the list elements.
     */
    @Override
    public void clear() {
        head = tail = curr = null;
        head = curr = new DLink<>(null, null);
        tail = new DLink<>(null, head);
        head.setNext(tail);
        cnt = 0;

    }

    /**
     * Insert an element at the current location. The client
     * is responsible for ensuring that the list’s capacity
     * is not exceeded.
     *
     * @param it The element to be inserted.
     */
    @Override
    public void insert(E it) {
        curr.setNext(new DLink<E>(it, curr.next(), curr));
        if (curr.next().next() != null) {
            curr.next().next().setPrev(curr.next());
        }
        if (tail == curr) {
            tail = curr.next();
        }
        cnt++;
    }

    /**
     * Append an element at the end of the list. The client
     * is responsible for ensuring that the list’s capacity
     * is not exceeded.
     *
     * @param it The element to be appended.
     */
    @Override
    public void append(E it) {
        tail = tail.setNext(new DLink<>(it,null, tail));
        cnt++;
    }

    /**
     * Remove and return the current element.
     *
     * @return The element that was removed.
     */
    @Override
    public E remove() {
        if(curr.next() == null) return null; //nothing to remove.
        E it = curr.next().element();
        if(curr.next().next() != null){
            curr.next().next().setPrev(curr);
        }else {
            tail = curr;
        }
        curr.setNext(curr.next().next());
        cnt--;
        return it;
    }

    /**
     * Set the current position to the start of the list
     */
    @Override
    public void moveToStart() {
        curr = head;
    }

    /**
     * Set the current position to the end of the list
     */
    @Override
    public void moveToEnd() {
        curr = tail.prev();
    }

    /**
     * Move the current position one step left. No change
     * if already at beginning.
     */
    @Override
    public void prev() {
        if(curr != head)curr = curr.prev();
    }

    /**
     * Move the current position one step right. No change
     * if already at end.
     */
    @Override
    public void next() {
        if(curr != tail)curr = curr.next();
    }

    /**
     * @return The number of elements in the list.
     */
    @Override
    public int length() {
        return cnt;
    }

    /**
     * @return The position of the current element.
     */
    @Override
    public int currPos() {
        int i;
        DLink<E> temp = head;
        for(i = 0; temp != curr; i++){
            temp = temp.next();
        }
        return i;
    }

    /**
     * ** Set current position.
     *
     * @param pos The position to make current.
     */
    @Override
    public void moveToPos(int pos) {
        assert pos >= 0 && pos <= cnt;
        for(int i = 0; i < pos; i++){
            curr = curr.next();
        }
    }

    /**
     * @return The current element.
     */
    @Override
    public E getValue() {
        return curr.next().element();
    }

}
