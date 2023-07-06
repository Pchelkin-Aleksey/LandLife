package Herbivore;

import Entity.Animal;
import Entity.TypeEntitys;
import Herbage.Grass;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivore extends Animal {
    protected Herbivore(int position_x, int position_y) {
        super(position_x, position_y);
    }
    public int getrand(int i, int k){
        return ThreadLocalRandom.current().nextInt(i, k);
    }
    @Override
    synchronized public void eat() {
        if (fullness >= 100) return;
        ArrayList<Grass> grassEat = cell.getGrass();
        if (grassEat.isEmpty()) return;
        int randomIndex = getrand(0,grassEat.size());
        int chance = getrand(1, 101);

        if (getСhanceEat(TypeEntitys.GRASS) >= chance){
            try {
                if (grassEat.get(randomIndex) != null) {
                    fullness += grassEat.get(randomIndex).getWeight() * 100/getNeedSaturation();
                    grassEat.get(randomIndex).die();
                    if (fullness > 100) fullness = 100;
                }
            } catch (Exception e) {return;}
        }
    }
}
