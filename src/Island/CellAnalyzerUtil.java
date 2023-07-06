package Island;

import Entity.Animal;
import Entity.TypeEntitys;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CellAnalyzerUtil {
    public static List<Animal> getListType (Cell cell, TypeEntitys ani){
        List<Animal> animals = cell.getAnimals();
        List<Animal> entityArrayList = new ArrayList<>();
        int k = 0;
        int j = animals.size();
        while (k < j){
            try {
                Animal animal = animals.get(k);
                if (ani.equals(animal.getType()))
                    entityArrayList.add(animal);
                j = animals.size();
                k++;
            } catch (Exception ignored){}
        }
        return entityArrayList;
    }
    public static int getCountLandAnimal(TypeEntitys ani){
        int count=0;
        HashMap<String,Cell> cells = Initialization.getCells();
        for (int i=0;i<Initialization.getSizeLand();i++){
            for (int j=0;j<Initialization.getSizeLand();j++){
                Cell cell = cells.get(ResultPositionUtil.getStringCoordinate(i,j));
                count += getListType(cell, ani).size();
            }
        }
        return count;
    }
    public static int getCountLandGrass(){
        int count = 0;
        HashMap<String,Cell> cells = Initialization.getCells();
        for (int i=0;i<Initialization.getSizeLand();i++){
            for (int j=0;j<Initialization.getSizeLand();j++){
                Cell cell = cells.get(ResultPositionUtil.getStringCoordinate(i,j));
                count += cell.getGrass().size();
            }
        }
        return count;
    }
    public static int getCountAnimal(Cell cell, TypeEntitys animal){
        List<Animal> en = getListType(cell, animal);
        return en.size();
    }
}