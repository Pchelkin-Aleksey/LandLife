package Herbivore;

import Entity.TypeEntitys;

public class Buffalo extends Herbivore{
    public Buffalo(int position_x, int position_y) {
        super(position_x, position_y);
    }
    public static final int maxCount = 10;
    @Override
    public TypeEntitys getType() {
        return TypeEntitys.BUFFALO;
    }

    @Override
    protected int getSpeed() {
        return 3;
    }

    @Override
    protected int getMaxCountInCell() {
        return 10;
    }

    @Override
    public double getWeight() {
        return 700;
    }

    @Override
    protected double getNeedSaturation() {
        return 100;
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
