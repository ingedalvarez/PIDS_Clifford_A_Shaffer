package org.ingedalvarez.ch4.factorial;


import org.ingedalvarez.ch4.AStack;
import org.ingedalvarez.ch4.Stack;

    /*
    In practice, an iterative form of the factorial function (method factBucle) would be both simpler
    and faster than the version shown in method factAStack. Unfortunately, it is not always
    possible to replace recursion with iteration.
    */

public class factorialMain
{
    public static void main( String[] args )
    {
        System.out.println( "Some exercises." );
        int n = 7;
        System.out.println(factRecu(n));
        System.out.println(factBucle(n));
        System.out.println(factAStack(n));
    }

    static long factRecu(int n){        //recursive algorithm.
        assert (n >= 0) && (n <= 20) : "n out of range";
        if(n == 0) {
            System.out.println("Call to factRecu of : "+ n);
            return 1;
        }
        else{
            System.out.println("Call to factRecu of : "+ n);
            return n * factRecu(n-1);
        }
    }

    static long factBucle(int n){       //iterative algorithm.
        assert (n >= 0) && (n <= 20) : "n out of range";
        long fact = 1;
        for(int i = 1; i <= n; i++){
            fact = fact * (i);
            System.out.println("Iteration No. "+ i);
        }
        return fact;
    }

    static long factAStack(int n){          //AStack algorithm.
        // To fit n! in a long variable, require n < 21
        assert (n >= 0) && (n <= 20) : "n out of range";
        // Make a stack just big enough
        Stack<Integer> S = new AStack<Integer>(n);
        while (n > 1) {
            System.out.println("Call to first while. ");
            S.push(n--);
        }
        long result = 1;
        while (S.length() > 0) {
            System.out.println("Call to second while. ");
            result = result * S.pop();
        }
        return result;
    }

}
