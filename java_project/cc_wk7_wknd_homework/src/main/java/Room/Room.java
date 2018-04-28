package Room;

import Characters.Character;
import Characters.Creatures.Creature;
import Characters.Creatures.CreatureType;
import Characters.Heroes.Healers.Cleric;
import Characters.Heroes.Hero;
import Characters.Heroes.Treasure;
import Characters.Narrator;

import java.util.ArrayList;

public class Room {

    private Narrator narrator;
    private Character monster;
    private Treasure treasure;
    private ArrayList<Hero> heroes;


    public Room(){
        this.narrator = new Narrator();
        this.monster = new Creature(CreatureType.getRandomCreature());
        this.treasure = Treasure.getRandomTreasure();
        this.heroes = new ArrayList<>();
    }

    public Narrator getNarrator() {
        return narrator;
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

    //For encounter- collectTreasure to be used as a conditional if any heroes remain alive.
    public void heroesCollectTreasure(){
        Hero hero = heroes.get(0);
        hero.addToInventory(this.treasure);
        this.treasure = null;
    }

    //For encounter - returning our heroes at the end of a fight if any remain alive afterwards.
    public ArrayList<Hero> returnRemainingHeroes(){
        ArrayList<Hero> remainingHeroes = new ArrayList<>();
        for (Hero hero : heroes){
            if(!hero.characterDead()){
                remainingHeroes.add(hero);
            }
        }
        for (Hero h: remainingHeroes) {
            narrator.addStoryLine(h.getName() + " survived the encounter" + " Treasure: " + h.getTotalTreasureValue() + " Health Points: " + h.getHp());
        }
        return remainingHeroes;
    }

    //For encounter. The heroes will all have a go at monster and monster will have a go at heroes.
    public void heroesFightMonster(){
        for(Hero hero : heroes){
            if (hero.getType() == "Healer"){
                narrator.addStoryLine(hero.standardMove(heroes.get(0)));
                narrator.addStoryLine(monster.standardMove(hero)); }
            else {narrator.addStoryLine(hero.standardMove(monster));
            narrator.addStoryLine(monster.standardMove(hero));}
        }

    }

    //For encounter. A boolean to check is there are any heroes left alive after the fight round. Can probably remove this and use remainingHeroes.isempty() as a conditional.
    public boolean allHeroesDead(){
        return returnRemainingHeroes().isEmpty();
    }

    //For encounter. A loop to have heroes and creatures fight until there is a winner.
    public void fight(){
        while(!monster.characterDead() && !allHeroesDead()){
            heroesFightMonster();
        }

    }

    public void encounter(){
        fight();
        if(!returnRemainingHeroes().isEmpty()){
            heroesCollectTreasure();

        }
    }





//    public ArrayList<Character> encounter( ArrayList<Character> heroes){
//
//    }
}
