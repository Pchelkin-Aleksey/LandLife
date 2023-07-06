package Predator;

import Entity.TypeEntitys;

public class Eagle extends Predator {
    public Eagle(int position_x, int position_y) {
        super(position_x, position_y);
    }
    public static final int maxCountInCell = 20;
    @Override
    public TypeEntitys getType() {
        return TypeEntitys.EAGLE;
    }

    @Override
    protected int getSpeed() {
        return 3;
    }

    @Override
    protected int getMaxCountInCell() {
        return 20;
    }

    @Override
    public double getWeight() {
        return 6;
    }

    @Override
    protected double getNeedSaturation() {
        return 1;
    }

    @Override
    protected TypeEntitys[] getWhatEat() {
        return new TypeEntitys[] {TypeEntitys.FOX, TypeEntitys.RABBIT, TypeEntitys.MOUSE };
    }

    @Override
    protected int getСhanceEat(TypeEntitys type) {
        switch (type){
            case RABBIT, MOUSE -> {
                return 90;
            }
            case FOX -> {
                return 10;
            }
        }
        return 0;
    }
}
