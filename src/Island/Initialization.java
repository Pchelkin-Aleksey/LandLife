package Island;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Initialization {
    private static int sizeLand;
    private static Map<String, Cell> cells = Collections.synchronizedMap(new HashMap<>());
    public static void generateIsland(){
        cells = new HashMap<>();
        for (int i = 0; i < sizeLand; i++)
            for (int j = 0; j < sizeLand; j++)
                cells.put(ResultPositionUtil.getStringCoordinate(i, j), new Cell(i, j));
    }
    public static void setSize(int size){
        sizeLand = size;
    }
    public static int getSizeLand(){
        return sizeLand;
    }
    public static HashMap<String, Cell> getCells(){
        return (HashMap<String, Cell>) cells;
    }
}