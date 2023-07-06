package Herbivore;

import Entity.TypeEntitys;

public class Boar extends Herbivore{
    public Boar(int position_x, int position_y) {
        super(position_x, position_y);
    }
    public static final int maxCount = 50;

    @Override
    public TypeEntitys getType() {
        return TypeEntitys.BOAR;
    }

    @Override
    protected int getSpeed() {
        return 2;
    }

    @Override
    protected int getMaxCountInCell() {
        return 50;
    }

    @Override
    public double getWeight() {
        return 400;
    }

    @Override
    protected double getNeedSaturation() {
        return 50;
    }

    @Override
    protected TypeEntitys[] getWhatEat() {
        return new TypeEntitys[0];
    }

    @Override
    protected int getСhanceEat(TypeEntitys type) {
        return 0;
    }
}
