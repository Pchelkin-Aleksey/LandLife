package Herbage;
import Entity.TypeEntitys;
import Island.Cell;
import Island.CellController;

public class Grass{
    private int position_x;
    private int position_y;
    public static final int maxCountInCell = 200;
    public double getWeight() {
        return 1.0;
    }
    public TypeEntitys getType() {
        return TypeEntitys.GRASS;
    }
    Cell cell;
    public Grass (int position_x,int position_y){
        this.position_x = position_x;
        this.position_y = position_y;
        cell = CellController.getCell(position_x,position_y);
    }
    public void die() {
        cell = CellController.getCell(position_x,position_y);
        cell.getGrass().remove(this);
    }
}