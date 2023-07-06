package Entity;

public enum TypeEntitys {
    BOAR("\uD83D\uDC17"),
    BUFFALO("\uD83D\uDC02"),
    DEER("\uD83E\uDD8C"),
    GOAT("\uD83D\uDC10"),
    HORSE("\uD83D\uDC0E"),
    MOUSE("\uD83D\uDC2D"),
    RABBIT("\uD83D\uDC07"),
    SHEEP("\uD83D\uDC11"),
    GRASS("\uD83C\uDF31"),
    BEAR("\uD83D\uDC3B"),
    BOA("\uD83D\uDC0D"),
    EAGLE("\uD83E\uDD85"),
    FOX("\uD83E\uDD8A"),
    WOLF("\uD83D\uDC3A");
    private final String image;
    TypeEntitys(String imageURL){
        this.image = imageURL;
    }
    public String getImage(){
        return image;
    }
}
