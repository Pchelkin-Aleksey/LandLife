package Predator;

import Entity.TypeEntitys;

public class Bear extends Predator {
    public static final int maxCountInCell = 5;
    public Bear(int position_x, int position_y) {
        super(position_x, position_y);
    }

    @Override
    public TypeEntitys getType() {
        return TypeEntitys.BEAR;
    }

    @Override
    protected int getSpeed() {
        return 2;
    }

    @Override
    protected int getMaxCountInCell() {
        return 5;
    }

    @Override
    public double getWeight() {
        return 500;
    }

    @Override
    protected double getNeedSaturation() {
        return 80;
    }

    @Override
    protected TypeEntitys[] getWhatEat() {
        return new TypeEntitys[] {TypeEntitys.GOAT,TypeEntitys.HORSE, TypeEntitys.DEER, TypeEntitys.RABBIT, TypeEntitys.MOUSE, TypeEntitys.GOAT, TypeEntitys.SHEEP, TypeEntitys.BOAR,TypeEntitys.BUFFALO };
    }

    @Override
    protected int getСhanceEat(TypeEntitys type) {
        switch (type){
            case RABBIT -> {
                return 60;
            }
            case BUFFALO -> {
                return 20;
            }
            case BOAR -> {
                return 50;
            }
            case SHEEP, GOAT -> {
                return 70;
            }
            case MOUSE -> {
                return 90;
            }
            case DEER, BOA -> {
                return 80;
            }
            case HORSE -> {
                return 40;
            }
        }
        return 0;
    }
}
