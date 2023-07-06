package Predator;

import Entity.TypeEntitys;

public class Fox extends Predator{
    public static final int maxCountInCell = 30;
    public Fox(int position_x, int position_y) {
        super(position_x, position_y);
    }

    @Override
    public TypeEntitys getType() {
        return TypeEntitys.FOX;
    }

    @Override
    protected int getSpeed() {
        return 2;
    }

    @Override
    protected int getMaxCountInCell() {
        return 30;
    }

    @Override
    public double getWeight() {
        return 8;
    }

    @Override
    protected double getNeedSaturation() {
        return 2;
    }

    @Override
    protected TypeEntitys[] getWhatEat() {
        return new TypeEntitys[] {TypeEntitys.RABBIT};
    }

    @Override
    protected int getСhanceEat(TypeEntitys type) {
        switch (type){
            case RABBIT -> {
                return 70;
            }
        }
        return 0;
    }
}
