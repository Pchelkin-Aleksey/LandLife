package Herbivore;

import Entity.TypeEntitys;

public class Sheep extends Herbivore{
    public Sheep(int position_x, int position_y) {
        super(position_x, position_y);
    }
    public static final int maxCount = 140;
    @Override
    public TypeEntitys getType() {
        return TypeEntitys.SHEEP;
    }

    @Override
    protected int getSpeed() {
        return 3;
    }

    @Override
    protected int getMaxCountInCell() {
        return 140;
    }

    @Override
    public double getWeight() {
        return 70;
    }

    @Override
    protected double getNeedSaturation() {
        return 15;
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