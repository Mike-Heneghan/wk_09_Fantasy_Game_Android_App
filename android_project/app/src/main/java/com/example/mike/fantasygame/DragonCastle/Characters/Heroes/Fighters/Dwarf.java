package com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters;

import com.example.mike.fantasygame.DragonCastle.Characters.Character;

import java.io.Serializable;
import java.util.ArrayList;

public class Dwarf extends Fighter implements Serializable {
    private ArrayList<Weapon> throwingAxes;

    public Dwarf(String name){
        super(name);
        this.imageId = 2;
        weapon = Weapon.AXE;
        defence = Defence.ARMOUR;
        throwingAxes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            throwingAxes.add(Weapon.TINYAXE);
        }
    }

    public ArrayList<Weapon> getThrowingAxes() {
        return throwingAxes;
    }

    public String signatureMove(Character characterToAttack) {
        if (throwingAxes.size() > 0) {
            if (shouldDoMove(throwingAxes.get(0).chanceValue)) {
                characterToAttack.takeDamage(throwingAxes.get(0).damageValue);
                throwingAxes.remove(0);
                return this.getName() + " attacked " + characterToAttack.getName() + " successfully.";
            }
            return this.getName() + " missed " + characterToAttack.getName() + "!";
        }
        return this.getName() + " is out of Throwing Axes!";
    }
}
