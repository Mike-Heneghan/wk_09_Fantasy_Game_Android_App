package DragonCastle.Characters.Heroes.Fighters;

import DragonCastle.Characters.Character;

public class Knight extends Fighter {

    public Knight(String name){
        super(name);
        this.imageId = 1;
        this.weapon = Weapon.SWORD;
        this.defence = Defence.SHIELD;
    }

    public int stab(){
        return 20;
    }

    //move2
    //For the knight the stab has 100% chance of hitting.
    public String signatureMove(Character characterToAttack){
       {characterToAttack.takeDamage(this.stab());}
       return this.getName() + " attacked " + characterToAttack.getName() + " successfully.";
    }


}
