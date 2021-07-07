package org.ingedalvarez.ch4.towerofhanoi2;

import org.ingedalvarez.ch4.AStack;
import org.ingedalvarez.ch4.Stack;

public class TOH2main {

    public static void main(String[] args) {
        int n = 4;
        Pole start, goal, temp;
        start = new Pole("start", n);
        goal = new Pole("goal", n);
        temp = new Pole("temp", n);
        start.populateStack(n);

        System.out.println(start.toString());
        System.out.println(goal.toString());
        System.out.println(temp.toString());

        TOH(n, start, goal, temp);

        System.out.println(start.toString());
        System.out.println(goal.toString());
        System.out.println(temp.toString());


    }

    private static void TOH(int n, Pole start, Pole goal, Pole temp){
        int bucles = 0;
        Stack<TOHObj> s = new AStack<TOHObj>(2 * (n + 1));
        s.push(new TOHObj(TOHOp.TOH, n, start, goal, temp));
        while(s.length() > 0){
            bucles++;
            TOHObj it = s.pop();
            if(it.op == TOHOp.MOVE){
                move(it.start, it.goal);
            }else if(it.num > 0){
                s.push(new TOHObj(TOHOp.TOH,it.num-1, it.temp, it.goal, it.start));
                s.push(new TOHObj(TOHOp.MOVE, it.start, it.goal));
                s.push(new TOHObj(TOHOp.TOH,it.num-1, it.start, it.temp, it.goal));

            }
        }
        System.out.println("Numero de repeticiones del bucle: " + bucles);
    }

    private static void move(Pole start, Pole goal) {
        Integer it = start.getPole().pop();
        goal.getPole().push(it);
    }
}
