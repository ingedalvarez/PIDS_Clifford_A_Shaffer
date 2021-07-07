package org.ingedalvarez.ch4.towerofhanoi2;

public class TOHObj {
    public TOHOp op;
    public  int num;
    public Pole start, goal, temp;

    TOHObj(TOHOp o, int n, Pole s, Pole g, Pole t){
        op = o; num =  n; start = s; goal = g; temp = t;
    }

    TOHObj(TOHOp o, Pole s, Pole g){
        op = o; start = s; goal = g;;
    }

}
