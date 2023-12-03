package com.company.dsa;

public class Main {
    public static void main(String[] args) {
        //List<Integer> test=new LinkedList<>();
        List<Integer> values = new LinkedList<>();
//         values.addFirst(5);
//         values.addFirst(6);
//         values.addFirst(8);
//         values.addLast(12);
        values.add(0, 4);
        values.add(1, 3);
        values.add(2, 2);
        values.add(2, 8);
        values.removeFirst();
        values.removeLast();



        System.out.println();

    }
}
