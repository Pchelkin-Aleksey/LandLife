package Predator;

import Entity.TypeEntitys;

public class Wolf extends Predator{

    public Wolf(int position_x, int position_y) {
        super(position_x, position_y);
    }
    public static final int maxCountInCell = 30;
    @Override
    public TypeEntitys getType() {
        return TypeEntitys.WOLF;
    }

    @Override
    protected int getSpeed() {
        return 3;
    }

    @Override
    protected int getMaxCountInCell() {
        return 30;
    }

    @Override
    public double getWeight() {
        return 50;
    }

    @Override
    protected double getNeedSaturation() {
        return 8;
    }

    @Override
    protected TypeEntitys[] getWhatEat() {
        return new TypeEntitys[] {TypeEntitys.HORSE, TypeEntitys.DEER, TypeEntitys.GOAT, TypeEntitys.SHEEP, TypeEntitys.MOUSE, TypeEntitys.BOAR, TypeEntitys.BUFFALO, TypeEntitys.RABBIT};
    }

    @Override
    protected int getСhanceEat(TypeEntitys type) {
        switch (type){
            case RABBIT, SHEEP -> {
                return 70;
            }
            case HORSE, BUFFALO -> {
                return 10;
            }
            case DEER, BOAR -> {
                return 15;
            }
            case GOAT -> {
                return 60;
            }
            case MOUSE -> {
                return 80;
            }
        }
        return 0;
    }
}
