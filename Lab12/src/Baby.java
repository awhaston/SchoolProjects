/*
Class: CSE 1321L
Section: WJ1
Term: Spring 2022
Instructor: Leul Endashaw
Name: Wyatt Haston
Lab#: 12
*/

import java.util.Random;

public class Baby implements Runnable{
    private int time;
    private String name;

    public Baby(String name) {
        Random random = new Random();
        this.time = random.nextInt(5000);
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println("I am going to sleep for " + time + "ms.");
            Thread.sleep(time);
            System.out.println("My name is " + name + " and I am awake! Feed me!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
