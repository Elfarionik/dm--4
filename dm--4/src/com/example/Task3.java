package com.example;

import java.util.ArrayList;
import java.util.Arrays;

public class Task3 {
    static void printTripResults(ArrayList<String> s){
        Object[] x = s.toArray();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < x.length; i++) {
            res.append((String) x[i]);
        }
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == '(' || res.charAt(i) == ')' || res.charAt(i) == '!' || res.charAt(i) == '`') {
                res.deleteCharAt(i);
                i = -1;
            }
        }


        System.out.println(res);
    }
   private  static String clean(String s) {
        String[] x = s.split("");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < x.length; i++) {
            res.append((String) x[i]);
        }
        for (int i = 0; i < res.length(); i++) {
            if (res.charAt(i) == '(' || res.charAt(i) == ')' || res.charAt(i) == '!' || res.charAt(i) == '`') {
                res.deleteCharAt(i);
                i = -1;
            }
        }
        return res.toString();
    }


    private static String smallPolca(String s) {
        char[] symbols = {'^', '/', '*', '+', '-'};
        StringBuilder res = new StringBuilder(s);
        System.out.println("Розкриваємо частину\n" + clean(s) + "\n");
        for (char symbol : symbols) {
            int number = getNumberOfSigns(s, symbol);
            while (number != 0) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == symbol) {
                        if (s.charAt(i - 1) == '!') continue;
                        number--;

                        //LEFT
                        int left = i - 1;
                        if (s.charAt(left) == '`' && left > 0) {
                            left--;
                            while (s.charAt(left) != '`') {
                                left--;
                            }
                        } else {
                            while (left > 0 && ((s.charAt(left) >= '0' && s.charAt(left) <= '9') || s.charAt(left) == ' ' || s.charAt(left) == '.' || s.charAt(left) == ','))
                                left--;
                            left++;
                        }

                        //RIGHT
                        int right = i + 1;
                        if (right < s.length() && s.charAt(right) == '`') {
                            right++;
                            while (right < s.length() && s.charAt(right) != '`') {
                                right++;
                            }
                        } else {
                            while ((s.charAt(right) >= '0' && s.charAt(right) <= '9') || s.charAt(i) == ' ' ||
                                    s.charAt(right) == '.' || s.charAt(right) == ',')
                                right++;

                        }
                        String el = "`" + "!" + s.charAt(i) + " " + s.substring(left, i) + " " + s.substring(i + 1, right) + "`";
                        res.delete(left, right);
                        StringBuilder el1 = new StringBuilder(el);
                        for (int j = 1; j < el1.length() - 1; j++) {
                            if (j < el1.length() - 1 && el1.charAt(j) == '`') {
                                el1.deleteCharAt(j);
                                j = 0;
                            }
                        }
                        res.insert(left, el1);
                        System.out.println("Отримуємо \n" + clean(el1.toString()) + "\n");
                        s = res.toString();
                    }
                }
            }
        }
        for (int i = 1; i < res.length() - 1; i++)
            if (res.charAt(i) == '`') {
                res.deleteCharAt(i);
                i = 0;
            }
        return res.toString();
    }

     private static String smalleReversedPolca(String s) {
        char[] symbols = {'^', '/', '*', '+', '-'};
        StringBuilder res = new StringBuilder(s);
        System.out.println("Розкриваємо частину\n" + clean(s) + "\n");
        for (char symbol : symbols) {
            int number = getNumberOfSigns(s, symbol);
            while (number != 0) {
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) == symbol) {
                        if (s.charAt(i - 1) == '!') continue;
                        number--;

                        //LEFT
                        int left = i - 1;
                        if (s.charAt(left) == '`' && left > 0) {
                            left--;
                            while (s.charAt(left) != '`') {
                                left--;
                            }
                        } else {
                            while (left > 0 && ((s.charAt(left) >= '0' && s.charAt(left) <= '9') || s.charAt(left) == ' ' || s.charAt(left) == '.' || s.charAt(left) == ','))
                                left--;
                            left++;
                        }

                        //RIGHT
                        int right = i + 1;
                        if (right < s.length() && s.charAt(right) == '`') {
                            right++;
                            while (right < s.length() && s.charAt(right) != '`') {
                                right++;
                            }
                        } else {
                            while ((s.charAt(right) >= '0' && s.charAt(right) <= '9') || s.charAt(i) == ' ' ||
                                    s.charAt(right) == '.' || s.charAt(right) == ',')
                                right++;

                        }
                        String el = "`"  + s.substring(left, i) + " " + s.substring(i + 1, right) + " " + "!" + s.charAt(i) + "`";
                        res.delete(left, right);
                        StringBuilder el1 = new StringBuilder(el);
                        for (int j = 1; j < el1.length() - 1; j++) {
                            if (j < el1.length() - 1 && el1.charAt(j) == '`') {
                                el1.deleteCharAt(j);
                                j = 0;
                            }
                        }
                        res.insert(left, el1);
                        System.out.println("Отримуємо \n" + clean(el1.toString()) + "\n");
                        s = res.toString();
                    }
                }
            }
        }
        for (int i = 1; i < res.length() - 1; i++)
            if (res.charAt(i) == '`') {
                res.deleteCharAt(i);
                i = 0;
            }
        return res.toString();
    }


    private static int getNumberOfSigns(String s, char symbol) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == symbol)
                if (i > 0 && s.charAt(i - 1) != '!')
                    res++;

        }
        return res;
    }

    //находим скобку в которой нет других скобок, удаляем ее и заменяем на польку с
    static ArrayList<String> getPolca(String s) {
        System.out.println("Вхідна строка: " + s);
        ArrayList<String> ls = new ArrayList<>(Arrays.asList(s.split("")));
        ls.add(")");
        ls.add(0, "(");

        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).equals("(")) {
                for (int j = i + 1; j < ls.size(); j++) {
                    if (ls.get(j).equals("(")) break;
                    if (ls.get(j).equals(")")) {
                        StringBuilder x = new StringBuilder();
                        for (int k = i; k <= j; k++) {
                            x.append(ls.get(k));
                        }
                        x.deleteCharAt(0);
                        x.deleteCharAt(x.length() - 1);
                        x.insert(0, '`');
                        x.append('`');
                        for (int k = j - i + 1; k > 0; k--) ls.remove(i);
                        ls.add(i, smallPolca(x.toString()));
                        i = 0;
                    }

                }
            }

        }
        return ls;
    }
    static ArrayList<String> getReversedPolca(String s) {
        System.out.println("Вхідна строка: " + s);
        ArrayList<String> ls = new ArrayList<>(Arrays.asList(s.split("")));
        ls.add(")");
        ls.add(0, "(");

        for (int i = 0; i < ls.size(); i++) {
            if (ls.get(i).equals("(")) {
                for (int j = i + 1; j < ls.size(); j++) {
                    if (ls.get(j).equals("(")) break;
                    if (ls.get(j).equals(")")) {
                        StringBuilder x = new StringBuilder();
                        for (int k = i; k <= j; k++) {
                            x.append(ls.get(k));
                        }
                        x.deleteCharAt(0);
                        x.deleteCharAt(x.length() - 1);
                        x.insert(0, '`');
                        x.append('`');
                        for (int k = j - i + 1; k > 0; k--) ls.remove(i);
                        ls.add(i, smalleReversedPolca(x.toString()));
                        i = 0;
                    }

                }
            }

        }
        return ls;
    }

}
