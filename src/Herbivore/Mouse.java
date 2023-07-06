package Herbivore;

import Entity.TypeEntitys;

public class Mouse extends Herbivore {
    public Mouse(int position_x, int position_y) {
        super(position_x, position_y);
    }
    public static final int maxCount = 500;
    @Override
    public TypeEntitys getType() {
        return TypeEntitys.MOUSE;
    }

    @Override
    protected int getSpeed() {
        return 1;
    }

    @Override
    protected int getMaxCountInCell() {
        return 500;
    }

    @Override
    public double getWeight() {
        return 0.05;
    }

    @Override
    protected double getNeedSaturation() {
        return 0.01;
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
