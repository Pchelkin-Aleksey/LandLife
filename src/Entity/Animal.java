package Entity;
import Island.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.ReentrantLock;

public abstract class Animal implements Actions, Runnable {
    ReentrantLock reentrantLock;
    private int position_x;
    private int position_y;
    public double fullness = 100;

    public Cell cell;
    protected Animal(int position_x, int position_y) {
        this.position_x = position_x;
        this.position_y = position_y;
        cell = CellController.getCell(position_x,position_y);
        reentrantLock = new ReentrantLock();
    }
    public abstract TypeEntitys getType();
    protected abstract int getSpeed(); // скорость
    protected abstract int getMaxCountInCell(); // максимум на клетке
    public abstract double getWeight(); //масса
    protected abstract double getNeedSaturation(); // Необходимая насыщенность
    protected abstract TypeEntitys[] getWhatEat(); // массив типов которые ест животное
    protected abstract int getСhanceEat(TypeEntitys type); // шанс быть сьеденым
    @Override
    public synchronized void move() {
        if(this.getSpeed() == 0) return;
        Animal animal = this;
        chooseDirection();
        cell.addAnimal(this);
        cell.remuveAnimal(animal);
    }
    private void chooseDirection(){
        int last_x = position_x;
        int last_y = position_y;
        int direction = ThreadLocalRandom.current().nextInt(0,4);
        if (direction == 0) position_x += getSpeed();
        else if (direction == 2) position_x -= getSpeed();
        else if (direction == 1) position_y += getSpeed();
        else position_y -= getSpeed();
        checkPos();
        if(CellAnalyzerUtil.getCountAnimal(cell,getType()) > this.getMaxCountInCell()) {
            position_x = last_x;
            position_y = last_y;
        }
    }
    private void checkPos(){
        if (position_x > Initialization.getSizeLand() -1) position_x -= Initialization.getSizeLand();
        if(position_x < 0) position_x += Initialization.getSizeLand();
        if (position_y > Initialization.getSizeLand()-1) position_y -= Initialization.getSizeLand();
        if (position_y < 0) position_y += Initialization.getSizeLand();
    }
    @Override
    public synchronized void multiply() {
        List<Animal> entities = CellAnalyzerUtil.getListType(cell,this.getType());
        if (entities.isEmpty()) return;
        if (this.getMaxCountInCell() > entities.size()+1)
            cell.getAnimals().add(this);
    }
    @Override
    public synchronized void slim(){
        fullness = fullness/3 - 0.5;
        if (fullness <= 0) this.die();
    }
    @Override
    public synchronized void die() {
        cell = CellController.getCell(position_x,position_y);
        cell.getAnimals().remove(this);
    }

    @Override
    synchronized public void run(){
        reentrantLock.lock();
        move();
        slim();
        eat();
        multiply();
        reentrantLock.unlock();
    }
}