package com.company.dsa;

public class Main {
    public static void main(String[] args) {
        //List<Integer> test=new LinkedList<>();
        List<Integer> values = new LinkedList<>();
//         values.addFirst(5);
//         values.addFirst(6);
//         values.addFirst(8);
//         values.addLast(12);
       values.addFirst(1);
        values.addLast(2);
        values.addLast(3);
        values.addLast(4);
        values.add(4, 5);

        values.removeFirst();
        values.removeLast();



        System.out.println();

    }
}
