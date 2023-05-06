package com.example.spring.study.doudizhu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author TwinkleDing
 */
public class App {

    static HashMap<Integer, String> hm = new HashMap<>();
    static ArrayList<Integer> list = new ArrayList<>();

    static {
        String[] color = {"♦", "♣", "♥", "♠"};
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2"};

        int serialNumber = 1;
        for (String n : number) {
            for (String c : color) {
                list.add(serialNumber);
                hm.put(serialNumber, c + n);
                serialNumber++;
            }
        }
        hm.put(serialNumber, "小王");
        list.add(serialNumber);
        serialNumber++;
        hm.put(serialNumber, "大王");
        list.add(serialNumber);
    }

    public App() {
        Collections.shuffle(list);

        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> p1 = new TreeSet<>();
        TreeSet<Integer> p2 = new TreeSet<>();
        TreeSet<Integer> p3 = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            int serialNumber = list.get(i);
            if (i <= 2) {
                lord.add(serialNumber);
                continue;
            }
            if (i % 3 == 0) {
                p1.add(serialNumber);
            }
            if (i % 3 == 1) {
                p2.add(serialNumber);
            }
            if (i % 3 == 2) {
                p3.add(serialNumber);
            }
        }

        // 看牌
        lookPoker("底牌", lord);
        lookPoker("Player1", p1);
        lookPoker("Player2", p2);
        lookPoker("Player3", p3);
    }

    public void lookPoker(String name, TreeSet<Integer> list) {
        System.out.print(name + "：");
        for (Integer i : list) {
            String poker = hm.get(i);
            System.out.print(" " + poker + " ");
        }
        System.out.println();
    }

}
