package DragonCastle.Characters.Heroes.Mages;

import DragonCastle.Characters.Character;
import DragonCastle.Characters.Creatures.Creature;
import DragonCastle.Characters.Heroes.Treasure;

import java.util.ArrayList;

public class Warlock extends Mage {

    public Warlock(String name){
        super(name);
        this.imageId = 4;
    }

    //move 2. This takes the Warlock's creature's second attack, which is high damage but low chance and will apply it to the character being attacked.
    //There is a weird bug in this method. I should just be able to call this.creature but instead I have to call its getter. Why?
    //The creature is private in the mage class so you can only access it with the public getCreature method.

    public String signatureMove(Character characterToAttack){
        if (shouldDoMove(getCreature().getMv2ChanceValue())) {
            characterToAttack.takeDamage(getCreature().getMv2DamageValue());
            return this.getName() + " attacked " + characterToAttack.getName() + " successfully.";
        }
        return this.getName() + " missed " +characterToAttack.getName() + "!";
    }

}
