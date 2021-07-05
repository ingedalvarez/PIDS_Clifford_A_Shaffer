package org.ingedalvarez.ch4.towerofhanoi;

public class TOH {

    private int calls;

    public  void TOHanoi(int n, Pole start, Pole goal, Pole temp) {
        calls++;
        if (n == 0) return;                            // Base case
        TOHanoi(n - 1, start, temp, goal);        // Recursive call: n-1 rings
        move(start, goal);                           //Move bottom disk to goal
        TOHanoi(n - 1, temp, goal, start);      // Recursive call: n-1 rings

        System.out.println(start);
        System.out.println(goal);
        System.out.println(temp);
        System.out.println();

    }

    private void move(Pole start, Pole goal) {
        int it = start.getPole().pop();
        goal.getPole().push(it);

    }

    public int getCalls() {
        return calls;
    }


}
