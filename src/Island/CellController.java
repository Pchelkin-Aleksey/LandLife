package Island;

import java.util.ArrayList;

public class CellController {
    public static Cell getCell(int position_x, int position_y){
        return Initialization.getCells().get(ResultPositionUtil.getStringCoordinate(position_x,position_y));
    }
    public ArrayList<Cell> getListCell(){
        ArrayList<Cell> cells1 = new ArrayList<>();
        for (int i = 0; i < Initialization.getSizeLand(); i++)
            for(int j = 0; j < Initialization.getSizeLand(); j++)
                cells1.add(getCell(i,j));
        return cells1;
    }
}
