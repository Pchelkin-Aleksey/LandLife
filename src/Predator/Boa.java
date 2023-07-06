package Predator;

import Entity.TypeEntitys;

public class Boa extends Predator{
    public Boa(int position_x, int position_y) {
        super(position_x, position_y);
    }

    public static final int maxCountInCell = 30;
    @Override
    public TypeEntitys getType() {
        return TypeEntitys.BOA;
    }

    @Override
    protected int getSpeed() {
        return 1;
    }

    @Override
    protected int getMaxCountInCell() {
        return 30;
    }

    @Override
    public double getWeight() {
        return 15;
    }

    @Override
    protected double getNeedSaturation() {
        return 3;
    }

    @Override
    protected TypeEntitys[] getWhatEat() {
        return new TypeEntitys[] {TypeEntitys.FOX, TypeEntitys.RABBIT, TypeEntitys.MOUSE  };
    }

    @Override
    protected int getСhanceEat(TypeEntitys type) {
        switch (type){
            case RABBIT -> {
                return 20;
            }
            case FOX -> {
                return 15;
            }
            case MOUSE -> {
                return 40;
            }
        }
        return 0;
    }
}
