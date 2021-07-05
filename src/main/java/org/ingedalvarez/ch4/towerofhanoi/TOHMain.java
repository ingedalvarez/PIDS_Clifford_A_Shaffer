package org.ingedalvarez.ch4.towerofhanoi;

public class TOHMain {
    public static void main(String[] args) {
        int calls = 0;
        int n = 2;
        Pole start, goal, temp;

        start = new Pole("start", n);
        start.populateStack(n);
        goal = new Pole("goal", n);
        temp = new Pole("temp", n);

        TOH towers = new TOH();


        System.out.println(start);
        System.out.println(goal);
        System.out.println(temp);
        System.out.println();

        towers.TOHanoi(n, start, goal, temp);

        System.out.println("Numbers of discs: "+ n);
        System.out.println("Numbers of recursive call: "+towers.getCalls());

    }


}
