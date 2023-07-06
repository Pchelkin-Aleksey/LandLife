package Herbivore;

import Entity.TypeEntitys;

public class Deer extends Herbivore {
    public Deer(int position_x, int position_y) {
        super(position_x, position_y);
    }
    public static final int maxCount = 20;
    @Override
    public TypeEntitys getType() {
        return TypeEntitys.DEER;
    }

    @Override
    protected int getSpeed() {
        return 4;
    }

    @Override
    protected int getMaxCountInCell() {
        return 20;
    }

    @Override
    public double getWeight() {
        return 300;
    }

    @Override
    protected double getNeedSaturation() {
        return 50;
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
