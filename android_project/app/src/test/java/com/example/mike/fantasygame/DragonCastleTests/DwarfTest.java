package com.example.mike.fantasygame.DragonCastleTests;



import com.example.mike.fantasygame.DragonCastle.Characters.Creatures.Creature;
import com.example.mike.fantasygame.DragonCastle.Characters.Creatures.CreatureType;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters.Defence;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters.Dwarf;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Fighters.Weapon;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DwarfTest {
    private Dwarf dwarf1;
    private Creature dragon1;

    @Before
    public void before(){
        dwarf1 = new Dwarf("Simon");
        dragon1 = new Creature(CreatureType.DRAGON);

    }

    @Test
    public void canAssert(){
        assertEquals(1,1);
    }

    @Test
    public void hasName(){
        assertEquals("Simon", dwarf1.getName());
    }

    @Test
    public void hasAxe(){
        assertEquals(Weapon.AXE, dwarf1.getWeapon());
    }

    @Test
    public void hasArmor(){
        assertEquals(Defence.ARMOUR, dwarf1.getDefence());
    }

    @Test
    public void armorReducesDamage(){
        dwarf1.takeDamage(100);
        assertEquals(25, dwarf1.getHp());
    }

    @Test
    public void hasThrowingAxes(){
        assertEquals(5, dwarf1.getThrowingAxes().size());
    }

//    Commented Out Due to the randomness of moves.

//    @Test
//    public void canUseStandardMove(){
//        dwarf1.standardMove(dragon1);
//        assertEquals(110, dragon1.getHp());
//    }

//    @Test
//    public void canUseSignatureMove(){
//        dwarf1.signatureMove(dragon1);
//        assertEquals(140, dragon1.getHp());
//    }

    @Test
    public void canOnlyUseSignatureMoveAsLongAsThereAreAxes(){
        dwarf1.signatureMove(dragon1);
        dwarf1.signatureMove(dragon1);
        dwarf1.signatureMove(dragon1);
        dwarf1.signatureMove(dragon1);
        dwarf1.signatureMove(dragon1);
        dwarf1.signatureMove(dragon1);
        dwarf1.signatureMove(dragon1);
        dwarf1.signatureMove(dragon1);
        dwarf1.signatureMove(dragon1);
        assertEquals(100, dragon1.getHp());
        assertEquals(0, dwarf1.getThrowingAxes().size());
    }

//    Random tests
//    @Test
//    public void signatureMoveReturnsString(){
//    assertEquals("Simon attacked Dragony successfully.", dwarf1.signatureMove(dragon1));
//    }
//
//    @Test
//    public void outOfAxesMessage(){
//        dwarf1.signatureMove(dragon1);
//        dwarf1.signatureMove(dragon1);
//        dwarf1.signatureMove(dragon1);
//        dwarf1.signatureMove(dragon1);
//        dwarf1.signatureMove(dragon1);
//        dwarf1.signatureMove(dragon1);
//        dwarf1.signatureMove(dragon1);
//        dwarf1.signatureMove(dragon1);
//        assertEquals("Simon is out of Throwing Axes!",dwarf1.signatureMove(dragon1));
//    }

}
