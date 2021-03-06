package DragonCastle.Characters.Heroes;

import DragonCastle.Characters.Character;

import java.util.ArrayList;

public abstract class Hero extends Character {

    private ArrayList<Treasure> inventory;
    private String type;

    public Hero(String name, String type){
        super(name);
        this.type = type;
        this.inventory = new ArrayList<Treasure>();
        }

    public void addToInventory(Treasure treasureItem){
        inventory.add(treasureItem);
    }

    public Treasure removeFromInventory(){
        Treasure itemToRemove = null;
        if(inventory.size() > 0){itemToRemove = inventory.remove(0);}
        return itemToRemove;
    }

    public ArrayList<Treasure> getInventory() {
        return inventory;
    }

    public int getTotalTreasureValue(){
        int total = 0;
        for(Treasure item : inventory){
            total += item.getTreasureValue();
        }
        return total;
    }

    public String getType() {
        return type;
    }
}
