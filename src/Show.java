import Entity.TypeEntitys;
import Island.CellAnalyzerUtil;

public class Show {
    public void show(int day){
        StringBuilder builder = new StringBuilder();
        TypeEntitys[] entitys = new TypeEntitys[] {
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

        builder.append(TypeEntitys.GRASS.getImage()).append(" ").append(CellAnalyzerUtil.getCountLandGrass());
        for (TypeEntitys type : entitys) builder.append(" ").append(type.getImage()).append(" ").append(CellAnalyzerUtil.getCountLandAnimal(type));
        System.out.println("День " + day);
        System.out.println(builder);
    }
}
