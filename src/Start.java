import Entity.StartGeneration;
import Entity.TypeEntitys;
import Island.Cell;
import Island.CellController;
import Island.Initialization;

public class Start {
    private int size;
    private int day;
    Start(int size, int day){
        this.size = size;
        this.day = day;
    }
    private void ini(){
        Initialization.setSize(size);
        Initialization.generateIsland();
        TypeEntitys[] entitys = new TypeEntitys[] {
                TypeEntitys.GRASS,
                TypeEntitys.BOAR,
                TypeEntitys.BUFFALO,
                TypeEntitys.DEER,
                TypeEntitys.GOAT,
                TypeEntitys.HORSE,
                TypeEntitys.MOUSE,
                TypeEntitys.RABBIT,
                TypeEntitys.SHEEP,
                TypeEntitys.BEAR,
                TypeEntitys.BOA,
                TypeEntitys.EAGLE,
                TypeEntitys.FOX,
                TypeEntitys.WOLF
        };
        for (TypeEntitys type : entitys) StartGeneration.startGeneration(type);
    }
    public void start(){
        ini();
        Show show = new Show();
        Thread thread;
        StartGeneration startGeneration = new StartGeneration();
        for (int k = 1; k < day + 1; k++){
            for (int i = 0; i < Initialization.getSizeLand(); i++) {
                for (int j = 0; j < Initialization.getSizeLand(); j++) {
                    Cell cell = CellController.getCell(i,j);
                    cell.live();
                }
                thread = new Thread(startGeneration);
                thread.start();
            }
            show.show(k);
        }
    }
}