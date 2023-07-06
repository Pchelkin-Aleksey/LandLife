package Predator;

import Entity.Animal;
import Entity.TypeEntitys;
import Island.CellAnalyzerUtil;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {
    Predator(int position_x, int position_y) {
        super(position_x, position_y);
    }
    public int getrand(int i, int k){
        return ThreadLocalRandom.current().nextInt(i, k);
    }
    @Override
    synchronized public void eat() {
        TypeEntitys[] typeArray =  this.getWhatEat();
        List<Animal> animalsEat;
        for (TypeEntitys typeEntitys : typeArray){
            if (this.fullness >= 100) return;
            animalsEat = CellAnalyzerUtil.getListType(cell,typeEntitys);
            if (animalsEat.isEmpty()) return;
            int randomIndex = getrand(0,animalsEat.size());
            int chance = getrand(1, 101);

            if (getСhanceEat(typeEntitys) >= chance){
                this.fullness += animalsEat.get(randomIndex).getWeight() * 100/getNeedSaturation();
                animalsEat.get(randomIndex).die();
                if (fullness > 100) this.fullness = 100;
            }
        }
    }
}
