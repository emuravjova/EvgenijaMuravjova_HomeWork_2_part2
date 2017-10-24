package com.playtika.family;

/**
 * Created by jane on 9/22/17.
 */
abstract class FamilyMembers {
    final String familyRole;

    public FamilyMembers(String familyRole) {
        this.familyRole = familyRole;
    }

    abstract void play(int time);
}