package Island;

import Entity.Animal;
import Herbage.Grass;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Cell {
    ReentrantLock reentrantLock;
    private int position_x = 0;
    private int position_y = 0;
    private final List<Animal> animals;
    private final ArrayList<Grass> grasses;
    Cell(int position_x, int position_y){
        this.position_x = position_x;
        this.position_y = position_y;
        grasses = new ArrayList<>();
        animals = Collections.synchronizedList(new ArrayList<Animal>());
        reentrantLock = new ReentrantLock();
    }
    public ArrayList<Grass> getGrass(){
        return grasses;
    }
    public void addGrass(Grass grass){
        grasses.add(grass);
    }
    synchronized public void addAnimal(Animal animal){animals.add(animal);}
    synchronized public void remuveAnimal(Animal animal){
        animals.remove(animal);
    }

    synchronized public List<Animal> getAnimals(){
        return animals;
    }
    public void live() {
        Thread thread;
        int iterator = 0;
        int siize = animals.size();

       while (iterator < siize){
           Animal animal;
           try {
               animal = animals.get(iterator);
           } catch (Exception e){
               iterator++;
               continue;
           }
           thread = new Thread(animal);
           thread.start();
           iterator++;
           siize = animals.size();
       }
   }
}