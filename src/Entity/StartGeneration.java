package Entity;

import Herbage.Grass;
import Herbivore.*;
import Island.*;
import Predator.*;

import java.util.concurrent.ThreadLocalRandom;

public class StartGeneration implements Runnable {
    public StartGeneration() {}
    private static ResultPositionUtil generationPositions() {
        int x_position = ThreadLocalRandom.current().nextInt(0, Initialization.getSizeLand());
        int y_position = ThreadLocalRandom.current().nextInt(0, Initialization.getSizeLand());
        return new ResultPositionUtil(x_position, y_position);
    }
    private static void generationGrass() {
        ResultPositionUtil pos = generationPositions();
        Cell cell = CellController.getCell(pos.x_position, pos.y_position);
        int count = ThreadLocalRandom.current().nextInt(0, Grass.maxCountInCell - cell.getGrass().size());
        for (int i = 0; i < count; i++) {
            cell.addGrass(new Grass(pos.x_position, pos.y_position));
        }
    }
    private static int getCount(TypeEntitys type) {
        switch (type) {
            case BOAR -> {
                return Boar.maxCount;
            }
            case BUFFALO -> {
                return Buffalo.maxCount;
            }
            case DEER -> {
                return Deer.maxCount;
            }
            case GOAT -> {
                return Goat.maxCount;
            }
            case HORSE -> {
                return Horse.maxCount;
            }
            case MOUSE -> {
                return Mouse.maxCount;
            }
            case RABBIT -> {
                return Rabbit.maxCount;
            }
            case SHEEP -> {
                return Sheep.maxCount;
            }
            case BEAR -> {
                return Bear.maxCountInCell;
            }
            case BOA -> {
                return Boa.maxCountInCell;
            }
            case EAGLE -> {
                return Eagle.maxCountInCell;
            }
            case FOX -> {
                return Fox.maxCountInCell;
            }
            case WOLF -> {
                return Wolf.maxCountInCell;
            }
        }
        return 0;
    }

    private static void generationAnimal(TypeEntitys type) {
        ResultPositionUtil pos = generationPositions();
        Cell cell = CellController.getCell(pos.x_position, pos.y_position);
        int count = ThreadLocalRandom.current().nextInt(0, getCount(type));
        for (int i = 0; i < count; i++) {
            switch (type) {
                case BOAR -> cell.addAnimal(new Boar(pos.x_position, pos.y_position));
                case BUFFALO -> cell.addAnimal(new Buffalo(pos.x_position, pos.y_position));
                case DEER -> cell.addAnimal(new Deer(pos.x_position, pos.y_position));
                case GOAT -> cell.addAnimal(new Goat(pos.x_position, pos.y_position));
                case HORSE -> cell.addAnimal(new Horse(pos.x_position, pos.y_position));
                case MOUSE -> cell.addAnimal(new Mouse(pos.x_position, pos.y_position));
                case RABBIT -> cell.addAnimal(new Rabbit(pos.x_position, pos.y_position));
                case SHEEP -> cell.addAnimal(new Sheep(pos.x_position, pos.y_position));
                case BEAR -> cell.addAnimal(new Bear(pos.x_position, pos.y_position));
                case BOA -> cell.addAnimal(new Boa(pos.x_position, pos.y_position));
                case EAGLE -> cell.addAnimal(new Eagle(pos.x_position, pos.y_position));
                case FOX -> cell.addAnimal(new Fox(pos.x_position, pos.y_position));
                case WOLF -> cell.addAnimal(new Wolf(pos.x_position, pos.y_position));
            }
        }
    }

    public static void startGeneration(TypeEntitys type) {
        int count = ThreadLocalRandom.current().nextInt(1, Initialization.getSizeLand());
        for (int i = 0; i < count; i++) {
            if (type == TypeEntitys.GRASS) generationGrass();
            else generationAnimal(type);
        }
    }

    @Override
    synchronized public void run() {
        generationGrass();
    }
}
