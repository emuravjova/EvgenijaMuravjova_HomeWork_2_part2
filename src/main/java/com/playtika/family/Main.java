package com.playtika.family;

/**
 * Created by jane on 9/23/17.
 */
public class Main {
    public static void main(String[] args) {
        Parent mother = new Parent("mother",10,10);
        Child sun = new Child("sun");
        mother.child = sun;
        mother.feed(2);
        sun.sayIfHungry();
        mother.feed(6);
        sun.sayIfHungry();
        mother.play(3);
        sun.sayIfBored();
        mother.play(6);
        sun.sayIfBored();
    }
}
