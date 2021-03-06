package com.example.mike.fantasygame.DragonCastle.Room;

import com.example.mike.fantasygame.DragonCastle.Characters.Character;
import com.example.mike.fantasygame.DragonCastle.Characters.Creatures.Creature;
import com.example.mike.fantasygame.DragonCastle.Characters.Creatures.CreatureType;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Healers.Cleric;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Hero;
import com.example.mike.fantasygame.DragonCastle.Characters.Heroes.Treasure;
import com.example.mike.fantasygame.DragonCastle.Characters.Narrator;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Room implements Serializable{

    private Character monster;
    private Treasure treasure;
    private ArrayList<Hero> heroes;


    public Room(){
        this.monster = new Creature(CreatureType.getRandomCreature());
        this.treasure = Treasure.getRandomTreasure();
        this.heroes = new ArrayList<>();
    }

    public Character getMonster() {
        return monster;
    }

    public Treasure getTreasure() {
        return treasure;
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }

    public Boolean noHeroesAlive(){
        return heroes.isEmpty();
    }

    public void addHeroes(Hero hero){
        heroes.add(hero);
    }

    public void addHeroesFromHallway(ArrayList<Hero> heroesFromHallway){
        heroes = heroesFromHallway;
    }


    public boolean isFightOver(){
        if (monster.getHp()<= 0 || areAllHeroesDefeated()) {
            return true;
        }
        return false;
    }

    public boolean areAllHeroesDefeated() {
        int aliveCounter = 0;
        for (Hero h : heroes) {
            if (h.getHp() > 0) {aliveCounter++;}
        }
        if (aliveCounter == 0) { return true; }

        else return false;
    }

    public Boolean isMonsterDead(){
        if (monster.getHp() <= 0){
            return true;
        }
        return false;
    }

    public void heroesCollectTreasure(){
        returnAliveHeroes().get(0).addToInventory(treasure);
    }

    public void heroStandardMove(Hero hero){
        if (hero.getHp() > 0){
            if (hero.getType() == "Healer"){
                Narrator.getInstance().addStoryLine(hero.standardMove(heroWithLowestHealth()));
            }
            else if (hero.getType() == "Attacker"){
                Narrator.getInstance().addStoryLine(hero.standardMove(monster));
            }
        }
        else Narrator.getInstance().addStoryLine(hero.getName() + " is dead!");

    }

    public void heroSignatureMove(Hero hero){
        if (hero.getHp() > 0){
            if (hero.getType() == "Healer"){
                Narrator.getInstance().addStoryLine(hero.signatureMove(heroWithLowestHealth()));
            }
            else Narrator.getInstance().addStoryLine(hero.signatureMove(monster));}
        else Narrator.getInstance().addStoryLine(hero.getName() + " is dead!");
        }

    public Hero heroWithLowestHealth(){
        Hero heroToHeal = null;
        for (Hero h: heroes) {
            if (heroToHeal == null){
                heroToHeal = h;
            }
            else {
                if (heroToHeal.getHp() > h.getHp()){
                    heroToHeal = h;
                }
            }
        }
        return heroToHeal;
    }

    public void monsterAttacks(){
        Hero heroTarget = this.returnRandomAliveHero();
        if (monster.getHp() > 0){
            if(this.returnFiftyFifty() < 2 ){
                Narrator.getInstance().addStoryLine(monster.standardMove(heroTarget));
            }
            else Narrator.getInstance().addStoryLine(monster.signatureMove(heroTarget));
        }
        else Narrator.getInstance().addStoryLine(monster.getName() + " is dead!");
    }

    public Hero returnRandomAliveHero(){
        Hero heroToAttack = null;
        ArrayList<Hero> aliveHeroes = this.returnAliveHeroes();
        Collections.shuffle(aliveHeroes);
        heroToAttack = aliveHeroes.get(0);
        return heroToAttack;
    }

    public ArrayList<Hero> returnAliveHeroes(){
        ArrayList<Hero> aliveHeroes = new ArrayList<>();
        for (Hero h: heroes){
            if (h.getHp() > 0){
                aliveHeroes.add(h);
            }
        }
        return aliveHeroes;
    }

    public int returnFiftyFifty(){
        Random rand = new Random();
        return (1 + rand.nextInt((2 - 1) + 1));
    }

    public Hero getHeroByName(String heroName){
        Hero heroToFind = null;
        for (Hero h: heroes) {
            if (h.getName() == heroName){
                heroToFind = h;
            }
        }
        return heroToFind;
    }
}
