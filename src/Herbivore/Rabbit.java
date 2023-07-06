package Herbivore;

import Entity.TypeEntitys;

public class Rabbit extends Herbivore {
    public static final int maxCount = 150;
    public Rabbit(int position_x, int position_y) {
        super(position_x, position_y);
    }
    @Override
    public TypeEntitys getType() {
        return TypeEntitys.RABBIT;
    }
    @Override
    protected int getSpeed() {
        return 2;
    }
    @Override
    protected int getMaxCountInCell() {
        return 150;
    }
    @Override
    public double getWeight() {
        return 2;
    }
    @Override
    protected double getNeedSaturation() {
        return 0.45;
    }
    @Override
    protected TypeEntitys[] getWhatEat() {
        return new TypeEntitys[] {TypeEntitys.GRASS};
    }
    protected int getСhanceEat(TypeEntitys type) {
        switch (type){
            case GRASS -> {
                return 100;
            }
        }
        return 0;
    }
}
