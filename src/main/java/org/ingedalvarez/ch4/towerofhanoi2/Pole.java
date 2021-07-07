package org.ingedalvarez.ch4.towerofhanoi2;

import org.ingedalvarez.ch4.AStack;


public class Pole {
    private int n;
    private String name;
    private AStack<Integer> pole;

    public Pole(String name, int n) {
        this.name = name;
        pole = new AStack<>(n);
    }

    public void populateStack(int n) {
        while (n > 0) {
            pole.push(n--);
        }
    }

    public AStack<Integer> getPole(){
        return pole;
    }


    @Override
    public String toString(){
        AStack<Integer> pole1 = new AStack(pole.length());
        AStack<Integer> pole2 = new AStack(pole.length());
        int it;
       while(pole.length() != 0){
           it = pole.pop();
           pole1.push(it);
       }
        while(pole1.length() != 0){
            it = pole1.pop();
            pole.push(it);
            pole2.push(it);
        }


       String print = "[ ";
       while (pole2.length() != 0){
           print = print + pole2.pop() + " ";
       }
        return this.name +": " + print + "]";
    }


}


