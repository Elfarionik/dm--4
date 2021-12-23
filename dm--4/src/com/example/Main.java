package com.example;

public class Main {

    public static void main(String[] args) {
        int[][] a = {
                {0,0,1,0,1},
                {0,0,0,1,1},
                {0,1,0,0,0},
                {1,1,1,0,1},
                {1,0,0,0,0},
        };
        String s = "(12+8)/(3*7-1)";

        System.out.println("Task 1");
        System.out.println("Орієнтованість: " + Task1.isOriented(a));
        System.out.println();

        System.out.println("Task2\n" + Task2.getTree(s));
        System.out.println("Task 3");
        System.out.println("Отримання польского запису");
        Task3.printTripResults(Task3.getPolca(s));
        System.out.println("Отримання Зворотнього польского запису");
        Task3.printTripResults(Task3.getReversedPolca(s));

    }

}
