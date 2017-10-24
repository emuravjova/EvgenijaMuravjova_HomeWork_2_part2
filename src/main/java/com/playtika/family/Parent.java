package com.playtika.family;

/**
 * Created by jane on 9/22/17.
 */
public class Parent extends FamilyMembers {

    private int parentTime;
    private int parentFood;
    public Child child;

    public Parent(String familyRole, int parentTime, int parentFood) {
        super(familyRole);
        this.parentTime = parentTime;
        this.parentFood = parentFood;
    }

    @Override
    void play(int time) {
        parentTime = parentTime - time;
        child.play(time);
    }

    void feed(int food) {
        parentFood = parentFood - food;
        child.eat(food);
    }


}
