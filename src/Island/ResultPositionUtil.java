package Island;

public class ResultPositionUtil {
    public int x_position;
    public int y_position;
    public ResultPositionUtil(int x_position, int y_position){
        this.x_position = x_position;
        this.y_position = y_position;
    }
    public static String getStringCoordinate(int position_x, int position_y ){
        return position_x + ":" + position_y;
    }
    public static ResultPositionUtil getIntCoordinate(String coordinate){
        String[] result = coordinate.split(":");
        return new  ResultPositionUtil(Integer.parseInt(result[0]),Integer.parseInt(result[1]));
    }
}
